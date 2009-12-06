package your.app.server.rpc;

import wogwt.WOGWTServerUtil;
import wogwt.server.rpc.WOGWTRpcService;
import your.app.gwt.eo.MovieClient;
import your.app.gwt.eo.StudioClient;
import your.app.gwt.rpc.EOService;
import your.app.server.eo.Movie;
import your.app.server.eo.Studio;

import com.webobjects.appserver.WOContext;
import com.webobjects.eocontrol.EOSortOrdering;
import com.webobjects.foundation.NSArray;
import com.webobjects.foundation.NSSelector;

import er.extensions.eof.ERXBatchFetchUtilities;
import er.extensions.foundation.ERXArrayUtilities;

public class EOServiceImpl extends WOGWTRpcService implements EOService {
	
	public EOServiceImpl(WOContext context) {
		super(context);
	}
	
	public NSArray<MovieClient> allMovies() {
		NSArray<Movie> movies = Movie.fetchAllMovies(editingContext(), 
				new NSArray<EOSortOrdering>(new EOSortOrdering(Movie.TITLE_KEY, EOSortOrdering.CompareAscending)));
		ERXBatchFetchUtilities.batchFetch(movies, Movie.STUDIO_KEY, false);
		
		NSArray<String> relationshipsToInclude = new NSArray<String>(Movie.STUDIO_KEY);
		
		NSArray<MovieClient> clientMovies = (NSArray<MovieClient>) WOGWTServerUtil.toClientEOList(movies, relationshipsToInclude);
		return clientMovies;
	}
		
	public NSArray<StudioClient> allStudios() {
		NSArray<Studio> studios = Studio.fetchAllStudios(editingContext(),
				new NSArray<EOSortOrdering>(new EOSortOrdering(Studio.NAME_KEY, EOSortOrdering.CompareAscending)));

		ERXBatchFetchUtilities.batchFetch(studios, Studio.MOVIES_KEY, false);
		
		NSArray<String> relationshipsToInclude = new NSArray<String>(Studio.MOVIES_KEY);
		
		NSArray<StudioClient> clientStudios = (NSArray<StudioClient>) WOGWTServerUtil.toClientEOList(studios, relationshipsToInclude);
		return clientStudios;
	}

	public void saveMovies(NSArray<MovieClient> movies) {
		// TODO: implement save
		editingContext().saveChanges();
	}

}
