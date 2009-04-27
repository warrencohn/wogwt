package your.app.gwt.eo;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;

public final class TalentPhoto_CustomFieldSerializer extends _TalentPhoto_CustomFieldSerializer {

	public static void deserialize(SerializationStreamReader streamReader, TalentPhoto instance)
    throws SerializationException {
		_TalentPhoto_CustomFieldSerializer.deserialize(streamReader, instance);
	}
	
	public static void serialize(SerializationStreamWriter streamWriter, TalentPhoto instance)
	    throws SerializationException {
		_TalentPhoto_CustomFieldSerializer.serialize(streamWriter, instance);
	}

}