package your.app.gwt.rpc;

import wogwt.translatable.WOGWTClientUtil;
import your.app.gwt.eo.Movie;
import your.app.gwt.eo.Studio;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.ServiceDefTarget;
import com.webobjects.foundation.NSArray;

public interface EOService extends RemoteService {
	
	public static class Util {
		public static EOServiceAsync getInstance() {
			EOServiceAsync service = (EOServiceAsync)GWT.create(EOService.class);
			((ServiceDefTarget)service).setServiceEntryPoint(WOGWTClientUtil.rpcUrl());
			return service;
		}
	}

	public NSArray<Movie> allMovies();
	public NSArray<Studio> allStudios();
	
	public void saveMovies(NSArray<Movie> movies);
	
	public Movie aMovie();
	
}
