// DO NOT EDIT.  Make changes to Director_CustomFieldSerializer.java instead.
package your.app.gwt.eo;

import wogwt.translatable.WOGWTClientUtil;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.core.com.webobjects.foundation.NSDictionary_CustomFieldSerializer;
import com.webobjects.foundation.NSDictionary;

public class _Director_CustomFieldSerializer {

	public static void deserialize(SerializationStreamReader streamReader, Director instance)
        throws SerializationException {
    	NSDictionary snapshot = NSDictionary_CustomFieldSerializer.instantiate(streamReader);
    	instance.reapplyChangesFromDictionary(snapshot);
    }

    public static void serialize(SerializationStreamWriter streamWriter, Director instance)
        throws SerializationException {
    	NSDictionary_CustomFieldSerializer.serialize(streamWriter, 
    			WOGWTClientUtil.serializableSnapshot(instance));
    }
    
}