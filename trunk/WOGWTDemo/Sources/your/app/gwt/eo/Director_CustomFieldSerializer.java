package your.app.gwt.eo;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;

public final class Director_CustomFieldSerializer extends _Director_CustomFieldSerializer {

	public static void deserialize(SerializationStreamReader streamReader, Director instance)
    throws SerializationException {
		_Director_CustomFieldSerializer.deserialize(streamReader, instance);
	}
	
	public static Director instantiate(SerializationStreamReader streamReader)
	throws SerializationException {
		return _Director_CustomFieldSerializer.instantiate(streamReader);
	}
	
	public static void serialize(SerializationStreamWriter streamWriter, Director instance)
	    throws SerializationException {
		_Director_CustomFieldSerializer.serialize(streamWriter, instance);
	}

}