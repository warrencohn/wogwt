package test.com.webobjects.foundation;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

import com.webobjects.foundation.NSArray;
import com.webobjects.foundation.NSDictionary;
import com.webobjects.foundation.NSKeyValueCoding;
import com.webobjects.foundation.NSMutableDictionary;

public class TestNSDictionary extends BaseTestCase {

	public void testNSDictionary() {
		NSDictionary dict = new NSDictionary();
		assertTrue(dict.isEmpty());
	}

	public void testNSDictionaryMapOfKV() {
		Map map = new HashMap();
		map.put("key", "value");
		NSDictionary dict = new NSDictionary(map);
		assertEquals("value", dict.get("key"));
	}

	public void testNSDictionaryNSArrayOfVNSArrayOfK() {
		NSArray keys = new NSArray(new String[] {"key1", "key2"});
		NSArray values = new NSArray(new String[] {"value1", "value2"});
		NSDictionary dict = new NSDictionary(values, keys);
		assertEquals("value1", dict.get("key1"));
		assertEquals("value2", dict.get("key2"));
	}

	public void testNSDictionaryNSDictionaryOfKV() {
		NSMutableDictionary mutableDict = new NSMutableDictionary("value", "key");
		NSDictionary dict = new NSDictionary(mutableDict);
		assertFalse(dict.isEmpty());
		mutableDict.put("key", "newValue");
		assertEquals("value", dict.get("key"));
	}

	public void testNSDictionaryVArrayKArray() {
		String[] keys = new String[] {"key1", "key2"};
		String[] values = new String[] {"value1", "value2"};
		NSDictionary dict = new NSDictionary(values, keys);
		assertEquals("value1", dict.get("key1"));
		assertEquals("value2", dict.get("key2"));
	}

	public void testNSDictionaryVK() {
		NSDictionary dict = new NSDictionary("value", "key");
		assertEquals("value", dict.get("key"));
	}

	public void testAllKeys() {
		String[] keys = new String[] {"key1", "key2"};
		String[] values = new String[] {"value1", "value2"};
		NSDictionary dict = new NSDictionary(values, keys);
		NSArray keyArray = dict.allKeys();
		assertEquals(2, keyArray.size());
		assertTrue(keyArray.contains("key1"));
		assertTrue(keyArray.contains("key2"));
	}

	public void testAllKeysForObject() {
		String[] keys = new String[] {"key1", "key2"};
		String[] values = new String[] {"value", "value"};
		NSDictionary dict = new NSDictionary(values, keys);
		NSArray keyArray = dict.allKeysForObject("value");
		assertEquals(2, keyArray.size());
		assertTrue(keyArray.contains("key1"));
		assertTrue(keyArray.contains("key2"));
	}

	public void testAllValues() {
		String[] keys = new String[] {"key1", "key2"};
		String[] values = new String[] {"value1", "value2"};
		NSDictionary dict = new NSDictionary(values, keys);
		NSArray keyArray = dict.allValues();
		assertEquals(2, keyArray.size());
		assertTrue(keyArray.contains("value1"));
		assertTrue(keyArray.contains("value2"));
	}

	public void testCount() {
		String[] keys = new String[] {"key1", "key2"};
		String[] values = new String[] {"value1", "value2"};
		NSDictionary dict = new NSDictionary(values, keys);
		assertEquals(2, dict.count());
	}

	public void testEmptyDictionary() {
		assertTrue(NSDictionary.EmptyDictionary.isEmpty());
		assertTrue(NSDictionary.emptyDictionary().isEmpty());
	}

	public void testHashMap() {
		String[] keys = new String[] {"key1", "key2"};
		String[] values = new String[] {"value1", "value2"};
		NSDictionary dict = new NSDictionary(values, keys);
		Map hashMap = dict.hashMap();
		assertEquals(2, hashMap.size());
		assertEquals("value1", hashMap.get("key1"));
		assertEquals("value2", dict.get("key2"));
	}

	public void testIsEqualToDictionary() {
		String[] keys = new String[] {"key1", "key2"};
		String[] values = new String[] {"value1", "value2"};
		NSDictionary dict = new NSDictionary(values, keys);
		NSDictionary dict2 = new NSDictionary(values, keys);
		assertTrue(dict.isEqualToDictionary(dict2));
	}

	public void testImmutableClone() {
		String[] keys = new String[] {"key1", "key2"};
		String[] values = new String[] {"value1", "value2"};
		NSDictionary dict = new NSDictionary(values, keys);
		NSDictionary clone = dict.immutableClone();
		
		assertEquals(NSDictionary.class, clone.getClass());
		assertEquals(clone, dict);
	}

