package com.webobjects.eocontrol;

import com.webobjects.foundation.NSArray;
import com.webobjects.foundation.NSMutableArray;

public class _EOCheapCopyMutableArray extends NSMutableArray {

	public _EOCheapCopyMutableArray() {
		super();
	}
	
	public _EOCheapCopyMutableArray(NSArray otherArray) {
		super(otherArray);
	}
	
	public _EOCheapCopyMutableArray(EOFaultHandler handler) {
		super();
	}
	
}
