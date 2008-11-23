package your.app.gwt.rpc;

import your.app.gwt.eo.RootEntityClient;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.webobjects.foundation.NSArray;

public interface EOServiceAsync {
	
	public void allRootEntities(AsyncCallback<NSArray<RootEntityClient>> callback);

}
