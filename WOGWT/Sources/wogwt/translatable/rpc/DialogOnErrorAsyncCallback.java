package wogwt.translatable.rpc;

import wogwt.translatable.ErrorDialog;

import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * An AsyncCallback that displays a modal ErrorDialog for any error.
 */
public class DialogOnErrorAsyncCallback<T> implements AsyncCallback<T> {

	/**
	 * Empty implementation
	 */
	public void onSuccess(T response) {
		
	}
	
	/**
	 * Displays an ErrorDialog with the error message
	 */
	public void onFailure(Throwable error) {
		ErrorDialog dialog = new ErrorDialog(error.getMessage());
		dialog.show();
	}
}
