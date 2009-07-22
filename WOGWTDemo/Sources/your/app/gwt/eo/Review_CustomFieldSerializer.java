package your.app.gwt.eo;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;

public final class Review_CustomFieldSerializer extends _Review_CustomFieldSerializer {

	public static void deserialize(SerializationStreamReader streamReader, Review instance)
    throws SerializationException {
		_Review_CustomFieldSerializer.deserialize(streamReader, instance);
	}
	
	public static Review instantiate(SerializationStreamReader streamReader)
	throws SerializationException {
		return _Review_CustomFieldSerializer.instantiate(streamReader);
	}
	
	public static void serialize(SerializationStreamWriter streamWriter, Review instance)
	    throws SerializationException {
		_Review_CustomFieldSerializer.serialize(streamWriter, instance);
	}

}