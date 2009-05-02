package com.webobjects.eocontrol;

import com.webobjects.foundation.NSDictionary;
import com.webobjects.foundation.NSMutableSet;
import com.webobjects.foundation.NSSelector;

/**
 * This class does NOTHING.  It is only defined so that the same EO classes
 * can be used both on the server and client.
 *
 */
public class EOKeyValueQualifier extends EOQualifier {

	public EOKeyValueQualifier(String key, NSSelector selector, Object value) {
		super();
	}

	@Override
	public void addQualifierKeysToSet(NSMutableSet arg0) {
	}

	@Override
	public EOQualifier qualifierWithBindings(NSDictionary arg0, boolean arg1) {
		return null;
	}

	@Override
	public void validateKeysWithRootClassDescription(EOClassDescription arg0) {
	}
	
}
