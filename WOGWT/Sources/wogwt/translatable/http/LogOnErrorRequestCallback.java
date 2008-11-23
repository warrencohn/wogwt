package wogwt.translatable.http;


import com.allen_sauer.gwt.log.client.Log;
import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.Response;

/**
 * A request callback that does Log.error for any error
 */
public abstract class LogOnErrorRequestCallback extends WOGWTRequestCallback {
	
	public abstract void onSuccess(Request request, Response response);
	
	public void onError(Request request, Throwable throwable) {
		super.onError(request, throwable);
		Log.error("Request error: " + throwable.getMessage());
	}
	
}
