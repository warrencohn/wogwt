package com.webobjects.foundation;

import java.util.HashMap;
import java.util.Map;

import com.webobjects.foundation.NSArray;
import com.webobjects.foundation.NSMutableDictionary;

public class NSMutableDictionary<K,V> extends HashMap {

	public NSMutableDictionary() {
		super();
	}
	
	public NSMutableDictionary(Map<K,V> map) {
		super(map);
	}
	
	public NSMutableDictionary(NSMutableDictionary<K,V> otherDictionary) {
		super(otherDictionary);
	}
	
	public NSMutableDictionary(V object, K key) {
		super();
		put(key, object);
	}
	
	public void addEntriesFromDictionary(NSDictionary otherDictionary) {
		putAll(otherDictionary);
	}
	
	public void removeAllObjects() {
		clear();
	}
	
	public V removeObjectForKey(Object key) {
		return (V)remove(key);
	}
	
	public void removeObjectsForKeys(NSArray keys) {
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
}
