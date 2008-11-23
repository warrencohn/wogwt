package com.google.gwt.user.client.rpc.core.com.webobjects.foundation;

import java.util.HashMap;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.core.java.util.Map_CustomFieldSerializerBase;
import com.webobjects.foundation.NSDictionary;

public final class NSDictionary_CustomFieldSerializer {

	public static void deserialize(SerializationStreamReader streamReader, NSDictionary instance)
        throws SerializationException {

    }

    public static NSDictionary instantiate(SerializationStreamReader streamReader)
		throws SerializationException {
		HashMap map = new HashMap();
		Map_CustomFieldSerializerBase.deserialize(streamReader, map);
		return new NSDictionary(map);
	}
    
    public static void serialize(SerializationStreamWriter streamWriter, NSDictionary instance)
        throws SerializationException {
    	Map_CustomFieldSerializerBase.serialize(streamWriter, instance);
    }
    
}