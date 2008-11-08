package wogwt.translatable;

import java.util.Map;

public interface WOGWTClientEO {

	public String entityName();
	public Integer primaryKeyValue();
	public Map toMap();
	
	public boolean isFault();
	public void setIsFault(boolean value);
	
}
