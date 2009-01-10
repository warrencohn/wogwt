package test.com.webobjects.foundation;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.NoSuchElementException;
import java.util.Vector;

import com.webobjects.foundation.NSArray;
import com.webobjects.foundation.NSComparator;
import com.webobjects.foundation.NSDictionary;
import com.webobjects.foundation.NSMutableArray;
import com.webobjects.foundation.NSMutableDictionary;
import com.webobjects.foundation.NSRange;
import com.webobjects.foundation.NSTimestamp;
import com.webobjects.foundation.NSComparator.ComparisonException;

public class TestNSArray extends BaseTestCase {
	
	public void testNSArray() {
		NSArray array = new NSArray();
		assertTrue(array.isEmpty());
	}

	public void testNSArrayE() {
		NSArray array = new NSArray("abc");
		assertEquals(1, array.size());
		assertEquals("abc", array.get(0));
	}

	public void testNSArrayEArray() {
		String[] str = new String[] {"abc", "def"};
		NSArray array = new NSArray(str);
		assertEquals(2, array.size());
		assertEquals("abc", array.get(0));
		assertEquals("def", array.get(1));
	}

	public void testNSArrayEArrayNSRange() {
		String[] str = new String[] {"abc", "def"}; 
		NSRange range = new NSRange(1, 1);
		NSArray array = new NSArray(str, range);
		assertEquals(1, array.size());
		assertEquals("def", array.get(0));
	}

	public void testNSArrayNSArrayOfQextendsE() {
		NSArray array = new NSArray("abc");
		NSArray array2 = new NSArray(array);
		assertEquals(1, array2.size());
		assertEquals("abc", array2.get(0));
	}
	
	public void testNSArrayCollectionOfQextendsE() {
		ArrayList list = new ArrayList();
		list.add("abc");
		list.add("def");
		
		NSArray array = new NSArray(list);
		assertEquals(2, array.size());
		
		list.add(null);
		try {
			array = new NSArray(list);
			fail("IllegalArgumentException expected");
		} catch (IllegalArgumentException e) {
		}
	}

	public void testNSArrayCollectionOfQextendsEBoolean() {
		ArrayList list = new ArrayList();
		list.add("abc");
		list.add(null);
		list.add("def");
		
		NSArray array = new NSArray(list, false);
		assertEquals(2, array.size());
		
		try {
			array = new NSArray(list, true);
			fail("IllegalArgumentException expected");
		} catch (IllegalArgumentException e) {
		}
	}

	public void testNSArrayListOfQextendsENSRangeBoolean() {
		ArrayList list = new ArrayList();
		list.add("abc");
		list.add(null);
		list.add("def");
		
		NSRange range = new NSRange(1, 2);
		
		NSArray array = new NSArray(list, range, true);
		assertEquals(1, array.size());
		
		try {
			array = new NSArray(list, range, false);
			fail("IllegalArgumentException expected");
		} catch (IllegalArgumentException e) {
		}
	}

	public void testArrayByAddingObject() {
		NSArray array = new NSArray("abc");
		NSArray array2 = array.arrayByAddingObject("def");
		assertEquals(2, array2.size());
	}

	public void testArrayByAddingObjectsFromArray() {
		NSArray array = new NSArray("abc");
		NSArray array2 = new NSArray(new String[] {"def", "ghi"});
		NSArray array3 = array.arrayByAddingObjectsFromArray(array2);
		assertEquals(3, array3.size());
	}

	public void testArrayList() {
		NSArray array = new NSArray("abc");
		ArrayList list = array.arrayList();
		
		ArrayList expected = new ArrayList();
		expected.add("abc");
		assertEquals(expected, list);
	}

	public void testClone() {
		NSArray array = new NSArray("abc");
		NSArray clone = (NSArray) array.clone();
		assertEquals(clone, array);
	}

	public void testComponentsJoinedByString() {
		NSArray array = new NSArray(new String[] {"abc", "def"});
		String joined = array.componentsJoinedByString("-");
		assertEquals("abc-def", joined);
	}

	public void testComponentsSeparatedByString() {
		NSArray array = NSArray.componentsSeparatedByString("abc-def", "-");
		NSArray expected = new NSArray(new String[] {"abc", "def"});
		assertEquals(expected, array);
	}

