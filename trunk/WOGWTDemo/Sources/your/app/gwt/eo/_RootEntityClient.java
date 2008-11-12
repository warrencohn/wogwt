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
	private your.app.gwt.eo.ToOneEntityClient toOneEntity;
	private List<your.app.gwt.eo.ToManyEntityClient> toManyEntityObjects;

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
		keys.add("toOneEntity");
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
		map.put("toOneEntity", toOneEntity);
		map.put("toManyEntityObjects", toManyEntityObjects);
		return map;
	}

	public void takeValuesFromMap(Map<String, ?> map) {
		aBigDecimal = (BigDecimal)map.get("aBigDecimal");
		aBoolean = (Boolean)map.get("aBoolean");
		aDate = (NSTimestamp)map.get("aDate");
		anInt = (Integer)map.get("anInt");
		aString = (String)map.get("aString");
		toOneEntity = (your.app.gwt.eo.ToOneEntityClient)map.get("toOneEntity");
		toManyEntityObjects = (List)map.get("toManyEntityObjects");
		if (map.get( "primaryKeyValue" ) != null)
			primaryKeyValue = (Integer)map.get( "primaryKeyValue" );
	}
	
	public String entityName() {
		return "RootEntity";
	}
	
	// Attributes
	public BigDecimal aBigDecimal() {
		return aBigDecimal;
	}
	
	public void setABigDecimal(BigDecimal aBigDecimal) {
		this.aBigDecimal = aBigDecimal;
	}

	public Boolean aBoolean() {
		return aBoolean;
	}
	
	public void setABoolean(Boolean aBoolean) {
		this.aBoolean = aBoolean;
	}

	public NSTimestamp aDate() {
		return aDate;
	}
	
	public void setADate(NSTimestamp aDate) {
		this.aDate = aDate;
	}

	public Integer anInt() {
		return anInt;
	}
	
	public void setAnInt(Integer anInt) {
		this.anInt = anInt;
	}

	public String aString() {
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

	// To One Relationships
	public your.app.gwt.eo.ToOneEntityClient toOneEntity() {
		return toOneEntity;
	}
	
	public void setToOneEntity(your.app.gwt.eo.ToOneEntityClient toOneEntity) {
		this.toOneEntity =  toOneEntity;
	}
	
	//To Many Relationships
	public List<your.app.gwt.eo.ToManyEntityClient> toManyEntityObjects() {
		return toManyEntityObjects;
	}
	
	public void setToManyEntityObjects(List<your.app.gwt.eo.ToManyEntityClient> toManyEntityObjects) {
		this.toManyEntityObjects = toManyEntityObjects;
	}
	

	public String toString() {
		return toMap().toString();
	}

}
