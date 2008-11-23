package wogwt.translatable.http;

import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.http.client.RequestException;
import com.google.gwt.http.client.Response;

/**
 * Adds an onSuccess method that can be used instead of onResponseReceived and treats all
 * non-2xx responses as errors and calls onError.
 */
public abstract class WOGWTRequestCallback implements RequestCallback {
	
	public void onResponseReceived(Request request, Response response) {
		if (!Integer.toString(response.getStatusCode()).startsWith("2")) {
			onError(request, new RequestException(response.getStatusCode() + ": " + response.getStatusText()));
			return;
		}
		onSuccess(request, response);
	}
	
	public void onSuccess(Request request, Response response) {
		// do nothing by default
	}
	
	public void onError(Request request, Throwable throwable) {
		// do nothing by default
	}
	
}
