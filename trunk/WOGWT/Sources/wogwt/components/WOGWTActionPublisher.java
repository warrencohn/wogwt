package wogwt.components;

import java.lang.reflect.Method;

import com.webobjects.appserver.WOActionResults;
import com.webobjects.appserver.WOComponent;
import com.webobjects.appserver.WOContext;
import com.webobjects.appserver.WORequest;
import com.webobjects.appserver.WOResponse;
import com.webobjects.foundation.NSArray;
import com.webobjects.foundation.NSMutableArray;

/**
 * This component "publishes" the urls of all the component actions in the
 * host page containing it so that the urls can be used to dynamically create
 * GWT hyperlinks or other widgets that call component actions.  Component
 * action urls have to be generated on the server, but GWT encourages
 * the construction of the UI on the client, so this component allows you to
 * do that and still access the component actions on the server.
 * 
 */
public class WOGWTActionPublisher extends WOComponent {
	
	public NSArray<Method> actionMethodList;
	public Method actionMethodItem;
	
    public WOGWTActionPublisher(WOContext context) {
        super(context);
    }
    
    @Override
    public boolean isStateless() {
    	return true;
    }
    
    public String actionMethodName() {
    	return actionMethodItem.getName();
    }
    
    public String actionMethodNameAnnotated() {
    	return "action:" + actionMethodName();
    }
    
    @Override
    public void appendToResponse(WOResponse response, WOContext context) {
    	actionMethodList = findActionMethods();
    	super.appendToResponse(response, context);
    }

	protected NSArray findActionMethods() {
		NSMutableArray actionMethods = new NSMutableArray();
    	
    	Method[] methods = rootParent().getClass().getMethods();
    	for (int i = 0; i < methods.length; i++) {
			Method method = methods[i];
			if (method.getParameterTypes().length == 0) {
				if (WOActionResults.class.isAssignableFrom(method.getReturnType()) ||
						method.getReturnType().equals(void.class)) {
					if (!method.getDeclaringClass().equals(WOComponent.class) &&
							!method.getDeclaringClass().equals(Object.class)) {
						actionMethods.addObject(method);
					}
				}
			}
		}
    	
    	return actionMethods.immutableClone();
	}
    
    public WOComponent rootParent() {
    	WOComponent result = this;
    	while (result.parent() != null) {
    		result = result.parent();
    	}
    	return result;
    }
    
    public WOActionResults performAction() {
    	try {
    		Method method = rootParent().getClass().getDeclaredMethod(actionMethodName(), new Class[0]);
    		Object result = method.invoke(rootParent(), new Object[0]);
    		return (WOActionResults) result;
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    	
    	return null;
    }
 
}