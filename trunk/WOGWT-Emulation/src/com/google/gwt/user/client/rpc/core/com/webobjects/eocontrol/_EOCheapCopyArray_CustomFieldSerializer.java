package com.google.gwt.user.client.rpc.core.com.webobjects.eocontrol;

import java.util.ArrayList;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.core.java.util.Collection_CustomFieldSerializerBase;
import com.webobjects.eocontrol._EOCheapCopyArray;
import com.webobjects.foundation.NSArray;

public final class _EOCheapCopyArray_CustomFieldSerializer {

	public static void deserialize(SerializationStreamReader streamReader, _EOCheapCopyArray instance)
        throws SerializationException {

    }

    public static _EOCheapCopyArray instantiate(SerializationStreamReader streamReader)
		throws SerializationException {
    	ArrayList array = new ArrayList();
    	Collection_CustomFieldSerializerBase.deserialize(streamReader, array);
    	return new _EOCheapCopyArray(new NSArray(array));
    }
    
    public static void serialize(SerializationStreamWriter streamWriter, _EOCheapCopyArray instance)
        throws SerializationException {
    	Collection_CustomFieldSerializerBase.serialize(streamWriter, instance);
    }
    
}