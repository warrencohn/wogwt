// DO NOT EDIT.  Make changes to ${entity.classNameWithoutPackage}.java instead.
package $entity.packageName;
// this must be in the client package

import java.util.*;
import java.math.BigDecimal;

import com.webobjects.eocontrol.EOGlobalID;
import com.webobjects.foundation.NSArray;
import com.webobjects.foundation.NSDictionary;
import com.webobjects.foundation.NSMutableDictionary;
import com.webobjects.foundation.NSKeyValueCoding;
import com.webobjects.foundation.NSKeyValueCodingAdditions;
import com.webobjects.foundation.NSTimestamp;

import wogwt.translatable.rpc.WOGWTClientEOImpl;

// This class can be serialized from server to client and back
public abstract class ${entity.prefixClassNameWithoutPackage} extends WOGWTClientEOImpl {
	
	public static final transient String ENTITY_NAME = "$entity.name";
	
	// KEYS
#foreach ($attribute in $entity.sortedClientClassAttributes)
	public static final String ${attribute.uppercaseUnderscoreName}_KEY = "$attribute.name";
#end
#foreach ($relationship in $entity.sortedClientClassRelationships)
	public static final String ${relationship.uppercaseUnderscoreName}_KEY = "$relationship.name";
#end
	
	// VARIABLES
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
#foreach ($relationship in $entity.sortedClientClassToManyRelationships)
		${relationship.name} = NSArray.EmptyArray;
#end
	}
	
	public ${entity.prefixClassNameWithoutPackage}(NSDictionary<String, Object> snapshot) {
		super(snapshot);
#foreach ($relationship in $entity.sortedClientClassToManyRelationships)
		if (${relationship.name} == null)
			${relationship.name} = NSArray.EmptyArray;
#end
	}

	public NSArray<String> attributeKeys() {
		NSArray<String> keys = new NSArray<String>( new String[] {
#foreach ($attribute in $entity.sortedClientClassAttributes)
			"${attribute.name}"#if ($velocityCount < $entity.sortedClientClassAttributes.size()),#end
			
#end	
		});
		return keys;
	}
	
	public NSArray<String> toOneRelationshipKeys() {
		NSArray<String> keys = new NSArray<String>( new String[] {	
#foreach ($relationship in $entity.sortedClientClassToOneRelationships)
			"${relationship.name}"#if ($velocityCount < $entity.sortedClientClassToOneRelationships.size()),#end
			
#end	
		});
		return keys;
	}
	
	public NSArray<String> toManyRelationshipKeys() {
		NSArray<String> keys = new NSArray<String>( new String[] {
#foreach ($relationship in $entity.sortedClientClassToManyRelationships)
			"${relationship.name}"#if ($velocityCount < $entity.sortedClassAttributes.size()),#end

#end
		});
    	return keys;
	}

	public int deleteRuleForRelationshipKey(String relationshipKey) {
#foreach ($relationship in $entity.sortedClientClassRelationships)
		if ("${relationship.name}".equals(relationshipKey))
			return deleteRuleNumber("$relationship.deleteRule.ID");
#end
		return -1;
	}
	
	public String inverseForRelationshipKey(String relationshipKey) {
#foreach ($relationship in $entity.sortedClientClassRelationships)
#if (${relationship.inverseRelationship.name} && ${relationship.inverseRelationship.clientClassProperty})
		if ("${relationship.name}".equals(relationshipKey))
			return "${relationship.inverseRelationship.name}";
#end
#end
		return null;
	}
	
	public boolean isReadOnly() {
#if (${entity.isReadOnly()})
		return true;
#else
		return false;
#end
	}
	
	public boolean ownsDestinationObjectsForRelationshipKey(String relationshipKey) {
#foreach ($relationship in $entity.sortedClientClassRelationships)
#if (${relationship.ownsDestination})
		if ("${relationship.name}".equals(relationshipKey))
			return $relationship.ownsDestination;
#end
#end
		return false;
	}
	
	public NSDictionary<String, Object> snapshot() {
		NSMutableDictionary<String, Object> map = new NSMutableDictionary<String, Object>();
		map.put("__globalID", __globalID() == null ? NSKeyValueCoding.NullValue : __globalID());
		map.put("isFault", isFault());
#foreach ($attribute in $entity.sortedClientClassAttributes)
		map.put("${attribute.name}", ${attribute.name} == null ? NSKeyValueCoding.NullValue : ${attribute.name});
#end
#foreach ($relationship in $entity.sortedClientClassToOneRelationships)
		map.put("${relationship.name}", ${relationship.name} == null ? NSKeyValueCoding.NullValue : ${relationship.name});
#end
#foreach ($relationship in $entity.sortedClientClassToManyRelationships)
		map.put("${relationship.name}", ((NSArray)${relationship.name}).mutableClone());
#end
		return map;
	}

	public Object valueForKey(String key) {
#foreach ($attribute in $entity.sortedClientClassAttributes)
		if ("${attribute.name}".equals(key)) {
			return ${attribute.name}();
		}
#end		
#foreach ($relationship in $entity.sortedClientClassToOneRelationships)
		if ("${relationship.name}".equals(key)) {
			return ${relationship.name}();
		}
#end
#foreach ($relationship in $entity.sortedClientClassToManyRelationships)
		if ("${relationship.name}".equals(key)) {
			return ${relationship.name}();
		}
#end
		if ("__globalID".equals(key)) {
			return __globalID();
		}
		if ("isFault".equals(key)) {
			return isFault();
		}
		return handleQueryWithUnboundKey(key);
	}
	
	public void takeValueForKey(Object value, String key) {
#foreach ($attribute in $entity.sortedClientClassAttributes)
		if ("${attribute.name}".equals(key)) {
			set${attribute.capitalizedName}(($attribute.javaClassName)value);
			return;
		}
#end		
#foreach ($relationship in $entity.sortedClientClassToOneRelationships)
		if ("${relationship.name}".equals(key)) {
			set${relationship.capitalizedName}(($relationship.destination.classNameWithDefault)value);
			return;
		}
#end
#foreach ($relationship in $entity.sortedClientClassToManyRelationships)
		if ("${relationship.name}".equals(key)) {
			set${relationship.capitalizedName}((NSArray)value);
			return;
		}
#end
		if ("__globalID".equals(key)) {
			setGlobalID((EOGlobalID)value);
			return;
		}
		if ("isFault".equals(key)) {
			setIsFault((Boolean)value);
			return;
		}
		handleTakeValueForUnboundKey(value, key);
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
	// To One Relationships
#foreach ($relationship in $entity.sortedClientClassToOneRelationships)
	public $relationship.destination.classNameWithDefault ${relationship.name}() {
		return ${relationship.name};
	}
	
	public void set${relationship.capitalizedName}($relationship.destination.classNameWithDefault ${relationship.name}) {
		this.${relationship.name} =  ${relationship.name};
	}
	
#end
	// To Many Relationships
#foreach ($relationship in $entity.sortedClientClassToManyRelationships)
	public NSArray<$relationship.destination.clientClassName> ${relationship.name}() {
		return ${relationship.name};
	}
	
	public void set${relationship.capitalizedName}(NSArray<$relationship.destination.clientClassName> ${relationship.name}) {
		this.${relationship.name} = ${relationship.name};
	}
	
	public void addTo${relationship.capitalizedName}Relationship($relationship.actualDestination.classNameWithDefault object) {
		${relationship.name}.add(object);
	}

	public void removeFrom${relationship.capitalizedName}Relationship($relationship.actualDestination.classNameWithDefault object) {
		${relationship.name}.remove(object);
	}
	
	public $relationship.actualDestination.classNameWithDefault create${relationship.capitalizedName}Relationship() {
		${relationship.actualDestination.classNameWithDefault} result = new ${relationship.actualDestination.classNameWithDefault}();
		${relationship.name}.add(result);
		return result;
	}
#end

}
