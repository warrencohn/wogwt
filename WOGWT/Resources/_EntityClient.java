// DO NOT EDIT.  Make changes to ${entity.classNameWithoutPackage}.java instead.
package $entity.packageName;
// this must be in the client package

import java.util.*;
import java.math.BigDecimal;

import com.google.gwt.user.client.rpc.IsSerializable;
import com.webobjects.foundation.NSArray;
import com.webobjects.foundation.NSMutableArray;
import com.webobjects.foundation.NSDictionary;
import com.webobjects.foundation.NSMutableDictionary;
import com.webobjects.foundation.NSKeyValueCoding;
import com.webobjects.foundation.NSKeyValueCodingAdditions;
import com.webobjects.foundation.NSTimestamp;

import wogwt.translatable.rpc.WOGWTClientEO;

// This class can be serialized from server to client and back
public abstract class ${entity.prefixClassNameWithoutPackage} implements IsSerializable, WOGWTClientEO, NSKeyValueCoding, NSKeyValueCodingAdditions {
	
	// Attributes
#foreach ($attribute in $entity.sortedClientClassAttributes)
	public static final String ${attribute.uppercaseUnderscoreName}_KEY = "$attribute.name";
#end

	// Relationships
#foreach ($relationship in $entity.sortedClientClassRelationships)
	public static final String ${relationship.uppercaseUnderscoreName}_KEY = "$relationship.name";
#end
	
#foreach ($attribute in $entity.sortedClientClassAttributes)
	private $attribute.javaClassName ${attribute.name};
#end
#foreach ($relationship in $entity.sortedClientClassToOneRelationships)
	private $relationship.destination.classNameWithDefault ${relationship.name};
#end
#foreach ($relationship in $entity.sortedClientClassToManyRelationships)
	private NSArray<$relationship.destination.clientClassName> ${relationship.name};
#end

	public ${entity.prefixClassNameWithoutPackage}() {
		super();
	}
	
	public ${entity.prefixClassNameWithoutPackage}(Map<String, ?> map) {
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
#foreach ($attribute in $entity.sortedClientClassAttributes)
			"${attribute.name}"#if ($velocityCount < $entity.sortedClientClassAttributes.size()),#end
			
#end	
		});
		return keys;
	}
	
	public static NSArray<String> toOneRelationshipKeys() {
		NSArray<String> keys = new NSArray<String>( new String[] {	
#foreach ($relationship in $entity.sortedClientClassToOneRelationships)
			"${relationship.name}"#if ($velocityCount < $entity.sortedClientClassToOneRelationships.size()),#end
			
#end	
		});
		return keys;
	}
	
	public static NSArray<String> toManyRelationshipKeys() {
		NSArray<String> keys = new NSArray<String>( new String[] {
#foreach ($relationship in $entity.sortedClientClassToManyRelationships)
			"${relationship.name}"#if ($velocityCount < $entity.sortedClassAttributes.size()),#end

#end
		});
    	return keys;
	}
	
	public Map<String, ?> toMap() {
		Map map = new HashMap();
#foreach ($attribute in $entity.sortedClientClassAttributes)
		map.put("${attribute.name}", ${attribute.name});
#end
#foreach ($relationship in $entity.sortedClientClassToOneRelationships)
		map.put("${relationship.name}", ${relationship.name});
#end
#foreach ($relationship in $entity.sortedClientClassToManyRelationships)
		map.put("${relationship.name}", ${relationship.name});
#end
		return map;
	}

	public void takeValuesFromMap(Map<String, ?> map) {
#foreach ($attribute in $entity.sortedClientClassAttributes)
		${attribute.name} = ($attribute.javaClassName)map.get("${attribute.name}");
#end		
#foreach ($relationship in $entity.sortedClientClassToOneRelationships)
		${relationship.name} = ($relationship.destination.classNameWithDefault)map.get("${relationship.name}");
#end
#foreach ($relationship in $entity.sortedClientClassToManyRelationships)
		${relationship.name} = (NSArray)map.get("${relationship.name}");
#end
		if (map.get( "primaryKeyValue" ) != null)
			primaryKeyValue = (Integer)map.get( "primaryKeyValue" );
	}
	
	public Object valueForKey(String key) {
		if ("primaryKeyValue".equals(key))
			return primaryKeyValue();
		else if ("entityName".equals(key))
			return entityName();
#foreach ($attribute in $entity.sortedClientClassAttributes)
		else if ("${attribute.name}".equals(key))
			return ${attribute.name}();
#end		
#foreach ($relationship in $entity.sortedClientClassToOneRelationships)
		else if ("${relationship.name}".equals(key))
			return ${relationship.name}();
#end
#foreach ($relationship in $entity.sortedClientClassToManyRelationships)
		else if ("${relationship.name}".equals(key))
			return ${relationship.name}();
#end
		else
			throw new RuntimeException(getClass().getName() + " does not has a key named '" + key + "'");
	}
	
	public void takeValueForKey(Object value, String key) {
		if ("primaryKeyValue".equals(key))
			setPrimaryKeyValue((Integer)value);
#foreach ($attribute in $entity.sortedClientClassAttributes)
		else if ("${attribute.name}".equals(key))
			set${attribute.capitalizedName}(($attribute.javaClassName)value);
#end		
#foreach ($relationship in $entity.sortedClientClassToOneRelationships)
		else if ("${relationship.name}".equals(key))
			set${relationship.capitalizedName}(($relationship.destination.classNameWithDefault)value);
#end
#foreach ($relationship in $entity.sortedClientClassToManyRelationships)
		else if ("${relationship.name}".equals(key))
			set${relationship.capitalizedName}((NSArray)value);
#end
		else
			throw new RuntimeException(getClass().getName() + " does not has a key named '" + key + "'");
	}
	
	public Object valueForKeyPath(String keyPath) {
		return NSKeyValueCodingAdditions.DefaultImplementation.valueForKeyPath(this, keyPath);
	}
	
	public void takeValueForKeyPath(Object value, String keyPath) {
		NSKeyValueCodingAdditions.DefaultImplementation.takeValueForKeyPath(this, value, keyPath);
	}
	
	public String entityName() {
		return "$entity.name";
	}
	
	// Attributes
#foreach ($attribute in $entity.sortedClientClassAttributes)
	public $attribute.javaClassName ${attribute.name}() {
		return ${attribute.name};
	}
	
	public void set${attribute.capitalizedName}($attribute.javaClassName ${attribute.name}) {
		this.${attribute.name} = ${attribute.name};
	}

#end
	private Integer primaryKeyValue;

	public Integer primaryKeyValue() {
		return primaryKeyValue;
	}
	
	public void setPrimaryKeyValue(Integer primaryKeyValue) {
		this.primaryKeyValue = primaryKeyValue;
	}

	// To One Relationships
#foreach ($relationship in $entity.sortedClientClassToOneRelationships)
	public $relationship.destination.classNameWithDefault ${relationship.name}() {
		return ${relationship.name};
	}
	
	public void set${relationship.capitalizedName}($relationship.destination.classNameWithDefault ${relationship.name}) {
		this.${relationship.name} =  ${relationship.name};
	}
	
#end
	//To Many Relationships
#foreach ($relationship in $entity.sortedClientClassToManyRelationships)
	public NSArray<$relationship.destination.clientClassName> ${relationship.name}() {
		return ${relationship.name};
	}
	
	public void set${relationship.capitalizedName}(NSArray<$relationship.destination.clientClassName> ${relationship.name}) {
		this.${relationship.name} = ${relationship.name};
	}
	
#end

	public String toString() {
		return toMap().toString();
	}

}
