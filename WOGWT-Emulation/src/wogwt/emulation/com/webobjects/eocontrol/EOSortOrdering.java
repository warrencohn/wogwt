package com.webobjects.eocontrol;

import java.io.Serializable;

import com.webobjects.foundation.NSArray;
import com.webobjects.foundation.NSMutableArray;
import com.webobjects.foundation.NSSelector;

public class EOSortOrdering implements Serializable {

	public static interface Comparision {
		public int compareAscending(Object other);
		public int compareCaseInsensitiveAscending(Object other);
		public int compareCaseInsensitiveDescending(Object other);
		public int compareDescending(Object other);
	}
	
	public static <E> void sortArrayUsingKeyOrderArray(NSMutableArray<E> array, NSArray<EOSortOrdering> sortOrderings) {
	}

	public static <E> NSArray<E> sortedArrayUsingKeyOrderArray(NSArray<E> array, NSArray<EOSortOrdering> sortOrderings) {
		return array;
	}
	
	public static EOSortOrdering sortOrderingWithKey(String key, NSSelector selector) {
		return new EOSortOrdering(key, selector);
	}
	
	private String key;
	private NSSelector selector;
	
	public EOSortOrdering(String key, NSSelector selector) {
		super();
		this.key = key;
		this.selector = selector;
	}

	public String key() {
		return key;
	}

	public NSSelector selector() {
		return selector;
	}

}
