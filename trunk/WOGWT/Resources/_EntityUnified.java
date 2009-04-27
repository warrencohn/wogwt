// DO NOT EDIT.  Make changes to ${entity.classNameWithoutPackage}.java instead.
package $entity.packageName;
// this must be in the client package

import java.util.*;
import java.math.BigDecimal;

import wogwt.translatable.WOGWTClientUtil;

import com.webobjects.eocontrol.EOEnterpriseObject;
import com.webobjects.foundation.NSArray;
import com.webobjects.foundation.NSMutableArray;
import com.webobjects.foundation.NSDictionary;
import com.webobjects.foundation.NSMutableDictionary;
import com.webobjects.foundation.NSKeyValueCoding;
import com.webobjects.foundation.NSKeyValueCodingAdditions;
import com.webobjects.foundation.NSTimestamp;
import com.webobjects.foundation.NSData;

// This class can be serialized from server to client and back
@SuppressWarnings("all")
public abstract class ${entity.prefixClassNameWithoutPackage} 
	extends com.webobjects.eocontrol.EOGenericRecord 
	implements wogwt.translatable.rpc.WOGWTSerializableEO {
		
	public static final transient String ENTITY_NAME = "$entity.name";
#foreach ($attribute in $entity.sortedClassAttributes)
	public static final transient String ${attribute.uppercaseUnderscoreName}_KEY = "$attribute.name";
#end
#foreach ($relationship in $entity.sortedClassRelationships)
	public static final transient String ${relationship.uppercaseUnderscoreName}_KEY = "$relationship.name";
#end
	
	public Integer _rawPrimaryKey;
#foreach ($attribute in $entity.sortedClassAttributes)
	public ${attribute.javaClassName} _$attribute.name;
#end
#foreach ($relationship in $entity.sortedClassToOneRelationships)
	public ${relationship.actualDestination.classNameWithDefault} _$relationship.name;
#end
#foreach ($relationship in $entity.sortedClassToManyRelationships)
	public NSArray<${relationship.actualDestination.classNameWithDefault}> _$relationship.name = new NSArray<${relationship.actualDestination.classNameWithDefault}>();
#end

	public ${entity.prefixClassNameWithoutPackage}() {
		super();
	}
	
	// Attributes
#foreach ($attribute in $entity.sortedClassAttributes)
#if (!$attribute.inherited)
	public $attribute.javaClassName ${attribute.name}() {
		return ($attribute.javaClassName) storedValueForKey("$attribute.name");
	}

	public void set${attribute.capitalizedName}($attribute.javaClassName value) {
		takeStoredValueForKey(value, "$attribute.name");
	}
	
#end
#end
#foreach ($relationship in $entity.sortedClassToOneRelationships)
#if (!$relationship.inherited) 
	public $relationship.actualDestination.classNameWithDefault ${relationship.name}() {
		return ($relationship.actualDestination.classNameWithDefault)storedValueForKey("$relationship.name");
	}
  
	public void set${relationship.capitalizedName}Relationship($relationship.actualDestination.classNameWithDefault value) {
		if (value == null) {
			$relationship.actualDestination.classNameWithDefault oldValue = ${relationship.name}();
			if (oldValue != null) {
				removeObjectFromBothSidesOfRelationshipWithKey(oldValue, "$relationship.name");
			}
		} else {
			addObjectToBothSidesOfRelationshipWithKey(value, "$relationship.name");
		}
	}
  
#end
#end
#foreach ($relationship in $entity.sortedClassToManyRelationships)
#if (!$relationship.inherited) 
	public NSArray<${relationship.actualDestination.classNameWithDefault}> ${relationship.name}() {
		return (NSArray<${relationship.actualDestination.classNameWithDefault}>)storedValueForKey("${relationship.name}");
	}
	
	public void set${relationship.capitalizedName}(NSArray<${relationship.actualDestination.classNameWithDefault}> aValue) {
		takeStoredValueForKey(aValue, "${relationship.name}");
	}
	
	public void addTo${relationship.capitalizedName}($relationship.actualDestination.classNameWithDefault object) {
		includeObjectIntoPropertyWithKey(object, "${relationship.name}");
	}

	public void removeFrom${relationship.capitalizedName}($relationship.actualDestination.classNameWithDefault object) {
		excludeObjectFromPropertyWithKey(object, "${relationship.name}");
	}

	public void addTo${relationship.capitalizedName}Relationship($relationship.actualDestination.classNameWithDefault object) {
		addObjectToBothSidesOfRelationshipWithKey(object, "${relationship.name}");
	}

	public void removeFrom${relationship.capitalizedName}Relationship($relationship.actualDestination.classNameWithDefault object) {
		removeObjectFromBothSidesOfRelationshipWithKey(object, "${relationship.name}");
	}
	
#end
#end
	@Override
	public NSArray<String> attributeKeys() {
		NSArray<String> result = super.attributeKeys();
		if (result != null)
			return result;

		NSArray<String> keys = new NSArray<String>( new String[] {
#foreach ($attribute in $entity.sortedClientClassAttributes)
			"${attribute.name}"#if ($velocityCount < $entity.sortedClientClassAttributes.size()),#end
			
#end	
		});
		return keys;
	}
	
	@Override
	public NSArray<String> toOneRelationshipKeys() {
		NSArray<String> result = super.toOneRelationshipKeys();
		if (result != null)
			return result;
		
		NSArray<String> keys = new NSArray<String>( new String[] {	
#foreach ($relationship in $entity.sortedClientClassToOneRelationships)
			"${relationship.name}"#if ($velocityCount < $entity.sortedClientClassToOneRelationships.size()),#end
			
#end	
		});
		
		return keys;
	}
	
	@Override
	public NSArray<String> toManyRelationshipKeys() {
		NSArray<String> result = super.toManyRelationshipKeys();
		if (result != null)
			return result;
		
		NSArray<String> keys = new NSArray<String>( new String[] {
#foreach ($relationship in $entity.sortedClientClassToManyRelationships)
			"${relationship.name}"#if ($velocityCount < $entity.sortedClassAttributes.size()),#end

#end
		});
		
    	return keys;
	}
	
	public int deleteRuleNumber(String deleteRuleName) {
		if ("EODeleteRuleNullify".equals(deleteRuleName)) {
			return 0;
		} else if ("EODeleteRuleCascade".equals(deleteRuleName)) {
			return 1;
		} else if ("EODeleteRuleDeny".equals(deleteRuleName)) {
			return 2;
		} else if ("EODeleteRuleNoAction".equals(deleteRuleName)) {
			return 3;
		} else {
			return -1;
		}
	}
	
	@Override
	public int deleteRuleForRelationshipKey(String relationshipKey) {
		int result = super.deleteRuleForRelationshipKey(relationshipKey);
		if (result != -1)
			return result;
		
#foreach ($relationship in $entity.sortedClientClassRelationships)
		if ("${relationship.name}".equals(relationshipKey))
			return deleteRuleNumber("$relationship.deleteRule.ID");
#end

		return result;
	}
	
	@Override
	public String inverseForRelationshipKey(String relationshipKey) {
		String result = super.inverseForRelationshipKey(relationshipKey);
		if (result != null)
			return result;
		
#foreach ($relationship in $entity.sortedClientClassRelationships)
#if (${relationship.inverseRelationship.name})
		if ("${relationship.name}".equals(relationshipKey))
			return "${relationship.inverseRelationship.name}";
#end
#end

		return null;
	}
	
	@Override
	public boolean isReadOnly() {
#if (${entity.isReadOnly()})
		return true;
#else
		return false;
#end
	}
	
	@Override
	public boolean ownsDestinationObjectsForRelationshipKey(String relationshipKey) {
		try {
			return super.ownsDestinationObjectsForRelationshipKey(relationshipKey);
		} catch (UnsupportedOperationException e) {
#foreach ($relationship in $entity.sortedClientClassRelationships)
#if (${relationship.ownsDestination})
			if ("${relationship.name}".equals(relationshipKey))
				return $relationship.ownsDestination;
#end
#end
			return false;
		}
	}
	
	@Override
	public Object valueForKey(String key) {
		try {
			return super.valueForKey(key);
		} catch (UnsupportedOperationException e) {
			if ("entityName".equals(key))
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
				return handleQueryWithUnboundKey(key);
		}
	}
	
	@Override
	public void takeValueForKey(Object value, String key) {
		try {
			super.takeValueForKey(value, key);
		} catch (UnsupportedOperationException e) {
#foreach ($attribute in $entity.sortedClientClassAttributes)
			if ("${attribute.name}".equals(key)) {
				set${attribute.capitalizedName}(WOGWTClientUtil.isNull(value) ? null : ($attribute.javaClassName)value);
				return;
			}
#end		
#foreach ($relationship in $entity.sortedClientClassToOneRelationships)
			if ("${relationship.name}".equals(key)) {
				set${relationship.capitalizedName}Relationship(WOGWTClientUtil.isNull(value) ? null : ($relationship.destination.classNameWithDefault)value);
				return;
			}
#end
#foreach ($relationship in $entity.sortedClientClassToManyRelationships)
			if ("${relationship.name}".equals(key)) {
				set${relationship.capitalizedName}((NSArray<$relationship.destination.classNameWithDefault>)value);
				return;
			}
#end
			handleTakeValueForUnboundKey(value, key);
		}
	}
	
	@Override
	public Object storedValueForKey(String key) {
		try {
			return super.storedValueForKey(key);
		} catch (UnsupportedOperationException e) {
#foreach ($attribute in $entity.sortedClientClassAttributes)
			if ("${attribute.name}".equals(key))
				return _${attribute.name};
#end		
#foreach ($relationship in $entity.sortedClientClassToOneRelationships)
			if ("${relationship.name}".equals(key))
				return _${relationship.name};
#end
#foreach ($relationship in $entity.sortedClientClassToManyRelationships)
			if ("${relationship.name}".equals(key))
				return _${relationship.name};
#end		
			return handleQueryWithUnboundKey(key);
		}
	}
	
	@Override
	public void takeStoredValueForKey(Object value, String key) {
		try {
			super.takeStoredValueForKey(value, key);
		} catch (UnsupportedOperationException e) {
#foreach ($attribute in $entity.sortedClientClassAttributes)
			if ("${attribute.name}".equals(key)) {
				_${attribute.name} = (${attribute.javaClassName})value;
				return;
			}
#end		
#foreach ($relationship in $entity.sortedClientClassToOneRelationships)
			if ("${relationship.name}".equals(key)) {
				_${relationship.name} = (${relationship.actualDestination.classNameWithDefault})value;
				return;
			}
#end
#foreach ($relationship in $entity.sortedClientClassToManyRelationships)
			if ("${relationship.name}".equals(key)) {
				_${relationship.name} = (NSArray<${relationship.actualDestination.classNameWithDefault}>)value;
				return;
			}
#end		
			handleTakeValueForUnboundKey(value, key);
		}
	}
	
	protected void includeObjectIntoPropertyWithKey(Object eo, String key) {
		try {
			super.includeObjectIntoPropertyWithKey(eo, key);
		} catch (UnsupportedOperationException e) {
#foreach ($relationship in $entity.sortedClientClassToManyRelationships)
			if ("${relationship.name}".equals(key)) {
				_${relationship.name} = _${relationship.name}.mutableClone();
				_${relationship.name}.add((${relationship.actualDestination.classNameWithDefault})eo);
				return;
			}
#end
		}		
	}
	
	@Override
	protected void excludeObjectFromPropertyWithKey(Object eo, String key) {
		try {
			super.excludeObjectFromPropertyWithKey(eo, key);
		} catch (UnsupportedOperationException e) {
#foreach ($relationship in $entity.sortedClientClassToManyRelationships)
			if ("${relationship.name}".equals(key)) {
				if (_${relationship.name}.contains(eo)) {
					_${relationship.name} = _${relationship.name}.mutableClone();
					_${relationship.name}.remove(eo);
					return;
				} else {
					throw new IllegalArgumentException("Relationship '" + key + "' does not contain object: " + eo);
				}
			}
#end
		}
	}
	
	@Override
	public String entityName() {
		return "$entity.name";
	}
	
	public NSDictionary<String, Object> clientSnapshot() {
		NSDictionary<String, Object> result = new NSMutableDictionary();
		
#foreach ($attribute in $entity.sortedClientClassAttributes)
		if (valueForKey("${attribute.name}") != null)
			result.put("${attribute.name}", valueForKey("${attribute.name}"));
		else
			result.put("${attribute.name}", NSKeyValueCoding.NullValue);

#end
#foreach ($relationship in $entity.sortedClientClassToOneRelationships)
		if (valueForKey("${relationship.name}") != null)
			result.put("${relationship.name}", valueForKey("${relationship.name}"));
		else
			result.put("${relationship.name}", NSKeyValueCoding.NullValue);

#end
#foreach ($relationship in $entity.sortedClientClassToManyRelationships)
		if (valueForKey("${relationship.name}") != null)
			result.put("${relationship.name}", valueForKey("${relationship.name}"));
		else
			result.put("${relationship.name}", NSArray.EmptyArray);

#end
		return result.immutableClone();
	}
		
}
