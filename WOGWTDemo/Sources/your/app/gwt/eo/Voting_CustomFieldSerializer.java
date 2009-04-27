package your.app.gwt.eo;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;

public final class Voting_CustomFieldSerializer extends _Voting_CustomFieldSerializer {

	public static void deserialize(SerializationStreamReader streamReader, Voting instance)
    throws SerializationException {
		_Voting_CustomFieldSerializer.deserialize(streamReader, instance);
	}
	
	public static void serialize(SerializationStreamWriter streamWriter, Voting instance)
	    throws SerializationException {
		_Voting_CustomFieldSerializer.serialize(streamWriter, instance);
	}

}