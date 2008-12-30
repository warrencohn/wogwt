package com.webobjects.foundation;

import java.io.Serializable;

public class NSRange extends Object implements Serializable, Cloneable {
	
	public static final NSRange ZeroRange = new NSRange();
	
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
		if (getClass() != obj.getClass())
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
		return location >= this.location && location <= this.maxRange();
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
		
		return (otherRange.location >= location &&
				otherRange.maxRange() <= maxRange());
	}
	
	public int maxRange() {
		if (length <= 0)
			return location;
		else
			return location + length - 1;
	}
	
	public NSRange rangeByIntersectingRange(NSRange otherRange) {
		if (otherRange == null)
			return ZeroRange;
		
		int start = Math.max(location, otherRange.location());
		int end = Math.min(maxRange(), otherRange.maxRange());
		return new NSRange(start, end - start + 1);
	}
	
	public NSRange rangeByUnioningRange(NSRange otherRange) {
		if (otherRange == null)
			return this;
		
		int start = Math.min(location, otherRange.location());
		int end = Math.max(maxRange(), otherRange.maxRange());
		return new NSRange(start, end - start + 1);
	}
	
//	public NSRange 	subtractRange(NSRange otherRange, NSMutableRange resultRange1, NSMutableRange resultRange2) {
//		// TODO: implement
//		throw new RuntimeException("not implemented");
//	}
	
}
