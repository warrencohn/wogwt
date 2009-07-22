// DO NOT EDIT.  Make changes to Movie_CustomFieldSerializer.java instead.
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

public class _Movie_CustomFieldSerializer {

	public static void deserialize(SerializationStreamReader streamReader, Movie instance)
        throws SerializationException {
		
    }

	public static void readFields(SerializationStreamReader streamReader, Movie instance) 
	throws SerializationException {
    	instance.setCategory((String)streamReader.readObject());
    	instance.setDateReleased((NSTimestamp)streamReader.readObject());
    	instance.setPosterName((String)streamReader.readObject());
    	instance.setRated((String)streamReader.readObject());
    	instance.setRevenue((java.math.BigDecimal)streamReader.readObject());
    	instance.setTitle((String)streamReader.readObject());
    	instance.setTrailerName((String)streamReader.readObject());
    	instance.setStudioRelationship((Studio)streamReader.readObject());
	}
	
	public static Movie serverInstantiate(SerializationStreamReader streamReader)
	throws SerializationException {

		EOGlobalID id = (EOGlobalID)streamReader.readObject();
    	Boolean isFault = (Boolean)streamReader.readObject();
    	
		EOEditingContext sessionEC = ERXWOContext.currentContext().session().defaultEditingContext();
		Movie instance = (Movie)sessionEC.objectForGlobalID(id);

		if (instance == null) {
			EOEditingContext requestEC = (EOEditingContext) ERXWOContext.contextDictionary().valueForKey("editingContext");
			instance = (Movie)requestEC.faultForGlobalID(id, requestEC);
		}
		
		if (instance == null) {
			instance = new Movie();
			sessionEC.insertObject(instance);
		}

		readFields(streamReader, instance);
		return (Movie) instance;	
	}
	
	public static Movie clientInstantiate(SerializationStreamReader streamReader)
	throws SerializationException {

		Movie instance = new Movie();
		
    	instance.__setGlobalID((EOGlobalID)streamReader.readObject());
    	instance.takeValueForKey((Boolean)streamReader.readObject(), "__isFault");
    	
    	readFields(streamReader, instance);
    	return instance;
	}
	
	public static Movie instantiate(SerializationStreamReader streamReader)
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
	  
    public static void serialize(SerializationStreamWriter streamWriter, Movie instance)
        throws SerializationException {
    	
    	streamWriter.writeObject(instance.__globalID());
    	streamWriter.writeObject(instance.isFault());
    	
    	streamWriter.writeObject(instance.category());
    	streamWriter.writeObject(instance.dateReleased());
    	streamWriter.writeObject(instance.posterName());
    	streamWriter.writeObject(instance.rated());
    	streamWriter.writeObject(instance.revenue());
    	streamWriter.writeObject(instance.title());
    	streamWriter.writeObject(instance.trailerName());
    	streamWriter.writeObject(instance.studio());
    
    	//Map<String, Object> snapshot = WOGWTClientUtil.serializableSnapshot(instance).hashMap();
    	//streamWriter.writeObject(snapshot);
    }
    
}