	public void testContainsObject() {
		NSArray array = new NSArray(new String[] {"abc", "def"});
		assertTrue(array.contains("def"));
		assertFalse(array.contains("123"));
	}

	public void testCount() {
		NSArray array = new NSArray(new String[] {"abc", "def"});
		assertEquals(2, array.count());
		assertEquals(array.size(), array.count());
	}

	public void testEmptyArray() {
		NSArray array = NSArray.EmptyArray;
		assertEquals(0, array.size());
		
		array = NSArray.emptyArray();
		assertEquals(0, array.size());
	}

	public void testFirstObjectCommonWithArray() {
		NSArray array = new NSArray(new String[] {"abc", "def"});
		NSArray array2 = new NSArray(new String[] {"def", "ghi"});
		
		Object commonObject = array.firstObjectCommonWithArray(array2);
		assertEquals("def", commonObject);
		
		array2 = new NSArray(new String[] {"ghi", "jkl"});
		commonObject = array.firstObjectCommonWithArray(array2);
		assertNull(commonObject);
	}

	public void testImmutableClone() {
		NSArray array = new NSArray("abc");
		NSArray clone = array.immutableClone();
		assertEquals(clone, array);
		assertEquals(NSArray.class, clone.getClass());
	}

	public void testIndexOfIdenticalObjectObject() {
		String def = "def";
		NSArray array = new NSArray(new String[] {"abc", def});
		int index = array.indexOfIdenticalObject(def);
		assertEquals(1, index);
		
		index = array.indexOfIdenticalObject("ghi");
		assertEquals(NSArray.NotFound, index);
	}

	public void testIndexOfIdenticalObjectObjectNSRange() {
		String def = "def";
		NSArray array = new NSArray(new String[] {"abc", def});
		NSRange range = new NSRange(1, 1);
		int index = array.indexOfIdenticalObject(def, range);
		assertEquals(0, index);
		
		range = NSRange.ZeroRange;
		index = array.indexOfIdenticalObject(def, range);
		assertEquals(NSArray.NotFound, index);
	}

	public void testIndexOfObjectObject() {
		NSArray array = new NSArray(new String[] {"abc", "def"});
		int index = array.indexOfIdenticalObject("def");
		assertEquals(1, index);
		
		index = array.indexOfIdenticalObject("ghi");
		assertEquals(NSArray.NotFound, index);
	}

	public void testIndexOfObjectObjectNSRange() {
		NSArray array = new NSArray(new String[] {"abc", "def"});
		NSRange range = new NSRange(1, 1);
		int index = array.indexOfIdenticalObject("def", range);
		assertEquals(0, index);
		
		range = NSRange.ZeroRange;
		index = array.indexOfObject("def", range);
		assertEquals(NSArray.NotFound, index);
	}

	public void testIsEqualToArray() {
		NSArray array = new NSArray("abc");
		NSArray clone = array.immutableClone();
		assertTrue(array.isEqualToArray(clone));
		
		clone = new NSArray("def");
		assertFalse(array.isEqualToArray(clone));
	}

	public void testMutableClone() {
		NSArray array = new NSArray("abc");
		NSMutableArray clone = array.mutableClone();
		assertEquals(1, clone.size());
		assertEquals("abc", clone.get(0));
	}

	public void testObjectAtIndex() {
		NSArray array = new NSArray("abc");
		assertEquals("abc", array.objectAtIndex(0));
	}

	public void testObjects() {
		String[] strings = new String[] {"abc", "def"};
		NSArray array = new NSArray(strings);
		Object[] objects = array.objects();
		assertEquals(strings.length, objects.length);
		assertEquals(strings[0], objects[0]);
		assertEquals(strings[1], objects[1]);
	}

	public void testObjectsNSRange() {
		String[] strings = new String[] {"abc", "def"};
		NSArray array = new NSArray(strings);
		NSRange range = new NSRange(1, 1);
		Object[] objects = array.objects(range);
		assertEquals(1, objects.length);
		assertEquals(strings[1], objects[0]);
	}

	public void testObjectEnumerator() {
		NSArray array = new NSArray(new String[] {"abc", "def"});
		Enumeration e = array.objectEnumerator();
		assertTrue(e.hasMoreElements());
		assertEquals("abc", e.nextElement());
		assertEquals("def", e.nextElement());
		assertFalse(e.hasMoreElements());
		try {
			e.nextElement();
			fail("Expected NoSuchElementException");
		} catch (NoSuchElementException ex) {} 
	}
	
