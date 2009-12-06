package wogwt.translatable.rpc;

import java.io.Serializable;

import com.google.gwt.user.client.rpc.IsSerializable;
import com.webobjects.eocontrol.EOGlobalID;
import com.webobjects.foundation.NSArray;
import com.webobjects.foundation.NSDictionary;
import com.webobjects.foundation.NSKeyValueCoding;
import com.webobjects.foundation.NSKeyValueCodingAdditions;

/**
 * The primary interface for DTOs that can be transferred to the client.
 * This stands in place of EOEnterpriseObject on the client.  Besides 
 * just making EO data available on the client, the methods here are meant 
 * to make it easy to match these objects up with real EOs when necessary,
 * like when saving objects from the client back to the server.
 */
public interface WOGWTClientEO extends NSKeyValueCoding, NSKeyValueCodingAdditions, IsSerializable, Serializable {

	public EOGlobalID __globalID();
	
	public boolean isFault();
	
	public NSArray<String> allPropertyKeys();
	
	public NSArray<String> attributeKeys();
	
	//public NSDictionary changesFromSnapshot(NSDictionary<String, Object> snapshot);
	
	public int deleteRuleForRelationshipKey(String relationshipKey);
	
	public String entityName();
	
	//public String eoDescription();
	
	//public String eoShallowDescription();
	
	public String inverseForRelationshipKey(String relationshipKey);
	
	//public boolean isFault();
	
	public boolean isReadOnly();
	
	public boolean isToManyKey(String key);
	
	public boolean ownsDestinationObjectsForRelationshipKey(String relationshipKey);
	
	public NSDictionary<String, Object> snapshot();
	
	public NSArray<String> toManyRelationshipKeys();
	
	public NSArray<String> toOneRelationshipKeys();
	
	public void updateFromSnapshot(NSDictionary<String, Object> snapshot);
		
}
