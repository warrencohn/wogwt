package com.webobjects.eocontrol;

public interface EOFaulting {

	public void clearFault();
	//public EOFaultHandler faultHandler();
	public boolean isFault();
	//public void turnIntoFault(EOFaultHandler handler);
	public void willRead();
	
}
