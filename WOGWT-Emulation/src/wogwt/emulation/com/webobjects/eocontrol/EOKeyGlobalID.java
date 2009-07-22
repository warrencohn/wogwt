package com.webobjects.eocontrol;

import com.webobjects.foundation.NSArray;

public abstract class EOKeyGlobalID extends EOGlobalID {

	public static EOKeyGlobalID globalIDWithEntityName(String entityName, Object[] values) {
		return null;
	}
	
	private String _entityName;
	private int _hash;
	
	protected EOKeyGlobalID(String entityName, int hashCode) {
		super();
		this._entityName = entityName;
		this._hash = hashCode;
	}

	public String entityName() {
		return _entityName;
	}
	
	@Override
	public int hashCode() {
		return _hash;
	}
	
	public abstract int keyCount();
	
	public abstract Object[] keyValues();
	
	public NSArray<Object> keyValuesArray() {
		return new NSArray<Object>(keyValues());
	}

}
