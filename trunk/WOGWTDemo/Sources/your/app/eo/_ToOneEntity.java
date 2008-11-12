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
import wogwt.WOGWTServerUtil;

// This class can only be used on the server-side
public abstract class _ToOneEntity extends  EOGenericRecord implements WOGWTServerEO {
	public static final String ENTITY_NAME = "ToOneEntity";

	// Attributes
	public static final String NAME_KEY = "name";

	// Relationships
	public static final String ROOT_ENTITIES_KEY = "rootEntities";

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

  public NSArray rootEntities() {
    return (NSArray)storedValueForKey("rootEntities");
  }

  public NSArray rootEntities(EOQualifier qualifier) {
    return rootEntities(qualifier, null, false);
  }

  public NSArray rootEntities(EOQualifier qualifier, boolean fetch) {
    return rootEntities(qualifier, null, fetch);
  }

  public NSArray rootEntities(EOQualifier qualifier, NSArray sortOrderings, boolean fetch) {
    NSArray results;
    if (fetch) {
      EOQualifier fullQualifier;
      EOQualifier inverseQualifier = new EOKeyValueQualifier(your.app.eo.RootEntity.TO_ONE_ENTITY_KEY, EOQualifier.QualifierOperatorEqual, this);
      if (qualifier == null) {
        fullQualifier = inverseQualifier;
      }
      else {
        NSMutableArray qualifiers = new NSMutableArray();
        qualifiers.addObject(qualifier);
        qualifiers.addObject(inverseQualifier);
        fullQualifier = new EOAndQualifier(qualifiers);
      }
      results = your.app.eo.RootEntity.fetchRootEntities(editingContext(), fullQualifier, sortOrderings);
    }
    else {
      results = rootEntities();
      if (qualifier != null) {
        results = (NSArray)EOQualifier.filteredArrayWithQualifier(results, qualifier);
      }
      if (sortOrderings != null) {
        results = (NSArray)EOSortOrdering.sortedArrayUsingKeyOrderArray(results, sortOrderings);
      }
    }
    return results;
  }
  
  public void addToRootEntitiesRelationship(your.app.eo.RootEntity object) {
    if (_ToOneEntity.LOG.isDebugEnabled()) {
      _ToOneEntity.LOG.debug("adding " + object + " to rootEntities relationship");
    }
    addObjectToBothSidesOfRelationshipWithKey(object, "rootEntities");
  }

  public void removeFromRootEntitiesRelationship(your.app.eo.RootEntity object) {
    if (_ToOneEntity.LOG.isDebugEnabled()) {
      _ToOneEntity.LOG.debug("removing " + object + " from rootEntities relationship");
    }
    removeObjectFromBothSidesOfRelationshipWithKey(object, "rootEntities");
  }

  public your.app.eo.RootEntity createRootEntitiesRelationship() {
    EOClassDescription eoClassDesc = EOClassDescription.classDescriptionForEntityName("RootEntity");
    EOEnterpriseObject eo = eoClassDesc.createInstanceWithEditingContext(editingContext(), null);
    editingContext().insertObject(eo);
    addObjectToBothSidesOfRelationshipWithKey(eo, "rootEntities");
    return (your.app.eo.RootEntity) eo;
  }

  public void deleteRootEntitiesRelationship(your.app.eo.RootEntity object) {
    removeObjectFromBothSidesOfRelationshipWithKey(object, "rootEntities");
    editingContext().deleteObject(object);
  }

  public void deleteAllRootEntitiesRelationships() {
    Enumeration objects = rootEntities().immutableClone().objectEnumerator();
    while (objects.hasMoreElements()) {
      deleteRootEntitiesRelationship((your.app.eo.RootEntity)objects.nextElement());
    }
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
	  return new your.app.gwt.eo.ToOneEntityClient( WOGWTServerUtil.eoToDictionary(this) ); 
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
	  
	  your.app.gwt.eo.ToOneEntityClient rec = new your.app.gwt.eo.ToOneEntityClient( data ); 
	  return rec;
  }
  
}
