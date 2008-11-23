package wogwt.translatable.rpc;

import java.util.Map;

public interface WOGWTClientEO {

	public String entityName();
	public Integer primaryKeyValue();
	public Map toMap();
		
}
