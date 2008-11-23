package com.google.gwt.user.client.rpc.core.com.webobjects.foundation;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.core.java.util.Map_CustomFieldSerializerBase;
import com.webobjects.foundation.NSMutableDictionary;

public final class NSMutableDictionary_CustomFieldSerializer {

	public static void deserialize(SerializationStreamReader streamReader, NSMutableDictionary instance)
        throws SerializationException {
		Map_CustomFieldSerializerBase.deserialize(streamReader, instance);
    }

    public static void serialize(SerializationStreamWriter streamWriter, NSMutableDictionary instance)
        throws SerializationException {
    	Map_CustomFieldSerializerBase.serialize(streamWriter, instance);
    }
    
}