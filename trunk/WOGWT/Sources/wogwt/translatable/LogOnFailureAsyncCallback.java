package wogwt.translatable;

import com.allen_sauer.gwt.log.client.Log;
import com.google.gwt.user.client.rpc.AsyncCallback;

public class LogOnFailureAsyncCallback implements AsyncCallback {
	
	public void onFailure(Throwable error) {
		Log.error( "RPC failure:" + error.toString() );
	}
	
	public void onSuccess(Object retValue) {
	}
	
}
