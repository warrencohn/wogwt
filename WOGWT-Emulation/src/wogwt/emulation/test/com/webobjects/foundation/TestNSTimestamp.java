package test.com.webobjects.foundation;

import java.sql.Timestamp;
import java.util.Date;

import junit.framework.TestCase;

import com.webobjects.foundation.NSTimestamp;

public class TestNSTimestamp extends TestCase {

	protected void setUp() throws Exception {
		super.setUp();
	}

	public void testNSTimestamp() {
		NSTimestamp time = new NSTimestamp();
		assertNotNull(time);
	}

	public void testNSTimestampDate() {
		Date date = new Date();
		NSTimestamp time = new NSTimestamp(date);
		assertEquals(date.getTime(), time.getTime());
	}

	public void testNSTimestampLong() {
		long date = new Date().getTime();
		NSTimestamp time = new NSTimestamp(date);
		assertEquals(date, time.getTime());
	}

	public void testNSTimestampLongInt() {
		Timestamp date = new Timestamp(new Date().getTime());
		long d = new Date().getTime() / 1000;
		d = d * 1000;
		int nanos = 1000;
		NSTimestamp time = new NSTimestamp(d, nanos);
		assertEquals(d, time.getTime());
		assertEquals(1000, time.getNanos());
	}

	public void testNSTimestampLongNSTimestamp() {
		long t = 1000;
		NSTimestamp earlierTime = new NSTimestamp();
		NSTimestamp time = new NSTimestamp(t, earlierTime);
		assertTrue(earlierTime.before(time));
	}

	public void testNSTimestampTimestamp() {
		Timestamp ts = new Timestamp(new Date().getTime());
		NSTimestamp time = new NSTimestamp(ts);
		assertEquals(time.getTime(), ts.getTime());
	}

	public void testGetNanos() {
		Timestamp ts = new Timestamp(new Date().getTime());
		ts.setNanos(100);
		NSTimestamp time = new NSTimestamp(ts);
		assertEquals(100, time.getNanos());
	}
	
	public void testCompare() {
		NSTimestamp firstTime = new NSTimestamp();
		Date date = new Date(firstTime.getTime() + 1000);
		NSTimestamp nextTime = new NSTimestamp(date);
		assertEquals(-1, firstTime.compare(nextTime));
		assertEquals(0, firstTime.compare(firstTime));
		assertEquals(1, nextTime.compare(firstTime));
	}

	public void testTimestampByAddingGregorianUnits() {
		fail("Not yet implemented");
	}

	public void testSetYear() {
		try {
			new NSTimestamp().setYear(2000);
			fail("SetYear should throw UnsupportedOperationException");
		} catch (UnsupportedOperationException e) {
		}
	}

	public void testSetMonth() {
		try {
			new NSTimestamp().setMonth(1);
			fail("SetMonth should throw UnsupportedOperationException");
		} catch (UnsupportedOperationException e) {
		}
	}

	public void testSetDate() {
		try {
			new NSTimestamp().setDate((int)new Date().getTime());
			fail("SetDate should throw UnsupportedOperationException");
		} catch (UnsupportedOperationException e) {
		}
	}

	public void testSetHours() {
		try {
			new NSTimestamp().setHours(1);
			fail("SetHours should throw UnsupportedOperationException");
		} catch (UnsupportedOperationException e) {
		}
	}

	public void testSetMinutes() {
		try {
			new NSTimestamp().setMinutes(1);
			fail("SetMinutes should throw UnsupportedOperationException");
		} catch (UnsupportedOperationException e) {
		}
	}

	public void testSetSeconds() {
		try {
			new NSTimestamp().setSeconds(1);
			fail("SetSeconds should throw UnsupportedOperationException");
		} catch (UnsupportedOperationException e) {
		}
	}

	public void testSetTime() {
		try {
			new NSTimestamp().setTime(new Date().getTime());
			fail("SetTime should throw UnsupportedOperationException");
		} catch (UnsupportedOperationException e) {
		}
	}

	public void testSetNanos() {
		try {
			new NSTimestamp().setNanos(999999999);
			fail("SetNanos should throw UnsupportedOperationException");
		} catch (UnsupportedOperationException e) {
		}
	}

}
