// $LastChangedRevision: 4733 $ DO NOT EDIT.  Make changes to ToManyEntity.java instead.
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
public abstract class _ToManyEntity extends  ERXGenericRecord implements WOGWTServerEO {
  public static final String ENTITY_NAME = "ToManyEntity";

  // Attribute Keys
  public static final ERXKey<String> NAME = new ERXKey<String>("name");
  // Relationship Keys
  public static final ERXKey<your.app.eo.RootEntity> ROOT_ENTITY = new ERXKey<your.app.eo.RootEntity>("rootEntity");

  // Attributes
  public static final String NAME_KEY = NAME.key();
  // Relationships
  public static final String ROOT_ENTITY_KEY = ROOT_ENTITY.key();

  private static Logger LOG = Logger.getLogger(_ToManyEntity.class);

  public ToManyEntity localInstanceIn(EOEditingContext editingContext) {
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

  public your.app.eo.RootEntity rootEntity() {
    return (your.app.eo.RootEntity)storedValueForKey("rootEntity");
  }
  
  public void setRootEntity(your.app.eo.RootEntity value) {
    takeStoredValueForKey(value, "rootEntity");
  }

  public void setRootEntityRelationship(your.app.eo.RootEntity value) {
    if (_ToManyEntity.LOG.isDebugEnabled()) {
      _ToManyEntity.LOG.debug("updating rootEntity from " + rootEntity() + " to " + value);
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	setRootEntity(value);
    }
    else if (value == null) {
    	your.app.eo.RootEntity oldValue = rootEntity();
    	if (oldValue != null) {
    		removeObjectFromBothSidesOfRelationshipWithKey(oldValue, "rootEntity");
      }
    } else {
    	addObjectToBothSidesOfRelationshipWithKey(value, "rootEntity");
    }
  }
  

  public static ToManyEntity createToManyEntity(EOEditingContext editingContext, String name
, your.app.eo.RootEntity rootEntity) {
    ToManyEntity eo = (ToManyEntity) EOUtilities.createAndInsertInstance(editingContext, _ToManyEntity.ENTITY_NAME);    
		eo.setName(name);
    eo.setRootEntityRelationship(rootEntity);
    return eo;
  }

  public static NSArray<ToManyEntity> fetchAllToManyEntities(EOEditingContext editingContext) {
    return _ToManyEntity.fetchAllToManyEntities(editingContext, null);
  }

  public static NSArray<ToManyEntity> fetchAllToManyEntities(EOEditingContext editingContext, NSArray<EOSortOrdering> sortOrderings) {
    return _ToManyEntity.fetchToManyEntities(editingContext, null, sortOrderings);
  }

  public static NSArray<ToManyEntity> fetchToManyEntities(EOEditingContext editingContext, EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings) {
    EOFetchSpecification fetchSpec = new EOFetchSpecification(_ToManyEntity.ENTITY_NAME, qualifier, sortOrderings);
    fetchSpec.setIsDeep(true);
    NSArray<ToManyEntity> eoObjects = (NSArray<ToManyEntity>)editingContext.objectsWithFetchSpecification(fetchSpec);
    return eoObjects;
  }

  public static ToManyEntity fetchToManyEntity(EOEditingContext editingContext, String keyName, Object value) {
    return _ToManyEntity.fetchToManyEntity(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static ToManyEntity fetchToManyEntity(EOEditingContext editingContext, EOQualifier qualifier) {
    NSArray<ToManyEntity> eoObjects = _ToManyEntity.fetchToManyEntities(editingContext, qualifier, null);
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

  public static ToManyEntity localInstanceIn(EOEditingContext editingContext, ToManyEntity eo) {
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
	data.addEntriesFromDictionary(
			WOGWTServerUtil.relationshipsToClientEOs(this, relationshipsToSerialize));
    your.app.gwt.eo.ToManyEntityClient rec = new your.app.gwt.eo.ToManyEntityClient( data ); 
    return rec;
  }

}
