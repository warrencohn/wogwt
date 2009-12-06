// DO NOT EDIT.  Make changes to MovieRoleClient.java instead.
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
public abstract class _MovieRoleClient extends WOGWTClientEOImpl {
	
	public static final transient String ENTITY_NAME = "MovieRole";
	
	// KEYS
	public static final String ROLE_NAME_KEY = "roleName";
	public static final String MOVIE_KEY = "movie";
	public static final String TALENT_KEY = "talent";
	
	// VARIABLES
	private String roleName;
	private your.app.gwt.eo.MovieClient movie;
	private your.app.gwt.eo.TalentClient talent;

	public _MovieRoleClient() {
		super();
	}
	
	public _MovieRoleClient(NSDictionary<String, Object> snapshot) {
		super(snapshot);
	}

	public NSArray<String> attributeKeys() {
		NSArray<String> keys = new NSArray<String>( new String[] {
			"roleName"			
		});
		return keys;
	}
	
	public NSArray<String> toOneRelationshipKeys() {
		NSArray<String> keys = new NSArray<String>( new String[] {	
			"movie",			
			"talent"			
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
		if ("talent".equals(relationshipKey))
			return deleteRuleNumber("EODeleteRuleNullify");
		return -1;
	}
	
	public String inverseForRelationshipKey(String relationshipKey) {
		if ("talent".equals(relationshipKey))
			return "roles";
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
		map.put("roleName", roleName == null ? NSKeyValueCoding.NullValue : roleName);
		map.put("movie", movie == null ? NSKeyValueCoding.NullValue : movie);
		map.put("talent", talent == null ? NSKeyValueCoding.NullValue : talent);
		return map;
	}

	public Object valueForKey(String key) {
		if ("roleName".equals(key)) {
			return roleName();
		}
		if ("movie".equals(key)) {
			return movie();
		}
		if ("talent".equals(key)) {
			return talent();
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
		if ("roleName".equals(key)) {
			setRoleName((String)value);
			return;
		}
		if ("movie".equals(key)) {
			setMovie((your.app.gwt.eo.MovieClient)value);
			return;
		}
		if ("talent".equals(key)) {
			setTalent((your.app.gwt.eo.TalentClient)value);
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
		return "MovieRole";
	}
	
	// Attributes
	public String roleName() {
		return roleName;
	}
	
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	// To One Relationships
	public your.app.gwt.eo.MovieClient movie() {
		return movie;
	}
	
	public void setMovie(your.app.gwt.eo.MovieClient movie) {
		this.movie =  movie;
	}
	
	public your.app.gwt.eo.TalentClient talent() {
		return talent;
	}
	
	public void setTalent(your.app.gwt.eo.TalentClient talent) {
		this.talent =  talent;
	}
	
	// To Many Relationships

}
