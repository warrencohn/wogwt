// DO NOT EDIT.  Make changes to ToManyEntityClient.java instead.
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
public abstract class _ToManyEntityClient implements IsSerializable, WOGWTClientEO {
	
	private String name;
	private your.app.gwt.eo.RootEntityClient rootEntityObject;

	public _ToManyEntityClient() {
		super();
	}
	
	public _ToManyEntityClient(Map<String, ?> map) {
		super();
		takeValuesFromMap( map );
	}
	
	public static String[] keys() {
		List keys = new ArrayList();
		keys.add("name");
		keys.add("rootEntityObject");
    	return (String[])keys.toArray( new String[keys.size()] );
	}

	public Map<String, ?> toMap() {
		Map map = new HashMap();
		map.put("name", name);
		map.put("rootEntityObject", rootEntityObject);
		return map;
	}

	public void takeValuesFromMap(Map<String, ?> map) {
		name = (String)map.get("name");
		rootEntityObject = (your.app.gwt.eo.RootEntityClient)map.get("rootEntityObject");
		if (map.get( "primaryKeyValue" ) != null)
			primaryKeyValue = (Integer)map.get( "primaryKeyValue" );
	}
	
	public String entityName() {
		return "ToManyEntity";
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
	public your.app.gwt.eo.RootEntityClient rootEntityObject() {
		return rootEntityObject;
	}
	
	public void setRootEntityObject(your.app.gwt.eo.RootEntityClient rootEntityObject) {
		this.rootEntityObject =  rootEntityObject;
	}
	
	//To Many Relationships

	public String toString() {
		return toMap().toString();
	}

}
