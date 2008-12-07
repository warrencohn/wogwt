// DO NOT EDIT.  Make changes to Review.java instead.
package your.app.gwt.eo;
// this must be in the client package

import java.util.*;
import java.math.BigDecimal;

import com.google.gwt.user.client.rpc.IsSerializable;
import com.webobjects.foundation.NSArray;
import com.webobjects.foundation.NSMutableArray;
import com.webobjects.foundation.NSDictionary;
import com.webobjects.foundation.NSMutableDictionary;
import com.webobjects.foundation.NSKeyValueCoding;
import com.webobjects.foundation.NSTimestamp;

import wogwt.translatable.rpc.WOGWTClientEO;

// This class can be serialized from server to client and back
public abstract class _Review implements IsSerializable, WOGWTClientEO, NSKeyValueCoding {
	
	// Attributes
	public static final String REVIEW_KEY = "review";
	public static final String REVIEWER_KEY = "reviewer";

	// Relationships
	public static final String MOVIE_KEY = "movie";
	
	private String review;
	private String reviewer;
	private your.app.gwt.eo.MovieClient movie;

	public _Review() {
		super();
	}
	
	public _Review(Map<String, ?> map) {
		super();
		takeValuesFromMap( map );
	}
	
	public static NSArray<String> keys() {
		List<String> keys = new ArrayList();
		keys.addAll(attributeKeys());
		keys.addAll(toOneRelationshipKeys());
		keys.addAll(toManyRelationshipKeys());
    	return new NSArray(keys);
	}

	public static NSArray<String> attributeKeys() {
		NSArray<String> keys = new NSArray<String>( new String[] {
			"review",			
			"reviewer"			
		});
		return keys;
	}
	
	public static NSArray<String> toOneRelationshipKeys() {
		NSArray<String> keys = new NSArray<String>( new String[] {	
			"movie"			
		});
		return keys;
	}
	
	public static NSArray<String> toManyRelationshipKeys() {
		NSArray<String> keys = new NSArray<String>( new String[] {
		});
    	return keys;
	}
	
	public Map<String, ?> toMap() {
		Map map = new HashMap();
		map.put("review", review);
		map.put("reviewer", reviewer);
		map.put("movie", movie);
		return map;
	}

	public void takeValuesFromMap(Map<String, ?> map) {
		review = (String)map.get("review");
		reviewer = (String)map.get("reviewer");
		movie = (your.app.gwt.eo.MovieClient)map.get("movie");
		if (map.get( "primaryKeyValue" ) != null)
			primaryKeyValue = (Integer)map.get( "primaryKeyValue" );
	}
	
	public Object valueForKey(String key) {
		if ("primaryKeyValue".equals(key))
			return primaryKeyValue();
		else if ("entityName".equals(key))
			return entityName();
		else if ("review".equals(key))
			return review();
		else if ("reviewer".equals(key))
			return reviewer();
		else if ("movie".equals(key))
			return movie();
		else
			throw new RuntimeException(getClass().getName() + " does not has a key named '" + key + "'");
	}
	
	public void takeValueForKey(Object value, String key) {
		if ("primaryKeyValue".equals(key))
			setPrimaryKeyValue((Integer)value);
		else if ("review".equals(key))
			setReview((String)value);
		else if ("reviewer".equals(key))
			setReviewer((String)value);
		else if ("movie".equals(key))
			setMovie((your.app.gwt.eo.MovieClient)value);
		else
			throw new RuntimeException(getClass().getName() + " does not has a key named '" + key + "'");
	}
	
	public String entityName() {
		return "Review";
	}
	
	// Attributes
	public String review() {
		return review;
	}
	
	public void setReview(String review) {
		this.review = review;
	}

	public String reviewer() {
		return reviewer;
	}
	
	public void setReviewer(String reviewer) {
		this.reviewer = reviewer;
	}

	private Integer primaryKeyValue;

	public Integer primaryKeyValue() {
		return primaryKeyValue;
	}
	
	public void setPrimaryKeyValue(Integer primaryKeyValue) {
		this.primaryKeyValue = primaryKeyValue;
	}

	// To One Relationships
	public your.app.gwt.eo.MovieClient movie() {
		return movie;
	}
	
	public void setMovie(your.app.gwt.eo.MovieClient movie) {
		this.movie =  movie;
	}
	
	//To Many Relationships

	public String toString() {
		return toMap().toString();
	}

}
