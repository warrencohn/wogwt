// $LastChangedRevision: 4733 $ DO NOT EDIT.  Make changes to RootEntity.java instead.
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
public abstract class _RootEntity extends  ERXGenericRecord implements WOGWTServerEO {
  public static final String ENTITY_NAME = "RootEntity";

  // Attribute Keys
  public static final ERXKey<BigDecimal> A_BIG_DECIMAL = new ERXKey<BigDecimal>("aBigDecimal");
  public static final ERXKey<Boolean> A_BOOLEAN = new ERXKey<Boolean>("aBoolean");
  public static final ERXKey<NSTimestamp> A_DATE = new ERXKey<NSTimestamp>("aDate");
  public static final ERXKey<Integer> AN_INT = new ERXKey<Integer>("anInt");
  public static final ERXKey<String> A_STRING = new ERXKey<String>("aString");
  // Relationship Keys
  public static final ERXKey<your.app.eo.ToManyEntity> TO_MANY_ENTITIES = new ERXKey<your.app.eo.ToManyEntity>("toManyEntities");
  public static final ERXKey<your.app.eo.ToOneEntity> TO_ONE_ENTITY = new ERXKey<your.app.eo.ToOneEntity>("toOneEntity");

  // Attributes
  public static final String A_BIG_DECIMAL_KEY = A_BIG_DECIMAL.key();
  public static final String A_BOOLEAN_KEY = A_BOOLEAN.key();
  public static final String A_DATE_KEY = A_DATE.key();
  public static final String AN_INT_KEY = AN_INT.key();
  public static final String A_STRING_KEY = A_STRING.key();
  // Relationships
  public static final String TO_MANY_ENTITIES_KEY = TO_MANY_ENTITIES.key();
  public static final String TO_ONE_ENTITY_KEY = TO_ONE_ENTITY.key();

  private static Logger LOG = Logger.getLogger(_RootEntity.class);

  public RootEntity localInstanceIn(EOEditingContext editingContext) {
    RootEntity localInstance = (RootEntity)EOUtilities.localInstanceOfObject(editingContext, this);
    if (localInstance == null) {
      throw new IllegalStateException("You attempted to localInstance " + this + ", which has not yet committed.");
    }
    return localInstance;
  }

  public BigDecimal aBigDecimal() {
    return (BigDecimal) storedValueForKey("aBigDecimal");
  }

  public void setABigDecimal(BigDecimal value) {
    if (_RootEntity.LOG.isDebugEnabled()) {
    	_RootEntity.LOG.debug( "updating aBigDecimal from " + aBigDecimal() + " to " + value);
    }
    takeStoredValueForKey(value, "aBigDecimal");
  }

  public Boolean aBoolean() {
    return (Boolean) storedValueForKey("aBoolean");
  }

  public void setABoolean(Boolean value) {
    if (_RootEntity.LOG.isDebugEnabled()) {
    	_RootEntity.LOG.debug( "updating aBoolean from " + aBoolean() + " to " + value);
    }
    takeStoredValueForKey(value, "aBoolean");
  }

  public NSTimestamp aDate() {
    return (NSTimestamp) storedValueForKey("aDate");
  }

  public void setADate(NSTimestamp value) {
    if (_RootEntity.LOG.isDebugEnabled()) {
    	_RootEntity.LOG.debug( "updating aDate from " + aDate() + " to " + value);
    }
    takeStoredValueForKey(value, "aDate");
  }

  public Integer anInt() {
    return (Integer) storedValueForKey("anInt");
  }

  public void setAnInt(Integer value) {
    if (_RootEntity.LOG.isDebugEnabled()) {
    	_RootEntity.LOG.debug( "updating anInt from " + anInt() + " to " + value);
    }
    takeStoredValueForKey(value, "anInt");
  }

  public String aString() {
    return (String) storedValueForKey("aString");
  }

  public void setAString(String value) {
    if (_RootEntity.LOG.isDebugEnabled()) {
    	_RootEntity.LOG.debug( "updating aString from " + aString() + " to " + value);
    }
    takeStoredValueForKey(value, "aString");
  }

