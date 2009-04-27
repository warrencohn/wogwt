package your.app.gwt.eo;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;

public final class Movie_CustomFieldSerializer extends _Movie_CustomFieldSerializer {

	public static void deserialize(SerializationStreamReader streamReader, Movie instance)
    throws SerializationException {
		_Movie_CustomFieldSerializer.deserialize(streamReader, instance);
	}
	
	public static void serialize(SerializationStreamWriter streamWriter, Movie instance)
	    throws SerializationException {
		_Movie_CustomFieldSerializer.serialize(streamWriter, instance);
	}

}