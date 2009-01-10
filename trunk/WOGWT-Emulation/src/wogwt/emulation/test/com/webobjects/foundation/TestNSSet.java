package test.com.webobjects.foundation;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import com.webobjects.foundation.NSArray;
import com.webobjects.foundation.NSMutableArray;
import com.webobjects.foundation.NSMutableSet;
import com.webobjects.foundation.NSSet;


public class TestNSSet extends BaseTestCase {

	public void testNSSet() {
		NSSet set = new NSSet();
		assertTrue(set.isEmpty());
	}

	public void testNSSetCollectionOfQextendsE() {
		ArrayList list = new ArrayList();
		list.add("abc");
		list.add("abc");
		
		NSSet set = new NSSet(list);
		assertEquals(1, set.size());
		assertTrue(set.contains("abc"));
	}

	public void testNSSetE() {
		NSSet set = new NSSet("abc");
		assertTrue(set.contains("abc"));
	}

	public void testNSSetEArray() {
		String[] strings = new String[] {"abc", "abc"};
		NSSet set = new NSSet(strings);
		assertEquals(1, set.size());
		assertTrue(set.contains("abc"));
	}

	public void testNSSetNSArrayOfQextendsE() {
		NSMutableArray list = new NSMutableArray();
		list.add("abc");
		list.add("abc");
		
		NSSet set = new NSSet(list);
		assertEquals(1, set.size());
		assertTrue(set.contains("abc"));
	}

	public void testNSSetNSSetOfQextendsE() {
		NSSet set = new NSSet("abc");
		NSSet copy = new NSSet(set);
		assertEquals(1, copy.size());
		assertTrue(copy.contains("abc"));
	}

	public void testNSSetSetOfQextendsEBoolean() {
		Set source = new HashSet();
		source.add("abc");
		source.add(null);
		
		NSSet set = new NSSet(source, true);
		assertEquals(1, set.size());
		assertTrue(set.contains("abc"));
		
		try {
			set = new NSSet(source, false);
			fail("IllegalArgumentException expected");
		} catch (IllegalArgumentException e) {
		}
	}

	public void testAllObjects() {
		NSSet set = new NSSet(new String[] {"abc", "123"});
		NSArray allObjects = set.allObjects();
		assertEquals(2, allObjects.size());
		assertTrue(allObjects.contains("abc"));
		assertTrue(allObjects.contains("123"));
	}

	public void testAnyObject() {
		NSSet set = new NSSet(new String[] {"abc"});
		Object object = set.anyObject();
		assertEquals("abc", object);
	}

	public void testContainsObject() {
		NSSet set = new NSSet(new String[] {"abc"});
		assertTrue(set.containsObject("abc"));
		assertFalse(set.containsObject("123"));
	}

	public void testCount() {
		NSSet set = new NSSet(new String[] {"abc"});
		assertEquals(1, set.count());
		
		set = new NSSet(new String[] {"abc", "123", "abc"});
		assertEquals(2, set.count());
	}

	public void testEmptySet() {
		NSSet set = NSSet.emptySet();
		assertTrue(set.isEmpty());
	}

	public void testHashSet() {
		NSSet set = new NSSet(new String[] {"abc"});
		NSSet hashSet = (NSSet) set.hashSet();
		assertEquals(1, hashSet.size());
		assertTrue(hashSet.contains("abc"));
	}

	public void testClone() {
		NSSet set = new NSSet(new String[] {"abc", "123"});
		NSSet clone = (NSSet) set.clone();
		assertEquals(set, clone);
	}

	public void testImmutableClone() {
		NSSet set = new NSSet(new String[] {"abc", "123"});
		NSSet clone = (NSSet) set.immutableClone();
		assertEquals(set, clone);
		assertEquals(NSSet.class, clone.getClass());
	}

	public void testMutableClone() {
		NSSet set = new NSSet(new String[] {"abc"});
		NSMutableSet clone = set.mutableClone();
		assertEquals(1, clone.size());
		assertTrue(clone.contains("abc"));
	}

