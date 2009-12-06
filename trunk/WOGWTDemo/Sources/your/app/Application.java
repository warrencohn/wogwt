package your.app;

import wogwt.GWTContext;
import wogwt.WOGWTServerUtil;
import wogwt.components.WOGWTScript;
import wogwt.server.rpc.GWTRPCRequestHandler;

import com.webobjects.appserver.WOContext;
import com.webobjects.appserver.WORequest;
import com.webobjects.appserver.WOResponse;
import com.webobjects.appserver._private.WOComponentRequestHandler;
import com.webobjects.foundation._NSUtilities;

import er.ajax.AjaxUtils;
import er.extensions.appserver.ERXApplication;

public class Application extends ERXApplication {
	
	public static void main(String[] argv) {
		ERXApplication.main(argv, Application.class);
	}

	public Application() {
		super();
		
//	    ERXRestRequestHandler.register(new ERXUnsafeRestAuthenticationDelegate(), true, false);
//	    
//	    ERXRouteRequestHandler routeRequestHandler = new ERXRouteRequestHandler(); 
//	    routeRequestHandler.addRoutes(Studio.ENTITY_NAME);
//	    routeRequestHandler.addDefaultRoutes(Movie.ENTITY_NAME);
//	    ERXRouteRequestHandler.register(routeRequestHandler); 
	    
		if (WOGWTScript.isHostedMode()) {
			setContextClassName(GWTContext.class.getName());
		}
		
		registerRequestHandler(new GWTRPCRequestHandler(), GWTRPCRequestHandler.KEY);

		if(!isWO54()) {
		    System.setProperty("er.extensions.ERXAjaxApplication.allowContextPageResponse", "true");
		    registerRequestHandler(new WOComponentRequestHandler() {
		        @Override
		        public WOResponse handleRequest(WORequest request) {
		            AjaxUtils.updateMutableUserInfoWithAjaxInfo(request);
		            return super.handleRequest(request);
		        }
		    }, "ja");
		}
		
		// needed for proper class loading in GWT's Hosted Mode shell
		_NSUtilities.setClassForName( your.app.components.Main.class, "Main" );

		setPageCacheSize(3);
	}

    public WOResponse dispatchRequest(WORequest request) {
    	WOResponse response = super.dispatchRequest( request );
    	
    	WOGWTServerUtil.onlyIncludeUpdateContainerInResponse(request, response);
    	
    	return response;
    }
    
    @Override
    public String host() {
    	_setHost("127.0.0.1");
    	return "127.0.0.1";
    }
    
    
}
