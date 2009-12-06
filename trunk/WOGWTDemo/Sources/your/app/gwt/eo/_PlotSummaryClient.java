// DO NOT EDIT.  Make changes to PlotSummaryClient.java instead.
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
public abstract class _PlotSummaryClient extends WOGWTClientEOImpl {
	
	public static final transient String ENTITY_NAME = "PlotSummary";
	
	// KEYS
	public static final String SUMMARY_KEY = "summary";
	public static final String MOVIE_KEY = "movie";
	
	// VARIABLES
	private String summary;
	private your.app.gwt.eo.MovieClient movie;

	public _PlotSummaryClient() {
		super();
	}
	
	public _PlotSummaryClient(NSDictionary<String, Object> snapshot) {
		super(snapshot);
	}

	public NSArray<String> attributeKeys() {
		NSArray<String> keys = new NSArray<String>( new String[] {
			"summary"			
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
		map.put("summary", summary == null ? NSKeyValueCoding.NullValue : summary);
		map.put("movie", movie == null ? NSKeyValueCoding.NullValue : movie);
		return map;
	}

	public Object valueForKey(String key) {
		if ("summary".equals(key)) {
			return summary();
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
		if ("summary".equals(key)) {
			setSummary((String)value);
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
		return "PlotSummary";
	}
	
	// Attributes
	public String summary() {
		return summary;
	}
	
	public void setSummary(String summary) {
		this.summary = summary;
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
