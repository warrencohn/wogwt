package com.google.gwt.user.client.rpc.core.com.webobjects.foundation;

import java.sql.Timestamp;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.webobjects.foundation.NSTimestamp;

public final class NSTimestamp_CustomFieldSerializer {

	public static void deserialize(SerializationStreamReader streamReader, NSTimestamp instance)
        throws SerializationException {
    	
    }

    public static NSTimestamp instantiate(SerializationStreamReader streamReader)
    	throws SerializationException {
    	long time = streamReader.readLong();
    	int nanos = streamReader.readInt();
 
    	if (nanos == 0) {
        	int milliseconds = (int)(time % 1000);
    		nanos = milliseconds * 1000000;
    	}
    	
    	Timestamp t = new Timestamp(time);
    	t.setNanos(nanos);
 
        return new NSTimestamp(t);
    }

    public static void serialize(SerializationStreamWriter streamWriter, NSTimestamp instance)
        throws SerializationException {
        streamWriter.writeLong(instance.getTime());
        streamWriter.writeInt(instance.getNanos());
    }
    
}