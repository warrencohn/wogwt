package your.app.server.rpc;

import wogwt.WOGWTServerUtil;
import wogwt.server.rpc.WOGWTRpcService;
import your.app.eo.Movie;
import your.app.gwt.eo.MovieClient;
import your.app.gwt.rpc.EOService;

import com.webobjects.appserver.WOContext;
import com.webobjects.foundation.NSArray;


public class EOServiceImpl extends WOGWTRpcService implements EOService {
	
	public EOServiceImpl(WOContext context) {
		super(context);
	}
	
	public NSArray<MovieClient> allMovies() {
		NSArray<Movie> eos = Movie.fetchAllMovies(editingContext());
		NSArray result = WOGWTServerUtil.toClientEOList(eos, 
				new NSArray<String>(new String[] {
						Movie.STUDIO_KEY,
						Movie.ROLES_KEY}));
		return result;
	}
		
}