  public your.app.eo.ToOneEntity toOneEntity() {
    return (your.app.eo.ToOneEntity)storedValueForKey("toOneEntity");
  }
  
  public void setToOneEntity(your.app.eo.ToOneEntity value) {
    takeStoredValueForKey(value, "toOneEntity");
  }

  public void setToOneEntityRelationship(your.app.eo.ToOneEntity value) {
    if (_RootEntity.LOG.isDebugEnabled()) {
      _RootEntity.LOG.debug("updating toOneEntity from " + toOneEntity() + " to " + value);
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	setToOneEntity(value);
    }
    else if (value == null) {
    	your.app.eo.ToOneEntity oldValue = toOneEntity();
    	if (oldValue != null) {
    		removeObjectFromBothSidesOfRelationshipWithKey(oldValue, "toOneEntity");
      }
    } else {
    	addObjectToBothSidesOfRelationshipWithKey(value, "toOneEntity");
    }
  }
  
  public NSArray<your.app.eo.ToManyEntity> toManyEntities() {
    return (NSArray<your.app.eo.ToManyEntity>)storedValueForKey("toManyEntities");
  }

  public NSArray<your.app.eo.ToManyEntity> toManyEntities(EOQualifier qualifier) {
    return toManyEntities(qualifier, null, false);
  }

  public NSArray<your.app.eo.ToManyEntity> toManyEntities(EOQualifier qualifier, boolean fetch) {
    return toManyEntities(qualifier, null, fetch);
  }

  public NSArray<your.app.eo.ToManyEntity> toManyEntities(EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings, boolean fetch) {
    NSArray<your.app.eo.ToManyEntity> results;
    if (fetch) {
      EOQualifier fullQualifier;
      EOQualifier inverseQualifier = new EOKeyValueQualifier(your.app.eo.ToManyEntity.ROOT_ENTITY_KEY, EOQualifier.QualifierOperatorEqual, this);
    	
      if (qualifier == null) {
        fullQualifier = inverseQualifier;
      }
      else {
        NSMutableArray qualifiers = new NSMutableArray();
        qualifiers.addObject(qualifier);
        qualifiers.addObject(inverseQualifier);
        fullQualifier = new EOAndQualifier(qualifiers);
      }

      results = your.app.eo.ToManyEntity.fetchToManyEntities(editingContext(), fullQualifier, sortOrderings);
    }
    else {
      results = toManyEntities();
      if (qualifier != null) {
        results = (NSArray<your.app.eo.ToManyEntity>)EOQualifier.filteredArrayWithQualifier(results, qualifier);
      }
      if (sortOrderings != null) {
        results = (NSArray<your.app.eo.ToManyEntity>)EOSortOrdering.sortedArrayUsingKeyOrderArray(results, sortOrderings);
      }
    }
    return results;
  }
  
  public void addToToManyEntities(your.app.eo.ToManyEntity object) {
    includeObjectIntoPropertyWithKey(object, "toManyEntities");
  }

  public void removeFromToManyEntities(your.app.eo.ToManyEntity object) {
    excludeObjectFromPropertyWithKey(object, "toManyEntities");
  }

