package test.com.webobjects.foundation;

import java.util.HashMap;
import java.util.Map;

import junit.framework.TestCase;

import com.webobjects.foundation.NSArray;
import com.webobjects.foundation.NSDictionary;
import com.webobjects.foundation.NSMutableDictionary;

public class TestNSMutableDictionary extends TestCase {

	protected void setUp() throws Exception {
		super.setUp();
	}

	public void testNSMutableDictionary() {
		NSMutableDictionary dict = new NSMutableDictionary();
		assertTrue(dict.isEmpty());
	}

	public void testNSMutableDictionaryInt() {
		NSMutableDictionary dict = new NSMutableDictionary(5);
		assertTrue(dict.isEmpty());
	}

	public void testNSMutableDictionaryMapOfKV() {
		Map map = new HashMap();
		map.put("key", "value");
		NSMutableDictionary dict = new NSMutableDictionary(map);
		assertEquals("value", dict.get("key"));
	}

	public void testNSMutableDictionaryNSArrayOfVNSArrayOfK() {
		NSArray keys = new NSArray(new String[] {"key1", "key2"});
		NSArray values = new NSArray(new String[] {"value1", "value2"});
		NSMutableDictionary dict = new NSMutableDictionary(values, keys);
		assertEquals("value1", dict.get("key1"));
		assertEquals("value2", dict.get("key2"));
	}

	public void testNSMutableDictionaryNSMutableDictionaryOfKV() {
		NSMutableDictionary mutableDict = new NSMutableDictionary("value", "key");
		NSMutableDictionary dict = new NSMutableDictionary(mutableDict);
		assertFalse(dict.isEmpty());
		mutableDict.put("key", "newValue");
		assertEquals("value", dict.get("key"));
	}

	public void testNSMutableDictionaryVArrayKArray() {
		String[] keys = new String[] {"key1", "key2"};
		String[] values = new String[] {"value1", "value2"};
		NSMutableDictionary dict = new NSMutableDictionary(values, keys);
		assertEquals("value1", dict.get("key1"));
		assertEquals("value2", dict.get("key2"));
	}

	public void testNSMutableDictionaryVK() {
		NSMutableDictionary dict = new NSMutableDictionary("value", "key");
		assertEquals("value", dict.get("key"));
	}

	public void testPutObjectObject() {
		NSMutableDictionary dict = new NSMutableDictionary();
		dict.put("key", "value");
		assertEquals("value", dict.get("key"));
	}

	public void testSetObjectForKey() {
		NSMutableDictionary dict = new NSMutableDictionary();
		dict.setObjectForKey("value", "key");
		assertEquals("value", dict.get("key"));
	}

	public void testPutAllMap() {
		Map map = new HashMap();
		map.put("key", "value");
		map.put("key2", "value2");
		NSMutableDictionary dict = new NSMutableDictionary();
		dict.putAll(map);
		assertEquals("value", dict.get("key"));
		assertEquals("value2", dict.get("key2"));
	}

	public void testAddEntriesFromDictionary() {
		String[] keys = new String[] {"key1", "key2"};
		String[] values = new String[] {"value1", "value2"};
		NSDictionary dict = new NSDictionary(values, keys);
		
		NSMutableDictionary mutableDict = new NSMutableDictionary();
		mutableDict.addEntriesFromDictionary(dict);
		
		assertEquals("value1", dict.get("key1"));
		assertEquals("value2", dict.get("key2"));
	}
	
	public void testRemoveObject() {
		NSMutableDictionary dict = new NSMutableDictionary("value", "key");
		dict.remove("key");
		assertTrue(dict.isEmpty());
	}

	public void testClear() {
		NSMutableDictionary dict = new NSMutableDictionary("value", "key");
		dict.clear();
		assertTrue(dict.isEmpty());
	}
	
	public void testRemoveAllObjects() {
		NSMutableDictionary dict = new NSMutableDictionary("value", "key");
		dict.removeAllObjects();
		assertTrue(dict.isEmpty());
	}

	public void testRemoveObjectForKey() {
		NSMutableDictionary dict = new NSMutableDictionary("value", "key");
		dict.removeObjectForKey("key");
		assertTrue(dict.isEmpty());
	}

	public void testRemoveObjectsForKeys() {
		String[] keys = new String[] {"key1", "key2"};
		String[] values = new String[] {"value1", "value2"};
		NSMutableDictionary dict = new NSMutableDictionary(values, keys);
		dict.removeObjectsForKeys(new NSArray(new String[] {"key1", "key2"}));
		assertTrue(dict.isEmpty());
	}

	public void testSetDictionary() {
		String[] keys = new String[] {"key1", "key2"};
		String[] values = new String[] {"value1", "value2"};
		NSMutableDictionary dict = new NSMutableDictionary(values, keys);
		dict.setDictionary(new NSDictionary("value3", "key3"));
		assertEquals("value3", dict.get("key3"));
	}

	public void testImmutableClone() {
		String[] keys = new String[] {"key1", "key2"};
		String[] values = new String[] {"value1", "value2"};
		NSDictionary dict = new NSDictionary(values, keys);
		NSDictionary clone = dict.immutableClone();
		
		assertEquals(NSDictionary.class, clone.getClass());
		assertEquals(clone, dict);
	}

	public void testClone() {
		String[] keys = new String[] {"key1", "key2"};
		String[] values = new String[] {"value1", "value2"};
		NSMutableDictionary dict = new NSMutableDictionary(values, keys);
		NSMutableDictionary clone = (NSMutableDictionary) dict.clone();
		
		assertEquals(NSMutableDictionary.class, clone.getClass());
		assertEquals(clone, dict);
	}

}
