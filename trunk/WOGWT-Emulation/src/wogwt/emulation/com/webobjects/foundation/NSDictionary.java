package com.webobjects.foundation;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/**
 * Fully implemented except for NSKeyValueCodingAdditions
 */
public class NSDictionary<K,V> extends HashMap implements NSKeyValueCoding,
	NSKeyValueCodingAdditions {

	public static final NSDictionary EmptyDictionary = new NSDictionary();
	
	public static final boolean CheckForNull = true;
	public static final boolean IgnoreNull = true;
	
	public NSDictionary() {
		super();
	}
	
	public NSDictionary(int capacity) {
		super(capacity);
	}
	
	public NSDictionary(Map<K,V> map) {
		super(map);
	}
	
	public NSDictionary(NSArray<V> objects, NSArray<K> keys) {
		if (keys == null || objects == null)
			return;
		
		if (objects.size() != keys.size())
			throw new IllegalArgumentException("number of keys does not match number of objects");
		
		for (int i = 0; i < keys.size(); i++) {
			super.put(keys.get(i), objects.get(i));
		}
	}
	
	public NSDictionary(NSDictionary<K,V> otherDictionary) {
		super(otherDictionary);
	}
	
	public NSDictionary(V[] objects, K[] keys) {
		if (keys == null || objects == null)
			return;
		
		if (objects.length != keys.length)
			throw new IllegalArgumentException("number of keys does not match number of objects");
		
		for (int i = 0; i < keys.length; i++) {
			super.put(keys[i], objects[i]);
		}
	}
	
	public NSDictionary(V object, K key) {
		super();
		if (key != null && object != null)
			super.put(key, object);
		else
			throw new IllegalArgumentException("Object or key may not be null");
	}
	
	public NSArray<K> allKeys() {
		return new NSArray(keySet().toArray());
	}
	
	public NSArray<K> allKeysForObject(Object object) {
		if (object == null)
			return NSArray.EmptyArray;
		
		NSMutableArray<K> result = new NSMutableArray<K>();
		
		NSArray keys = allKeys();
		for (int i = 0; i < keys.size(); i++) {
			Object key = keys.get(i);
			if (object.equals(get(key))) {
				result.add(key);
			}
		}
		
		return result;
	}
	
	public NSArray<V> allValues() {
		return new NSArray(values());
	}
	
	public int count() {
		return size();
	}
	
	public static <K,V> NSDictionary<K,V> emptyDictionary() {
		return new NSDictionary<K, V>();
	}
	
	public HashMap<K, V> hashMap() {
		return (HashMap<K, V>)clone();
	}
	
	public boolean isEqualToDictionary(NSDictionary otherDictionary) {
		return equals(otherDictionary);
	}
	
	public NSDictionary<K, V> immutableClone() {
		return this;
	}
	
	public NSMutableDictionary<K, V> mutableClone() {
		return new NSMutableDictionary<K, V>(this);
	}
	
	public Enumeration<V> objectEnumerator() {
		return allValues().objectEnumerator();
	}
	
	public V objectForKey(Object key) {
		return (V)get(key);
	}
			
	public Object valueForKey(String key) {
		return get(key);
	}
	
	public void takeValueForKey(Object value, String key) {
		if (value != null)
			superDotPut(key, value);
		else
			superDotRemove(key);
	}
	
	public Object valueForKeyPath(String keyPath) {
		if (containsKey(keyPath)) {
			return get(keyPath);
		}
		
		String firstKey;
		String restOfKeyPath = null;
		int dotIndex = keyPath.indexOf(NSKeyValueCodingAdditions.KeyPathSeparator);
		if (dotIndex == -1) {
			firstKey = keyPath;
		} else {
			firstKey = keyPath.substring(0, dotIndex);
			if (keyPath.length()-1 > dotIndex) {
				restOfKeyPath = keyPath.substring(dotIndex+1);
			}
		}

		Object firstValue = get(firstKey);
		if (firstValue != null && 
				(firstValue instanceof NSKeyValueCodingAdditions)
				&& restOfKeyPath != null) {
			return ((NSKeyValueCodingAdditions)firstValue).valueForKeyPath(restOfKeyPath);
		} else {
			return firstValue;
		}
	}
	
	// TODO: not sure how this behaves in WO
	public void takeValueForKeyPath(Object value, String keyPath) {
		superDotPut(keyPath, value);
	}
	
	protected void superDotClear() {
		super.clear();
	}
	
	protected Object superDotPut(Object key, Object value) {
		if (key == null || value == null)
			throw new IllegalArgumentException("Key or value may not be null");
		else
			return super.put(key, value);
	}
	
	protected void superDotPutAll(Map m) {
		if (m.containsKey(null) || m.containsValue(null))
			throw new IllegalArgumentException("Key or value may not be null");
		else
			super.putAll(m);
	}
	
	protected Object superDotRemove(Object key) {
		return super.remove(key);
	}
	
	private static final String UNSUPPORTED = " is not a supported operation in com.webobjects.foundation.NSDictionary";
	
		@Override
	public void clear() {
		throw new UnsupportedOperationException("clear" + UNSUPPORTED);
	}
	
	@Override
	public Object clone() {
		return this;
	}
		
	@Override
	public Object put(Object key, Object value) {
		throw new UnsupportedOperationException("put" + UNSUPPORTED);
	}
	
	@Override
	public void putAll(Map m) {
		throw new UnsupportedOperationException("putAll" + UNSUPPORTED);
	}
	
	@Override
	public Object remove(Object key) {
		throw new UnsupportedOperationException("remove" + UNSUPPORTED);
	}
	
}
