package your.app.gwt.rpc;

import your.app.gwt.eo.MovieClient;
import your.app.gwt.eo.StudioClient;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.webobjects.foundation.NSArray;

public interface EOServiceAsync {
	
	public void allMovies(AsyncCallback<NSArray<MovieClient>> callback);
	public void allStudios(AsyncCallback<NSArray<StudioClient>> callback);

}
