package com.google.gwt.user.client.rpc.core.com.webobjects.foundation;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.webobjects.foundation.NSMutableRange;

public final class NSMutableRange_CustomFieldSerializer {

	public static void deserialize(SerializationStreamReader streamReader, NSMutableRange instance)
        throws SerializationException {
    	
    }

    public static NSMutableRange instantiate(SerializationStreamReader streamReader)
    	throws SerializationException {
    	int location = streamReader.readInt();
    	int length = streamReader.readInt();
    	return new NSMutableRange(location, length);
    }

    public static void serialize(SerializationStreamWriter streamWriter, NSMutableRange instance)
        throws SerializationException {
        streamWriter.writeInt(instance.location());
        streamWriter.writeInt(instance.length());
    }
    
}