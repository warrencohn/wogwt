package com.google.gwt.user.client.rpc.core.com.webobjects.foundation;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.core.java.util.Collection_CustomFieldSerializerBase;
import com.webobjects.foundation.NSMutableArray;

public final class NSMutableArray_CustomFieldSerializer {

	public static void deserialize(SerializationStreamReader streamReader, NSMutableArray instance)
        throws SerializationException {
    	Collection_CustomFieldSerializerBase.deserialize(streamReader, instance);
    }

    public static void serialize(SerializationStreamWriter streamWriter, NSMutableArray instance)
        throws SerializationException {
    	Collection_CustomFieldSerializerBase.serialize(streamWriter, instance);
    }
    
}