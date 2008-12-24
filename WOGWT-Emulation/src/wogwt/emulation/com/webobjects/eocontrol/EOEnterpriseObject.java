package com.webobjects.eocontrol;

import java.io.Serializable;

import com.webobjects.foundation.NSArray;
import com.webobjects.foundation.NSDictionary;
import com.webobjects.foundation.NSKeyValueCoding;
import com.webobjects.foundation.NSKeyValueCodingAdditions;

public interface EOEnterpriseObject extends EODeferredFaulting, 
	EOKeyValueCoding, EOKeyValueCodingAdditions, NSKeyValueCoding, 
	NSKeyValueCoding.ErrorHandling, NSKeyValueCodingAdditions, Serializable {

	public void addObjectToPropertyWithKey(Object eo, String key);
	
	public NSArray<String> allPropertyKeys();
	
	public NSArray<String> attributeKeys();
	
	public NSDictionary changesFromSnapshot(NSDictionary<String, Object> snapshot);
	
	public void clearFault();
	
	public void clearProperties();
	
	public int deleteRuleForRelationshipKey(String relationshipKey);
	
	public String entityName();
	
	public String eoDescription();
	
	public String eoShallowDescription();
	
	public String inverseForRelationshipKey(String relationshipKey);
	
	public boolean isFault();
	
	public boolean isReadOnly();
	
	public boolean isToManyKey(String key);
	
	public Object opaqueState();
	
	public boolean ownsDestinationObjectsForRelationshipKey(String relationshipKey);
	
	public void prepareValuesForClient();
	
	public void reapplyChangesFromDictionary(NSDictionary<String, Object> changes);
	
	public void removeObjectFromPropertyWithKey(Object eo, String key);
	
	public NSDictionary<String, Object> snapshot();
	

	
	public NSArray<String> toManyRelationshipKeys();
	
	public NSArray<String> toOneRelationshipKeys();
	
	public void updateFromSnapshot(NSDictionary<String, Object> snapshot);
	
	public String userPresentableDescription();
	
	public void willChange();
	public void willRead();
	
	
}
