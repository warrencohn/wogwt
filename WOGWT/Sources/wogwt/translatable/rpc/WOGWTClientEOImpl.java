package wogwt.translatable.rpc;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.webobjects.eocontrol.EOCustomObject;
import com.webobjects.eocontrol.EOGlobalID;
import com.webobjects.foundation.NSArray;
import com.webobjects.foundation.NSDictionary;
import com.webobjects.foundation.NSKeyValueCoding;
import com.webobjects.foundation.NSKeyValueCodingAdditions;
import com.webobjects.foundation.NSMutableDictionary;

/**
 * Base class for the client DTO objects used in place of EOs.
 *
 */
public abstract class WOGWTClientEOImpl implements WOGWTClientEO {

	private EOGlobalID __globalID;
	private boolean isFault = false;
	
	public WOGWTClientEOImpl() {
		super();
	}
	
	public WOGWTClientEOImpl(NSDictionary<String, Object> snapshot) {
		super();
		updateFromSnapshot( snapshot );
	}
	
	public EOGlobalID __globalID() {
		return __globalID;
	}
	
	protected void setGlobalID(EOGlobalID id) {
		__globalID = id;
	}
	
	public boolean isFault() {
		return isFault;
	}
	
	protected void setIsFault(boolean value) {
		isFault = value;
	}
	
	public NSArray<String> allPropertyKeys() {
		List<String> keys = new ArrayList();
		keys.addAll(attributeKeys());
		keys.addAll(toOneRelationshipKeys());
		keys.addAll(toManyRelationshipKeys());
    	return new NSArray(keys);
	}

	 
	public boolean isToManyKey(String key) {
		return toManyRelationshipKeys().contains(key);
	}
	
	public int deleteRuleNumber(String deleteRuleName) {
		if ("EODeleteRuleNullify".equals(deleteRuleName)) {
			return 0;
		} else if ("EODeleteRuleCascade".equals(deleteRuleName)) {
			return 1;
		} else if ("EODeleteRuleDeny".equals(deleteRuleName)) {
			return 2;
		} else if ("EODeleteRuleNoAction".equals(deleteRuleName)) {
			return 3;
		} else {
			return -1;
		}
	}
	
	public void updateFromSnapshot(NSDictionary<String, Object> snapshot) {
		for (String key : snapshot.allKeys()) {
			Object value = snapshot.get(key);
			
			if (NSKeyValueCoding.NullValue == value) {
				value = null;
			}
			
			if (value instanceof NSArray) {
				value = ((NSArray)value).mutableClone();
			}	
			
			takeValueForKey(value, key);
		}
	}
	
	public Object valueForKeyPath(String keyPath) {
		return NSKeyValueCodingAdditions.DefaultImplementation.valueForKeyPath(this, keyPath);
	}
	
	public void takeValueForKeyPath(Object value, String keyPath) {
		NSKeyValueCodingAdditions.DefaultImplementation.takeValueForKeyPath(this, value, keyPath);
	}
	
	public Object handleQueryWithUnboundKey(String key) {
		throw new NSKeyValueCoding.UnknownKeyException("Class '" + getClass().getName() + " does not have a client key named " + key, this, key);	
	}
	
	public void handleTakeValueForUnboundKey(Object value, String key) {
		throw new NSKeyValueCoding.UnknownKeyException("Class '" + getClass().getName() + " does not have a client key named " + key, this, key);
	}
	
	public NSDictionary valuesForKeys(NSArray keys) {
		NSMutableDictionary result = new NSMutableDictionary();
		for (Iterator iterator = keys.iterator(); iterator.hasNext();) {
			String key = (String) iterator.next();
			result.put(key, valueForKey(key));
		}
		return result.immutableClone();
	}
	
	public String toString() {
		return entityName() + ": " + __globalID().toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((__globalID == null) ? 0 : __globalID.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		WOGWTClientEO other = (WOGWTClientEO) obj;
		if (__globalID == null) {
			if (other.__globalID() != null)
				return false;
		} else if (!__globalID.equals(other.__globalID()))
			return false;
		return true;
	}
	
}
