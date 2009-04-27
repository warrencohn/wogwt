package com.webobjects.eocontrol;

public interface EODeferredFaulting extends EOFaulting {

	public Object willReadRelationship(Object value);
	
}
