package com.webobjects.eocontrol;

import com.webobjects.foundation.NSArray;

public class _EOCheapCopyArray extends NSArray {

	public _EOCheapCopyArray() {
		super();
	}
	
	public _EOCheapCopyArray(NSArray otherArray) {
		super(otherArray);
	}
	
	public boolean isFault() {
		return true;
	}
	
}
