package $entity.packageName;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;

public final class ${entity.classNameWithoutPackage} extends ${entity.prefixClassNameWithoutPackage} {

	public static void deserialize(SerializationStreamReader streamReader, ${entity.name} instance)
    throws SerializationException {
		${entity.prefixClassNameWithoutPackage}.deserialize(streamReader, instance);
	}
	
	public static void serialize(SerializationStreamWriter streamWriter, ${entity.name} instance)
	    throws SerializationException {
		${entity.prefixClassNameWithoutPackage}.serialize(streamWriter, instance);
	}

}