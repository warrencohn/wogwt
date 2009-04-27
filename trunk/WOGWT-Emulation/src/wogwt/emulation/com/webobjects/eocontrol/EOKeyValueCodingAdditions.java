package com.webobjects.eocontrol;

import com.webobjects.foundation.NSArray;
import com.webobjects.foundation.NSDictionary;
import com.webobjects.foundation.NSKeyValueCodingAdditions;

public interface EOKeyValueCodingAdditions extends NSKeyValueCodingAdditions, EOKeyValueCoding {

	public void takeValuesFromDictionary(NSDictionary dictionary);
	public void takeValuesFromDictionaryWithMapping(NSDictionary dictionary,
			NSDictionary mapping);
	
	public NSDictionary valuesForKeys(NSArray keys);
	public NSDictionary valuesForKeysWithMapping(NSDictionary mapping);
}
