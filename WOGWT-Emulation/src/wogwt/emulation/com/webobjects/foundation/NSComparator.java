package com.webobjects.foundation;

import java.util.Comparator;

public abstract class NSComparator implements Comparator {

	public static final transient int OrderedAscending = -1;
	public static final transient int OrderedSame = 0;
	public static final transient int OrderedDescending = 1;

	public NSComparator() {
		super();
	}
	
	/* FIXME: this is really a hack, because it should throw 
	 * ComparisonException, but it doesn't so that we can extend 
	 * java.util.Comparator and use the Collections class for sorting.
	 */
	public abstract int compare (Object object1, Object object2);
	
	private static final transient NSComparator AscendingComparableComparator = new NSComparator() {
		public int compare(Object object1, Object object2) {
			if (object1 == null && object2 == null)
				return OrderedSame;
			else if (object1 == null)
				return OrderedDescending;
			else if (object2 == null)
				return OrderedAscending;
			else {
				int result = ((Comparable)object1).compareTo(object2);
				if (result > 0)
					return OrderedDescending;
				else if (result < 0)
					return OrderedAscending;
				else
					return OrderedSame;
			}
		}
	};
	
	private static final transient NSComparator DescendingComparableComparator = new NSComparator() {
		public int compare(Object object1, Object object2) {
			if (object1 == null && object2 == null)
				return OrderedSame;
			else if (object1 == null)
				return OrderedAscending;
			else if (object2 == null)
				return OrderedDescending;
			else {
				int result = ((Comparable)object1).compareTo(object2);
				if (result < 0)
					return OrderedDescending;
				else if (result > 0)
					return OrderedAscending;
				else
					return OrderedSame;
			}		
		}
	};
	
	public static final transient NSComparator AscendingStringComparator = AscendingComparableComparator;	
	public static final transient NSComparator DescendingStringComparator = DescendingComparableComparator;
	
	public static final transient NSComparator AscendingNumberComparator = AscendingComparableComparator;
	public static final transient NSComparator DescendingNumberComparator = DescendingComparableComparator;
	
	public static final transient NSComparator AscendingTimestampComparator = AscendingComparableComparator;
	public static final transient NSComparator DescendingTimestampComparator = DescendingComparableComparator;
	
	public static final transient NSComparator AscendingCaseInsensitiveStringComparator = new NSComparator() {
		public int compare(Object object1, Object object2) {
			if (object1 == null && object2 == null)
				return OrderedSame;
			else if (object1 == null)
				return OrderedDescending;
			else if (object2 == null)
				return OrderedAscending;
			else {
				int result = (((String)object1).toLowerCase()).compareTo(((String)object2).toLowerCase());
				if (result > 0)
					return OrderedDescending;
				else if (result < 0)
					return OrderedAscending;
				else
					return OrderedSame;
			}
		}
	};
	
	public static final transient NSComparator DescendingCaseInsensitiveStringComparator = new NSComparator() {
		public int compare(Object object1, Object object2) {
			if (object1 == null && object2 == null)
				return OrderedSame;
			else if (object1 == null)
				return OrderedAscending;
			else if (object2 == null)
				return OrderedDescending;
			else {
				int result = (((String)object1).toLowerCase()).compareTo(((String)object2).toLowerCase());
				if (result < 0)
					return OrderedDescending;
				else if (result > 0)
					return OrderedAscending;
				else
					return OrderedSame;
			}		
		}
	};
	
	public static class ComparisonException extends Exception {
		
		public ComparisonException(String message) {
			super(message);
		}
		
	}
}