	public void testReverseObjectEnumerator() {
		NSArray array = new NSArray(new String[] {"abc", "def"});
		Enumeration e = array.reverseObjectEnumerator();
		assertTrue(e.hasMoreElements());
		assertEquals("def", e.nextElement());
		assertEquals("abc", e.nextElement());
		assertFalse(e.hasMoreElements());
		try {
			e.nextElement();
			fail("Expected NoSuchElementException");
		} catch (NoSuchElementException ex) {} 
	}
	
	public void testSortedArrayUsingComparator() throws ComparisonException {
		NSArray array = new NSArray(new String[] {"abc", "def"});
		NSArray sorted;
		
		sorted = array.sortedArrayUsingComparator(NSComparator.AscendingStringComparator);
		assertNotSame(array, sorted);
		assertEquals("abc", sorted.get(0));
		assertEquals("def", sorted.get(1));
		
		sorted = array.sortedArrayUsingComparator(NSComparator.DescendingStringComparator);
		assertEquals("def", sorted.get(0));
		assertEquals("abc", sorted.get(1));
		
		
		array = new NSArray(new String[] {"abc", "DEF"});
		sorted = array.sortedArrayUsingComparator(NSComparator.AscendingCaseInsensitiveStringComparator);
		assertEquals("abc", sorted.get(0));
		assertEquals("DEF", sorted.get(1));
		
		sorted = array.sortedArrayUsingComparator(NSComparator.DescendingCaseInsensitiveStringComparator);
		assertEquals("DEF", sorted.get(0));
		assertEquals("abc", sorted.get(1));
		
		
		array = new NSArray(new Integer[] {1, 2});
		sorted = array.sortedArrayUsingComparator(NSComparator.AscendingNumberComparator);
		assertEquals(1, sorted.get(0));
		assertEquals(2, sorted.get(1));
		
		sorted = array.sortedArrayUsingComparator(NSComparator.DescendingNumberComparator);
		assertEquals(2, sorted.get(0));
		assertEquals(1, sorted.get(1));
		
		
		NSTimestamp earlierTime = new NSTimestamp();
		NSTimestamp laterTime = earlierTime.timestampByAddingGregorianUnits(0,1,0,0,0,0);
		array = new NSArray(new NSTimestamp[] {earlierTime, laterTime});
		sorted = array.sortedArrayUsingComparator(NSComparator.AscendingTimestampComparator);
		assertEquals(earlierTime, sorted.get(0));
		assertEquals(laterTime, sorted.get(1));
		
		sorted = array.sortedArrayUsingComparator(NSComparator.DescendingTimestampComparator);
		assertEquals(laterTime, sorted.get(0));
		assertEquals(earlierTime, sorted.get(1));
	}

	public void testSubarrayWithRange() {
		NSArray array = new NSArray(new String[] {"abc", "def"});
		NSRange range = new NSRange(1, 1);
		NSArray subArray = array.subarrayWithRange(range);
		assertEquals(1, subArray.size());
		assertEquals("def", subArray.get(0));
	}

	public void testValueForKey() {
		NSDictionary[] dicts = new NSDictionary[] {
				new NSDictionary("val1", "key"),
				new NSDictionary("val2", "key")
				};
		NSArray array = new NSArray(dicts);
		NSArray result = (NSArray) array.valueForKey("key");
		assertEquals(2, result.size());
		assertEquals("val1", result.get(0));
		assertEquals("val2", result.get(1));
	}

	public void testTakeValueForKey() {
		NSDictionary[] dicts = new NSDictionary[] {
				new NSDictionary("val1", "key"),
				new NSDictionary("val2", "key")
				};
		NSArray array = new NSArray(dicts);
		array.takeValueForKey("val3", "key3");
		
		NSDictionary dict1 = (NSDictionary) array.get(0);
		NSDictionary dict2 = (NSDictionary) array.get(1);
		
		assertEquals("val3", dict1.objectForKey("key3"));
		assertEquals("val3", dict2.objectForKey("key3"));
	}

