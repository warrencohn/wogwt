package your.app.gwt.eo;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;

public final class Talent_CustomFieldSerializer extends _Talent_CustomFieldSerializer {

	public static void deserialize(SerializationStreamReader streamReader, Talent instance)
    throws SerializationException {
		_Talent_CustomFieldSerializer.deserialize(streamReader, instance);
	}
	
	public static void serialize(SerializationStreamWriter streamWriter, Talent instance)
	    throws SerializationException {
		_Talent_CustomFieldSerializer.serialize(streamWriter, instance);
	}

}