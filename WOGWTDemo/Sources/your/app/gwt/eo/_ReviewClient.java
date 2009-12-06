// DO NOT EDIT.  Make changes to ReviewClient.java instead.
package your.app.gwt.eo;
// this must be in the client package

import java.util.*;
import java.math.BigDecimal;

import com.webobjects.eocontrol.EOGlobalID;
import com.webobjects.foundation.NSArray;
import com.webobjects.foundation.NSDictionary;
import com.webobjects.foundation.NSMutableDictionary;
import com.webobjects.foundation.NSKeyValueCoding;
import com.webobjects.foundation.NSKeyValueCodingAdditions;
import com.webobjects.foundation.NSTimestamp;

import wogwt.translatable.rpc.WOGWTClientEOImpl;

// This class can be serialized from server to client and back
public abstract class _ReviewClient extends WOGWTClientEOImpl {
	
	public static final transient String ENTITY_NAME = "Review";
	
	// KEYS
	public static final String REVIEW_KEY = "review";
	public static final String REVIEWER_KEY = "reviewer";
	public static final String MOVIE_KEY = "movie";
	
	// VARIABLES
	private String review;
	private String reviewer;
	private your.app.gwt.eo.MovieClient movie;

	public _ReviewClient() {
		super();
	}
	
	public _ReviewClient(NSDictionary<String, Object> snapshot) {
		super(snapshot);
	}

	public NSArray<String> attributeKeys() {
		NSArray<String> keys = new NSArray<String>( new String[] {
			"review",			
			"reviewer"			
		});
		return keys;
	}
	
	public NSArray<String> toOneRelationshipKeys() {
		NSArray<String> keys = new NSArray<String>( new String[] {	
			"movie"			
		});
		return keys;
	}
	
	public NSArray<String> toManyRelationshipKeys() {
		NSArray<String> keys = new NSArray<String>( new String[] {
		});
    	return keys;
	}

	public int deleteRuleForRelationshipKey(String relationshipKey) {
		if ("movie".equals(relationshipKey))
			return deleteRuleNumber("EODeleteRuleNullify");
		return -1;
	}
	
	public String inverseForRelationshipKey(String relationshipKey) {
		return null;
	}
	
	public boolean isReadOnly() {
		return false;
	}
	
	public boolean ownsDestinationObjectsForRelationshipKey(String relationshipKey) {
		return false;
	}
	
	public NSDictionary<String, Object> snapshot() {
		NSMutableDictionary<String, Object> map = new NSMutableDictionary<String, Object>();
		map.put("__globalID", __globalID() == null ? NSKeyValueCoding.NullValue : __globalID());
		map.put("isFault", isFault());
		map.put("review", review == null ? NSKeyValueCoding.NullValue : review);
		map.put("reviewer", reviewer == null ? NSKeyValueCoding.NullValue : reviewer);
		map.put("movie", movie == null ? NSKeyValueCoding.NullValue : movie);
		return map;
	}

	public Object valueForKey(String key) {
		if ("review".equals(key)) {
			return review();
		}
		if ("reviewer".equals(key)) {
			return reviewer();
		}
		if ("movie".equals(key)) {
			return movie();
		}
		if ("__globalID".equals(key)) {
			return __globalID();
		}
		if ("isFault".equals(key)) {
			return isFault();
		}
		return handleQueryWithUnboundKey(key);
	}
	
	public void takeValueForKey(Object value, String key) {
		if ("review".equals(key)) {
			setReview((String)value);
			return;
		}
		if ("reviewer".equals(key)) {
			setReviewer((String)value);
			return;
		}
		if ("movie".equals(key)) {
			setMovie((your.app.gwt.eo.MovieClient)value);
			return;
		}
		if ("__globalID".equals(key)) {
			setGlobalID((EOGlobalID)value);
			return;
		}
		if ("isFault".equals(key)) {
			setIsFault((Boolean)value);
			return;
		}
		handleTakeValueForUnboundKey(value, key);
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

	// To One Relationships
	public your.app.gwt.eo.MovieClient movie() {
		return movie;
	}
	
	public void setMovie(your.app.gwt.eo.MovieClient movie) {
		this.movie =  movie;
	}
	
	// To Many Relationships

}
