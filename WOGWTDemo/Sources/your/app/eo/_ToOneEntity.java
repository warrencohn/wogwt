// DO NOT EDIT.  Make changes to ToOneEntity.java instead.
package your.app.eo;

import com.webobjects.eoaccess.*;
import com.webobjects.eocontrol.*;
import com.webobjects.foundation.*;

import java.math.*;
import java.util.*;

import org.apache.log4j.Logger;

import wogwt.translatable.WOGWTClientEO;
import wogwt.WOGWTServerEO;

// This class can only be used on the server-side
public abstract class _ToOneEntity extends  EOGenericRecord implements WOGWTServerEO {
	public static final String ENTITY_NAME = "ToOneEntity";

	// Attributes
	public static final String NAME_KEY = "name";

	// Relationships

  private static Logger LOG = Logger.getLogger(_ToOneEntity.class);

  public ToOneEntity localInstanceOfToOneEntity(EOEditingContext editingContext) {
    ToOneEntity localInstance = (ToOneEntity)EOUtilities.localInstanceOfObject(editingContext, this);
    if (localInstance == null) {
      throw new IllegalStateException("You attempted to localInstance " + this + ", which has not yet committed.");
    }
    return localInstance;
  }

  public String name() {
    return (String) storedValueForKey("name");
  }

  public void setName(String value) {
    if (_ToOneEntity.LOG.isDebugEnabled()) {
    	_ToOneEntity.LOG.debug( "updating name from " + name() + " to " + value);
    }
    takeStoredValueForKey(value, "name");
  }

  public static ToOneEntity createToOneEntity(EOEditingContext editingContext, String name
) {
    ToOneEntity eo = (ToOneEntity)EOUtilities.createAndInsertInstance(editingContext, _ToOneEntity.ENTITY_NAME);
		eo.setName(name);
    return eo;
  }

  public static NSArray fetchAllToOneEntities(EOEditingContext editingContext) {
    return _ToOneEntity.fetchAllToOneEntities(editingContext, null);
  }

  public static NSArray fetchAllToOneEntities(EOEditingContext editingContext, NSArray sortOrderings) {
    return _ToOneEntity.fetchToOneEntities(editingContext, null, sortOrderings);
  }

  public static NSArray fetchToOneEntities(EOEditingContext editingContext, EOQualifier qualifier, NSArray sortOrderings) {
    EOFetchSpecification fetchSpec = new EOFetchSpecification(_ToOneEntity.ENTITY_NAME, qualifier, sortOrderings);
    fetchSpec.setIsDeep(true);
    NSArray eoObjects = (NSArray)editingContext.objectsWithFetchSpecification(fetchSpec);
    return eoObjects;
  }

  public static ToOneEntity fetchToOneEntity(EOEditingContext editingContext, String keyName, Object value) {
    return _ToOneEntity.fetchToOneEntity(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static ToOneEntity fetchToOneEntity(EOEditingContext editingContext, EOQualifier qualifier) {
    NSArray eoObjects = _ToOneEntity.fetchToOneEntities(editingContext, qualifier, null);
    ToOneEntity eoObject;
    int count = eoObjects.count();
    if (count == 0) {
      eoObject = null;
    }
    else if (count == 1) {
      eoObject = (ToOneEntity)eoObjects.objectAtIndex(0);
    }
    else {
      throw new IllegalStateException("There was more than one ToOneEntity that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static ToOneEntity fetchRequiredToOneEntity(EOEditingContext editingContext, String keyName, Object value) {
    return _ToOneEntity.fetchRequiredToOneEntity(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static ToOneEntity fetchRequiredToOneEntity(EOEditingContext editingContext, EOQualifier qualifier) {
    ToOneEntity eoObject = _ToOneEntity.fetchToOneEntity(editingContext, qualifier);
    if (eoObject == null) {
      throw new NoSuchElementException("There was no ToOneEntity that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static ToOneEntity localInstanceOfToOneEntity(EOEditingContext editingContext, ToOneEntity eo) {
    ToOneEntity localInstance = (eo == null) ? null : (ToOneEntity)EOUtilities.localInstanceOfObject(editingContext, eo);
    if (localInstance == null && eo != null) {
      throw new IllegalStateException("You attempted to localInstance " + eo + ", which has not yet committed.");
    }
    return localInstance;
  }
  
  public WOGWTClientEO toClientEO() {
	  NSMutableDictionary data = snapshot().mutableClone();
	  
	  String key;
	  Object value;
	  EOEnterpriseObject eoValue;
	  
	  // To one relationships - either send faults or turn into client EOs

		List list;
		NSArray array;
	  	// To  many relationships

	  if (editingContext() != null && !editingContext().globalIDForObject( this ).isTemporary()) {
		  data.setObjectForKey( ((EOKeyGlobalID)editingContext().globalIDForObject( this )).keyValues()[0], "primaryKeyValue" );
	  }
	  your.app.gwt.eo.ToOneEntityClient rec = new your.app.gwt.eo.ToOneEntityClient( data.immutableClone() ); 
	  return rec;
  }
  
}
