// DO NOT EDIT.  Make changes to StudioClient.java instead.
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
public abstract class _StudioClient implements IsSerializable, WOGWTClientEO, NSKeyValueCoding, NSKeyValueCodingAdditions {
	
	// Attributes
	public static final String BUDGET_KEY = "budget";
	public static final String NAME_KEY = "name";

	// Relationships
	public static final String MOVIES_KEY = "movies";
	
	private BigDecimal budget;
	private String name;
	private NSArray<your.app.gwt.eo.MovieClient> movies;

	public _StudioClient() {
		super();
	}
	
	public _StudioClient(Map<String, ?> map) {
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
			"budget",			
			"name"			
		});
		return keys;
	}
	
	public static NSArray<String> toOneRelationshipKeys() {
		NSArray<String> keys = new NSArray<String>( new String[] {	
		});
		return keys;
	}
	
	public static NSArray<String> toManyRelationshipKeys() {
		NSArray<String> keys = new NSArray<String>( new String[] {
			"movies",
		});
    	return keys;
	}
	
	public Map<String, ?> toMap() {
		Map map = new HashMap();
		map.put("budget", budget);
		map.put("name", name);
		map.put("movies", movies);
		return map;
	}

	public void takeValuesFromMap(Map<String, ?> map) {
		budget = (BigDecimal)map.get("budget");
		name = (String)map.get("name");
		movies = (NSArray)map.get("movies");
		if (map.get( "primaryKeyValue" ) != null)
			primaryKeyValue = (Integer)map.get( "primaryKeyValue" );
	}
	
	public Object valueForKey(String key) {
		if ("primaryKeyValue".equals(key))
			return primaryKeyValue();
		else if ("entityName".equals(key))
			return entityName();
		else if ("budget".equals(key))
			return budget();
		else if ("name".equals(key))
			return name();
		else if ("movies".equals(key))
			return movies();
		else
			throw new RuntimeException(getClass().getName() + " does not has a key named '" + key + "'");
	}
	
	public void takeValueForKey(Object value, String key) {
		if ("primaryKeyValue".equals(key))
			setPrimaryKeyValue((Integer)value);
		else if ("budget".equals(key))
			setBudget((BigDecimal)value);
		else if ("name".equals(key))
			setName((String)value);
		else if ("movies".equals(key))
			setMovies((NSArray)value);
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
		return "Studio";
	}
	
	// Attributes
	public BigDecimal budget() {
		return budget;
	}
	
	public void setBudget(BigDecimal budget) {
		this.budget = budget;
	}

	public String name() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	private Integer primaryKeyValue;

	public Integer primaryKeyValue() {
		return primaryKeyValue;
	}
	
	public void setPrimaryKeyValue(Integer primaryKeyValue) {
		this.primaryKeyValue = primaryKeyValue;
	}

	// To One Relationships
	//To Many Relationships
	public NSArray<your.app.gwt.eo.MovieClient> movies() {
		return movies;
	}
	
	public void setMovies(NSArray<your.app.gwt.eo.MovieClient> movies) {
		this.movies = movies;
	}
	

	public String toString() {
		return toMap().toString();
	}

}
