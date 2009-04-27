package your.app.server.rpc;

import wogwt.server.rpc.WOGWTRpcService;
import your.app.gwt.eo.Movie;
import your.app.gwt.eo.Studio;
import your.app.gwt.rpc.EOService;

import com.webobjects.appserver.WOContext;
import com.webobjects.eoaccess.EOUtilities;
import com.webobjects.foundation.NSArray;

import er.extensions.eof.ERXBatchFetchUtilities;


public class EOServiceImpl extends WOGWTRpcService implements EOService {
	
	public EOServiceImpl(WOContext context) {
		super(context);
	}
	
	public NSArray<Movie> allMovies() {
		NSArray<Movie> eos = EOUtilities.objectsForEntityNamed(editingContext(), Movie.ENTITY_NAME);
		ERXBatchFetchUtilities.batchFetch(eos, Movie.STUDIO_KEY);
		return eos;
	}
		
	public NSArray<Studio> allStudios() {
		NSArray<Studio> eos = EOUtilities.objectsForEntityNamed(editingContext(), Studio.ENTITY_NAME);
		ERXBatchFetchUtilities.batchFetch(eos, Studio.MOVIES_KEY);
		return eos;
	}

}
