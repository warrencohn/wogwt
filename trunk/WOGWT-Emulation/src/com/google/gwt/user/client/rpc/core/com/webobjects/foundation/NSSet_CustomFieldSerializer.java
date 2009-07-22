package com.google.gwt.user.client.rpc.core.com.webobjects.foundation;

import java.util.HashSet;
import java.util.Set;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.core.java.util.Collection_CustomFieldSerializerBase;
import com.webobjects.foundation.NSSet;

public final class NSSet_CustomFieldSerializer {

	public static void deserialize(SerializationStreamReader streamReader, NSSet instance)
        throws SerializationException {

    }

    public static NSSet instantiate(SerializationStreamReader streamReader)
		throws SerializationException {
    	Set instance = new HashSet();
    	Collection_CustomFieldSerializerBase.deserialize(streamReader, instance);
    	return new NSSet(instance);
    }
    
    public static void serialize(SerializationStreamWriter streamWriter, NSSet instance)
        throws SerializationException {
    	Collection_CustomFieldSerializerBase.serialize(streamWriter, instance);
    }
    
}