// $LastChangedRevision: 4733 $ DO NOT EDIT.  Make changes to ${entity.classNameWithOptionalPackage}.java instead.
#if ($entity.superclassPackageName)
package $entity.superclassPackageName;

#end
import com.webobjects.eoaccess.*;
import com.webobjects.eocontrol.*;
import com.webobjects.foundation.*;

import java.math.*;
import java.util.*;
import org.apache.log4j.Logger;
import er.extensions.eof.ERXGenericRecord;
import er.extensions.eof.ERXKey;

@SuppressWarnings("all")
public class ${entity.prefixClassNameWithoutPackage} {

	// Attributes
#foreach ($attribute in $entity.sortedClassAttributes)
	public static final ERXKey ${attribute.uppercaseUnderscoreName} = new ERXKey(${entity.name}.${attribute.uppercaseUnderscoreName}_KEY);
#end

	// Relationships
#foreach ($relationship in $entity.sortedClassRelationships)
	public static final ERXKey ${relationship.uppercaseUnderscoreName} = new ERXKey(${entity.name}.${relationship.uppercaseUnderscoreName}_KEY);
#end

	public static ${entity.classNameWithoutPackage} create( EOEditingContext ec ) {
		${entity.classNameWithOptionalPackage} eo = new ${entity.name}();
	    ec.insertObject( eo );
	    return eo;
	}

#foreach ($relationship in $entity.sortedClassToManyRelationships)
#if (!$relationship.inherited) 
#if (!$relationship.inverseRelationship || $relationship.flattened || !$relationship.inverseRelationship.classProperty)
	public static NSArray<${relationship.actualDestination.classNameWithDefault}> ${relationship.name}(${entity.name} eo, EOQualifier qualifier) {
		return ${relationship.name}(eo, qualifier, null);
	}
#else
	public static NSArray<${relationship.actualDestination.classNameWithDefault}> ${relationship.name}(${entity.name} eo, EOQualifier qualifier) {
		return ${relationship.name}(eo, qualifier, null, false);
	}

	public static NSArray<${relationship.actualDestination.classNameWithDefault}> ${relationship.name}(${entity.name} eo, EOQualifier qualifier, boolean fetch) {
		return ${relationship.name}(eo, qualifier, null, fetch);
	}
#end

  	public static NSArray<${relationship.actualDestination.classNameWithDefault}> ${relationship.name}(${entity.name} eo, EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings#if ($relationship.inverseRelationship && !$relationship.flattened && $relationship.inverseRelationship.classProperty), boolean fetch#end) {
  		NSArray<${relationship.actualDestination.classNameWithDefault}> results;
#if ($relationship.inverseRelationship && !$relationship.flattened && $relationship.inverseRelationship.classProperty)
    	if (fetch) {
    		EOQualifier fullQualifier;
#if (${relationship.actualDestination.genericRecord})
      		EOQualifier inverseQualifier = new EOKeyValueQualifier("${relationship.inverseRelationship.name}", EOQualifier.QualifierOperatorEqual, eo);
#else
      		EOQualifier inverseQualifier = new EOKeyValueQualifier(${relationship.actualDestination.classNameWithDefault}.${relationship.inverseRelationship.uppercaseUnderscoreName}_KEY, EOQualifier.QualifierOperatorEqual, eo);
#end
    	
			if (qualifier == null) {
				fullQualifier = inverseQualifier;
			}
			else {
				NSMutableArray<EOQualifier> qualifiers = new NSMutableArray<EOQualifier>();
				qualifiers.addObject(qualifier);
				qualifiers.addObject(inverseQualifier);
				fullQualifier = new EOAndQualifier(qualifiers);
			}

#if (${relationship.actualDestination.genericRecord})
			EOFetchSpecification fetchSpec = new EOFetchSpecification("${relationship.actualDestination.name}", qualifier, sortOrderings);
      		fetchSpec.setIsDeep(true);
      		results = (NSArray<${relationship.actualDestination.classNameWithDefault}>)editingContext().objectsWithFetchSpecification(fetchSpec);
#else
      		results = Ex${relationship.actualDestination.name}.fetch${relationship.actualDestination.pluralName}(eo.editingContext(), fullQualifier, sortOrderings);
#end
    	} else {
#end
      		results = eo.${relationship.name}();
      		if (qualifier != null) {
      			results = (NSArray<${relationship.actualDestination.classNameWithDefault}>)EOQualifier.filteredArrayWithQualifier(results, qualifier);
      		}
      		if (sortOrderings != null) {
      			results = (NSArray<${relationship.actualDestination.classNameWithDefault}>)EOSortOrdering.sortedArrayUsingKeyOrderArray(results, sortOrderings);
      		}
#if ($relationship.inverseRelationship && !$relationship.flattened && $relationship.inverseRelationship.classProperty)
    	}
#end
    	return results;
  	}
  

