package wogwt.translatable.rpc;

import com.webobjects.eocontrol.EOEnterpriseObject;
import com.webobjects.foundation.NSDictionary;

/**
 * Adds a method to EOEnterpriseObject to return a clientSnapshot dictionary
 * that can be used to populate a DTO object to return EO data to the client.
 */
public interface WOGWTSerializableEO extends EOEnterpriseObject {

	public NSDictionary<String, Object> clientSnapshot();
	
}
