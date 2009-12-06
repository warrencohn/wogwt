// DO NOT EDIT.  Make changes to MovieClient.java instead.
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
public abstract class _MovieClient extends WOGWTClientEOImpl {
	
	public static final transient String ENTITY_NAME = "Movie";
	
	// KEYS
	public static final String CATEGORY_KEY = "category";
	public static final String DATE_RELEASED_KEY = "dateReleased";
	public static final String POSTER_NAME_KEY = "posterName";
	public static final String RATED_KEY = "rated";
	public static final String REVENUE_KEY = "revenue";
	public static final String TITLE_KEY = "title";
	public static final String TRAILER_NAME_KEY = "trailerName";
	public static final String STUDIO_KEY = "studio";
	
	// VARIABLES
	private String category;
	private NSTimestamp dateReleased;
	private String posterName;
	private String rated;
	private java.math.BigDecimal revenue;
	private String title;
	private String trailerName;
	private your.app.gwt.eo.StudioClient studio;

	public _MovieClient() {
		super();
	}
	
	public _MovieClient(NSDictionary<String, Object> snapshot) {
		super(snapshot);
	}

	public NSArray<String> attributeKeys() {
		NSArray<String> keys = new NSArray<String>( new String[] {
			"category",			
			"dateReleased",			
			"posterName",			
			"rated",			
			"revenue",			
			"title",			
			"trailerName"			
		});
		return keys;
	}
	
	public NSArray<String> toOneRelationshipKeys() {
		NSArray<String> keys = new NSArray<String>( new String[] {	
			"studio"			
		});
		return keys;
	}
	
	public NSArray<String> toManyRelationshipKeys() {
		NSArray<String> keys = new NSArray<String>( new String[] {
		});
    	return keys;
	}

	public int deleteRuleForRelationshipKey(String relationshipKey) {
		if ("studio".equals(relationshipKey))
			return deleteRuleNumber("EODeleteRuleNullify");
		return -1;
	}
	
	public String inverseForRelationshipKey(String relationshipKey) {
		if ("studio".equals(relationshipKey))
			return "movies";
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
		map.put("category", category == null ? NSKeyValueCoding.NullValue : category);
		map.put("dateReleased", dateReleased == null ? NSKeyValueCoding.NullValue : dateReleased);
		map.put("posterName", posterName == null ? NSKeyValueCoding.NullValue : posterName);
		map.put("rated", rated == null ? NSKeyValueCoding.NullValue : rated);
		map.put("revenue", revenue == null ? NSKeyValueCoding.NullValue : revenue);
		map.put("title", title == null ? NSKeyValueCoding.NullValue : title);
		map.put("trailerName", trailerName == null ? NSKeyValueCoding.NullValue : trailerName);
		map.put("studio", studio == null ? NSKeyValueCoding.NullValue : studio);
		return map;
	}

	public Object valueForKey(String key) {
		if ("category".equals(key)) {
			return category();
		}
		if ("dateReleased".equals(key)) {
			return dateReleased();
		}
		if ("posterName".equals(key)) {
			return posterName();
		}
		if ("rated".equals(key)) {
			return rated();
		}
		if ("revenue".equals(key)) {
			return revenue();
		}
		if ("title".equals(key)) {
			return title();
		}
		if ("trailerName".equals(key)) {
			return trailerName();
		}
		if ("studio".equals(key)) {
			return studio();
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
		if ("category".equals(key)) {
			setCategory((String)value);
			return;
		}
		if ("dateReleased".equals(key)) {
			setDateReleased((NSTimestamp)value);
			return;
		}
		if ("posterName".equals(key)) {
			setPosterName((String)value);
			return;
		}
		if ("rated".equals(key)) {
			setRated((String)value);
			return;
		}
		if ("revenue".equals(key)) {
			setRevenue((java.math.BigDecimal)value);
			return;
		}
		if ("title".equals(key)) {
			setTitle((String)value);
			return;
		}
		if ("trailerName".equals(key)) {
			setTrailerName((String)value);
			return;
		}
		if ("studio".equals(key)) {
			setStudio((your.app.gwt.eo.StudioClient)value);
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
		return "Movie";
	}
	
	// Attributes
	public String category() {
		return category;
	}
	
	public void setCategory(String category) {
		this.category = category;
	}

	public NSTimestamp dateReleased() {
		return dateReleased;
	}
	
	public void setDateReleased(NSTimestamp dateReleased) {
		this.dateReleased = dateReleased;
	}

	public String posterName() {
		return posterName;
	}
	
	public void setPosterName(String posterName) {
		this.posterName = posterName;
	}

	public String rated() {
		return rated;
	}
	
	public void setRated(String rated) {
		this.rated = rated;
	}

	public java.math.BigDecimal revenue() {
		return revenue;
	}
	
	public void setRevenue(java.math.BigDecimal revenue) {
		this.revenue = revenue;
	}

	public String title() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}

	public String trailerName() {
		return trailerName;
	}
	
	public void setTrailerName(String trailerName) {
		this.trailerName = trailerName;
	}

	// To One Relationships
	public your.app.gwt.eo.StudioClient studio() {
		return studio;
	}
	
	public void setStudio(your.app.gwt.eo.StudioClient studio) {
		this.studio =  studio;
	}
	
	// To Many Relationships

}