	public void testValueForKeyPath() {
		NSDictionary[] dicts = new NSDictionary[] {
				new NSDictionary(2, "key"),
				new NSDictionary(4, "key")
				};
		NSArray array = new NSArray(dicts);
		int count = ((Integer) array.valueForKeyPath("@count")).intValue();
		assertEquals(2, count);
		
		BigDecimal sum = (BigDecimal) array.valueForKeyPath("@sum.key");
		assertEquals(new BigDecimal(6), sum);
		
		BigDecimal avg = (BigDecimal) array.valueForKeyPath("@avg.key");
		assertEquals(new BigDecimal(3), avg);
		
		int min = ((Integer) array.valueForKeyPath("@min.key")).intValue();
		assertEquals(2, min);
		
		int max = ((Integer) array.valueForKeyPath("@max.key")).intValue();
		assertEquals(4, max);
		
		NSDictionary subDict = new NSDictionary(2, "subkey");
		NSDictionary dict = new NSDictionary(subDict, "key");
		array = new NSArray(dict);
		NSArray values = (NSArray) array.valueForKeyPath("key.subkey");
		assertEquals(1, values.size());
		assertEquals(2, values.get(0));
	}

	public void testTakeValueForKeyPath() {
		NSMutableDictionary subDict = new NSMutableDictionary(2, "subkey");
		NSMutableDictionary dict = new NSMutableDictionary(subDict, "key");
		NSArray array = new NSArray(dict);
		array.takeValueForKeyPath(3, "key.subkey");
		assertEquals(2, subDict.objectForKey("subkey"));
	}

	public void testVector() {
		String[] strings = new String[] {"abc", "def"};
		NSArray array = new NSArray(strings);
		Vector vector = array.vector();
		assertEquals(strings.length, vector.size());
		assertEquals(strings[0], vector.get(0));
		assertEquals(strings[1], vector.get(1));
	}

	public void testClear() {
		try {
			NSArray.EmptyArray.clear();
			fail("Clear should throw UnsupportedOperationException");
		} catch (UnsupportedOperationException e) {
		}
	}

	public void testAddObject() {
		try {
			NSArray.EmptyArray.add(1);
			fail("Add should throw UnsupportedOperationException");
		} catch (UnsupportedOperationException e) {
		}
	}

	public void testAddIntObject() {
		try {
			NSArray.EmptyArray.add(0, 1);
			fail("Add should throw UnsupportedOperationException");
		} catch (UnsupportedOperationException e) {
		}
	}

	public void testAddAllCollection() {
		try {
			ArrayList list = new ArrayList();
			list.add(1);
			list.add(2);
			NSArray.EmptyArray.addAll(list);
			fail("AddAll should throw UnsupportedOperationException");
		} catch (UnsupportedOperationException e) {
		}
	}

	public void testAddAllIntCollection() {
		try {
			ArrayList list = new ArrayList();
			list.add(1);
			list.add(2);
			NSArray.EmptyArray.addAll(0, list);
			fail("AddAll should throw UnsupportedOperationException");
		} catch (UnsupportedOperationException e) {
		}
	}

	public void testRemoveInt() {
		try {
			NSArray.EmptyArray.remove(0);
			fail("Remove should throw UnsupportedOperationException");
		} catch (UnsupportedOperationException e) {
		}
	}

	public void testRemoveObject() {
		try {
			NSArray.EmptyArray.remove("abc");
			fail("Remove should throw UnsupportedOperationException");
		} catch (UnsupportedOperationException e) {
		}
	}

	public void testRemoveAllCollection() {
		try {
			ArrayList list = new ArrayList();
			list.add(1);
			list.add(2);
			NSArray.EmptyArray.removeAll(list);
			fail("RemoveAll should throw UnsupportedOperationException");
		} catch (UnsupportedOperationException e) {
		}
	}

	public void testRetainAllCollection() {
		try {
			ArrayList list = new ArrayList();
			list.add(1);
			list.add(2);
			NSArray.EmptyArray.retainAll(list);
			fail("RetainAll should throw UnsupportedOperationException");
		} catch (UnsupportedOperationException e) {
		}
	}

	public void testSetIntObject() {
		try {
			NSArray.EmptyArray.set(0, "abc");
			fail("Remove should throw UnsupportedOperationException");
		} catch (UnsupportedOperationException e) {
		}
	}

}
