package wogwt.translatable;

import com.google.gwt.http.client.Response;

public interface AfterDOMUpdateCallback {
	
	/**
	 * 
	 * @param sender either the Widget or Element that triggered the callback
	 * @param url
	 * @param response
	 */
	public void afterDOMUpdate(Object sender, String url, Response response);
	
}
