package wogwt.translatable.http;


import com.google.gwt.gen2.logging.shared.Log;
import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.Response;

/**
 * A request callback that does Log.error for any error
 */
public abstract class LogOnErrorRequestCallback extends WOGWTRequestCallback {
	
	/**
	 * Empty implementation
	 */
	public void onSuccess(Request request, Response response) {
		
	}
	
	/**
	 * Logs an error to any available consoles: firebug, gwt-shell, eclipse
	 */
	public void onError(Request request, Throwable throwable) {
		super.onError(request, throwable);
		Log.severe("Request error: " + throwable.getMessage());
	}
	
}
