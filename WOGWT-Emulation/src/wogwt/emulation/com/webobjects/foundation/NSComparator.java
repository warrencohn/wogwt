package com.webobjects.foundation;

public abstract class NSComparator {

	public static final int OrderedAscending = -1;
	public static final int OrderedSame = 0;
	public static final int OrderedDescending = 1;
	
	// TODO: add static comparator instances
	
	public NSComparator() {
		super();
	}
	
	public abstract int compare (Object object1, Object object2);
	
	public static class ComparisonException extends Exception {
		
		public ComparisonException(String message) {
			super(message);
		}
		
	}
}
