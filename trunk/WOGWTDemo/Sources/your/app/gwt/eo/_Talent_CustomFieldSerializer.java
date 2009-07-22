// DO NOT EDIT.  Make changes to Talent_CustomFieldSerializer.java instead.
package your.app.gwt.eo;

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

public class _Talent_CustomFieldSerializer {

	public static void deserialize(SerializationStreamReader streamReader, Talent instance)
        throws SerializationException {
		
    }

	public static void readFields(SerializationStreamReader streamReader, Talent instance) 
	throws SerializationException {
    	instance.setFirstName((String)streamReader.readObject());
    	instance.setLastName((String)streamReader.readObject());
    	instance.setPhotoRelationship((TalentPhoto)streamReader.readObject());
		// TODO: bad
    	instance.setMoviesDirected((NSArray<Movie>)streamReader.readObject());
		// TODO: bad
    	instance.setRoles((NSArray<MovieRole>)streamReader.readObject());
	}
	
	public static Talent serverInstantiate(SerializationStreamReader streamReader)
	throws SerializationException {

		EOGlobalID id = (EOGlobalID)streamReader.readObject();
    	Boolean isFault = (Boolean)streamReader.readObject();
    	
		EOEditingContext sessionEC = ERXWOContext.currentContext().session().defaultEditingContext();
		Talent instance = (Talent)sessionEC.objectForGlobalID(id);

		if (instance == null) {
			EOEditingContext requestEC = (EOEditingContext) ERXWOContext.contextDictionary().valueForKey("editingContext");
			instance = (Talent)requestEC.faultForGlobalID(id, requestEC);
		}
		
		if (instance == null) {
			instance = new Talent();
			sessionEC.insertObject(instance);
		}

		readFields(streamReader, instance);
		return (Talent) instance;	
	}
	
	public static Talent clientInstantiate(SerializationStreamReader streamReader)
	throws SerializationException {

		Talent instance = new Talent();
		
    	instance.__setGlobalID((EOGlobalID)streamReader.readObject());
    	instance.takeValueForKey((Boolean)streamReader.readObject(), "__isFault");
    	
    	readFields(streamReader, instance);
    	return instance;
	}
	
	public static Talent instantiate(SerializationStreamReader streamReader)
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
	  
    public static void serialize(SerializationStreamWriter streamWriter, Talent instance)
        throws SerializationException {
    	
    	streamWriter.writeObject(instance.__globalID());
    	streamWriter.writeObject(instance.isFault());
    	
    	streamWriter.writeObject(instance.firstName());
    	streamWriter.writeObject(instance.lastName());
    	streamWriter.writeObject(instance.photo());
    	streamWriter.writeObject(instance.moviesDirected());
    	streamWriter.writeObject(instance.roles());
    
    	//Map<String, Object> snapshot = WOGWTClientUtil.serializableSnapshot(instance).hashMap();
    	//streamWriter.writeObject(snapshot);
    }
    
}