package test.com.webobjects.foundation;

import com.webobjects.foundation.NSMutableRange;
import com.webobjects.foundation.NSRange;

public class TestNSRange extends BaseTestCase {

	public void testNSRange() {
		NSRange range = new NSRange();
		assertEquals(new NSRange(0,0), range);
	}

	public void testNSRangeIntInt() {
		NSRange range = new NSRange(2,3);
		assertEquals(2, range.location());
		assertEquals(3, range.length());
	}

	public void testNSRangeNSRange() {
		NSRange range = new NSRange(1,1);
		NSRange otherRange = new NSRange(range);
		assertEquals(range, otherRange);
	}

	public void testLocation() {
		NSRange range = new NSRange(2,3);
		assertEquals(2, range.location());
	}

	public void testLength() {
		NSRange range = new NSRange(2,3);
		assertEquals(3, range.length());
	}

	public void testEqualsObject() {
		NSRange range = new NSRange(2,3);
		NSRange otherRange = new NSRange(2, 3);
		assertTrue(range.equals(otherRange));
		
		otherRange = new NSRange(3, 3);
		assertFalse(range.equals(otherRange));
		
		otherRange = null;
		assertFalse(range.equals(otherRange));
		
		otherRange = new NSMutableRange(2, 3);
		assertFalse(range.equals(otherRange));
	}
	
	public void testIsEqualToRange() {
		NSRange range = new NSRange(2,3);
		NSRange otherRange = new NSRange(2, 3);
		assertTrue(range.isEqualToRange(otherRange));
		
		otherRange = new NSRange(3, 3);
		assertFalse(range.isEqualToRange(otherRange));
	}

	public void testToString() {
		NSRange range = new NSRange(2,3);
		assertEquals("{2, 3}", range.toString());
	}

	public void testClone() {
		NSRange range = new NSRange(2,3);
		NSRange clone = (NSRange) range.clone();
		assertEquals(range, clone);
	}

	public void testContainsLocation() {
		NSRange range = new NSRange(2,3);
		assertFalse(range.containsLocation(1));
		assertTrue(range.containsLocation(2));
		assertTrue(range.containsLocation(4));
		assertFalse(range.containsLocation(5));
	}

	public void testIntersectsRange() {
		NSRange range = new NSRange(2,3);
		NSRange otherRange = new NSRange(3, 3);
		assertTrue(range.intersectsRange(otherRange));
	}

	public void testIsEmpty() {
		NSRange range = new NSRange(2,3);
		assertFalse(range.isEmpty());
		
		range = new NSRange(2, 0);
		assertTrue(range.isEmpty());
		
		range = new NSRange(0, -1);
		assertTrue(range.isEmpty());
	}

	public void testIsSubrangeOfRange() {
		NSRange range = new NSRange(2,3); //2,3,4
		NSRange otherRange = new NSRange(3, 2); //3,4
		assertTrue(range.isSubrangeOfRange(otherRange));
	}

	public void testMaxRange() {
		NSRange range = new NSRange(2,3);
		assertEquals(4, range.maxRange());
		
		range = new NSRange(0, 0);
		assertEquals(0, range.maxRange());
	}

	public void testRangeByIntersectingRange() {
		NSRange range = new NSRange(2,3); //2,3,4
		NSRange otherRange = new NSRange(3, 3); //3,4,5
		NSRange intersection = range.rangeByIntersectingRange(otherRange); //3,4
		assertEquals(new NSRange(3, 2), intersection);
	}

	public void testRangeByUnioningRange() {
		NSRange range = new NSRange(2,3); //2,3,4
		NSRange otherRange = new NSRange(3, 3); //3,4,5
		NSRange union = range.rangeByUnioningRange(otherRange); //2,3,4,5
		assertEquals(new NSRange(2, 4), union);
	}

	public void testZeroRange() {
		assertEquals(0, NSRange.ZeroRange.location());
		assertEquals(0, NSRange.ZeroRange.length());
	}
	
	public void testSubtractRange() {
		NSMutableRange result1 = new NSMutableRange();
		NSMutableRange result2 = new NSMutableRange();
		
		// no intersection
		NSRange testRange = new NSRange(0, 2);
		testRange.subtractRange(new NSRange(2, 2), result1, result2);
		assertEquals(new NSMutableRange(0, 2), result1);
		assertEquals(new NSMutableRange(0, 0), result2);
		
		// total intersection
		testRange = new NSRange(1, 2);
		testRange.subtractRange(new NSRange(0, 4), result1, result2);
		assertEquals(new NSMutableRange(0, 0), result1);
		assertEquals(new NSMutableRange(0, 0), result2);
		
		// start intersection
		testRange = new NSRange(1, 2);
		testRange.subtractRange(new NSRange(0, 2), result1, result2);
		assertEquals(new NSMutableRange(2, 1), result1);
		assertEquals(new NSMutableRange(0, 0), result2);
		
		// end intersection
		testRange = new NSRange(1, 2);
		testRange.subtractRange(new NSRange(2, 2), result1, result2);
		assertEquals(new NSMutableRange(1, 1), result1);
		assertEquals(new NSMutableRange(0, 0), result2);
	}
	
	public void testFromString() {
		NSRange range = NSRange.fromString("{1,1}");
		assertEquals(new NSRange(1,1), range);

		range = NSRange.fromString("{1, 1}");
		assertEquals(new NSRange(1,1), range);
		
		try {
			NSRange.fromString("{1}");
			fail("IllegalArgumentException expected");
		} catch (IllegalArgumentException e) {
		}
	}
	
}
