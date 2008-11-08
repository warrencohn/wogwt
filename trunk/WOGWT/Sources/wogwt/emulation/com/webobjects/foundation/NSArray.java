package com.webobjects.foundation;

import java.util.ArrayList;
import java.util.Collection;

import com.webobjects.foundation.NSMutableArray;

public class NSArray<E> extends ArrayList {

	public NSArray() {
		super();
	}
	
	public NSArray(E object) {
		super();
		add(object);
	}
	
	public NSArray(E[] objects) {
		for (int i = 0; i < objects.length; i++) {
			add(objects[i]);
		}
	}
	
	public NSArray(Collection<? extends E> collection)  {
		this((E[])collection.toArray());
	}
	
	public NSArray(NSArray<? extends E> otherArray) {
		this((E[])otherArray.toArray());
	}
	
	public NSArray<E> arrayByAddingObject(E object) {
		NSArray<E> result = (NSArray<E>)this.clone();
		result.add(object);
		return result;
	}
	
	public NSArray<E> arrayByAddingObjectsFromArray(NSArray<E> otherArray) {
		NSArray<E> result = (NSArray<E>)this.clone();
		for (int i = 0; i < otherArray.size(); i++) {
			result.add(otherArray.get(i));
		}
		return result;
	}
	
	public ArrayList<E> arrayList() {
		return this;
	}
	
	public int count() {
		return size();
	}
	
	static <T> NSArray<T> emptyArray() {
		return new NSArray();
	}
	
	public NSArray<E> immutableClone() {
		return (NSArray<E>)this.clone();
	}
	
	public NSMutableArray<E> mutableClone() {
		return new NSMutableArray<E>(this);
	}
	
	public E objectAtIndex(int index) {
		return (E)get(index);
	}
	
	public E[] objects() {
		return (E[])toArray();
	}
	
}
