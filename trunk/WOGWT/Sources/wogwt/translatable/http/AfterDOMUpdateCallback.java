package wogwt.translatable.http;

import com.google.gwt.http.client.Response;

/**
 * A simple callback used with the Updater classes to allow for custom
 * actions after an HTTP request and response modifies the DOM.
 * 
 * This is mainly used to re-attach event listeners to the portion of
 * the DOM that was replaced.
 *
 */
public interface AfterDOMUpdateCallback {
	
	/**
	 * 
	 * @param sender either the Widget or Element that triggered the callback
	 * @param url of the HTTP request that resulted in the DOM update
	 * @param response of the HTTP request for url
	 */
	public void afterDOMUpdate(Object sender, String url, Response response);
	
}
