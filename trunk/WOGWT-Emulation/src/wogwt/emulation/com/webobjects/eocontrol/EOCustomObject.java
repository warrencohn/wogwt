package com.webobjects.eocontrol;

import java.util.Iterator;

import com.webobjects.foundation.NSArray;
import com.webobjects.foundation.NSDictionary;
import com.webobjects.foundation.NSKeyValueCoding;
import com.webobjects.foundation.NSKeyValueCodingAdditions;
import com.webobjects.foundation.NSMutableArray;
import com.webobjects.foundation.NSMutableDictionary;
import com.webobjects.foundation.NSMutableSet;

/**
 * This class provides all the behavior possible, but most methods
 * need to be implemented in a subclass
 */
public abstract class EOCustomObject implements EOEnterpriseObject, EODeferredFaulting {

	private EOGlobalID __globalID;
	
	public EOCustomObject() {
		super();
	}
	
	public EOGlobalID __globalID() {
		return __globalID;
	}
	
	public void __setGlobalID(EOGlobalID id) {
		__globalID = id;
	}
	
	public void addObjectToPropertyWithKey(Object eo, String key) {
		if (isToManyKey(key)) {
			NSMutableArray value = ((NSArray) valueForKey(key)).mutableClone();
			if (value != null) {
				value.add(eo);
				takeStoredValueForKey(value, key);
			}
		} else {
			if (attributeKeys().contains(key) ||
					toOneRelationshipKeys().contains(key)) {
				takeStoredValueForKey(eo, key);
			}
		}
	}

	public void addObjectToBothSidesOfRelationshipWithKey(EORelationshipManipulation eo, String key){
		addObjectToPropertyWithKey(eo, key);
		if (inverseForRelationshipKey(key) != null) {
			eo.addObjectToPropertyWithKey(this, inverseForRelationshipKey(key));
		}
	}
	
	public NSArray<String> allPropertyKeys() {
		NSMutableSet<String> keys = new NSMutableSet();
		keys.addAll(attributeKeys());
		keys.addAll(toOneRelationshipKeys());
		keys.addAll(toManyRelationshipKeys());
    	return keys.allObjects();
	}
	
	public abstract NSArray<String> attributeKeys();

	public void awakeFromClientUpdate(EOEditingContext ec) {
	}
	
	public void awakeFromFetch(EOEditingContext ec) {
	}
	
	public void awakeFromInsertion(EOEditingContext ec) {
	}
	
	public static boolean canAccessFieldsDirectly() {
		return true;
	}
	
	public NSDictionary changesFromSnapshot(NSDictionary<String, Object> snapshot) {
		NSMutableDictionary result = new NSMutableDictionary();
		
		NSDictionary currentValues = snapshot();
		for (Iterator iterator = snapshot.keySet().iterator(); iterator.hasNext();) {
			String key = (String) iterator.next();
			Object snapshotValue = snapshot.get(key);
			if (currentValues.get(key).equals(snapshotValue)) {
				result.put(key, currentValues.get(key));
			}
		}
		
		return result;
	}
	
	public EOClassDescription classDescription() {
		return null;
	}
	
	public EOClassDescription classDescriptionForDestinationKey(String detailKey) {
		return null;
	}
	
	public void clearFault() {
		throw new IllegalStateException("clearFault was invoked on an object that is not a fault");
	}
	
	public void clearProperties() {
		NSMutableArray relationshipKeys = new NSMutableArray();
		relationshipKeys.addAll(toOneRelationshipKeys());
		relationshipKeys.addAll(toManyRelationshipKeys());
		
		for (Iterator iterator = relationshipKeys.iterator(); iterator.hasNext();) {
			String key = (String) iterator.next();
			takeValueForKey(null, key);
		}
	}
	
	public abstract int deleteRuleForRelationshipKey(String relationshipKey);
	
	public EOEditingContext editingContext() {
		return null;
	}
	
	public abstract String entityName();
	
	public String eoDescription() {
		return toString();
	}
	
	public String eoShallowDescription() {
		return toString();
	}
	
	protected abstract void includeObjectIntoPropertyWithKey(Object eo, String key);
	
	protected abstract void excludeObjectFromPropertyWithKey(Object eo, String key);
	
	public abstract String inverseForRelationshipKey(String relationshipKey);
	
	public abstract boolean isFault();
	
	public abstract boolean isReadOnly();
	
	public boolean isToManyKey(String key) {
		return toManyRelationshipKeys().contains(key);
	}
	
	public abstract Object opaqueState();
	
	public abstract boolean ownsDestinationObjectsForRelationshipKey(String relationshipKey); 
	
	public void prepareValuesForClient() {
	}

	public void propagateDeleteWithEditingContext(EOEditingContext ec) {
	}
	
	public void reapplyChangesFromDictionary(NSDictionary<String, Object> changes) {
		for (Iterator iterator = changes.keySet().iterator(); iterator.hasNext();) {
			String key = (String) iterator.next();
			Object value = changes.get(key);
			takeValueForKey(value, key);
		}
	}
	
	public void removeObjectFromPropertyWithKey(Object eo, String key) {
		if (isToManyKey(key)) {
			NSMutableArray value = ((NSArray) valueForKey(key)).mutableClone();
			if (value != null) {
				value.remove(eo);
				takeStoredValueForKey(value, key);
			}
		} else {
			takeStoredValueForKey(null, key);
		}
	}
	
