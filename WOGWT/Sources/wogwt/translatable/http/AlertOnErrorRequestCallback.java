package wogwt.translatable.http;


import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.Response;
import com.google.gwt.user.client.Window;

/**
 * A request callback that displays a modal ErrorDialog for any error
 */
public abstract class AlertOnErrorRequestCallback extends WOGWTRequestCallback {
	
	/**
	 * Empty implementation
	 */
	public void onSuccess(Request request, Response response) {
		
	}
	
	/**
	 * Displays an ErrorDialog with the error message
	 */
	public void onError(Request request, Throwable throwable) {
		Window.alert(throwable.getMessage());
	}
	
}
