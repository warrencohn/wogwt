// DO NOT EDIT.  Make changes to Voting.java instead.
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
public abstract class _Voting implements IsSerializable, WOGWTClientEO, NSKeyValueCoding {
	
	// Attributes
	public static final String NUMBER_OF_VOTES_KEY = "numberOfVotes";
	public static final String RUNNING_AVERAGE_KEY = "runningAverage";

	// Relationships
	public static final String MOVIE_KEY = "movie";
	
	private Integer numberOfVotes;
	private Double runningAverage;
	private your.app.gwt.eo.MovieClient movie;

	public _Voting() {
		super();
	}
	
	public _Voting(Map<String, ?> map) {
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
			"numberOfVotes",			
			"runningAverage"			
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
		map.put("numberOfVotes", numberOfVotes);
		map.put("runningAverage", runningAverage);
		map.put("movie", movie);
		return map;
	}

	public void takeValuesFromMap(Map<String, ?> map) {
		numberOfVotes = (Integer)map.get("numberOfVotes");
		runningAverage = (Double)map.get("runningAverage");
		movie = (your.app.gwt.eo.MovieClient)map.get("movie");
		if (map.get( "primaryKeyValue" ) != null)
			primaryKeyValue = (Integer)map.get( "primaryKeyValue" );
	}
	
	public Object valueForKey(String key) {
		if ("primaryKeyValue".equals(key))
			return primaryKeyValue();
		else if ("entityName".equals(key))
			return entityName();
		else if ("numberOfVotes".equals(key))
			return numberOfVotes();
		else if ("runningAverage".equals(key))
			return runningAverage();
		else if ("movie".equals(key))
			return movie();
		else
			throw new RuntimeException(getClass().getName() + " does not has a key named '" + key + "'");
	}
	
	public void takeValueForKey(Object value, String key) {
		if ("primaryKeyValue".equals(key))
			setPrimaryKeyValue((Integer)value);
		else if ("numberOfVotes".equals(key))
			setNumberOfVotes((Integer)value);
		else if ("runningAverage".equals(key))
			setRunningAverage((Double)value);
		else if ("movie".equals(key))
			setMovie((your.app.gwt.eo.MovieClient)value);
		else
			throw new RuntimeException(getClass().getName() + " does not has a key named '" + key + "'");
	}
	
	public String entityName() {
		return "Voting";
	}
	
	// Attributes
	public Integer numberOfVotes() {
		return numberOfVotes;
	}
	
	public void setNumberOfVotes(Integer numberOfVotes) {
		this.numberOfVotes = numberOfVotes;
	}

	public Double runningAverage() {
		return runningAverage;
	}
	
	public void setRunningAverage(Double runningAverage) {
		this.runningAverage = runningAverage;
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
