package wogwt.translatable.rpc;

import com.google.gwt.gen2.logging.shared.Log;
import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * An AsyncCallback that does Log.error for any error.
 */
public class LogOnErrorAsyncCallback<T> implements AsyncCallback<T> {

	/**
	 * Empty implementation
	 */
	public void onSuccess(T response) {
		
	}
	
	/**
	 * Logs an error to any available consoles: firebug, gwt-shell, eclipse
	 */
	public void onFailure(Throwable error) {
		Log.severe(error.getMessage(), Log.CATEGORY, error);
	}
}
