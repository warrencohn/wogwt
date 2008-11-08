// DO NOT EDIT.  Make changes to ${entity.classNameWithoutPackage}.java instead.
package $entity.packageName;
// this must be in the client package

import java.util.*;
import java.math.BigDecimal;

import com.google.gwt.user.client.rpc.IsSerializable;
import com.webobjects.foundation.NSArray;
import com.webobjects.foundation.NSDictionary;
import com.webobjects.foundation.NSTimestamp;

import wogwt.translatable.WOGWTClientEO;

// This class can be serialized from server to client and back
public abstract class ${entity.prefixClassNameWithoutPackage} implements IsSerializable, WOGWTClientEO {
	
#foreach ($attribute in $entity.sortedClassAttributes)
	private $attribute.javaClassName ${attribute.name};
#end
#foreach ($relationship in $entity.sortedClassToOneRelationships)
	private $relationship.destination.classNameWithDefault ${relationship.name};
#end
#foreach ($relationship in $entity.sortedClassToManyRelationships)
	private List<$relationship.destination.clientClassName> ${relationship.name};
#end
	private boolean isFault = false;

	public ${entity.prefixClassNameWithoutPackage}() {
		super();
	}
	
	public ${entity.prefixClassNameWithoutPackage}(Map<String, ?> map) {
		super();
		takeValuesFromMap( map );
	}
	
	public static String[] keys() {
		List keys = new ArrayList();
#foreach ($attribute in $entity.sortedClassAttributes)
		keys.add("${attribute.name}");
#end	
#foreach ($relationship in $entity.sortedClassToOneRelationships)
		keys.add("${relationship.name}");
#end
#foreach ($relationship in $entity.sortedClassToManyRelationships)
		keys.add("${relationship.name}");
#end
    	return (String[])keys.toArray( new String[keys.size()] );
	}

	public Map<String, ?> toMap() {
		Map map = new HashMap();
#foreach ($attribute in $entity.sortedClassAttributes)
		map.put("${attribute.name}", ${attribute.name});
#end
#foreach ($relationship in $entity.sortedClassToOneRelationships)
		map.put("${relationship.name}", ${relationship.name});
#end
#foreach ($relationship in $entity.sortedClassToManyRelationships)
		map.put("${relationship.name}", ${relationship.name});
#end
		return map;
	}

	public void takeValuesFromMap(Map<String, ?> map) {
#foreach ($attribute in $entity.sortedClassAttributes)
		${attribute.name} = ($attribute.javaClassName)map.get("${attribute.name}");
#end		
#foreach ($relationship in $entity.sortedClassToOneRelationships)
		${relationship.name} = ($relationship.destination.classNameWithDefault)map.get("${relationship.name}");
#end
#foreach ($relationship in $entity.sortedClassToManyRelationships)
		${relationship.name} = (List)map.get("${relationship.name}");
#end
		if (map.get( "primaryKeyValue" ) != null)
			primaryKeyValue = (Integer)map.get( "primaryKeyValue" );
	}
	
	public String entityName() {
		return "$entity.name";
	}
	
	// Attributes
#foreach ($attribute in $entity.sortedClassAttributes)
	public $attribute.javaClassName ${attribute.name}() {
		if (isFault()) {
			System.out.println("I'm a fault!!!");
		}
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
	
	public boolean isFault() {
		return isFault;
	}
	
	public void setIsFault(boolean value) {
		this.isFault = value;
	}

	// To One Relationships
#foreach ($relationship in $entity.sortedClassToOneRelationships)
	public $relationship.destination.classNameWithDefault ${relationship.name}() {
		return ${relationship.name};
	}
	
	public void set${relationship.capitalizedName}($relationship.destination.classNameWithDefault ${relationship.name}) {
		this.${relationship.name} =  ${relationship.name};
	}
	
#end
	//To Many Relationships
#foreach ($relationship in $entity.sortedClassToManyRelationships)
	public List<$relationship.destination.clientClassName> ${relationship.name}() {
		return ${relationship.name};
	}
	
	public void set${relationship.capitalizedName}(List<$relationship.destination.clientClassName> ${relationship.name}) {
		this.${relationship.name} = ${relationship.name};
	}
	
#end
}