	public void testMutableClone() {
		String[] keys = new String[] {"key1", "key2"};
		String[] values = new String[] {"value1", "value2"};
		NSDictionary dict = new NSDictionary(values, keys);
		NSDictionary clone = dict.mutableClone();
		
		assertEquals(NSMutableDictionary.class, clone.getClass());
		assertEquals(clone, dict);
	}

	public void testKeyEnumerator() {
		NSDictionary dict = new NSDictionary("value", "key");	
		Enumeration e = dict.keyEnumerator();
		
		assertTrue(e.hasMoreElements());
		assertEquals("key", e.nextElement());
		assertFalse(e.hasMoreElements());
		try {
			e.nextElement();
			fail("Expected NoSuchElementException");
		} catch (NoSuchElementException ex) {} 
	}
	
	public void testObjectEnumerator() {
		NSDictionary dict = new NSDictionary("value", "key");	
		Enumeration e = dict.objectEnumerator();
		
		assertTrue(e.hasMoreElements());
		assertEquals("value", e.nextElement());
		assertFalse(e.hasMoreElements());
		try {
			e.nextElement();
			fail("Expected NoSuchElementException");
		} catch (NoSuchElementException ex) {} 
	}
	
	public void testObjectForKey() {
		NSDictionary dict = new NSDictionary("value", "key");
		assertEquals("value", dict.objectForKey("key"));
	}

	public void testValueForKey() {
		NSDictionary dict = new NSDictionary("value", "key");
		assertEquals("value", dict.valueForKey("key"));
	}

	public void testTakeValueForKey() {
		NSDictionary dict = new NSDictionary("value", "key");
		dict.takeValueForKey("newValue", "key");
		assertEquals("newValue", dict.get("key"));
	}

	public void testValueForKeyPath() {
		NSDictionary dict = new NSDictionary("value", "key");
		assertEquals("value", dict.valueForKeyPath("key"));
		
		dict = new NSDictionary("value", "key.path");
		assertEquals("value", dict.valueForKeyPath("key.path"));
		
		NSDictionary subDict = new NSDictionary("value", "path");
		dict = new NSDictionary(subDict, "key");
		assertEquals("value", dict.valueForKeyPath("key.path"));
	}

	public void testTakeValueForKeyPath() {
		NSDictionary dict = new NSDictionary("value", "key");
		dict.takeValueForKeyPath("newValue", "key");
		assertEquals("newValue", dict.get("key"));
		
		NSDictionary subDict = new NSDictionary("value", "path");
		dict = new NSDictionary(subDict, "key");
		dict.takeValueForKeyPath("newValue", "key.path");
		assertEquals("newValue", dict.valueForKeyPath("key.path"));
	}

	public void testClone() {
		String[] keys = new String[] {"key1", "key2"};
		String[] values = new String[] {"value1", "value2"};
		NSDictionary dict = new NSDictionary(values, keys);
		NSDictionary clone = (NSDictionary) dict.clone();
		
		assertEquals(NSDictionary.class, clone.getClass());
		assertEquals(clone, dict);
	}

	public void testPutObjectObject() {
		try {
			NSDictionary.EmptyDictionary.put("key", "value");
			fail("Put should throw UnsupportedOperationException");
		} catch (UnsupportedOperationException e) {
		}
	}

	public void testPutAllMap() {
		try {
			Map map = new HashMap();
			map.put("key", "value");
			NSDictionary.EmptyDictionary.putAll(map);
			fail("PutAll should throw UnsupportedOperationException");
		} catch (UnsupportedOperationException e) {
		}	
	}

	public void testRemoveObject() {
		try {
			NSDictionary.EmptyDictionary.remove("abc");
			fail("RemoveObject should throw UnsupportedOperationException");
		} catch (UnsupportedOperationException e) {
		}
	}

	public void testClear() {
		try {
			NSDictionary.EmptyDictionary.clear();
			fail("Clear should throw UnsupportedOperationException");
		} catch (UnsupportedOperationException e) {
		}
	}

	public void testUnknownKeyException() {
		NSDictionary dict = new NSDictionary("John", "name");
		try {
			throw new NSKeyValueCoding.UnknownKeyException("error", dict, "name");
		} catch (NSKeyValueCoding.UnknownKeyException e) {
			System.out.println(e.getMessage());
		}
	}
}
