package wogwt;

import wogwt.components.WOGWTScript;

import com.webobjects.appserver.WOApplication;
import com.webobjects.appserver.WORequest;
import com.webobjects.foundation._NSUtilities;
import com.webobjects.jspservlet.WOServletContext;

import er.extensions.appserver.ERXWOServletContext;

/**
 * This class should only be used in GWT Development Mode (aka Hosted Mode)
 * in order to generate URLs (component and direct action URLs) that include
 * the gwt.codesvr query parameter so that hosted mode continues to function
 * for application that have multiple html pages, so when you navigate to a
 * new page you don't lose the connection to the hosted mode server.
 *
 */
public class GWTContext extends ERXWOServletContext {

	public GWTContext(WORequest worequest) {
		super(worequest);
	}

	/**
	 * Adds the gwt.codesvr parameter to the generated URL
	 */
	@Override
	public String completeURLWithRequestHandlerKey(String requestHandlerKey,
			String requestHandlerPath, String queryString, boolean isSecure,
			int somePort) {
		return adjustUrl(requestHandlerKey, super.completeURLWithRequestHandlerKey(requestHandlerKey,
				requestHandlerPath, queryString, isSecure, somePort));
	}
	
	/**
	 * Adds the gwt.codesvr parameter to the generated URL
	 */
	@Override
	public String completeURLWithRequestHandlerKey(String applicationNumber, String requestHandlerKey,
			String requestHandlerPath, String queryString, boolean isSecure, int somePort) {
		return adjustUrl(requestHandlerKey, super.completeURLWithRequestHandlerKey(applicationNumber, 
				requestHandlerKey, requestHandlerPath, queryString, isSecure,
				somePort));
	}
	
	/**
	 * Adds the gwt.codesvr parameter to the generated URL
	 */
	@Override
	protected String relativeURLWithRequestHandlerKey(String requestHandlerKey,
			String requestHandlerPath, String queryString) {
		return adjustUrl(requestHandlerKey, super.relativeURLWithRequestHandlerKey(requestHandlerKey,
				requestHandlerPath, queryString));
	}

	private String adjustUrl(String requestHandlerKey, String url) {
		if (url.indexOf('?') != -1 && !requestHandlerKey.equals("wr")) {
			url += "&";
		} else {
			url += "?";
		}
		url += "gwt.codesvr=" + WOApplication.application().host() + ":9997";
		return url;
	}
	
}
