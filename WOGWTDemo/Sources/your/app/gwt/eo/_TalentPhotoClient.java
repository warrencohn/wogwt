// DO NOT EDIT.  Make changes to TalentPhotoClient.java instead.
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
public abstract class _TalentPhotoClient extends WOGWTClientEOImpl {
	
	public static final transient String ENTITY_NAME = "TalentPhoto";
	
	// KEYS
	public static final String TALENT_KEY = "talent";
	
	// VARIABLES
	private your.app.gwt.eo.TalentClient talent;

	public _TalentPhotoClient() {
		super();
	}
	
	public _TalentPhotoClient(NSDictionary<String, Object> snapshot) {
		super(snapshot);
	}

	public NSArray<String> attributeKeys() {
		NSArray<String> keys = new NSArray<String>( new String[] {
		});
		return keys;
	}
	
	public NSArray<String> toOneRelationshipKeys() {
		NSArray<String> keys = new NSArray<String>( new String[] {	
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
		if ("talent".equals(relationshipKey))
			return deleteRuleNumber("EODeleteRuleNullify");
		return -1;
	}
	
	public String inverseForRelationshipKey(String relationshipKey) {
		if ("talent".equals(relationshipKey))
			return "photo";
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
		map.put("talent", talent == null ? NSKeyValueCoding.NullValue : talent);
		return map;
	}

	public Object valueForKey(String key) {
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
		return "TalentPhoto";
	}
	
	// Attributes
	// To One Relationships
	public your.app.gwt.eo.TalentClient talent() {
		return talent;
	}
	
	public void setTalent(your.app.gwt.eo.TalentClient talent) {
		this.talent =  talent;
	}
	
	// To Many Relationships

}
