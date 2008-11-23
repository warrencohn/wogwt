package wogwt.translatable.rpc;

import com.allen_sauer.gwt.log.client.Log;
import com.google.gwt.user.client.rpc.AsyncCallback;

public class LogOnErrorAsyncCallback<T> implements AsyncCallback<T> {

	public void onSuccess(T response) {
		
	}
	
	public void onFailure(Throwable error) {
		Log.error(error.getMessage(), error);
	}
}
