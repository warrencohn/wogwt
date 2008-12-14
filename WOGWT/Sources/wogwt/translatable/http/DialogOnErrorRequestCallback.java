package wogwt.translatable.http;


import wogwt.translatable.ErrorDialog;

import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.Response;

/**
 * A request callback that displays a modal ErrorDialog for any error
 */
public abstract class DialogOnErrorRequestCallback extends WOGWTRequestCallback {
	
	/**
	 * Empty implementation
	 */
	public void onSuccess(Request request, Response response) {
		
	}
	
	/**
	 * Displays an ErrorDialog with the error message
	 */
	public void onError(Request request, Throwable throwable) {
		ErrorDialog dialog = new ErrorDialog(throwable.getMessage());
		dialog.showModal();
	}
	
}
