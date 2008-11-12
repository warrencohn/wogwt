// DO NOT EDIT.  Make changes to ToOneEntityClient.java instead.
package your.app.gwt.eo;
// this must be in the client package

import java.util.*;
import java.math.BigDecimal;

import com.google.gwt.user.client.rpc.IsSerializable;
import com.webobjects.foundation.NSArray;
import com.webobjects.foundation.NSDictionary;
import com.webobjects.foundation.NSTimestamp;

import wogwt.translatable.WOGWTClientEO;

// This class can be serialized from server to client and back
public abstract class _ToOneEntityClient implements IsSerializable, WOGWTClientEO {
	
	private String name;
	private List<your.app.gwt.eo.RootEntityClient> rootEntities;

	public _ToOneEntityClient() {
		super();
	}
	
	public _ToOneEntityClient(Map<String, ?> map) {
		super();
		takeValuesFromMap( map );
	}
	
	public static String[] keys() {
		List keys = new ArrayList();
		keys.add("name");
		keys.add("rootEntities");
    	return (String[])keys.toArray( new String[keys.size()] );
	}

	public Map<String, ?> toMap() {
		Map map = new HashMap();
		map.put("name", name);
		map.put("rootEntities", rootEntities);
		return map;
	}

	public void takeValuesFromMap(Map<String, ?> map) {
		name = (String)map.get("name");
		rootEntities = (List)map.get("rootEntities");
		if (map.get( "primaryKeyValue" ) != null)
			primaryKeyValue = (Integer)map.get( "primaryKeyValue" );
	}
	
	public String entityName() {
		return "ToOneEntity";
	}
	
	// Attributes
	public String name() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	private Integer primaryKeyValue;

	public Integer primaryKeyValue() {
		return primaryKeyValue;
	}
	
	public void setPrimaryKeyValue(Integer primaryKeyValue) {
		this.primaryKeyValue = primaryKeyValue;
	}

	// To One Relationships
	//To Many Relationships
	public List<your.app.gwt.eo.RootEntityClient> rootEntities() {
		return rootEntities;
	}
	
	public void setRootEntities(List<your.app.gwt.eo.RootEntityClient> rootEntities) {
		this.rootEntities = rootEntities;
	}
	

	public String toString() {
		return toMap().toString();
	}

}