  public void addToToManyEntitiesRelationship(your.app.eo.ToManyEntity object) {
    if (_RootEntity.LOG.isDebugEnabled()) {
      _RootEntity.LOG.debug("adding " + object + " to toManyEntities relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	addToToManyEntities(object);
    }
    else {
    	addObjectToBothSidesOfRelationshipWithKey(object, "toManyEntities");
    }
  }

  public void removeFromToManyEntitiesRelationship(your.app.eo.ToManyEntity object) {
    if (_RootEntity.LOG.isDebugEnabled()) {
      _RootEntity.LOG.debug("removing " + object + " from toManyEntities relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	removeFromToManyEntities(object);
    }
    else {
    	removeObjectFromBothSidesOfRelationshipWithKey(object, "toManyEntities");
    }
  }

  public your.app.eo.ToManyEntity createToManyEntitiesRelationship() {
    EOClassDescription eoClassDesc = EOClassDescription.classDescriptionForEntityName("ToManyEntity");
    EOEnterpriseObject eo = eoClassDesc.createInstanceWithEditingContext(editingContext(), null);
    editingContext().insertObject(eo);
    addObjectToBothSidesOfRelationshipWithKey(eo, "toManyEntities");
    return (your.app.eo.ToManyEntity) eo;
  }

  public void deleteToManyEntitiesRelationship(your.app.eo.ToManyEntity object) {
    removeObjectFromBothSidesOfRelationshipWithKey(object, "toManyEntities");
    editingContext().deleteObject(object);
  }

  public void deleteAllToManyEntitiesRelationships() {
    Enumeration objects = toManyEntities().immutableClone().objectEnumerator();
    while (objects.hasMoreElements()) {
      deleteToManyEntitiesRelationship((your.app.eo.ToManyEntity)objects.nextElement());
    }
  }


  public static RootEntity createRootEntity(EOEditingContext editingContext) {
    RootEntity eo = (RootEntity) EOUtilities.createAndInsertInstance(editingContext, _RootEntity.ENTITY_NAME);    
    return eo;
  }

  public static NSArray<RootEntity> fetchAllRootEntities(EOEditingContext editingContext) {
    return _RootEntity.fetchAllRootEntities(editingContext, null);
  }

  public static NSArray<RootEntity> fetchAllRootEntities(EOEditingContext editingContext, NSArray<EOSortOrdering> sortOrderings) {
    return _RootEntity.fetchRootEntities(editingContext, null, sortOrderings);
  }

  public static NSArray<RootEntity> fetchRootEntities(EOEditingContext editingContext, EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings) {
    EOFetchSpecification fetchSpec = new EOFetchSpecification(_RootEntity.ENTITY_NAME, qualifier, sortOrderings);
    fetchSpec.setIsDeep(true);
    NSArray<RootEntity> eoObjects = (NSArray<RootEntity>)editingContext.objectsWithFetchSpecification(fetchSpec);
    return eoObjects;
  }

  public static RootEntity fetchRootEntity(EOEditingContext editingContext, String keyName, Object value) {
    return _RootEntity.fetchRootEntity(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static RootEntity fetchRootEntity(EOEditingContext editingContext, EOQualifier qualifier) {
    NSArray<RootEntity> eoObjects = _RootEntity.fetchRootEntities(editingContext, qualifier, null);
    RootEntity eoObject;
    int count = eoObjects.count();
    if (count == 0) {
      eoObject = null;
    }
    else if (count == 1) {
      eoObject = (RootEntity)eoObjects.objectAtIndex(0);
    }
    else {
      throw new IllegalStateException("There was more than one RootEntity that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static RootEntity fetchRequiredRootEntity(EOEditingContext editingContext, String keyName, Object value) {
    return _RootEntity.fetchRequiredRootEntity(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static RootEntity fetchRequiredRootEntity(EOEditingContext editingContext, EOQualifier qualifier) {
    RootEntity eoObject = _RootEntity.fetchRootEntity(editingContext, qualifier);
    if (eoObject == null) {
      throw new NoSuchElementException("There was no RootEntity that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static RootEntity localInstanceIn(EOEditingContext editingContext, RootEntity eo) {
    RootEntity localInstance = (eo == null) ? null : (RootEntity)EOUtilities.localInstanceOfObject(editingContext, eo);
    if (localInstance == null && eo != null) {
      throw new IllegalStateException("You attempted to localInstance " + eo + ", which has not yet committed.");
    }
    return localInstance;
  }

  public WOGWTClientEO toClientEO() {
    return new your.app.gwt.eo.RootEntityClient( WOGWTServerUtil.eoToDictionary(this) ); 
  }

  public WOGWTClientEO toClientEO(List<String> relationshipsToSerialize) {
    NSMutableDictionary data = WOGWTServerUtil.eoToDictionary(this).mutableClone();
	data.addEntriesFromDictionary(
			WOGWTServerUtil.relationshipsToClientEOs(this, relationshipsToSerialize));
    your.app.gwt.eo.RootEntityClient rec = new your.app.gwt.eo.RootEntityClient( data ); 
    return rec;
  }

}
