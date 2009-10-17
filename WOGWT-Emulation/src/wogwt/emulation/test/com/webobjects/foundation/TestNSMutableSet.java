package test.com.webobjects.foundation;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import junit.framework.TestCase;

import com.webobjects.foundation.NSMutableArray;
import com.webobjects.foundation.NSMutableSet;
import com.webobjects.foundation.NSSet;


public class TestNSMutableSet extends TestCase {

	public void testNSMutableSet() {
		NSMutableSet set = new NSMutableSet();
		assertTrue(set.isEmpty());
	}

	public void testNSMutableSetCollectionOfQextendsE() {
		ArrayList list = new ArrayList();
		list.add("abc");
		list.add("abc");
		
		NSMutableSet set = new NSMutableSet(list);
		assertEquals(1, set.size());
		assertTrue(set.contains("abc"));
	}

	public void testNSMutableSetE() {
		NSMutableSet set = new NSMutableSet("abc");
		assertTrue(set.contains("abc"));
	}

	public void testNSMutableSetEArray() {
		String[] strings = new String[] {"abc", "abc"};
		NSMutableSet set = new NSMutableSet(strings);
		assertEquals(1, set.size());
		assertTrue(set.contains("abc"));
	}

	public void testNSMutableSetInt() {
		NSMutableSet set = new NSMutableSet(1);
		assertTrue(set.isEmpty());
	}

	public void testNSMutableSetNSArrayOfQextendsE() {
		NSMutableArray list = new NSMutableArray();
		list.add("abc");
		list.add("abc");
		
		NSMutableSet set = new NSMutableSet(list);
		assertEquals(1, set.size());
		assertTrue(set.contains("abc"));
	}

	public void testNSMutableSetNSSetOfQextendsE() {
		NSMutableSet set = new NSMutableSet("abc");
		NSMutableSet copy = new NSMutableSet(set);
		assertEquals(1, copy.size());
		assertTrue(copy.contains("abc"));
	}

	public void testNSMutableSetSetOfQextendsEBoolean() {
		Set source = new HashSet();
		source.add("abc");
		source.add(null);
		
		NSMutableSet set = new NSMutableSet(source, true);
		assertEquals(1, set.size());
		assertTrue(set.contains("abc"));
		
		try {
			set = new NSMutableSet(source, false);
			fail("IllegalArgumentException expected");
		} catch (IllegalArgumentException e) {
		}
	}

	public void testAddObject() {
		NSMutableSet set = new NSMutableSet();
		set.addObject("abc");
		assertTrue(set.contains("abc"));
	}

	public void testAddObjectsFromArray() {
		NSMutableArray list = new NSMutableArray();
		list.add("abc");
		list.add("abc");
		
		NSMutableSet set = new NSMutableSet();
		set.addObjectsFromArray(list);
		assertEquals(1, set.size());
		assertTrue(set.contains("abc"));
	}

	public void testRemoveAllObjects() {
		NSMutableSet set = new NSMutableSet("abc");
		set.removeAllObjects();
		assertTrue(set.isEmpty());
	}

	public void testRemoveObject() {
		NSMutableSet set = new NSMutableSet("abc");
		Object removed = set.removeObject("abc");
		assertTrue(set.isEmpty());
		assertEquals("abc", removed);
	}

	public void testSubtractSet() {
		NSMutableSet otherSet = new NSMutableSet();
		otherSet.add("abc");
		otherSet.add("123");
		
		NSMutableSet set = new NSMutableSet("abc");
		set.subtractSet(otherSet);
		assertTrue(set.isEmpty());
	}

	public void testUnionSet() {
		NSMutableSet otherSet = new NSMutableSet();
		otherSet.add("abc");
		otherSet.add("123");
		
		NSMutableSet set = new NSMutableSet("abc");
		set.unionSet(otherSet);
		assertEquals(2, set.size());
		assertTrue(set.contains("abc"));
		assertTrue(set.contains("123"));
	}

	public void testSetSet() {
		NSMutableSet set = new NSMutableSet("abc");
		NSMutableSet otherSet = new NSMutableSet("123");
		otherSet.add("def");
		
		set.setSet(otherSet);
		assertEquals(otherSet, set);
	}

	public void testClone() {
		NSMutableSet set = new NSMutableSet("abc");
		NSMutableSet clone = (NSMutableSet) set.clone();
		assertEquals(set, clone);
		
		assertNotSame(set, clone);
	}

	public void testImmutableClone() {
		NSMutableSet set = new NSMutableSet("abc");
		NSSet clone = set.immutableClone();
		assertEquals(1, clone.size());
		assertTrue(clone.contains("abc"));
		
		assertNotSame(set, clone);
		
		assertEquals(NSSet.class, clone.getClass());
	}

	public void testClear() {
		NSMutableSet set = new NSMutableSet("abc");
		set.clear();
		assertTrue(set.isEmpty());
	}

	public void testAdd() {
		NSMutableSet set = new NSMutableSet();
		set.add("abc");
		assertTrue(set.contains("abc"));
	}

	public void testAddAllCollection() {
		NSMutableArray list = new NSMutableArray();
		list.add("abc");
		list.add("abc");
		
		NSMutableSet set = new NSMutableSet();
		set.addAll(list);
		assertEquals(1, set.size());
		assertTrue(set.contains("abc"));
	}

	public void testRemove() {
		NSMutableSet set = new NSMutableSet("abc");
		boolean removed = set.remove("abc");
		assertTrue(set.isEmpty());
		assertTrue(removed);
	}

	public void testRemoveAllCollection() {
		NSMutableArray list = new NSMutableArray();
		list.add("abc");
		list.add("123");
		
		NSMutableSet set = new NSMutableSet();
		set.addAll(list);
		set.removeAll(list);
		assertTrue(set.isEmpty());
	}

	public void testRetainAllCollection() {
		NSMutableArray list = new NSMutableArray();
		list.add("abc");
		list.add("123");
		
		NSMutableSet set = new NSMutableSet();
		set.addAll(list);
		
		list.remove("123");	
		set.retainAll(list);
		
		assertEquals(1, set.size());
		assertTrue(set.contains("abc"));
	}

}
