package wogwt;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.server.rpc.RPC;
import com.google.gwt.user.server.rpc.RPCRequest;
import com.webobjects.appserver.WOApplication;
import com.webobjects.appserver.WOContext;
import com.webobjects.appserver.WORequest;
import com.webobjects.appserver.WORequestHandler;
import com.webobjects.appserver.WOResponse;
import com.webobjects.appserver.WOSession;

/**
 * Register the request handler in your Application constructor by calling:
 * 
 * 		registerRequestHandler(new GWTRPCRequestHandler(), GWTRPCRequestHandler.KEY);
 * 
 * Set the property "wogwt.rpcImplementationPackage" to the package containing your
 * RPC service implementations or call registerServiceImplementation for each service.
 *
 * You invoke the service in the client code by doing something like this:
 * 
 * 		HelloServiceAsync helloService = (HelloServiceAsync)GWT.create(HelloService.class);
 *		((ServiceDefTarget)helloService).setServiceEntryPoint(WOGWTClientUtil.rpcUrl());
 *		
 * where HelloService and HelloServiceAsync are your service classes.
 */
public class GWTRPCRequestHandler extends WORequestHandler {

	public static final String KEY = "gwtrpc";
	private static final String RPC_PACKAGE_KEY = "wogwt.rpcImplementationPackage";
	
	private static final HashMap<Class, Class> serviceImplementations = new HashMap();
	
	public static void registerServiceImplementation(Class theInterface, Class theImplementation) {
		if (!theInterface.isInterface()) {
			throw new RuntimeException("The service interface must be an interface.");
		}
		if (!RemoteService.class.isAssignableFrom(theInterface)) {
			throw new RuntimeException("The service interface must extend com.google.gwt.user.client.rpc.RemoteService.");
		}
		if (theInterface.getSimpleName().endsWith("Async")) {
			throw new RuntimeException("The service interface must be the SYNCHRONOUS interface, not the Async one.");
		}
		if (theInterface.getSimpleName().endsWith("Async")) {
			throw new RuntimeException("The service interface must be the SYNCHRONOUS interface, not the Async one.");
		}
		
		boolean foundMatchingInterface = false;
		Class[] interfaces = theImplementation.getInterfaces();
		for (int i = 0; i < interfaces.length; i++) {
			if (interfaces[i].equals(theInterface))
				foundMatchingInterface = true;
		}
		if (!foundMatchingInterface) {
			throw new RuntimeException("The implementing class must implement " + theInterface.getName());
		}
		
		serviceImplementations.put(theInterface, theImplementation);
	}
	
	public GWTRPCRequestHandler() {
		super();
	}
	
	@Override
	public WOResponse handleRequest(WORequest request) {
		WOApplication application = WOApplication.application();
		WOContext context = application.createContextForRequest(request);
		WOResponse response = application.createResponseInContext(context);

		String wosid = request.stringFormValueForKey(WOContext.SessionIDBindingKey);
		if (wosid == null) {
			wosid = request.cookieValueForKey("wosid");
		}
		context._setRequestSessionID(wosid);

		WOSession session = null;
		if (context._requestSessionID() != null) {
			session = WOApplication.application().restoreSessionWithID(wosid, context);
		}
		try {
			
			try {
				response.setContent(processCall(request.contentString(), context));
				return response;
			} catch (Exception e) {
				return doUnexpectedFailure(e);
			}
			
		} finally {
			if (context._session() != null) {
				WOApplication.application().saveSessionForContext(context);
			}
		}
	}
	
	protected String processCall(String payload, WOContext context) 
		throws SerializationException, ClassNotFoundException, NoSuchMethodException, 
			InvocationTargetException, IllegalArgumentException, InstantiationException, IllegalAccessException {
		
		RPCRequest rpcRequest = RPC.decodeRequest(payload);
		
		// target will be the service implementation class (the servlet in normal RPC)
		Class serviceInterface = rpcRequest.getMethod().getDeclaringClass();
		
		Class serviceImplementation = serviceImplementations.get(serviceInterface);
		if (serviceImplementation == null) {
			serviceImplementation = findImplementingClassFromProperty(serviceInterface);
			
			if (serviceImplementation == null) {
				throw new RuntimeException("No service implementation registered for service:" + 
						serviceInterface.getName() + ". Call " + 
						GWTRPCRequestHandler.class.getSimpleName() + ".registerServiceImplementation()" + 
						" to register the service and it's implementation.");
			}
		}

		Constructor constructor;
		Object serviceObject;
		try {
			constructor = serviceImplementation.getConstructor(WOContext.class);
			serviceObject = constructor.newInstance(context);
		} catch (NoSuchMethodException e) {
			constructor = serviceImplementation.getConstructor();
			serviceObject = constructor.newInstance();
		}
		
		return RPC.invokeAndEncodeResponse(serviceObject, rpcRequest.getMethod(), rpcRequest.getParameters());
	}

	/**
	 * Override this method to control what should happen when an exception occurs while handling the RPC call.
	 * By default, this just throws a RuntimeException (so no response is generated).
	 * 
	 * @return the response to return
	 */
	protected WOResponse doUnexpectedFailure(Throwable e) {
		throw new RuntimeException(e);
	}
	
	protected Class findImplementingClassFromProperty(Class serviceInterface) {
		Class result = null;
		if (System.getProperty(RPC_PACKAGE_KEY) != null) {
			String rpcPackage = System.getProperty(RPC_PACKAGE_KEY).trim();
			String implementingClassName = rpcPackage + "." + serviceInterface.getSimpleName() + "Impl";
			
			try {
				result = Class.forName(implementingClassName);
				registerServiceImplementation(serviceInterface, result);
			} catch (ClassNotFoundException e) {}
			
		}
		return result;
	}
	
}
