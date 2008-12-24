package com.google.gwt.user.client.rpc.core.com.webobjects.foundation;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.webobjects.foundation.NSData;

public final class NSData_CustomFieldSerializer {

	public static void deserialize(SerializationStreamReader streamReader, NSData instance)
        throws SerializationException {

    }

    public static NSData instantiate(SerializationStreamReader streamReader)
		throws SerializationException {
    	int length = streamReader.readInt();
    	byte[] bytes = new byte[length];
    	for (int i = 0; i < bytes.length; i++) {
			bytes[i] = streamReader.readByte();
		}
    	return new NSData(bytes);
    }
    
    public static void serialize(SerializationStreamWriter streamWriter, NSData instance)
        throws SerializationException {
    	streamWriter.writeInt(instance.length());
    	for (int i = 0; i < instance.length(); i++) {
			streamWriter.writeByte(instance.bytes()[i]);
		}
    }
    
}