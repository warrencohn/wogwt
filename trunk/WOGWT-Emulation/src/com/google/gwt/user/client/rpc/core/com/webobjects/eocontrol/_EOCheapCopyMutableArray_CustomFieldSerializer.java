package com.google.gwt.user.client.rpc.core.com.webobjects.eocontrol;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.core.com.webobjects.foundation.NSArray_CustomFieldSerializer;
import com.google.gwt.user.client.rpc.core.java.util.Collection_CustomFieldSerializerBase;
import com.webobjects.eocontrol._EOCheapCopyMutableArray;

public final class _EOCheapCopyMutableArray_CustomFieldSerializer {

	public static void deserialize(SerializationStreamReader streamReader, _EOCheapCopyMutableArray instance)
        throws SerializationException {
    	Collection_CustomFieldSerializerBase.deserialize(streamReader, instance);
    }

    public static void serialize(SerializationStreamWriter streamWriter, _EOCheapCopyMutableArray instance)
        throws SerializationException {
    	Collection_CustomFieldSerializerBase.serialize(streamWriter, instance);
    }
    
}