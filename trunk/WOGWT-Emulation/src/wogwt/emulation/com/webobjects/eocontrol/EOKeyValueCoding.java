package com.webobjects.eocontrol;

public interface EOKeyValueCoding {

	public Object storedValueForKey(String key);
	public void takeStoredValueForKey(Object value, String key);
	
}
