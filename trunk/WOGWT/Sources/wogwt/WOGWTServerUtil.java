package wogwt;

import java.util.List;

import org.w3c.dom.Node;

import wogwt.server.rpc.WOGWTServerEO;
import wogwt.translatable.WOGWTClientUtil;
import wogwt.translatable.rpc.WOGWTClientEO;

import com.webobjects.appserver.WORequest;
import com.webobjects.appserver.WOResponse;
import com.webobjects.eocontrol.EOEnterpriseObject;
import com.webobjects.eocontrol.EOKeyGlobalID;
import com.webobjects.foundation.NSArray;
import com.webobjects.foundation.NSDictionary;
import com.webobjects.foundation.NSLog;
import com.webobjects.foundation.NSMutableArray;
import com.webobjects.foundation.NSMutableDictionary;

import er.extensions.foundation.ERXDictionaryUtilities;

/**
 * Utility functions for the Server ONLY.
 *
 */
public class WOGWTServerUtil {

	/**
	 * Reads the updateContainerID from the url and then strips everything from the 
	 * response except the updateContainer's html
	 * 
	 * @param request
	 * @param response the fully populated response to extract the update container from
	 */
	public static void onlyIncludeUpdateContainerInResponse(WORequest request, WOResponse response) {		
    	String updateContainerID = request.stringFormValueForKey(WOGWTClientUtil.UPDATE_CONTAINER_ID_KEY);
    	if (updateContainerID != null) {
	    	Node updateContainer = XMLUtilsServer.xhtmlElementWithID(response.contentString(), updateContainerID);
	    	if (updateContainer != null) {
	    		String partialResponse = XMLUtilsServer.serializeChildren(updateContainer);
	    		//String partialResponse = XMLUtilsServer.childrenToString(updateContainer); 	
	    		response.setContent(partialResponse);
	    	} else {
	    		NSLog.debug.appendln("update container '" + updateContainerID + "' not present in response");
	    		response.appendHeader(updateContainerID, WOGWTClientUtil.WOGWTMissingUpdateContainer);
	    	}
    	}	
	}
	
	/**
	 * Useful if you aren't using Wonder
	 * @param eo
	 * @return the primary key of the EO
	 */
	public static Object primaryKeyValue(EOEnterpriseObject eo) {
		if (eo.editingContext() != null && !eo.editingContext().globalIDForObject( eo ).isTemporary()) {
			return ((EOKeyGlobalID)eo.editingContext().globalIDForObject( eo )).keyValues()[0];
		} else {
			return null;
		}
	}
	  
	/**
	 * 
	 * @param eo
	 * @return the EO's snapshot dictionary minus any nulls and relationships, but
	 * including the primary key value
	 */
	public static NSDictionary eoToDictionary(EOEnterpriseObject eo) {
		NSMutableDictionary data = eo.snapshot().mutableClone();
		
		data = ERXDictionaryUtilities.removeNullValues(data).mutableClone();
		
		data.removeObjectsForKeys(eo.toOneRelationshipKeys());
		data.removeObjectsForKeys(eo.toManyRelationshipKeys());
		
		if (primaryKeyValue(eo) != null) {
			data.setObjectForKey( primaryKeyValue(eo), "primaryKeyValue" );
		}

		return data;
	}
	
	/**
	 * Converts regular EOs to their Client class versions.
	 * @param serverEOs
	 * @return array of Client EOs
	 */
	public static NSArray toClientEOList(List<? extends WOGWTServerEO> serverEOs) {
		return toClientEOList(serverEOs, null);
	}
	
	/**
	 * Converts regular EOs to their Client class versions.
	 * @param serverEOs
	 * @return array of Client EOs
	 */
	public static NSArray toClientEOList(List<? extends WOGWTServerEO> serverEOs, List<String> relationshipsToSerialize) {
		NSMutableArray result = new NSMutableArray(serverEOs.size());	  

		for (int i = 0; i < serverEOs.size(); i++) {
			WOGWTServerEO eo = serverEOs.get(i);
			if (relationshipsToSerialize == null)
				result.add( eo.toClientEO() );
			else
				result.add( eo.toClientEO(relationshipsToSerialize) );
		}
		
		return result.immutableClone();
	}
	
	/**
	 * 
	 * @param rootEO
	 * @param relationshipsToSerialize
	 * @return a dictionary with a key for each relationship the client EO as the value
	 */
	public static NSDictionary<String, ? extends WOGWTClientEO> relationshipsToClientEOs(EOEnterpriseObject rootEO, List<String> relationshipsToSerialize) {
		NSMutableDictionary result = new NSMutableDictionary();
		for (int i = 0; i < relationshipsToSerialize.size(); i++) { 
			String keyPath = relationshipsToSerialize.get(i);
			Object value = rootEO.valueForKey(keyPath);

			if (value != null && value instanceof NSArray) { // to-many relationship

				NSArray objects = (NSArray)value;
				NSMutableArray array = new NSMutableArray();
				for (int j = 0; j < objects.count(); j++) {
					WOGWTServerEO eo = (WOGWTServerEO)objects.objectAtIndex(j);
					array.add(eo.toClientEO());
				}
				result.setObjectForKey(array.immutableClone(), keyPath);

			} else if (value != null && value instanceof EOEnterpriseObject) { // to-one relationship
				WOGWTServerEO serverEO = (WOGWTServerEO)value;
				result.setObjectForKey(serverEO.toClientEO(), keyPath);
			}
		}
		return result.immutableClone();
	}
}
