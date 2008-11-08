package wogwt.translatable;

import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.Response;
import com.google.gwt.user.client.Window;

/**
 * A request callback that does Window.alert for any error
 */
public abstract class AlertOnErrorRequestCallback extends WOGWTRequestCallback {
	
	public abstract void onSuccess(Request request, Response response);
	
	public void onError(Request request, Throwable throwable) {
		super.onError(request, throwable);
		Window.alert(throwable.getMessage());
	}
	
}
