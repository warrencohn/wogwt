// DO NOT EDIT.  Make changes to RootEntityClient.java instead.
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
public abstract class _RootEntityClient implements IsSerializable, WOGWTClientEO {
	
	private BigDecimal aBigDecimal;
	private Boolean aBoolean;
	private NSTimestamp aDate;
	private Integer anInt;
	private String aString;
	private your.app.gwt.eo.ToOneEntityClient toOneEntityObject;
	private List<your.app.gwt.eo.ToManyEntityClient> toManyEntityObjects;
	private boolean isFault = false;

	public _RootEntityClient() {
		super();
	}
	
	public _RootEntityClient(Map<String, ?> map) {
		super();
		takeValuesFromMap( map );
	}
	
	public static String[] keys() {
		List keys = new ArrayList();
		keys.add("aBigDecimal");
		keys.add("aBoolean");
		keys.add("aDate");
		keys.add("anInt");
		keys.add("aString");
		keys.add("toOneEntityObject");
		keys.add("toManyEntityObjects");
    	return (String[])keys.toArray( new String[keys.size()] );
	}

	public Map<String, ?> toMap() {
		Map map = new HashMap();
		map.put("aBigDecimal", aBigDecimal);
		map.put("aBoolean", aBoolean);
		map.put("aDate", aDate);
		map.put("anInt", anInt);
		map.put("aString", aString);
		map.put("toOneEntityObject", toOneEntityObject);
		map.put("toManyEntityObjects", toManyEntityObjects);
		return map;
	}

	public void takeValuesFromMap(Map<String, ?> map) {
		aBigDecimal = (BigDecimal)map.get("aBigDecimal");
		aBoolean = (Boolean)map.get("aBoolean");
		aDate = (NSTimestamp)map.get("aDate");
		anInt = (Integer)map.get("anInt");
		aString = (String)map.get("aString");
		toOneEntityObject = (your.app.gwt.eo.ToOneEntityClient)map.get("toOneEntityObject");
		toManyEntityObjects = (List)map.get("toManyEntityObjects");
		if (map.get( "primaryKeyValue" ) != null)
			primaryKeyValue = (Integer)map.get( "primaryKeyValue" );
	}
	
	public String entityName() {
		return "RootEntity";
	}
	
	// Attributes
	public BigDecimal aBigDecimal() {
		if (isFault()) {
			System.out.println("I'm a fault!!!");
		}
		return aBigDecimal;
	}
	
	public void setABigDecimal(BigDecimal aBigDecimal) {
		this.aBigDecimal = aBigDecimal;
	}

	public Boolean aBoolean() {
		if (isFault()) {
			System.out.println("I'm a fault!!!");
		}
		return aBoolean;
	}
	
	public void setABoolean(Boolean aBoolean) {
		this.aBoolean = aBoolean;
	}

	public NSTimestamp aDate() {
		if (isFault()) {
			System.out.println("I'm a fault!!!");
		}
		return aDate;
	}
	
	public void setADate(NSTimestamp aDate) {
		this.aDate = aDate;
	}

	public Integer anInt() {
		if (isFault()) {
			System.out.println("I'm a fault!!!");
		}
		return anInt;
	}
	
	public void setAnInt(Integer anInt) {
		this.anInt = anInt;
	}

	public String aString() {
		if (isFault()) {
			System.out.println("I'm a fault!!!");
		}
		return aString;
	}
	
	public void setAString(String aString) {
		this.aString = aString;
	}

	private Integer primaryKeyValue;

	public Integer primaryKeyValue() {
		return primaryKeyValue;
	}
	
	public void setPrimaryKeyValue(Integer primaryKeyValue) {
		this.primaryKeyValue = primaryKeyValue;
	}
	
	public boolean isFault() {
		return isFault;
	}
	
	public void setIsFault(boolean value) {
		this.isFault = value;
	}

	// To One Relationships
	public your.app.gwt.eo.ToOneEntityClient toOneEntityObject() {
		return toOneEntityObject;
	}
	
	public void setToOneEntityObject(your.app.gwt.eo.ToOneEntityClient toOneEntityObject) {
		this.toOneEntityObject =  toOneEntityObject;
	}
	
	//To Many Relationships
	public List<your.app.gwt.eo.ToManyEntityClient> toManyEntityObjects() {
		return toManyEntityObjects;
	}
	
	public void setToManyEntityObjects(List<your.app.gwt.eo.ToManyEntityClient> toManyEntityObjects) {
		this.toManyEntityObjects = toManyEntityObjects;
	}
	
}
