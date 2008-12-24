package com.webobjects.foundation;

import java.util.Collection;
import java.util.List;

public class NSMutableArray<E> extends NSArray {

	public NSMutableArray() {
		super();
	}
	
	public NSMutableArray(Collection<? extends E> collection)  {
		super(collection);
	}
	
	public NSMutableArray(E object) {
		super(object);
	}
	
	public NSMutableArray(E[] objects) {
		super(objects);
	}
	
	public NSMutableArray(E[] objects, NSRange range) {
		super(objects, range);
	}
	
	public NSMutableArray(int capacity) {
		super(capacity);
	}
	
	public NSMutableArray(List<? extends E> list, NSRange range, boolean ignoreNull) {
		super(list, range, ignoreNull);
	}

	public NSMutableArray(NSArray<? extends E> otherArray) {
		super(otherArray);
	}
	
	public void addObject(Object object) {
		add(object);
	}
	
	public void addObjects(Object[] objects) {
		if (objects == null)
			return;
		for (int i = 0; i < objects.length; i++) {
			add(objects[i]);
		}
	}
	
	public void addObjectsFromArray(NSArray<? extends E> otherArray) {
		addAll(otherArray);
	}
	
	public NSArray immutableClone() {
		return new NSArray(this);
	}
	
	public void insertObjectAtIndex(E object, int index) {
		add(index, object);
	}
	
	public void removeAllObjects() {
		clear();
	}
	
	public boolean removeIdenticalObject(Object object) {
		int index = indexOfIdenticalObject(object);
		if (index != NotFound) {
			remove(index);
		}
		return index != NotFound;
	}
	
	public boolean removeIdenticalObject(Object object, NSRange range) {
		for (int i = range.location(); i <= range.maxRange(); i++) {
			if (get(i) == object) {
				remove(i);
				return true;
			}
		}
		return false;
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
	
	public boolean removeObject(Object object, NSRange range) {
		for (int i = range.location(); i <= range.maxRange(); i++) {
			if (get(i).equals(object)) {
				remove(i);
				return true;
			}
		}
		return false;
	}
	
	public E removeObjectAtIndex(int index) {
		return (E)remove(index);
	}
	
	public void removeObjects(Object[] objects) {
		removeAll(new NSArray(objects));
	}
	
	public void removeObjectsInArray(NSArray otherArray) {
		removeAll(otherArray);
	}
	
	public void removeObjectsInRange(NSRange range) {
		NSMutableArray<E> objectsToRemove = new NSMutableArray<E>();
		for (int i = range.location(); i <= range.maxRange(); i++) {
			objectsToRemove.add(get(i));
		}
		removeObjectsInArray(objectsToRemove);
	}
	
	public Object replaceObjectAtIndex(E object, int index) {
		return set(index, object);
	}
	
	public Object replaceObjectAtIndex(int index, E object) {
		return set(index, object);
	}
	
	/* copied from Project Wonder's NSMutableArray implementation */
	public void replaceObjectsInRange(NSRange range, NSArray<E> otherArray, NSRange otherRange) {
        if (range == null || otherRange == null)
            throw new IllegalArgumentException("Both ranges cannot be null");
        if (otherArray == null)
            throw new IllegalArgumentException("Other array cannot be null");
        int rangeLength = range.length();
        int rangeLocation = range.location();
        int otherRangeLength = otherRange.length();
        int otherRangeLocation = otherRange.location();
        for (; 0 < rangeLength && 0 < otherRangeLength; otherRangeLength--) {
            replaceObjectAtIndex(otherArray.objectAtIndex(otherRangeLocation), rangeLocation);
            rangeLocation++;
            rangeLength--;
            otherRangeLocation++;
        }

        for (; 0 < otherRangeLength; otherRangeLength--) {
            insertObjectAtIndex(otherArray.objectAtIndex(otherRangeLocation), rangeLocation);
            rangeLocation++;
            otherRangeLocation++;
        }

        for (; 0 < rangeLength; rangeLength--)
            removeObjectAtIndex(rangeLocation);
	}
	
	public void setArray(NSArray otherArray) {
		clear();
		addAll(otherArray);
	}
	
	public void sortUsingComparator(NSComparator comparator) {
		// TODO: implement
		throw new RuntimeException("not implemented");
	}
	
	@Override
	public boolean add(Object o) {
		return superDotAdd(o);
	}
	
	@Override
	public void add(int index, Object element) {
		superDotAdd(index, element);
	}
	
	@Override
	public boolean addAll(Collection c) {
		return superDotAddAll(c);
	}
	
	@Override
	public boolean addAll(int index, Collection c) {
		return superDotAddAll(index, c);
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
	public Object remove(int index) {
		return superDotRemove(index);
	}
	
	@Override
	public boolean remove(Object o) {
		return superDotRemove(o);
	}
	
	@Override
	public boolean removeAll(Collection c) {
		return superDotRemoveAll(c);
	}
	
	@Override
	public boolean retainAll(Collection c) {
		return superDotRetainAll(c);
	}
	
	@Override
	public Object set(int index, Object element) {
		if (element == null)
			throw new IllegalArgumentException(NULL_NOT_ALLOWED);
		return superDotSet(index, element);
	}
	
}
