package com.webobjects.foundation;

import java.sql.Timestamp;
import java.util.Date;

public class NSTimestamp extends Timestamp {

	public NSTimestamp() {
		this(new Date().getTime());
	}
	
	public NSTimestamp(long time) {
		super(time);
	}
	
	public NSTimestamp(Date date) {
		this(date.getTime());
	}
	
}
