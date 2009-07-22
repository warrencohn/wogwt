package com.google.gwt.user.client.rpc.core.com.webobjects.eocontrol;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.webobjects.eocontrol.EOTemporaryGlobalID;

public class EOTemporaryGlobalID_CustomFieldSerializer {

	public static void deserialize(SerializationStreamReader streamReader, EOTemporaryGlobalID instance)
        throws SerializationException {

    }

    public static EOTemporaryGlobalID instantiate(SerializationStreamReader streamReader)
		throws SerializationException {
    	int length = streamReader.readInt();
    	byte[] bytes = new byte[length];
    	
    	for (int i = 0; i < length; i++) {
    		bytes[i] = streamReader.readByte();
		}
    	
    	return EOTemporaryGlobalID._gidForRawBytes(bytes);
    }
    
    public static void serialize(SerializationStreamWriter streamWriter, EOTemporaryGlobalID instance)
        throws SerializationException {
    	streamWriter.writeInt(instance._rawBytes().length);
    	for (int i = 0; i < instance._rawBytes().length; i++) {
    		streamWriter.writeByte(instance._rawBytes()[i]);
		}
    }
    
}
