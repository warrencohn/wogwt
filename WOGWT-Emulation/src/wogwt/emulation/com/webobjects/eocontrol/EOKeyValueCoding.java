package com.webobjects.eocontrol;

import com.webobjects.foundation.NSKeyValueCoding;

public interface EOKeyValueCoding extends NSKeyValueCoding, NSKeyValueCoding.ErrorHandling {

	public Object storedValueForKey(String key);
	public void takeStoredValueForKey(Object value, String key);
	
}
