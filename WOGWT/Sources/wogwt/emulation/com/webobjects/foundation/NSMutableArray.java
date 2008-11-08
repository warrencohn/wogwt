package com.webobjects.foundation;

import java.util.ArrayList;
import java.util.Collection;

public class NSMutableArray<E> extends NSArray {

	public NSMutableArray() {
		super();
	}
	
	public NSMutableArray(E object) {
		super(object);
	}
	
	public NSMutableArray(E[] objects) {
		super(objects);
	}
	
	public NSMutableArray(int capacity) {
		super(capacity);
	}
	
	public NSMutableArray(Collection<? extends E> collection)  {
		super(collection);
	}
	
	public NSMutableArray(NSArray<? extends E> otherArray) {
		super(otherArray);
	}
	
	public void addObject(Object object) {
		add(object);
	}
	
	public void addObjects(Object[] objects) {
		for (int i = 0; i < objects.length; i++) {
			add(objects[i]);
		}
	}
	
	public void addObjectsFromArray(NSArray<? extends E> otherArray) {
		addAll(otherArray);
	}
	
	public NSArray immutableClone() {
		return new NSArray(toArray());
	}
	
	public NSMutableArray mutableClone() {
		return (NSMutableArray)this.clone();
	}
	
	public void insertObjectAtIndex(E object, int index) {
		add(index, object);
	}
	
	public void removeAllObjects() {
		clear();
	}
	
	public Object removeLastObject() {
		if (!isEmpty()) {
			return remove(size()-1);
		} 
		return null;
	}
	public boolean removeObject(Object e) {
		boolean result = false;
		while (result = remove(e)) {
		}
		return result;
	}
	
	public Object replaceObjectAtIndex(E object, int index) {
		return set(index, object);
	}
	
	public Object replaceObjectAtIndex(int index, E object) {
		return set(index, object);
	}
}
