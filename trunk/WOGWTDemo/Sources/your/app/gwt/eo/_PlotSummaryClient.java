// DO NOT EDIT.  Make changes to PlotSummaryClient.java instead.
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
import com.webobjects.foundation.NSKeyValueCodingAdditions;
import com.webobjects.foundation.NSTimestamp;

import wogwt.translatable.rpc.WOGWTClientEO;

// This class can be serialized from server to client and back
public abstract class _PlotSummaryClient implements IsSerializable, WOGWTClientEO, NSKeyValueCoding, NSKeyValueCodingAdditions {
	
	// Attributes
	public static final String SUMMARY_KEY = "summary";

	// Relationships
	public static final String MOVIE_KEY = "movie";
	
	private String summary;
	private your.app.gwt.eo.MovieClient movie;

	public _PlotSummaryClient() {
		super();
	}
	
	public _PlotSummaryClient(Map<String, ?> map) {
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
			"summary"			
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
		map.put("summary", summary);
		map.put("movie", movie);
		return map;
	}

	public void takeValuesFromMap(Map<String, ?> map) {
		summary = (String)map.get("summary");
		movie = (your.app.gwt.eo.MovieClient)map.get("movie");
		if (map.get( "primaryKeyValue" ) != null)
			primaryKeyValue = (Integer)map.get( "primaryKeyValue" );
	}
	
	public Object valueForKey(String key) {
		if ("primaryKeyValue".equals(key))
			return primaryKeyValue();
		else if ("entityName".equals(key))
			return entityName();
		else if ("summary".equals(key))
			return summary();
		else if ("movie".equals(key))
			return movie();
		else
			throw new RuntimeException(getClass().getName() + " does not has a key named '" + key + "'");
	}
	
	public void takeValueForKey(Object value, String key) {
		if ("primaryKeyValue".equals(key))
			setPrimaryKeyValue((Integer)value);
		else if ("summary".equals(key))
			setSummary((String)value);
		else if ("movie".equals(key))
			setMovie((your.app.gwt.eo.MovieClient)value);
		else
			throw new RuntimeException(getClass().getName() + " does not has a key named '" + key + "'");
	}
	
	public Object valueForKeyPath(String keyPath) {
		return NSKeyValueCodingAdditions.DefaultImplementation.valueForKeyPath(this, keyPath);
	}
	
	public void takeValueForKeyPath(Object value, String keyPath) {
		NSKeyValueCodingAdditions.DefaultImplementation.takeValueForKeyPath(this, value, keyPath);
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
