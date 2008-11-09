package your.app.gwt;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface HelloServiceAsync {
	
	public void hello(AsyncCallback<String> callback);
	
}
