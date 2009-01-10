package test.com.webobjects.foundation;

import java.sql.Timestamp;
import java.util.Date;

import com.webobjects.foundation.NSTimestamp;

public class TestNSTimestamp extends BaseTestCase {

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
		long d = new Date().getTime() / 1000;
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

	private static Date jan1() {
		Date d = new Date();
		d.setMonth(0);
		d.setDate(1);
		d.setYear(108);
		d.setHours(0);
		d.setMinutes(0);
		d.setSeconds(0);
		return d;
	}
	
	public void testTimestampByAddingGregorianUnits() {
		Date d = jan1();
		
		NSTimestamp timestamp = new NSTimestamp(d);
		NSTimestamp clone = new NSTimestamp(d);
		assertEquals(timestamp, clone);
		
		NSTimestamp temp = timestamp.timestampByAddingGregorianUnits(0, 0, 0, 0, 0, 0);
		assertEquals(timestamp, temp);
	}
		
	public void testTimestampByAddingGregorianUnitsYear() {
		Date d = jan1();
		
		NSTimestamp timestamp = new NSTimestamp(d);
		
		d.setYear(109);
		NSTimestamp expected = new NSTimestamp(d);
		
		NSTimestamp temp = timestamp.timestampByAddingGregorianUnits(1, 0, 0, 0, 0, 0);
		assertEquals(expected, temp);		
	}

	public void testTimestampByAddingGregorianUnitsMonth() {
		Date d = jan1();
		
		NSTimestamp timestamp = new NSTimestamp(d);
		
		d.setMonth(1);
		NSTimestamp expected = new NSTimestamp(d);
		
		NSTimestamp temp = timestamp.timestampByAddingGregorianUnits(0, 1, 0, 0, 0, 0);
		assertEquals(expected, temp);		
	}
	
	public void testTimestampByAddingGregorianUnitsDate() {
		Date d = jan1();
		
		NSTimestamp timestamp = new NSTimestamp(d);
		
		d.setDate(2);
		NSTimestamp expected = new NSTimestamp(d);
		
		NSTimestamp temp = timestamp.timestampByAddingGregorianUnits(0, 0, 1, 0, 0, 0);
		assertEquals(expected, temp);		
	}
	
	public void testTimestampByAddingGregorianUnitsHour() {
		Date d = jan1();
		
		NSTimestamp timestamp = new NSTimestamp(d);
		
		d.setHours(1);
		NSTimestamp expected = new NSTimestamp(d);
		
		NSTimestamp temp = timestamp.timestampByAddingGregorianUnits(0, 0, 0, 1, 0, 0);
		assertEquals(expected, temp);		
	}
	
	public void testTimestampByAddingGregorianUnitsMinute() {
		Date d = jan1();
		
		NSTimestamp timestamp = new NSTimestamp(d);
		
		d.setMinutes(1);
		NSTimestamp expected = new NSTimestamp(d);
		
		NSTimestamp temp = timestamp.timestampByAddingGregorianUnits(0, 0, 0, 0, 1, 0);
		assertEquals(expected, temp);		
	}

	public void testTimestampByAddingGregorianUnitsSecond() {
		Date d = jan1();
		
		NSTimestamp timestamp = new NSTimestamp(d);
		
		d.setSeconds(1);
		NSTimestamp expected = new NSTimestamp(d);
		
		NSTimestamp temp = timestamp.timestampByAddingGregorianUnits(0, 0, 0, 0, 0, 1);
		assertEquals(expected, temp);		
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

	public void testDistantFuture() {
		assertTrue(NSTimestamp.DistantFuture.after(new NSTimestamp()));
	}
	
	public void testDistantPast() {
		assertTrue(NSTimestamp.DistantPast.before(new NSTimestamp()));
	}
	
}
