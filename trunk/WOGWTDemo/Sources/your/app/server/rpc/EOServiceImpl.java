package your.app.server.rpc;

import wogwt.WOGWTServerUtil;
import wogwt.server.rpc.WOGWTRpcService;
import your.app.eo.Movie;
import your.app.eo.MovieRole;
import your.app.eo.Studio;
import your.app.gwt.eo.MovieClient;
import your.app.gwt.eo.StudioClient;
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
						Movie.ROLES_KEY + "." + MovieRole.TALENT_KEY}));
		return result;
	}
		
	public NSArray<StudioClient> allStudios() {
		NSArray<Studio> eos = Studio.fetchAllStudios(editingContext());
		NSArray result = WOGWTServerUtil.toClientEOList(eos, 
				new NSArray<String>(new String[] {
						Studio.MOVIES_KEY}));
		return result;
	}
}