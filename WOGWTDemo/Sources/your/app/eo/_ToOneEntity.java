// $LastChangedRevision: 4733 $ DO NOT EDIT.  Make changes to ToOneEntity.java instead.
package your.app.eo;

import com.webobjects.eoaccess.*;
import com.webobjects.eocontrol.*;
import com.webobjects.foundation.*;
import java.math.*;
import java.util.*;
import org.apache.log4j.Logger;

import er.extensions.eof.*;
import er.extensions.foundation.*;

import wogwt.translatable.rpc.WOGWTClientEO;
import wogwt.server.rpc.WOGWTServerEO;
import wogwt.WOGWTServerUtil;

// This class can only be used on the server-side
@SuppressWarnings("all")
public abstract class _ToOneEntity extends  ERXGenericRecord implements WOGWTServerEO {
  public static final String ENTITY_NAME = "ToOneEntity";

  // Attribute Keys
  public static final ERXKey<String> NAME = new ERXKey<String>("name");
  // Relationship Keys
  public static final ERXKey<your.app.eo.RootEntity> ROOT_ENTITIES = new ERXKey<your.app.eo.RootEntity>("rootEntities");

  // Attributes
  public static final String NAME_KEY = NAME.key();
  // Relationships
  public static final String ROOT_ENTITIES_KEY = ROOT_ENTITIES.key();

  private static Logger LOG = Logger.getLogger(_ToOneEntity.class);

  public ToOneEntity localInstanceIn(EOEditingContext editingContext) {
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

  public NSArray<your.app.eo.RootEntity> rootEntities() {
    return (NSArray<your.app.eo.RootEntity>)storedValueForKey("rootEntities");
  }

  public NSArray<your.app.eo.RootEntity> rootEntities(EOQualifier qualifier) {
    return rootEntities(qualifier, null, false);
  }

  public NSArray<your.app.eo.RootEntity> rootEntities(EOQualifier qualifier, boolean fetch) {
    return rootEntities(qualifier, null, fetch);
  }

  public NSArray<your.app.eo.RootEntity> rootEntities(EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings, boolean fetch) {
    NSArray<your.app.eo.RootEntity> results;
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
        results = (NSArray<your.app.eo.RootEntity>)EOQualifier.filteredArrayWithQualifier(results, qualifier);
      }
      if (sortOrderings != null) {
        results = (NSArray<your.app.eo.RootEntity>)EOSortOrdering.sortedArrayUsingKeyOrderArray(results, sortOrderings);
      }
    }
    return results;
  }
  
  public void addToRootEntities(your.app.eo.RootEntity object) {
    includeObjectIntoPropertyWithKey(object, "rootEntities");
  }

  public void removeFromRootEntities(your.app.eo.RootEntity object) {
    excludeObjectFromPropertyWithKey(object, "rootEntities");
  }

  public void addToRootEntitiesRelationship(your.app.eo.RootEntity object) {
    if (_ToOneEntity.LOG.isDebugEnabled()) {
      _ToOneEntity.LOG.debug("adding " + object + " to rootEntities relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	addToRootEntities(object);
    }
    else {
    	addObjectToBothSidesOfRelationshipWithKey(object, "rootEntities");
    }
  }

  public void removeFromRootEntitiesRelationship(your.app.eo.RootEntity object) {
    if (_ToOneEntity.LOG.isDebugEnabled()) {
      _ToOneEntity.LOG.debug("removing " + object + " from rootEntities relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	removeFromRootEntities(object);
    }
    else {
    	removeObjectFromBothSidesOfRelationshipWithKey(object, "rootEntities");
    }
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
    ToOneEntity eo = (ToOneEntity) EOUtilities.createAndInsertInstance(editingContext, _ToOneEntity.ENTITY_NAME);    
		eo.setName(name);
    return eo;
  }

  public static NSArray<ToOneEntity> fetchAllToOneEntities(EOEditingContext editingContext) {
    return _ToOneEntity.fetchAllToOneEntities(editingContext, null);
  }

  public static NSArray<ToOneEntity> fetchAllToOneEntities(EOEditingContext editingContext, NSArray<EOSortOrdering> sortOrderings) {
    return _ToOneEntity.fetchToOneEntities(editingContext, null, sortOrderings);
  }

  public static NSArray<ToOneEntity> fetchToOneEntities(EOEditingContext editingContext, EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings) {
    EOFetchSpecification fetchSpec = new EOFetchSpecification(_ToOneEntity.ENTITY_NAME, qualifier, sortOrderings);
    fetchSpec.setIsDeep(true);
    NSArray<ToOneEntity> eoObjects = (NSArray<ToOneEntity>)editingContext.objectsWithFetchSpecification(fetchSpec);
    return eoObjects;
  }

  public static ToOneEntity fetchToOneEntity(EOEditingContext editingContext, String keyName, Object value) {
    return _ToOneEntity.fetchToOneEntity(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static ToOneEntity fetchToOneEntity(EOEditingContext editingContext, EOQualifier qualifier) {
    NSArray<ToOneEntity> eoObjects = _ToOneEntity.fetchToOneEntities(editingContext, qualifier, null);
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

  public static ToOneEntity localInstanceIn(EOEditingContext editingContext, ToOneEntity eo) {
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
	data.addEntriesFromDictionary(
			WOGWTServerUtil.relationshipsToClientEOs(this, relationshipsToSerialize));
    your.app.gwt.eo.ToOneEntityClient rec = new your.app.gwt.eo.ToOneEntityClient( data ); 
    return rec;
  }

}
