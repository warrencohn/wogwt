// DO NOT EDIT.  Make changes to ${entity.classNameWithoutPackage}.java instead.
package $entity.packageName;

import wogwt.translatable.WOGWTClientUtil;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.core.com.webobjects.foundation.NSDictionary_CustomFieldSerializer;
import com.webobjects.foundation.NSDictionary;

public class ${entity.prefixClassNameWithoutPackage} {

	public static void deserialize(SerializationStreamReader streamReader, ${entity.name} instance)
        throws SerializationException {
    	NSDictionary snapshot = NSDictionary_CustomFieldSerializer.instantiate(streamReader);
    	instance.reapplyChangesFromDictionary(snapshot);
    }

    public static void serialize(SerializationStreamWriter streamWriter, ${entity.name} instance)
        throws SerializationException {
    	NSDictionary_CustomFieldSerializer.serialize(streamWriter, 
    			WOGWTClientUtil.serializableSnapshot(instance));
    }
    
}