// DO NOT EDIT.  Make changes to ${entity.classNameWithoutPackage}.java instead.
package $entity.packageName;
// this must be in the client package

import java.util.*;
import java.math.BigDecimal;

import wogwt.translatable.WOGWTClientUtil;

import com.webobjects.eocontrol.*;
import com.webobjects.foundation.*;

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
	
	/* these fields are defined for serialization and to hold data on the client side;
	   can't use a plain Map because all the types must be explicit for optimal code */
#foreach ($attribute in $entity.sortedClassAttributes)
	private ${attribute.javaClassName} _$attribute.name;
#end
#foreach ($relationship in $entity.sortedClassToOneRelationships)
	private ${relationship.actualDestination.classNameWithDefault} _$relationship.name;
#end
#foreach ($relationship in $entity.sortedClassToManyRelationships)
	private NSArray<${relationship.actualDestination.classNameWithDefault}> _$relationship.name = new NSArray<${relationship.actualDestination.classNameWithDefault}>();
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

#if (!$relationship.inverseRelationship || $relationship.flattened || !$relationship.inverseRelationship.classProperty)
  public NSArray<${relationship.actualDestination.classNameWithDefault}> ${relationship.name}(EOQualifier qualifier) {
    return ${relationship.name}(qualifier, null);
  }
#else
  public NSArray<${relationship.actualDestination.classNameWithDefault}> ${relationship.name}(EOQualifier qualifier) {
    return ${relationship.name}(qualifier, null, false);
  }

  public NSArray<${relationship.actualDestination.classNameWithDefault}> ${relationship.name}(EOQualifier qualifier, boolean fetch) {
    return ${relationship.name}(qualifier, null, fetch);
  }
