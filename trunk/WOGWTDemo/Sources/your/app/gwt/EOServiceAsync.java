package your.app.gwt;

import java.util.List;

import your.app.gwt.eo.RootEntityClient;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface EOServiceAsync {
	
	public void allRootEntities(AsyncCallback<List<RootEntityClient>> callback);
	
}