  	public static $relationship.actualDestination.classNameWithDefault create${relationship.capitalizedName}Relationship(${entity.name} object) {
  		EOClassDescription eoClassDesc = EOClassDescription.classDescriptionForEntityName("${relationship.actualDestination.name}");
  		EOEnterpriseObject eo = eoClassDesc.createInstanceWithEditingContext(object.editingContext(), null);
  		object.editingContext().insertObject(eo);
  		object.addObjectToBothSidesOfRelationshipWithKey(eo, "${relationship.name}");
  		return ($relationship.actualDestination.classNameWithDefault) eo;
  	}

  	public static void delete${relationship.capitalizedName}Relationship(${entity.name} eo, $relationship.actualDestination.classNameWithDefault object) {
  		eo.removeObjectFromBothSidesOfRelationshipWithKey(object, "${relationship.name}");
#if (!$relationship.ownsDestination)
    	eo.editingContext().deleteObject(object);
#end
  	}

  	public void deleteAll${relationship.capitalizedName}Relationships(${entity.name} eo) {
  		Enumeration<$relationship.actualDestination.classNameWithDefault> objects = eo.${relationship.name}().immutableClone().objectEnumerator();
  		while (objects.hasMoreElements()) {
  			delete${relationship.capitalizedName}Relationship(eo, objects.nextElement());
  		}
  	}

#end
#end

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
		${entity.classNameWithOptionalPackage} eo = (${entity.classNameWithOptionalPackage})#if ($entity.partialEntitySet)this;#else EOUtilities.createAndInsertInstance(editingContext, ${entity.name}.ENTITY_NAME);#end
    
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

  	public static ${entity.classNameWithOptionalPackage} localInstanceIn(EOEditingContext editingContext, ${entity.classNameWithOptionalPackage} eo) {
  		${entity.classNameWithOptionalPackage} localInstance = (eo == null) ? null : (${entity.classNameWithOptionalPackage})EOUtilities.localInstanceOfObject(editingContext, eo);
  		if (localInstance == null && eo != null) {
  			throw new IllegalStateException("You attempted to localInstance " + eo + ", which has not yet committed.");
  		}
  		return localInstance;
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

	/** returns the object if it exists.  If there are zero or two or more objects, return null */
	public static ${entity.classNameWithoutPackage} objectMatchingKeyAndValue( EOEditingContext ec, String key, Object value ) {
		${entity.classNameWithoutPackage} result = null;
		try {
			result = (${entity.classNameWithoutPackage})EOUtilities.objectMatchingKeyAndValue(ec, ${entity.name}.ENTITY_NAME, key, value);				
		} catch (EOObjectNotAvailableException e) {
		} catch (EOUtilities.MoreThanOneException e) {
		}
		return result;
	}
	
	/** returns the object if it exists.  If there are zero or two or more objects, return null */
	public static ${entity.classNameWithoutPackage} objectMatchingValues( EOEditingContext ec, NSDictionary values ) {
		${entity.classNameWithoutPackage} result = null;
		try {
			result = (${entity.classNameWithoutPackage})EOUtilities.objectMatchingValues(ec, ${entity.name}.ENTITY_NAME, values);				
		} catch (EOObjectNotAvailableException e) {
		} catch (EOUtilities.MoreThanOneException e) {
		}
		return result;
	}
	
	/** returns the object if it exists.  If there are zero or two or more objects, return null */
	public static ${entity.classNameWithoutPackage} objectMatchingPrimaryKeyValue( EOEditingContext ec, Object value ) {
		${entity.classNameWithoutPackage} result = null;
		try {
			result = (${entity.classNameWithoutPackage})EOUtilities.objectWithPrimaryKeyValue( ec, ${entity.name}.ENTITY_NAME, value );				
		} catch (EOObjectNotAvailableException e) {
		} catch (EOUtilities.MoreThanOneException e) {
		}
		return result;
	}
}
