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
//		Movie m = new Movie();
//		session().defaultEditingContext().insertObject(m);
//		m.setTitle("Test Movie");
//		
//		Studio s = new Studio();
//		session().defaultEditingContext().insertObject(s);
//		s.setName("Test Studio");
//		
//		m.setStudioRelationship(s);
//		
//		return new NSArray<Movie>(m);
		NSArray<Movie> eos = EOUtilities.objectsForEntityNamed(
				session().defaultEditingContext(), Movie.ENTITY_NAME);
		ERXBatchFetchUtilities.batchFetch(eos, Movie.STUDIO_KEY, false);
		//ERXBatchFetchUtilities.batchFetch(eos, "studio.movies", false);
		return eos;
		//return new NSArray<Movie>(eos.get(0));
	}
		
	public NSArray<Studio> allStudios() {
		NSArray<Studio> eos = EOUtilities.objectsForEntityNamed(
				session().defaultEditingContext(), Studio.ENTITY_NAME);
		
		for (Studio studio : eos) {
			NSArray<Movie> movies = studio.movies();
			for (Movie movie : movies) {
				String title = movie.title();
			}
		}
		//ERXBatchFetchUtilities.batchFetch(eos, "movies.title", false);
		return eos;
		//return new NSArray<Studio>(eos.get(0));
	}

	public void saveMovies(NSArray<Movie> movies) {
		session().defaultEditingContext().saveChanges();
	}
	
	public Movie aMovie() {
		Movie result = allMovies().get(0);
		return result;
	}
	
}
