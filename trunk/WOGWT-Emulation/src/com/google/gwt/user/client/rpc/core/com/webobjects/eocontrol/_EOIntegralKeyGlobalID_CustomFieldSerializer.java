package com.google.gwt.user.client.rpc.core.com.webobjects.eocontrol;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.webobjects.eocontrol._EOIntegralKeyGlobalID;

public class _EOIntegralKeyGlobalID_CustomFieldSerializer {

	public static void deserialize(SerializationStreamReader streamReader, _EOIntegralKeyGlobalID instance)
	throws SerializationException {

	}

	public static _EOIntegralKeyGlobalID instantiate(SerializationStreamReader streamReader)
	throws SerializationException {
		String entityName = streamReader.readString();
		Number keyValue = (Number) streamReader.readObject();
		return new _EOIntegralKeyGlobalID(entityName, keyValue);
	}

	public static void serialize(SerializationStreamWriter streamWriter, _EOIntegralKeyGlobalID instance)
	throws SerializationException {
		streamWriter.writeString(instance.entityName());
		streamWriter.writeObject(instance.keyValues()[0]);
	}

}
