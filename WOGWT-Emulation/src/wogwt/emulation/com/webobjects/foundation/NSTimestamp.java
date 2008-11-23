package com.webobjects.foundation;

import java.sql.Timestamp;
import java.util.Date;

public class NSTimestamp extends Timestamp {

	private static final String UNSUPPORTED = " is not a supported operation of com.webobjects.foundation.NSTimestamp";

	public NSTimestamp() {
		this(new Date().getTime());
	}
	
	public NSTimestamp(Date date) {
		this(date.getTime());
	}
	
	public NSTimestamp(long time) {
		super(time);
	}
	
	public NSTimestamp(long milliseconds, int nanoseconds) {
		super(milliseconds);
		int nanos = nanoseconds;
    	if (nanoseconds == 0) {
        	nanos = (int)(milliseconds % 1000);
    		nanos = nanos * 1000000;
    	}
		super.setNanos(nanoseconds);
	}
	
	public NSTimestamp(long time, NSTimestamp date) {
		this(date.getTime() + time);
	}
	
	public NSTimestamp(Timestamp sqlTimestamp) {
		this(sqlTimestamp.getTime(), sqlTimestamp.getNanos());
	}
	
	public int compare(NSTimestamp ts) {
		int result = compareTo(ts);
		if (result < 0)
			return NSComparator.OrderedAscending;
		else if (result == 0)
			return NSComparator.OrderedSame;
		else
			return NSComparator.OrderedDescending;
	}
	
	@Override
	public int getNanos() {
		int milliseconds =  Math.round(super.getNanos() / 1000000) * 1000000;
		return super.getNanos() - milliseconds;
	}

	public NSTimestamp timestampByAddingGregorianUnits(int years, 
			int months, int days, int hours, int minutes, int seconds)  {
		Date result = new Date();
		result.setYear(years);
		result.setMonth(months);
		result.setDate(days);
		result.setHours(hours);
		result.setMinutes(minutes);
		result.setSeconds(seconds);
		return new NSTimestamp(result);
	}
	
	@Override
	public void setDate(int date) {
		throw new UnsupportedOperationException("setDate" + UNSUPPORTED);
	}
	
	@Override
	public void setMonth(int month) {
		throw new UnsupportedOperationException("setMonth" + UNSUPPORTED);
	}
	
	@Override
	public void setYear(int year) {
		throw new UnsupportedOperationException("setYear" + UNSUPPORTED);
	}
	
	@Override
	public void setHours(int hours) {
		throw new UnsupportedOperationException("setHours" + UNSUPPORTED);
	}
	
	@Override
	public void setMinutes(int minutes) {
		throw new UnsupportedOperationException("setMinutes" + UNSUPPORTED);
	}
	
	@Override
	public void setSeconds(int seconds) {
		throw new UnsupportedOperationException("setSeconds" + UNSUPPORTED);
	}
	
	@Override
	public void setNanos(int n) {
		throw new UnsupportedOperationException("setNanos" + UNSUPPORTED);
	}
	
	@Override
	public void setTime(long time) {
		throw new UnsupportedOperationException("setTime" + UNSUPPORTED);
	}
	
}
