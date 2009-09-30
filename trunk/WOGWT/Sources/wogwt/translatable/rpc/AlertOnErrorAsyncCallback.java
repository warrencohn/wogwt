package wogwt.translatable.rpc;

import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * An AsyncCallback that displays a modal ErrorDialog for any error.
 */
public class AlertOnErrorAsyncCallback<T> implements AsyncCallback<T> {

	/**
	 * Empty implementation
	 */
	public void onSuccess(T response) {
		
	}
	
	/**
	 * Displays an ErrorDialog with the error message
	 */
	public void onFailure(Throwable error) {
		Window.alert(error.getMessage());
	}
	
}
