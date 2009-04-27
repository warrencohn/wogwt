package com.webobjects.eocontrol;

public abstract class EOFaultHandler {

	public EOFaultHandler() {
		super();
	}
	
	public static boolean isFault(Object object) {
		return false;
	}
	
}
