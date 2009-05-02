package com.webobjects.eocontrol;

import java.io.Serializable;

public class EOGlobalID implements Serializable, Cloneable {

	public static final String GlobalIDChangedNotification = "EOGlobalIDChangedNotification";
	
	public EOGlobalID() {
		super();
	}
	
	public boolean isTemporary() {
		return false;
	}
	
	public Object clone() {
		return this;
	}

}
