package wogwt;

import java.util.Enumeration;

import org.apache.log4j.Appender;
import org.apache.log4j.Logger;
import org.apache.log4j.varia.StringMatchFilter;

import com.webobjects.appserver.WOApplication;
import com.webobjects.appserver.WOComponent;
import com.webobjects.appserver.WOContext;
import com.webobjects.appserver.WOResponse;
import com.webobjects.appserver.WOSession;
import com.webobjects.appserver._private.WOSubmitButton;
import com.webobjects.foundation.NSDictionary;
import com.webobjects.foundation.NSKeyValueCoding;

import er.extensions.appserver.ERXResponseRewriter;
import er.extensions.appserver.ERXResponseRewriter.TagMissingBehavior;
import er.extensions.components._private.ERXSubmitButton;
import er.extensions.foundation.ERXPatcher;
import er.extensions.foundation.ERXProperties;

/**
 * Adds GWT functionality to a page.  
 * 
 * This component must be placed in the BODY of the page (anywhere).
 * 
 * Basically just adds the nocache.js script into the head of the host page 
 * along with some meta tags to provide information for the script.
 * If history support is enabled, an iframe is added to the body.
 *
 */
public class WOGWTScript extends WOComponent {
	
	static {
		// Add patch for ERXSubmitButton because buttons must use the "button" tag, not "input" for GWT to be able to wrap them.
		// Only required in hosted mode because of assertations.  Not wanted in production because the of "ieFix" in ERXSubmitButton.
		if (WOGWTScript.isHostedMode()) {
			ERXPatcher.setClassForName(ERXSubmitButton.class, WOSubmitButton.class.getSimpleName());	
		}
		
        // Filter out log messages we don't care about. 
		// We are actually trimming down the response after it is totally generated, 
		// so this warning isn't accurate.
        StringMatchFilter filter = new StringMatchFilter();
        filter.setStringToMatch("invokeAction: An non stored response return context.page()");
        filter.setAcceptOnMatch(false);
        Enumeration appenders = Logger.getRootLogger().getAllAppenders();
        while (appenders.hasMoreElements()) {
			Appender appender = (Appender)appenders.nextElement();
			appender.addFilter(filter);
		}
        filter.setAcceptOnMatch(false);
	}
	
	/**
	 * Checks the property "wogwt.isHostedMode" and returns the value.  Defaults to false.
	 * 
	 * You should set the property in the GWT shell's launcher configuration under 
	 * VM arguments add -Dwogwt.isHostedMode="true"
	 */
	public static boolean isHostedMode() {
		return ERXProperties.booleanForKeyWithDefault("wogwt.isHostedMode", false);
	}
	
    public WOGWTScript(WOContext context) {
        super(context);
    }
    
    @Override
    public boolean isStateless() {
    	return true;
    }
    
    @Override
    public void appendToResponse(WOResponse response, WOContext context) {
    	super.appendToResponse(response, context);

    	String directActionUrl = context.directActionURLForActionNamed( "default", null ); // new NSDictionary(false, WOContext.SessionIDBindingKey)
    	
    	String queryString = null;
    	if (context.hasSession()) {
    		queryString = WOContext.SessionIDBindingKey + "=" + context.session().sessionID();
    	}
    	String rpcUrl = context.urlWithRequestHandlerKey(GWTRPCRequestHandler.KEY, null, queryString);
    	
    	ERXResponseRewriter.addScriptCodeInHead(response, context, 
    			"WOGWT={};\n" +
    			"WOGWT.hostPageName='" + rootParent().getClass().getSimpleName() + "';\n" +
    			"WOGWT.rpcUrl='" + rpcUrl + "';\n" +
    			"WOGWT.directActionBaseUrl='" + directActionUrl + "';\n" +
    			"WOGWT.componentRequestHandlerKey='" + application().componentRequestHandlerKey() + "';\n" +
    			"WOGWT.ajaxRequestHandlerKey='" + application().ajaxRequestHandlerKey() + "';\n"
    			);
    	
    	
    	if (!WOGWTScript.isHostedMode()) {
    		ERXResponseRewriter.addScriptResourceInHead(response, context, "app", scriptPath());
    	} else {
    		String scriptTag = "<script language=\"javascript\" src=\"/" + module() + "/" + module() + ".nocache.js\"></script>";	
    		ERXResponseRewriter.insertInResponseBeforeHead(context().response(), context(), scriptTag, TagMissingBehavior.Inline);
    	}
    }

    /**
     * @return the fully qualified name of the module, like com.yourcompany.Application
     * where the module file name is com.yourcompany.Applicaton.gwt.xml
     */
    public String module() {
    	return (String) valueForBinding("module");
    }
    
    public String scriptPath() {
    	return module() + "/" + module() + ".nocache.js";
    }
    
    public WOComponent rootParent() {
    	WOComponent result = this;
    	while (result.parent() != null) {
    		result = result.parent();
    	}
    	return result;
    }

}