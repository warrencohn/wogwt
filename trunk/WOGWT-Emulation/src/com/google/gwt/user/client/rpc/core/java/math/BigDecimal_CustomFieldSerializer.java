package com.google.gwt.user.client.rpc.core.java.math;

import java.math.BigDecimal;
import java.math.BigInteger;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;

public class BigDecimal_CustomFieldSerializer {

	public static void deserialize(SerializationStreamReader streamReader, BigDecimal instance)
    throws SerializationException {

	}
	
	public static BigDecimal instantiate(SerializationStreamReader streamReader)
		throws SerializationException {
		BigInteger unscaledValue = (BigInteger) streamReader.readObject();
		int scale = streamReader.readInt();
		return new BigDecimal(unscaledValue, scale);
	}
	
	public static void serialize(SerializationStreamWriter streamWriter, BigDecimal instance)
	    throws SerializationException {
		streamWriter.writeObject(instance.unscaledValue());
		streamWriter.writeInt(instance.scale());
	}

}
