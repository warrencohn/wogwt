// DO NOT EDIT.  Make changes to StudioClient.java instead.
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
public abstract class _StudioClient extends WOGWTClientEOImpl {
	
	public static final transient String ENTITY_NAME = "Studio";
	
	// KEYS
	public static final String BUDGET_KEY = "budget";
	public static final String NAME_KEY = "name";
	public static final String MOVIES_KEY = "movies";
	
	// VARIABLES
	private java.math.BigDecimal budget;
	private String name;
	private NSArray<your.app.gwt.eo.MovieClient> movies;

	public _StudioClient() {
		super();
		movies = NSArray.EmptyArray;
	}
	
	public _StudioClient(NSDictionary<String, Object> snapshot) {
		super(snapshot);
		if (movies == null)
			movies = NSArray.EmptyArray;
	}

	public NSArray<String> attributeKeys() {
		NSArray<String> keys = new NSArray<String>( new String[] {
			"budget",			
			"name"			
		});
		return keys;
	}
	
	public NSArray<String> toOneRelationshipKeys() {
		NSArray<String> keys = new NSArray<String>( new String[] {	
		});
		return keys;
	}
	
	public NSArray<String> toManyRelationshipKeys() {
		NSArray<String> keys = new NSArray<String>( new String[] {
			"movies",
		});
    	return keys;
	}

	public int deleteRuleForRelationshipKey(String relationshipKey) {
		if ("movies".equals(relationshipKey))
			return deleteRuleNumber("EODeleteRuleNullify");
		return -1;
	}
	
	public String inverseForRelationshipKey(String relationshipKey) {
		if ("movies".equals(relationshipKey))
			return "studio";
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
		map.put("budget", budget == null ? NSKeyValueCoding.NullValue : budget);
		map.put("name", name == null ? NSKeyValueCoding.NullValue : name);
		map.put("movies", ((NSArray)movies).mutableClone());
		return map;
	}

	public Object valueForKey(String key) {
		if ("budget".equals(key)) {
			return budget();
		}
		if ("name".equals(key)) {
			return name();
		}
		if ("movies".equals(key)) {
			return movies();
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
		if ("budget".equals(key)) {
			setBudget((java.math.BigDecimal)value);
			return;
		}
		if ("name".equals(key)) {
			setName((String)value);
			return;
		}
		if ("movies".equals(key)) {
			setMovies((NSArray)value);
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
		return "Studio";
	}
	
	// Attributes
	public java.math.BigDecimal budget() {
		return budget;
	}
	
	public void setBudget(java.math.BigDecimal budget) {
		this.budget = budget;
	}

	public String name() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	// To One Relationships
	// To Many Relationships
	public NSArray<your.app.gwt.eo.MovieClient> movies() {
		return movies;
	}
	
	public void setMovies(NSArray<your.app.gwt.eo.MovieClient> movies) {
		this.movies = movies;
	}
	
	public void addToMoviesRelationship(your.app.gwt.eo.MovieClient object) {
		movies.add(object);
	}

	public void removeFromMoviesRelationship(your.app.gwt.eo.MovieClient object) {
		movies.remove(object);
	}
	
	public your.app.gwt.eo.MovieClient createMoviesRelationship() {
		your.app.gwt.eo.MovieClient result = new your.app.gwt.eo.MovieClient();
		movies.add(result);
		return result;
	}

}
