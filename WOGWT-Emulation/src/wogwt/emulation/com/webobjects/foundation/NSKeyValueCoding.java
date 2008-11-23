package com.webobjects.foundation;

public interface NSKeyValueCoding {

	public void takeValueForKey(Object value, String key);
	public Object valueForKey(String key);
	
}
