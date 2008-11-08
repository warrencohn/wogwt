package com.webobjects.foundation;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import com.webobjects.foundation.NSArray;
import com.webobjects.foundation.NSMutableDictionary;

public class NSDictionary<K,V> extends HashMap {

	public NSDictionary() {
		super();
	}
	
	public NSDictionary(Map<K,V> map) {
		super(map);
	}
	
	public NSDictionary(NSDictionary<K,V> otherDictionary) {
		super(otherDictionary);
	}
	
	public NSDictionary(V object, K key) {
		super();
		put(key, object);
	}
	
	public NSArray<K> allKeys() {
		return new NSArray(keySet().toArray());
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
	
	public NSDictionary<K, V> immutableClone() {
		return (NSDictionary<K, V>)clone();
	}
	
	public NSMutableDictionary<K, V> mutableClone() {
		return new NSMutableDictionary<K, V>(this);
	}
	
	public V objectForKey(Object key) {
		return (V)get(key);
	}
		
}
