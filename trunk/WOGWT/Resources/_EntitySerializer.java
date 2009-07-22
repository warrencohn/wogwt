// DO NOT EDIT.  Make changes to ${entity.classNameWithoutPackage}.java instead.
package $entity.packageName;

import java.util.*;
import java.math.BigDecimal;

import com.google.gwt.core.client.GWT;
import com.google.gwt.gen2.logging.shared.Log;
import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.core.com.webobjects.foundation.NSDictionary_CustomFieldSerializer;
import com.google.gwt.user.client.rpc.core.java.util.Map_CustomFieldSerializerBase;
import com.webobjects.eocontrol.EOEditingContext;
import com.webobjects.eocontrol.EOGlobalID;
import com.webobjects.foundation.*;

import er.extensions.appserver.ERXWOContext;

public class ${entity.prefixClassNameWithoutPackage} {

	public static void deserialize(SerializationStreamReader streamReader, ${entity.name} instance)
        throws SerializationException {
		
    }

	public static void readFields(SerializationStreamReader streamReader, ${entity.name} instance) 
	throws SerializationException {
#foreach ($attribute in $entity.sortedClientClassAttributes)
    	instance.set${attribute.capitalizedName}((${attribute.javaClassName})streamReader.readObject());
#end
#foreach ($relationship in $entity.sortedClientClassToOneRelationships)
    	instance.set${relationship.capitalizedName}Relationship((${relationship.actualDestination.entity.name})streamReader.readObject());
#end
#foreach ($relationship in $entity.sortedClientClassToManyRelationships)
		// TODO: bad
    	instance.set${relationship.capitalizedName}((NSArray<$relationship.actualDestination.entity.name>)streamReader.readObject());
#end
	}
	
	public static ${entity.name} serverInstantiate(SerializationStreamReader streamReader)
	throws SerializationException {

		EOGlobalID id = (EOGlobalID)streamReader.readObject();
    	Boolean isFault = (Boolean)streamReader.readObject();
    	
		EOEditingContext sessionEC = ERXWOContext.currentContext().session().defaultEditingContext();
		${entity.name} instance = (${entity.name})sessionEC.objectForGlobalID(id);

		if (instance == null) {
			EOEditingContext requestEC = (EOEditingContext) ERXWOContext.contextDictionary().valueForKey("editingContext");
			instance = ($entity.name)requestEC.faultForGlobalID(id, requestEC);
		}
		
		if (instance == null) {
			instance = new ${entity.name}();
			sessionEC.insertObject(instance);
		}

		readFields(streamReader, instance);
		return (${entity.name}) instance;	
	}
	
	public static ${entity.name} clientInstantiate(SerializationStreamReader streamReader)
	throws SerializationException {

		${entity.name} instance = new ${entity.name}();
		
    	instance.__setGlobalID((EOGlobalID)streamReader.readObject());
    	instance.takeValueForKey((Boolean)streamReader.readObject(), "__isFault");
    	
    	readFields(streamReader, instance);
    	return instance;
	}
	
	public static ${entity.name} instantiate(SerializationStreamReader streamReader)
	throws SerializationException {
		try {
			if (GWT.isClient()) {
				return clientInstantiate(streamReader);
			} else {
				return serverInstantiate(streamReader);
			}
		} catch (SerializationException e) {
			Log.severe(e.getMessage(), Log.CATEGORY, e);
			throw e;
		}
	}
	  
    public static void serialize(SerializationStreamWriter streamWriter, ${entity.name} instance)
        throws SerializationException {
    	
    	streamWriter.writeObject(instance.__globalID());
    	streamWriter.writeObject(instance.isFault());
    	
#foreach ($attribute in $entity.sortedClientClassAttributes)
    	streamWriter.writeObject(instance.${attribute.name}());
#end
#foreach ($relationship in $entity.sortedClientClassToOneRelationships)
    	streamWriter.writeObject(instance.${relationship.name}());
#end
#foreach ($relationship in $entity.sortedClientClassToManyRelationships)
    	streamWriter.writeObject(instance.${relationship.name}());
#end
    
    	//Map<String, Object> snapshot = WOGWTClientUtil.serializableSnapshot(instance).hashMap();
    	//streamWriter.writeObject(snapshot);
    }
    
}