#end

  public NSArray<${relationship.actualDestination.classNameWithDefault}> ${relationship.name}(EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings#if ($relationship.inverseRelationship && !$relationship.flattened && $relationship.inverseRelationship.classProperty), boolean fetch#end) {
    NSArray<${relationship.actualDestination.classNameWithDefault}> results;

    results = ${relationship.name}();
    if (qualifier != null) {
      results = (NSArray<${relationship.actualDestination.classNameWithDefault}>)EOQualifier.filteredArrayWithQualifier(results, qualifier);
    }
    if (sortOrderings != null) {
      results = (NSArray<${relationship.actualDestination.classNameWithDefault}>)EOSortOrdering.sortedArrayUsingKeyOrderArray(results, sortOrderings);
    }

    return results;
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

  public $relationship.actualDestination.classNameWithDefault create${relationship.capitalizedName}Relationship() {
    EOEnterpriseObject eo = new ${relationship.actualDestination.classNameWithDefault}();
    editingContext().insertObject(eo);
    addObjectToBothSidesOfRelationshipWithKey(eo, "${relationship.name}");
    return ($relationship.actualDestination.classNameWithDefault) eo;
  }

  public void delete${relationship.capitalizedName}Relationship($relationship.actualDestination.classNameWithDefault object) {
    removeObjectFromBothSidesOfRelationshipWithKey(object, "${relationship.name}");
#if (!$relationship.ownsDestination)
    editingContext().deleteObject(object);
#end
  }

  public void deleteAll${relationship.capitalizedName}Relationships() {
    Enumeration objects = ${relationship.name}().immutableClone().objectEnumerator();
    while (objects.hasMoreElements()) {
      delete${relationship.capitalizedName}Relationship(($relationship.actualDestination.classNameWithDefault)objects.nextElement());
    }
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
#if (${relationship.inverseRelationship.name} && ${relationship.inverseRelationship.clientClassProperty})
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
				set${attribute.capitalizedName}((value == null || value instanceof NSKeyValueCoding.Null) ? null : ($attribute.javaClassName)value);
				return;
			}
#end		
#foreach ($relationship in $entity.sortedClientClassToOneRelationships)
			if ("${relationship.name}".equals(key)) {
				set${relationship.capitalizedName}Relationship((value == null || value instanceof NSKeyValueCoding.Null) ? null : ($relationship.destination.classNameWithDefault)value);
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
	
	public Object handleQueryWithUnboundKey(String key) {
		if ("__globalID".equals(key) || "__isFault".equals(key)) {
			return null;
		} else {
			throw new NSKeyValueCoding.UnknownKeyException("Class '" + getClass().getName() + " does not have a client key named " + key, this, key);
		}	
	}
	
	public void handleTakeValueForUnboundKey(Object value, String key) {
		if ("__globalID".equals(key) || "__isFault".equals(key)) {
			return;
		} else {
			throw new NSKeyValueCoding.UnknownKeyException("Class '" + getClass().getName() + " does not have a client key named " + key, this, key);
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
		
	public #if (!$entity.partialEntitySet)static #end${entity.classNameWithOptionalPackage}#if (!$entity.partialEntitySet) create#else init#end${entity.name}(EOEditingContext editingContext#foreach ($attribute in $entity.sortedClassAttributes)
#if (!$attribute.allowsNull)
#set ($restrictingQualifierKey = 'false')
#foreach ($qualifierKey in $entity.restrictingQualifierKeys)#if ($attribute.name == $qualifierKey)#set ($restrictingQualifierKey = 'true')#end#end
#if ($restrictingQualifierKey == 'false')
#if ($attribute.userInfo.ERXConstantClassName), ${attribute.userInfo.ERXConstantClassName}#else, ${attribute.javaClassName}#end ${attribute.name}
#end
#end
#end
#foreach ($relationship in $entity.sortedClassToOneRelationships)
#if ($relationship.mandatory && !($relationship.ownsDestination && $relationship.propagatesPrimaryKey)), ${relationship.actualDestination.classNameWithDefault} ${relationship.name}#end
#end
) {
		${entity.classNameWithOptionalPackage} eo = (${entity.classNameWithOptionalPackage})#if ($entity.partialEntitySet)this;#else new ${entity.classNameWithOptionalPackage}(); editingContext.insertObject(eo);#end
    
#foreach ($attribute in $entity.sortedClassAttributes)
#if (!$attribute.allowsNull)
#set ($restrictingQualifierKey = 'false')
#foreach ($qualifierKey in $entity.restrictingQualifierKeys) 
#if ($attribute.name == $qualifierKey)
#set ($restrictingQualifierKey = 'true')
#end
#end
#if ($restrictingQualifierKey == 'false')
		eo.set${attribute.capitalizedName}(${attribute.name});
#end
#end
#end
#foreach ($relationship in $entity.sortedClassToOneRelationships)
#if ($relationship.mandatory && !($relationship.ownsDestination && $relationship.propagatesPrimaryKey))
		eo.set${relationship.capitalizedName}Relationship(${relationship.name});
#end
#end
		return eo;
	}
#if (!$entity.partialEntitySet)

	public static NSArray<${entity.classNameWithOptionalPackage}> fetchAll${entity.pluralName}(EOEditingContext editingContext) {
		return ${entity.prefixClassNameWithoutPackage}.fetchAll${entity.pluralName}(editingContext, null);
	}

	public static NSArray<${entity.classNameWithOptionalPackage}> fetchAll${entity.pluralName}(EOEditingContext editingContext, NSArray<EOSortOrdering> sortOrderings) {
		return ${entity.prefixClassNameWithoutPackage}.fetch${entity.pluralName}(editingContext, null, sortOrderings);
	}

	public static NSArray<${entity.classNameWithOptionalPackage}> fetch${entity.pluralName}(EOEditingContext editingContext, EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings) {
		EOFetchSpecification fetchSpec = new EOFetchSpecification(${entity.name}.ENTITY_NAME, qualifier, sortOrderings);
		fetchSpec.setIsDeep(true);
		NSArray<${entity.classNameWithOptionalPackage}> eoObjects = (NSArray<${entity.classNameWithOptionalPackage}>)editingContext.objectsWithFetchSpecification(fetchSpec);
		return eoObjects;
	}

	public static ${entity.classNameWithOptionalPackage} fetch${entity.name}(EOEditingContext editingContext, String keyName, Object value) {
		return ${entity.prefixClassNameWithoutPackage}.fetch${entity.name}(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
	}

	public static ${entity.classNameWithOptionalPackage} fetch${entity.name}(EOEditingContext editingContext, EOQualifier qualifier) {
		NSArray<${entity.classNameWithOptionalPackage}> eoObjects = ${entity.prefixClassNameWithoutPackage}.fetch${entity.pluralName}(editingContext, qualifier, null);
		${entity.classNameWithOptionalPackage} eoObject;
		int count = eoObjects.count();
		if (count == 0) {
			eoObject = null;
		}
		else if (count == 1) {
			eoObject = (${entity.classNameWithOptionalPackage})eoObjects.objectAtIndex(0);
		}
		else {
			throw new IllegalStateException("There was more than one ${entity.name} that matched the qualifier '" + qualifier + "'.");
		}
		return eoObject;
	}

	public static ${entity.classNameWithOptionalPackage} fetchRequired${entity.name}(EOEditingContext editingContext, String keyName, Object value) {
		return ${entity.prefixClassNameWithoutPackage}.fetchRequired${entity.name}(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
	}

	public static ${entity.classNameWithOptionalPackage} fetchRequired${entity.name}(EOEditingContext editingContext, EOQualifier qualifier) {
		${entity.classNameWithOptionalPackage} eoObject = ${entity.prefixClassNameWithoutPackage}.fetch${entity.name}(editingContext, qualifier);
		if (eoObject == null) {
			throw new NoSuchElementException("There was no ${entity.name} that matched the qualifier '" + qualifier + "'.");
		}
		return eoObject;
	}

#end
#foreach ($fetchSpecification in $entity.sortedFetchSpecs)
	public static EOFetchSpecification ${fetchSpecification.name}FetchSpec() {
        return EOFetchSpecification.fetchSpecificationNamed("${fetchSpecification.name}", ${entity.name}.ENTITY_NAME);
	}
	
#end
#foreach ($fetchSpecification in $entity.sortedFetchSpecs)
	public static EOFetchSpecification bind${fetchSpecification.capitalizedName}(#foreach ($binding in $fetchSpecification.distinctBindings)#if ($velocityCount>1), #end${binding.javaClassName} ${binding.name}Binding#end) {
	    EOFetchSpecification spec = EOFetchSpecification.fetchSpecificationNamed("${fetchSpecification.name}", ${entity.name}.ENTITY_NAME);
#if ($fetchSpecification.distinctBindings.size() > 0)
	    	
	    NSMutableDictionary bindings = new NSMutableDictionary();
#foreach ($binding in $fetchSpecification.distinctBindings)
	    if (${binding.name}Binding != null)
	        bindings.setObjectForKey(${binding.name}Binding, "${binding.name}");
#end
	    spec = spec.fetchSpecificationWithQualifierBindings(bindings);
	    
#end
	    return spec;
	} 

#end
#foreach ($fetchSpecification in $entity.sortedFetchSpecs)
#if (!$fetchSpecification.fetchEnterpriseObjects)
	/**
	 * RAW ROW KEY PATHS:
#foreach ($keyPath in $fetchSpecification.rawRowKeyPaths)
     * ${keyPath}
#end
	 */
#end
	public static NSArray#if ($fetchSpecification.fetchEnterpriseObjects)<${entity.classNameWithoutPackage}>#else<NSDictionary>#end objectsFor${fetchSpecification.capitalizedName}(EOEditingContext ec#foreach ($binding in $fetchSpecification.distinctBindings),
			${binding.attributePath.childClassName} ${binding.name}Binding#end) {
        EOFetchSpecification spec = bind${fetchSpecification.capitalizedName}(#foreach ($binding in $fetchSpecification.distinctBindings)#if ($velocityCount>1), #end${binding.name}Binding#end);
        return ec.objectsWithFetchSpecification(spec);        
	}
	
#end

}
