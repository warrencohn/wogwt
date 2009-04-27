package your.app.gwt.eo;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;

public final class MovieRole_CustomFieldSerializer extends _MovieRole_CustomFieldSerializer {

	public static void deserialize(SerializationStreamReader streamReader, MovieRole instance)
    throws SerializationException {
		_MovieRole_CustomFieldSerializer.deserialize(streamReader, instance);
	}
	
	public static void serialize(SerializationStreamWriter streamWriter, MovieRole instance)
	    throws SerializationException {
		_MovieRole_CustomFieldSerializer.serialize(streamWriter, instance);
	}

}