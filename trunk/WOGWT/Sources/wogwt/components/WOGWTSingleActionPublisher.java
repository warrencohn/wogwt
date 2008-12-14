package wogwt.components;

import wogwt.translatable.WOGWTClientUtil;

import com.webobjects.appserver.WOContext;

/**
 * This component "publishes" the url of a component action in the
 * host page containing it so that the url can be used to dynamically create
 * GWT hyperlinks or other widgets that call component actions.  Component
 * action urls have to be generated on the server, but GWT encourages
 * the construction of the UI on the client, so this component allows you to
 * do that and still access the component actions on the server.
 * 
 * This component is invisible, but must be placed in the BODY of the page 
 * because it generate a hidden anchor element.
 * 
 */
public class WOGWTSingleActionPublisher extends com.webobjects.appserver.WOComponent {
	
    public WOGWTSingleActionPublisher(WOContext context) {
        super(context);
    }
    
    @Override
    public boolean isStateless() {
    	return true;
    }
    
    public String actionNameAnnotated() {
    	return WOGWTClientUtil.ACTION_ID_PREFIX + valueForBinding("action");
    }
    
}