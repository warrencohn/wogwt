package test.com.webobjects.foundation;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

import com.webobjects.foundation.NSArray;
import com.webobjects.foundation.NSComparator;
import com.webobjects.foundation.NSMutableArray;
import com.webobjects.foundation.NSRange;
import com.webobjects.foundation.NSTimestamp;
import com.webobjects.foundation.NSComparator.ComparisonException;

public class TestNSMutableArray extends TestCase {

	public void testNSMutableArray() {
		NSMutableArray array = new NSMutableArray();
		assertTrue(array.isEmpty());
	}

	public void testNSMutableArrayE() {
		NSMutableArray array = new NSMutableArray("abc");
		assertEquals(1, array.size());
		assertEquals("abc", array.get(0));
	}
	
	public void testNSMutableArrayEArray() {
		String[] str = new String[] {"abc", "def"};
		NSMutableArray array = new NSMutableArray(str);
		assertEquals(2, array.size());
		assertEquals("abc", array.get(0));
		assertEquals("def", array.get(1));
	}

	public void testNSMutableArrayEArrayNSRange() {
		String[] str = new String[] {"abc", "def"}; 
		NSRange range = new NSRange(1, 1);
		NSMutableArray array = new NSMutableArray(str, range);
		assertEquals(1, array.size());
		assertEquals("def", array.get(0));
	}
	
	public void testNSMutableArrayNSArrayOfQextendsE() {
		NSMutableArray array = new NSMutableArray("abc");
		NSMutableArray array2 = new NSMutableArray(array);
		assertEquals(1, array2.size());
		assertEquals("abc", array2.get(0));
	}
	
