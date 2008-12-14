package wogwt.translatable.rpc;

import java.util.Map;

import com.webobjects.foundation.NSKeyValueCoding;

/**
 * The primary interface for EOs that can be transferred to the client.
 * This stands in for EOEnterpriseObject.  Besides just making EOs
 * available on the client, the methods here are meant to make it easy 
 * to match these objects up with real EOs when necessary.
 *
 */
public interface WOGWTClientEO extends NSKeyValueCoding {

	public String entityName();
	public Integer primaryKeyValue();
	public Map toMap();
		
}
