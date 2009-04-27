package your.app.gwt.eo;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;

public final class Studio_CustomFieldSerializer extends _Studio_CustomFieldSerializer {

	public static void deserialize(SerializationStreamReader streamReader, Studio instance)
    throws SerializationException {
		_Studio_CustomFieldSerializer.deserialize(streamReader, instance);
	}
	
	public static void serialize(SerializationStreamWriter streamWriter, Studio instance)
	    throws SerializationException {
		_Studio_CustomFieldSerializer.serialize(streamWriter, instance);
	}

}