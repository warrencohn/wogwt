// DO NOT EDIT.  Make changes to ToManyEntity.java instead.
package your.app.eo;

import com.webobjects.eoaccess.*;
import com.webobjects.eocontrol.*;
import com.webobjects.foundation.*;

import java.math.*;
import java.util.*;

import org.apache.log4j.Logger;

import wogwt.translatable.WOGWTClientEO;
import wogwt.WOGWTServerEO;
import wogwt.WOGWTServerUtil;

// This class can only be used on the server-side
public abstract class _ToManyEntity extends  EOGenericRecord implements WOGWTServerEO {
	public static final String ENTITY_NAME = "ToManyEntity";

	// Attributes
	public static final String NAME_KEY = "name";

	// Relationships
	public static final String ROOT_ENTITY_OBJECT_KEY = "rootEntityObject";

  private static Logger LOG = Logger.getLogger(_ToManyEntity.class);

  public ToManyEntity localInstanceOfToManyEntity(EOEditingContext editingContext) {
    ToManyEntity localInstance = (ToManyEntity)EOUtilities.localInstanceOfObject(editingContext, this);
    if (localInstance == null) {
      throw new IllegalStateException("You attempted to localInstance " + this + ", which has not yet committed.");
    }
    return localInstance;
  }

  public String name() {
    return (String) storedValueForKey("name");
  }

  public void setName(String value) {
    if (_ToManyEntity.LOG.isDebugEnabled()) {
    	_ToManyEntity.LOG.debug( "updating name from " + name() + " to " + value);
    }
    takeStoredValueForKey(value, "name");
  }

  public your.app.eo.RootEntity rootEntityObject() {
    return (your.app.eo.RootEntity)storedValueForKey("rootEntityObject");
  }

  public void setRootEntityObjectRelationship(your.app.eo.RootEntity value) {
    if (_ToManyEntity.LOG.isDebugEnabled()) {
      _ToManyEntity.LOG.debug("updating rootEntityObject from " + rootEntityObject() + " to " + value);
    }
    if (value == null) {
    	your.app.eo.RootEntity oldValue = rootEntityObject();
    	if (oldValue != null) {
    		removeObjectFromBothSidesOfRelationshipWithKey(oldValue, "rootEntityObject");
      }
    } else {
    	addObjectToBothSidesOfRelationshipWithKey(value, "rootEntityObject");
    }
  }
  
  public static ToManyEntity createToManyEntity(EOEditingContext editingContext, String name
, your.app.eo.RootEntity rootEntityObject) {
    ToManyEntity eo = (ToManyEntity)EOUtilities.createAndInsertInstance(editingContext, _ToManyEntity.ENTITY_NAME);
		eo.setName(name);
    eo.setRootEntityObjectRelationship(rootEntityObject);
    return eo;
  }

  public static NSArray fetchAllToManyEntities(EOEditingContext editingContext) {
    return _ToManyEntity.fetchAllToManyEntities(editingContext, null);
  }

  public static NSArray fetchAllToManyEntities(EOEditingContext editingContext, NSArray sortOrderings) {
    return _ToManyEntity.fetchToManyEntities(editingContext, null, sortOrderings);
  }

  public static NSArray fetchToManyEntities(EOEditingContext editingContext, EOQualifier qualifier, NSArray sortOrderings) {
    EOFetchSpecification fetchSpec = new EOFetchSpecification(_ToManyEntity.ENTITY_NAME, qualifier, sortOrderings);
    fetchSpec.setIsDeep(true);
    NSArray eoObjects = (NSArray)editingContext.objectsWithFetchSpecification(fetchSpec);
    return eoObjects;
  }

  public static ToManyEntity fetchToManyEntity(EOEditingContext editingContext, String keyName, Object value) {
    return _ToManyEntity.fetchToManyEntity(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static ToManyEntity fetchToManyEntity(EOEditingContext editingContext, EOQualifier qualifier) {
    NSArray eoObjects = _ToManyEntity.fetchToManyEntities(editingContext, qualifier, null);
    ToManyEntity eoObject;
    int count = eoObjects.count();
    if (count == 0) {
      eoObject = null;
    }
    else if (count == 1) {
      eoObject = (ToManyEntity)eoObjects.objectAtIndex(0);
    }
    else {
      throw new IllegalStateException("There was more than one ToManyEntity that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static ToManyEntity fetchRequiredToManyEntity(EOEditingContext editingContext, String keyName, Object value) {
    return _ToManyEntity.fetchRequiredToManyEntity(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static ToManyEntity fetchRequiredToManyEntity(EOEditingContext editingContext, EOQualifier qualifier) {
    ToManyEntity eoObject = _ToManyEntity.fetchToManyEntity(editingContext, qualifier);
    if (eoObject == null) {
      throw new NoSuchElementException("There was no ToManyEntity that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static ToManyEntity localInstanceOfToManyEntity(EOEditingContext editingContext, ToManyEntity eo) {
    ToManyEntity localInstance = (eo == null) ? null : (ToManyEntity)EOUtilities.localInstanceOfObject(editingContext, eo);
    if (localInstance == null && eo != null) {
      throw new IllegalStateException("You attempted to localInstance " + eo + ", which has not yet committed.");
    }
    return localInstance;
  }
  

  
  public WOGWTClientEO toClientEO() {
	  return new your.app.gwt.eo.ToManyEntityClient( WOGWTServerUtil.eoToDictionary(this) ); 
  }
  
  public WOGWTClientEO toClientEO(List<String> relationshipsToSerialize) {
	  NSMutableDictionary data = WOGWTServerUtil.eoToDictionary(this).mutableClone();
	  
	  for (int i = 0; i < relationshipsToSerialize.size(); i++) { 
		String keyPath = relationshipsToSerialize.get(i);
		Object value = valueForKey(keyPath);
		
		if (value != null && value instanceof NSArray) {
			
			NSArray objects = (NSArray)value;
			List result = new ArrayList();
			for (int j = 0; j < objects.count(); j++) {
				WOGWTServerEO eo = (WOGWTServerEO)objects.objectAtIndex(j);
				result.add(eo.toClientEO());
			}
			data.setObjectForKey(result, keyPath);
			
		} else if (value != null && value instanceof EOEnterpriseObject) {
			WOGWTServerEO serverEO = (WOGWTServerEO)value;
			data.setObjectForKey(serverEO.toClientEO(), keyPath);
		}
		
	  }
	  
	  your.app.gwt.eo.ToManyEntityClient rec = new your.app.gwt.eo.ToManyEntityClient( data ); 
	  return rec;
  }
  
}
