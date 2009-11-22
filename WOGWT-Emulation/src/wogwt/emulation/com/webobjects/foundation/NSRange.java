package com.webobjects.foundation;

import java.io.Serializable;

public class NSRange extends Object implements Serializable, Cloneable {
	
	public static final transient NSRange ZeroRange = new NSRange();
	
	/** 
	 * 
	 * @param string The string must be of the form "{location,length}"
	 * @return
	 */
	public static NSRange fromString(String string) {
		if (string == null || !string.trim().matches("\\{[0-9]+,\\s*[0-9]+\\}"))
			throw new IllegalArgumentException("Invalid argument to NSRange.fromString");
		
		String str = string.trim();
		str = str.substring(1, str.length()-1);
		String[] parts = str.split(",\\s*");
		
		return new NSRange(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]));
	}
	
	protected int location;
	protected int length;
	
	public NSRange() {
		location = 0;
		length = 0;
	}
	
	public NSRange(int location, int length) {
		if (length < 0) {
			throw new IllegalArgumentException("Cannot create an " + getClass().getName() + "with negative length.");
		}
		this.location = location;
		this.length = length;
	}
	
	public NSRange(NSRange range) {
		this();
		if (range != null) {
			this.location = range.location();
			this.length = range.length();
		}
	}

	public int location() {
		return location;
	}

	public int length() {
		return length;
	}
	
	public boolean isEqualToRange(NSRange otherRange) {
		return equals(otherRange);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + length;
		result = prime * result + location;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof NSRange))
			return false;
		final NSRange other = (NSRange) obj;
		if (length != other.length)
			return false;
		if (location != other.location)
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "{" + location + ", " + length + "}";
	}
	
	public Object clone()  {
		return this;
	}
	
	public boolean containsLocation(int location) {
		return location >= this.location && location <= lastLocation();
	}
	
	public boolean intersectsRange(NSRange otherRange) {
		if (otherRange == null)
			return false;
		
		if (otherRange.location >= location &&
				otherRange.location <= maxRange())
			return true; // starts in this range
		else if (otherRange.maxRange() >= location &&
				otherRange.maxRange() <= maxRange())
			return true; // ends in this range
		else
			return false;
	}
	
	public boolean isEmpty() {
		return length <= 0;
	}
	
	public boolean isSubrangeOfRange(NSRange otherRange) {
		if (otherRange == null)
			return false;
		
		return (otherRange.location <= location &&
				otherRange.maxRange() >= maxRange());
	}
	
	public int maxRange() {
		if (length <= 0)
			return location;
		else
			return location + length;
	}
	
	private int lastLocation() {
		if (length <= 0)
			return location;
		else
			return location + length -1;
	}
	
	public NSRange rangeByIntersectingRange(NSRange otherRange) {
		if (otherRange == null)
			return ZeroRange;
		
		int start = Math.max(location, otherRange.location());
		int end = Math.min(lastLocation(), otherRange.lastLocation());
		return new NSRange(start, end - start + 1);
	}
	
	public NSRange rangeByUnioningRange(NSRange otherRange) {
		if (otherRange == null)
			return this;
		
		int start = Math.min(location, otherRange.location());
		int end = Math.max(lastLocation(), otherRange.lastLocation());
		return new NSRange(start, end - start + 1);
	}
	
	public void subtractRange(NSRange otherRange, NSMutableRange resultRange1, NSMutableRange resultRange2) {
		NSRange intersection = rangeByIntersectingRange(otherRange);
		
		// no intersection, return the same range
		if (intersection.isEmpty()) {
			resultRange1.setLocation(location());
			resultRange1.setLength(length());
			
			resultRange2.setLocation(0);
			resultRange2.setLength(0);
		
		// total intersection, return empty range
		} else if (intersection.location() == location() && intersection.length() == length()) {
			resultRange1.setLocation(0);
			resultRange1.setLength(0);
			
			resultRange2.setLocation(0);
			resultRange2.setLength(0);
		
		// intersects from the start, single result with the remaining range
		} else if (intersection.location() == location()) { 
			resultRange1.setLocation(intersection.maxRange());
			resultRange1.setLength(length() - intersection.length());
			
			resultRange2.setLocation(0);
			resultRange2.setLength(0);
			
		// intersects from the end, single result with the beginning range
		} else {
			resultRange1.setLocation(intersection.location-1);
			resultRange1.setLength(length() - intersection.length());
			
			resultRange2.setLocation(0);
			resultRange2.setLength(0);
		}
	}
	
}
