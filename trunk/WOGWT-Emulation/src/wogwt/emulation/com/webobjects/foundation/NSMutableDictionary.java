package com.webobjects.foundation;

import java.util.Map;

import com.google.gwt.user.client.rpc.IsSerializable;

/**
 * Fully implemented except for NSKeyValueCodingAdditions
 */
public class NSMutableDictionary<K,V> extends NSDictionary {

	public NSMutableDictionary() {
		super();
	}
	
	public NSMutableDictionary(int capacity) {
		super(capacity);
	}
	
	public NSMutableDictionary(Map<K,V> map) {
		super(map);
	}
	
	public NSMutableDictionary(NSArray<V> objects, NSArray<K> keys) {
		super(objects, keys);
	}
	
	public NSMutableDictionary(NSMutableDictionary<K,V> otherDictionary) {
		super(otherDictionary);
	}
	
	public NSMutableDictionary(V[] objects, K[] keys) {
		super(objects, keys);
	}
	
	public NSMutableDictionary(V object, K key) {
		super();
		put(key, object);
	}
	
	public void addEntriesFromDictionary(NSDictionary otherDictionary) {
		putAll(otherDictionary);
	}
	
	public NSDictionary<K, V> immutableClone() {
		return new NSDictionary<K, V>(this);
	}
	
	public void removeAllObjects() {
		clear();
	}
	
	public V removeObjectForKey(Object key) {
		return (V)remove(key);
	}
	
	public void removeObjectsForKeys(NSArray keys) {
		if (keys == null)
			return;
		for (int i = 0; i < keys.size(); i++) {
			remove(keys.get(i));
		}
	}
	
	public void setDictionary(NSDictionary otherDictionary) {
		clear();
		putAll(otherDictionary);
	}
	
	public void setObjectForKey(Object object, Object key) {
		put(key, object);
	}
	
	@Override
	public void clear() {
		superDotClear();
	}
	
	@Override
	public Object put(Object key, Object value) {
		return superDotPut(key, value);
	}
	
	@Override
	public void putAll(Map m) {
		superDotPutAll(m);
	}
	
	@Override
	public Object remove(Object key) {
		return superDotRemove(key);
	}
}