	public void removeObjectFromBothSidesOfRelationshipWithKey(EORelationshipManipulation eo, String key) {
		removeObjectFromPropertyWithKey(eo, key);
		if (inverseForRelationshipKey(key) != null) {
			eo.removeObjectFromPropertyWithKey(this, inverseForRelationshipKey(key));
		}
	}
	
	public static boolean shouldUseStoredAccessors() {
		return true;
	}
	
	public NSDictionary<String, Object> snapshot() {
		NSMutableDictionary<String, Object> result = new NSMutableDictionary<String, Object>();
		
		for (Iterator iterator = attributeKeys().iterator(); iterator.hasNext();) {
			String key = (String) iterator.next();
			Object value = valueForKey(key);
			if (value == null)
				value = NSKeyValueCoding.NullValue;
			result.put(key, value);
		}
		
		for (Iterator iterator = toOneRelationshipKeys().iterator(); iterator.hasNext();) {
			String key = (String) iterator.next();
			Object value = valueForKey(key);
			if (value == null)
				value = NSKeyValueCoding.NullValue;
			result.put(key, value);
		}
		
		for (Iterator iterator = toManyRelationshipKeys().iterator(); iterator.hasNext();) {
			String key = (String) iterator.next();
			Object value = valueForKey(key);
			if (value == null)
				value = NSArray.EmptyArray;
			result.put(key, value);
		}
		
		return result.immutableClone();
	}
	
	public abstract NSArray<String> toManyRelationshipKeys();
	
	public abstract NSArray<String> toOneRelationshipKeys();
	
	public void updateFromSnapshot(NSDictionary<String, Object> snapshot) {
		takeValuesFromDictionary(snapshot);
	}
	
	public String userPresentableDescription() {
		return toString();
	}
	
	public void willChange() {
		
	}
	
	public void willRead() {
		
	}
	
	public Object willReadRelationship(Object value) {
		// assume there aren't any faults on the client
		return value;
	}
	
	public Object handleQueryWithUnboundKey(String key) {
		throw new NSKeyValueCoding.UnknownKeyException("Class '" + getClass().getName() + " does not have a client key named ", this, key);
	}
	
	public void handleTakeValueForUnboundKey(Object value, String key) {
		throw new NSKeyValueCoding.UnknownKeyException("Class '" + getClass().getName() + " does not have a client key named " + key, this, key);
	}
	
	public abstract Object storedValueForKey(String key);
	
	public abstract void takeStoredValueForKey(Object value, String key);
	
	public abstract void takeValueForKey(Object value, String key);
	
	public void takeValueForKeyPath(Object value, String keyPath) {
		NSKeyValueCodingAdditions.DefaultImplementation.takeValueForKeyPath(this, value, keyPath);
	}
	
	public void takeValuesFromDictionary(NSDictionary dictionary) {
		for (Iterator iterator = dictionary.keySet().iterator(); iterator.hasNext();) {
			String key = (String) iterator.next();
			Object value = dictionary.get(key);
			if (value.equals(NSKeyValueCoding.NullValue)) {
				value = null;
			}
			takeValueForKey(value, key);
		}
	}
	
	public void takeValuesFromDictionaryWithMapping(NSDictionary dictionary,
			NSDictionary mapping) {
		for (Iterator iterator = dictionary.keySet().iterator(); iterator.hasNext();) {
			String key = (String)mapping.get(iterator.next());
			Object value = dictionary.get(key);
			if (value.equals(NSKeyValueCoding.NullValue)) {
				value = null;
			}
			takeValueForKey(value, key);
		}
	}
	
	public void unableToSetNullForKey(String key) {
		throw new IllegalArgumentException("Unable to set null for key '" + key + "'");
	}
	
	public abstract Object valueForKey(String key);
	
	public Object valueForKeyPath(String keyPath) {
		return NSKeyValueCodingAdditions.DefaultImplementation.valueForKeyPath(this, keyPath);
	}
	
	public NSDictionary valuesForKeys(NSArray keys) {
		NSMutableDictionary result = new NSMutableDictionary();
		for (Iterator iterator = keys.iterator(); iterator.hasNext();) {
			String key = (String) iterator.next();
			result.put(key, valueForKey(key));
		}
		return result.immutableClone();
	}
	
	public NSDictionary valuesForKeysWithMapping(NSDictionary mapping) {
		NSMutableDictionary result = new NSMutableDictionary();
		for (Iterator iterator = mapping.keySet().iterator(); iterator.hasNext();) {
			String key = (String) iterator.next();
			key = (String) mapping.get(key);
			result.put(key, valueForKey(key));
		}
		return result.immutableClone();
	}
	
	public Object validateValueForKey(Object value, String key)
		throws ValidationException {
		// TODO: validate
		return value;
	}
            
	public Object validateTakeValueForKeyPath(Object value, String keyPath)
		throws ValidationException {
		// TODO: validate
		takeValueForKeyPath(value, keyPath);
		return value;
	}
            
	public void validateClientUpdate() throws ValidationException {
	}
	
	public void validateForUpdate() throws ValidationException {
	}
	
	public void validateForDelete() throws ValidationException {
	}
	
	public void validateForInsert() throws ValidationException {		
	}
	
	public void validateForSave() throws ValidationException {		
	}
	
	public String toString() {
		return snapshot().toString();
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
		EOCustomObject other = (EOCustomObject) obj;
		if (__globalID == null) {
			if (other.__globalID != null)
				return false;
		} else if (!__globalID.equals(other.__globalID))
			return false;
		return true;
	}
	
}
