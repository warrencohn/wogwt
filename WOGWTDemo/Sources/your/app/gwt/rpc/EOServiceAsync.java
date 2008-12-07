package your.app.gwt.rpc;

import your.app.gwt.eo.MovieClient;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.webobjects.foundation.NSArray;

public interface EOServiceAsync {
	
	public void allMovies(AsyncCallback<NSArray<MovieClient>> callback);

}
