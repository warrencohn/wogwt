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
	
#if (!$entity.partialEntitySet)
  	public static ${entity.classNameWithOptionalPackage} localInstanceIn(EOEditingContext editingContext, ${entity.classNameWithOptionalPackage} eo) {
  		${entity.classNameWithOptionalPackage} localInstance = (eo == null) ? null : (${entity.classNameWithOptionalPackage})EOUtilities.localInstanceOfObject(editingContext, eo);
  		if (localInstance == null && eo != null) {
  			throw new IllegalStateException("You attempted to localInstance " + eo + ", which has not yet committed.");
  		}
  		return localInstance;
  	}
#end