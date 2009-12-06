package com.google.gwt.user.client.rpc.core.java.math;

import java.math.BigInteger;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;

public class BigInteger_CustomFieldSerializer {

	public static void deserialize(SerializationStreamReader streamReader, BigInteger instance)
    throws SerializationException {

	}
	
	public static BigInteger instantiate(SerializationStreamReader streamReader)
		throws SerializationException {
		String value = streamReader.readString();
		return new BigInteger(value);
	}
	
	public static void serialize(SerializationStreamWriter streamWriter, BigInteger instance)
	    throws SerializationException {
		streamWriter.writeString(instance.toString());
	}

}
