package your.app.gwt.rpc;

import your.app.gwt.eo.Movie;
import your.app.gwt.eo.Studio;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.webobjects.foundation.NSArray;
import com.webobjects.foundation.NSKeyValueCoding;
import com.webobjects.foundation.NSMutableDictionary;

public interface EOServiceAsync {
	
	public void allMovies(AsyncCallback<NSArray<Movie>> callback);
	public void allStudios(AsyncCallback<NSArray<Studio>> callback);

}
