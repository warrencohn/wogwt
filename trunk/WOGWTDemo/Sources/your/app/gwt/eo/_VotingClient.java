// DO NOT EDIT.  Make changes to VotingClient.java instead.
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
public abstract class _VotingClient extends WOGWTClientEOImpl {
	
	public static final transient String ENTITY_NAME = "Voting";
	
	// KEYS
	public static final String NUMBER_OF_VOTES_KEY = "numberOfVotes";
	public static final String RUNNING_AVERAGE_KEY = "runningAverage";
	public static final String MOVIE_KEY = "movie";
	
	// VARIABLES
	private Integer numberOfVotes;
	private Double runningAverage;
	private your.app.gwt.eo.MovieClient movie;

	public _VotingClient() {
		super();
	}
	
	public _VotingClient(NSDictionary<String, Object> snapshot) {
		super(snapshot);
	}

	public NSArray<String> attributeKeys() {
		NSArray<String> keys = new NSArray<String>( new String[] {
			"numberOfVotes",			
			"runningAverage"			
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
		map.put("numberOfVotes", numberOfVotes == null ? NSKeyValueCoding.NullValue : numberOfVotes);
		map.put("runningAverage", runningAverage == null ? NSKeyValueCoding.NullValue : runningAverage);
		map.put("movie", movie == null ? NSKeyValueCoding.NullValue : movie);
		return map;
	}

	public Object valueForKey(String key) {
		if ("numberOfVotes".equals(key)) {
			return numberOfVotes();
		}
		if ("runningAverage".equals(key)) {
			return runningAverage();
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
		if ("numberOfVotes".equals(key)) {
			setNumberOfVotes((Integer)value);
			return;
		}
		if ("runningAverage".equals(key)) {
			setRunningAverage((Double)value);
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

	// To One Relationships
	public your.app.gwt.eo.MovieClient movie() {
		return movie;
	}
	
	public void setMovie(your.app.gwt.eo.MovieClient movie) {
		this.movie =  movie;
	}
	
	// To Many Relationships

}
