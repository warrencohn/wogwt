package com.webobjects.eocontrol;

import com.webobjects.foundation.NSArray;

/**
 * This class MUST be subclassed.  It cannot be used stand-alone on the client.
 * It should be considered abstract.
 */
public class EOGenericRecord extends EOCustomObject {

	public static boolean usesDeferredFaultCreation() {
		return true;
	}
	
	public EOGenericRecord() {
		super();
	}
	
	public EOGenericRecord(EOClassDescription classDescription) {
		super();
	}
	
	@Override
	public Object opaqueState() {
		return null;
	}
	
	@Override
	public NSArray<String> attributeKeys() {
		return null;
	}
	
	@Override
	public NSArray<String> toManyRelationshipKeys() {
		return null;
	}
	
	@Override
	public NSArray<String> toOneRelationshipKeys() {
		return null;
	}
	
	@Override
	public int deleteRuleForRelationshipKey(String relationshipKey) {
		return -1;
	}
	
	@Override
	public String entityName() {
		return null;
	}
	
	@Override
	public String inverseForRelationshipKey(String relationshipKey) {
		return null;
	}
	
	@Override
	public boolean isReadOnly() {
		return false;
	}
	
	@Override
	public boolean ownsDestinationObjectsForRelationshipKey(String relationshipKey) {
		throw new UnsupportedOperationException("Abstract method (not implemented)");
	}

	@Override
	public Object valueForKey(String key) {
		throw new UnsupportedOperationException("Abstract method (not implemented)");
	}
	
	@Override
	public void takeValueForKey(Object value, String key) {
		throw new UnsupportedOperationException("Abstract method (not implemented)");
	}
	
	@Override
	public Object storedValueForKey(String key) {
		throw new UnsupportedOperationException("Abstract method (not implemented)");

	}
	
	@Override
	public void takeStoredValueForKey(Object value, String key) {
		throw new UnsupportedOperationException("Abstract method (not implemented)");
	}
	
	@Override
	protected void includeObjectIntoPropertyWithKey(Object eo, String key) {
		throw new UnsupportedOperationException("Abstract method (not implemented)");
	}
	
	@Override
	protected void excludeObjectFromPropertyWithKey(Object eo, String key) {
		throw new UnsupportedOperationException("Abstract method (not implemented)");
	}
	
}
