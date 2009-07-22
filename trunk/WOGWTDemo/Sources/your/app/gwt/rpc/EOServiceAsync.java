package your.app.gwt.rpc;

import your.app.gwt.eo.Movie;
import your.app.gwt.eo.Studio;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.webobjects.foundation.NSArray;

public interface EOServiceAsync {
	
	public void allMovies(AsyncCallback<NSArray<Movie>> callback);
	public void allStudios(AsyncCallback<NSArray<Studio>> callback);

	public void saveMovies(NSArray<Movie> movie, AsyncCallback<Void> callback);
	
	public void aMovie(AsyncCallback<Movie> callback);
	
}