	public void testIntersectsSet() {
		NSSet set = new NSSet(new String[] {"abc", "123"});
		NSSet set2 = new NSSet(new String[] {"abc"});
		assertTrue(set.intersectsSet(set2));
		
		NSSet set3 = new NSSet(new String[] {"def"});
		assertFalse(set.intersectsSet(set3));
	}

	public void testIsEqualToSet() {
		NSSet set = new NSSet(new String[] {"abc", "123"});
		NSSet set2 = new NSSet(new String[] {"abc", "123"});
		assertTrue(set.isEqualToSet(set2));
		
		NSSet set3 = new NSSet(new String[] {"abc"});
		assertFalse(set.isEqualToSet(set3));
	}

	public void testIsSubsetOfSet() {
		NSSet set = new NSSet(new String[] {"abc"});
		NSSet set2 = new NSSet(new String[] {"abc", "123"});
		assertTrue(set.isSubsetOfSet(set2));
		assertFalse(set2.isSubsetOfSet(set));
		
		NSSet set3 = new NSSet(new String[] {"def"});
		assertFalse(set.isSubsetOfSet(set3));
	}

	public void testMember() {
		NSSet set = new NSSet(new String[] {"abc"});
		assertTrue(set.member("abc"));
		assertFalse(set.member("123"));
	}

	public void testSetByIntersectingSet() {
		NSSet set = new NSSet(new String[] {"abc"});
		NSSet set2 = new NSSet(new String[] {"abc", "123"});
		
		NSSet intersection = set.setByIntersectingSet(set2);
		assertEquals(1, intersection.size());
		assertTrue(intersection.contains("abc"));
		
		set2 = new NSSet(new String[] {"123"});
		intersection = set.setByIntersectingSet(set2);
		assertTrue(intersection.isEmpty());
	}

	public void testSetBySubtractingSet() {
		NSSet set = new NSSet(new String[] {"abc", "123"});
		NSSet set2 = new NSSet(new String[] {"123"});
		
		NSSet difference = set.setBySubtractingSet(set2);
		assertEquals(1, difference.size());
		assertTrue(difference.contains("abc"));
		
		set2 = new NSSet(new String[] {"def"});
		difference = set.setBySubtractingSet(set2);
		assertEquals(set, difference);
	}

	public void testSetByUnioningSet() {
		NSSet set = new NSSet(new String[] {"abc", "123"});
		NSSet set2 = new NSSet(new String[] {"def"});
		
		NSSet union = set.setByUnioningSet(set2);
		assertEquals(3, union.size());
		
		set2 = new NSSet(new String[] {"abc"});
		union = set.setByUnioningSet(set2);
		assertEquals(set.size(), union.size());
	}

	public void testClear() {
		try {
			NSSet.EmptySet.clear();
			fail("Clear should throw UnsupportedOperationException");
		} catch (UnsupportedOperationException e) {
		}
	}

	public void testAdd() {
		try {
			NSSet.EmptySet.add("abc");
			fail("Add should throw UnsupportedOperationException");
		} catch (UnsupportedOperationException e) {
		}
	}

	public void testAddAllCollection() {
		try {
			HashSet set = new HashSet();
			set.add("abc");
			set.add("123");
			NSSet.EmptySet.addAll(set);
			fail("AddAll should throw UnsupportedOperationException");
		} catch (UnsupportedOperationException e) {
		}
	}

	public void testRemove() {
		try {
			NSSet.EmptySet.remove("abc");
			fail("Clear should throw UnsupportedOperationException");
		} catch (UnsupportedOperationException e) {
		}
	}

	public void testRemoveAllCollection() {
		try {
			HashSet set = new HashSet();
			set.add("abc");
			set.add("123");
			NSSet.EmptySet.removeAll(set);
			fail("RemoveAll should throw UnsupportedOperationException");
		} catch (UnsupportedOperationException e) {
		}
	}

	public void testRetainAllCollection() {
		try {
			HashSet set = new HashSet();
			set.add("abc");
			set.add("123");
			NSSet.EmptySet.retainAll(set);
			fail("RetainAll should throw UnsupportedOperationException");
		} catch (UnsupportedOperationException e) {
		}
	}

}
