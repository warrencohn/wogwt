// DO NOT EDIT.  Make changes to RootEntityClient.java instead.
package your.app.gwt.eo;
// this must be in the client package

import java.util.*;
import java.math.BigDecimal;

import com.google.gwt.user.client.rpc.IsSerializable;
import com.webobjects.foundation.NSArray;
import com.webobjects.foundation.NSMutableArray;
import com.webobjects.foundation.NSDictionary;
import com.webobjects.foundation.NSMutableDictionary;
import com.webobjects.foundation.NSKeyValueCoding;
import com.webobjects.foundation.NSTimestamp;

import wogwt.translatable.rpc.WOGWTClientEO;

// This class can be serialized from server to client and back
public abstract class _RootEntityClient implements IsSerializable, WOGWTClientEO, NSKeyValueCoding {
	
	// Attributes
	public static final String A_BIG_DECIMAL_KEY = "aBigDecimal";
	public static final String A_BOOLEAN_KEY = "aBoolean";
	public static final String A_DATE_KEY = "aDate";
	public static final String AN_INT_KEY = "anInt";
	public static final String A_STRING_KEY = "aString";

	// Relationships
	public static final String TO_MANY_ENTITIES_KEY = "toManyEntities";
	public static final String TO_ONE_ENTITY_KEY = "toOneEntity";
	
	private BigDecimal aBigDecimal;
	private Boolean aBoolean;
	private NSTimestamp aDate;
	private Integer anInt;
	private String aString;
	private your.app.gwt.eo.ToOneEntityClient toOneEntity;
	private List<your.app.gwt.eo.ToManyEntityClient> toManyEntities;

	public _RootEntityClient() {
		super();
	}
	
	public _RootEntityClient(Map<String, ?> map) {
		super();
		takeValuesFromMap( map );
	}
	
	public static NSArray<String> keys() {
		List<String> keys = new ArrayList();
		keys.addAll(attributeKeys());
		keys.addAll(toOneRelationshipKeys());
		keys.addAll(toManyRelationshipKeys());
    	return new NSArray(keys);
	}

	public static NSArray<String> attributeKeys() {
		NSArray<String> keys = new NSArray<String>( new String[] {
			"aBigDecimal",			
			"aBoolean",			
			"aDate",			
			"anInt",			
			"aString"			
		});
		return keys;
	}
	
	public static NSArray<String> toOneRelationshipKeys() {
		NSArray<String> keys = new NSArray<String>( new String[] {	
			"toOneEntity",			
		});
		return keys;
	}
	
	public static NSArray<String> toManyRelationshipKeys() {
		NSArray<String> keys = new NSArray<String>( new String[] {
			"toManyEntities",
		});
    	return keys;
	}
	
	public Map<String, ?> toMap() {
		Map map = new HashMap();
		map.put("aBigDecimal", aBigDecimal);
		map.put("aBoolean", aBoolean);
		map.put("aDate", aDate);
		map.put("anInt", anInt);
		map.put("aString", aString);
		map.put("toOneEntity", toOneEntity);
		map.put("toManyEntities", toManyEntities);
		return map;
	}

	public void takeValuesFromMap(Map<String, ?> map) {
		aBigDecimal = (BigDecimal)map.get("aBigDecimal");
		aBoolean = (Boolean)map.get("aBoolean");
		aDate = (NSTimestamp)map.get("aDate");
		anInt = (Integer)map.get("anInt");
		aString = (String)map.get("aString");
		toOneEntity = (your.app.gwt.eo.ToOneEntityClient)map.get("toOneEntity");
		toManyEntities = (List)map.get("toManyEntities");
		if (map.get( "primaryKeyValue" ) != null)
			primaryKeyValue = (Integer)map.get( "primaryKeyValue" );
	}
	
	public Object valueForKey(String key) {
		if ("primaryKeyValue".equals(key))
			return primaryKeyValue();
		else if ("entityName".equals(key))
			return entityName();
		else if ("aBigDecimal".equals(key))
			return aBigDecimal();
		else if ("aBoolean".equals(key))
			return aBoolean();
		else if ("aDate".equals(key))
			return aDate();
		else if ("anInt".equals(key))
			return anInt();
		else if ("aString".equals(key))
			return aString();
		else if ("toOneEntity".equals(key))
			return toOneEntity();
		else if ("toManyEntities".equals(key))
			return toManyEntities();
		else
			throw new RuntimeException(getClass().getName() + " does not has a key named '" + key + "'");
	}
	
	public void takeValueForKey(Object value, String key) {
		if ("primaryKeyValue".equals(key))
			setPrimaryKeyValue((Integer)value);
		else if ("aBigDecimal".equals(key))
			setABigDecimal((BigDecimal)value);
		else if ("aBoolean".equals(key))
			setABoolean((Boolean)value);
		else if ("aDate".equals(key))
			setADate((NSTimestamp)value);
		else if ("anInt".equals(key))
			setAnInt((Integer)value);
		else if ("aString".equals(key))
			setAString((String)value);
		else if ("toOneEntity".equals(key))
			setToOneEntity((your.app.gwt.eo.ToOneEntityClient)value);
		else if ("toManyEntities".equals(key))
			setToManyEntities((List)value);
		else
			throw new RuntimeException(getClass().getName() + " does not has a key named '" + key + "'");
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
	public List<your.app.gwt.eo.ToManyEntityClient> toManyEntities() {
		return toManyEntities;
	}
	
	public void setToManyEntities(List<your.app.gwt.eo.ToManyEntityClient> toManyEntities) {
		this.toManyEntities = toManyEntities;
	}
	

	public String toString() {
		return toMap().toString();
	}

}
