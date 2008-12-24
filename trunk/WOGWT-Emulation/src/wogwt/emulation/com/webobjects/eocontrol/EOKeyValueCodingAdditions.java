package com.webobjects.eocontrol;

import com.webobjects.foundation.NSArray;
import com.webobjects.foundation.NSDictionary;

public interface EOKeyValueCodingAdditions {

	public void takeValuesFromDictionary(NSDictionary dictionary);
	public void takeValuesFromDictionaryWithMapping(NSDictionary dictionary,
			NSDictionary mapping);
	
	public NSDictionary valuesForKeys(NSArray keys);
	public NSDictionary valuesForKeysWithMapping(NSDictionary mapping);
}
