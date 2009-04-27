package wogwt.translatable.rpc;

import com.webobjects.eocontrol.EOEnterpriseObject;
import com.webobjects.foundation.NSDictionary;

public interface WOGWTSerializableEO extends EOEnterpriseObject {

	public NSDictionary<String, Object> clientSnapshot();
	
}
