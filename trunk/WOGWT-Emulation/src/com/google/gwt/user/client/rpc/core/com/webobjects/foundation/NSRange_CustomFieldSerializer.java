package com.google.gwt.user.client.rpc.core.com.webobjects.foundation;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.webobjects.foundation.NSRange;

public final class NSRange_CustomFieldSerializer {

	public static void deserialize(SerializationStreamReader streamReader, NSRange instance)
        throws SerializationException {
    	
    }

    public static NSRange instantiate(SerializationStreamReader streamReader)
    	throws SerializationException {
    	int location = streamReader.readInt();
    	int length = streamReader.readInt();
    	return new NSRange(location, length);
    }

    public static void serialize(SerializationStreamWriter streamWriter, NSRange instance)
        throws SerializationException {
        streamWriter.writeInt(instance.location());
        streamWriter.writeInt(instance.length());
    }
    
}