package com.google.gwt.user.client.rpc.core.com.webobjects.eocontrol;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.webobjects.eocontrol._EOIntegralKeyGlobalID;
import com.webobjects.eocontrol._EOVectorKeyGlobalID;

public class _EOVectorKeyGlobalID_CustomFieldSerializer {

	public static void deserialize(SerializationStreamReader streamReader, _EOVectorKeyGlobalID instance)
	throws SerializationException {

	}

	public static _EOVectorKeyGlobalID instantiate(SerializationStreamReader streamReader)
	throws SerializationException {
		String entityName = streamReader.readString();
		
    	int length = streamReader.readInt();
    	Object[] keyValues = new Object[length];
    	
    	for (int i = 0; i < length; i++) {
    		keyValues[i] = streamReader.readObject();
		}
    	
		return new _EOVectorKeyGlobalID(entityName, keyValues);
	}

	public static void serialize(SerializationStreamWriter streamWriter, _EOVectorKeyGlobalID instance)
	throws SerializationException {
		streamWriter.writeString(instance.entityName());
    	streamWriter.writeInt(instance.keyValues().length);
    	for (int i = 0; i < instance.keyValues().length; i++) {
    		streamWriter.writeObject(instance.keyValues()[i]);
		}
	}
	
}
