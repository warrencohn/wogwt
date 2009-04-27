package your.app.gwt.eo;

import com.webobjects.foundation.NSArray;
// this must be in a gwt translatable package

//This class can be serialized from server to client and back
public class Movie extends _Movie {

	public Movie() {	
		super();
	}

	public final void setReviews(NSArray<Review> aValue) {
		takeStoredValueForKey(aValue, "reviews");
	}
}
