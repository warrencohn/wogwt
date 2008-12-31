package com.webobjects.foundation;

import java.util.Collection;
import java.util.Set;

public class NSMutableSet<E> extends NSSet<E> {

	public NSMutableSet() {
		super();
	}
	
	public NSMutableSet(Collection<? extends E> collection) {
		super(collection);
	}
	
	public NSMutableSet(E object) {
		super(object);
	}
	
	public NSMutableSet(E[] objects) {
		super(objects);
		
	}
	
	public NSMutableSet(int capacity) {
		super(capacity);
	}
	
	public NSMutableSet(NSArray<? extends E> objects) {
		super(objects);
	}
	
	public NSMutableSet(NSSet<? extends E> otherSet) {
		super(otherSet);
	}
	
	public NSMutableSet(Set<? extends E> set, boolean ignoreNull) {
		super(set, ignoreNull);
	}
	
	public void addObject(E object) {
		add(object);
	}
	
	public void addObjectsFromArray(NSArray<? extends E> array) {
		addAll(array);
	}
	
	@Override
	public NSSet<E> immutableClone() {
		return new NSSet(this);
	}
	
	public void removeAllObjects() {
		clear();
	}
	
	public E removeObject(Object object) {
		if (remove(object))
			return (E) object;
		else
			return null;
	}
	
	public void setSet(NSSet<? extends E> otherSet) {
		clear();
		addAll(otherSet);
	}
	
	public void subtractSet(NSSet<? extends E> otherSet) {
		removeAll(otherSet);
	}
	
	public void unionSet(NSSet<? extends E> otherSet) {
		addAll(otherSet);
	}
	
	@Override
	public boolean add(E o) {
		return superDotAdd(o);
	}
	
	@Override
	public boolean addAll(Collection<? extends E> c) {
		return superDotAddAll(c);
	}
	
	@Override
	public void clear() {
		superDotClear();
	}
	
	@Override
	public Object clone() {
		return mutableClone();
	}
	
	@Override
	public boolean remove(Object o) {
		return superDotRemove(o);
	}
	
	@Override
	public boolean removeAll(Collection<?> c) {
		return superDotRemoveAll(c);
	}
	
	@Override
	public boolean retainAll(Collection<?> c) {
		return superDotRetainAll(c);
	}
	
}