	public void testNSMutableArrayCollectionOfQextendsE() {
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

	public void testNSMutableArrayInt() {
		NSMutableArray array = new NSMutableArray(2);
		assertTrue(array.isEmpty());
	}

	public void testNSMutableArrayListOfQextendsENSRangeBoolean() {
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

	public void testAddObjectArg() {
		NSMutableArray array = new NSMutableArray();
		array.add("abc");
		assertEquals(1, array.size());
		assertEquals("abc", array.get(0));
	}

	public void testAddIntObject() {
		NSMutableArray array = new NSMutableArray("abc");
		array.add(0, "def");
		assertEquals(2, array.size());
		assertEquals("def", array.get(0));
	}

	public void testAddAllCollection() {
		NSMutableArray array = new NSMutableArray();
		List arrayList = new ArrayList();
		arrayList.add("abc");
		arrayList.add("def");
		array.addAll(arrayList);
		assertEquals(2, array.size());
		assertEquals("abc", array.get(0));
	}

	public void testAddAllIntCollection() {
		NSMutableArray array = new NSMutableArray("ghi");
		List arrayList = new ArrayList();
		arrayList.add("abc");
		arrayList.add("def");
		array.addAll(0, arrayList);
		assertEquals(3, array.size());
		assertEquals("abc", array.get(0));
	}
	
	public void testAddObject() {
		NSMutableArray array = new NSMutableArray();
		array.addObject("abc");
		assertEquals(1, array.size());
		assertEquals("abc", array.get(0));
	}

	public void testAddObjects() {
		NSMutableArray array = new NSMutableArray();
		String[] strings = new String[] {"abc", "def"};
		array.addObjects(strings);
		assertEquals(2, array.size());
		assertEquals("abc", array.get(0));
	}

	public void testAddObjectsFromArray() {
		NSMutableArray array = new NSMutableArray();
		NSMutableArray otherArray = new NSMutableArray();
		otherArray.add("abc");
		otherArray.add("def");
		array.addObjectsFromArray(otherArray);
		assertEquals(2, array.size());
		assertEquals("abc", array.get(0));
	}

	public void testClear() {
		NSMutableArray array = new NSMutableArray("abc");
		assertFalse(array.isEmpty());
		array.clear();
		assertTrue(array.isEmpty());
	}

	public void testClone() {
		NSMutableArray array = new NSMutableArray("abc");
		NSMutableArray clone = (NSMutableArray) array.clone();
		assertEquals(array, clone);
	}

	public void testImmutableClone() {
		NSMutableArray array = new NSMutableArray("abc");
		NSArray clone = array.immutableClone();
		assertEquals(NSArray.class, clone.getClass());
		assertEquals(array, clone);
	}

	public void testRemoveInt() {
		NSMutableArray array = new NSMutableArray();
		array.add("abc");
		array.add("def");
		
		array.remove(0);
		assertEquals(1, array.size());
		assertEquals("def", array.get(0));
	}

	public void testRemoveObject() {
		NSMutableArray array = new NSMutableArray();
		array.add("abc");
		array.add("def");
		
		array.removeObject("abc");
		assertEquals(1, array.size());
		assertEquals("def", array.get(0));
	}

	public void testRemoveAllCollection() {
		NSMutableArray array = new NSMutableArray(new String[] {"abc", "def", "ghi"});
		List arrayList = new ArrayList();
		arrayList.add("abc");
		arrayList.add("def");
		array.removeAll(arrayList);
		assertEquals(1, array.size());
		assertEquals("ghi", array.get(0));
	}

	public void testRetainAllCollection() {
		NSMutableArray array = new NSMutableArray();
		array.add("abc");
		array.add("def");
		
		List arrayList = new ArrayList();
		arrayList.add("abc");

		array.retainAll(arrayList);
		
		assertEquals(1, array.size());
		assertEquals("abc", array.get(0));
	}

	public void testSetIntObject() {
		NSMutableArray array = new NSMutableArray(new String[] {"abc", "def", "ghi"});
		array.set(0, "123");
		assertEquals("123", array.get(0));
	}

	public void testInsertObjectAtIndex() {
		NSMutableArray array = new NSMutableArray(new String[] {"def"});
		array.insertObjectAtIndex("abc", 0);
		assertEquals(2, array.size());
		assertEquals("abc", array.get(0));
	}

	public void testRemoveAllObjects() {
		NSMutableArray array = new NSMutableArray(new String[] {"abc", "def", "ghi"});
		assertFalse(array.isEmpty());
		array.removeAllObjects();
		assertTrue(array.isEmpty());
	}

	public void testRemoveIdenticalObjectObject() {
		String def = "def";
		NSMutableArray array = new NSMutableArray(new String[] {"abc", def});
		array.removeIdenticalObject(def);
		assertEquals(1, array.size());
		assertEquals("abc", array.get(0));
	}

	public void testRemoveIdenticalObjectObjectNSRange() {
		String def = "def";
		NSMutableArray array = new NSMutableArray(new String[] {"abc", def});
		NSRange range = new NSRange(1, 1);
		array.removeIdenticalObject(def, range);
		assertEquals(1, array.size());
		assertEquals("abc", array.get(0));
	}

	public void testRemoveLastObject() {
		NSMutableArray array = new NSMutableArray(new String[] {"abc", "def"});
		array.removeLastObject();
		assertEquals(1, array.size());
		assertEquals("abc", array.get(0));
	}

	public void testRemoveObjectObject() {
		NSMutableArray array = new NSMutableArray(new String[] {"abc", "def"});
		array.removeObject("def");
		assertEquals(1, array.size());
		assertEquals("abc", array.get(0));
	}

	public void testRemoveObjectObjectNSRange() {
		NSMutableArray array = new NSMutableArray(new String[] {"abc", "def"});
		NSRange range = new NSRange(1, 1);
		array.removeObject("def", range);
		assertEquals(1, array.size());
		assertEquals("abc", array.get(0));
	}

	public void testRemoveObjectAtIndex() {
		NSMutableArray array = new NSMutableArray(new String[] {"abc", "def"});
		array.removeObjectAtIndex(1);
		assertEquals(1, array.size());
		assertEquals("abc", array.get(0));
	}

	public void testRemoveObjects() {
		NSMutableArray array = new NSMutableArray(new String[] {"abc", "def", "ghi"});
		String[] strings = new String[] {"def", "ghi"};
		array.removeObjects(strings);
		assertEquals(1, array.size());
		assertEquals("abc", array.get(0));
	}

	public void testRemoveObjectsInArray() {
		NSMutableArray array = new NSMutableArray(new String[] {"abc", "def", "ghi"});
		NSArray strings = new NSArray(new String[] {"def", "ghi"});
		array.removeObjectsInArray(strings);
		assertEquals(1, array.size());
		assertEquals("abc", array.get(0));
	}

	public void testRemoveObjectsInRange() {
		NSMutableArray array = new NSMutableArray(new String[] {"abc", "def", "ghi"});
		NSRange range = new NSRange(1, 2);
		array.removeObjectsInRange(range);
		assertEquals(1, array.size());
		assertEquals("abc", array.get(0));
	}

	public void testReplaceObjectAtIndexEInt() {
		NSMutableArray array = new NSMutableArray(new String[] {"abc", "def", "ghi"});
		array.replaceObjectAtIndex("123", 0);
		assertEquals("123", array.get(0));
	}

	public void testReplaceObjectsInRange() {
		NSMutableArray array = new NSMutableArray(new String[] {"abc", "def", "ghi"});
		NSMutableArray array2 = new NSMutableArray(new String[] {"123", "456"});
		NSRange sourceRange = new NSRange(1, 2);
		NSRange otherRange = new NSRange(0, 2);
		array.replaceObjectsInRange(sourceRange, array2, otherRange);
		assertEquals(3, array.size());
		assertEquals("abc", array.get(0));
		assertEquals("123", array.get(1));
		assertEquals("456", array.get(2));
	}

	public void testSetArray() {
		NSMutableArray array = new NSMutableArray(new String[] {"abc", "def", "ghi"});
		array.setArray(new NSArray("abc"));
		assertEquals(1, array.size());
		assertEquals("abc", array.get(0));
	}

	public void testSortUsingComparator() throws ComparisonException {
		NSMutableArray array = new NSMutableArray(new String[] {"abc", "def"});

		array.sortUsingComparator(NSComparator.AscendingStringComparator);
		assertEquals("abc", array.get(0));
		assertEquals("def", array.get(1));
		
		array.sortUsingComparator(NSComparator.DescendingStringComparator);
		assertEquals("def", array.get(0));
		assertEquals("abc", array.get(1));
		
		
		array = new NSMutableArray(new String[] {"abc", "DEF"});
		array.sortUsingComparator(NSComparator.AscendingCaseInsensitiveStringComparator);
		assertEquals("abc", array.get(0));
		assertEquals("DEF", array.get(1));
		
		array.sortUsingComparator(NSComparator.DescendingCaseInsensitiveStringComparator);
		assertEquals("DEF", array.get(0));
		assertEquals("abc", array.get(1));
		
		
		array = new NSMutableArray(new Integer[] {1, 2});
		array.sortUsingComparator(NSComparator.AscendingNumberComparator);
		assertEquals(1, array.get(0));
		assertEquals(2, array.get(1));
		
		array.sortUsingComparator(NSComparator.DescendingNumberComparator);
		assertEquals(2, array.get(0));
		assertEquals(1, array.get(1));
		
		
		NSTimestamp earlierTime = new NSTimestamp();
		NSTimestamp laterTime = earlierTime.timestampByAddingGregorianUnits(0,1,0,0,0,0);
		array = new NSMutableArray(new NSTimestamp[] {earlierTime, laterTime});
		array.sortUsingComparator(NSComparator.AscendingTimestampComparator);
		assertEquals(earlierTime, array.get(0));
		assertEquals(laterTime, array.get(1));
		
		array.sortUsingComparator(NSComparator.DescendingTimestampComparator);
		assertEquals(laterTime, array.get(0));
		assertEquals(earlierTime, array.get(1));
	}

}
