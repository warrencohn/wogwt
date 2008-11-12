// DO NOT EDIT.  Make changes to RootEntity.java instead.
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
public abstract class _RootEntity extends  EOGenericRecord implements WOGWTServerEO {
	public static final String ENTITY_NAME = "RootEntity";

	// Attributes
	public static final String A_BIG_DECIMAL_KEY = "aBigDecimal";
	public static final String A_BOOLEAN_KEY = "aBoolean";
	public static final String A_DATE_KEY = "aDate";
	public static final String AN_INT_KEY = "anInt";
	public static final String A_STRING_KEY = "aString";

	// Relationships
	public static final String TO_MANY_ENTITY_OBJECTS_KEY = "toManyEntityObjects";
	public static final String TO_ONE_ENTITY_KEY = "toOneEntity";

  private static Logger LOG = Logger.getLogger(_RootEntity.class);

  public RootEntity localInstanceOfRootEntity(EOEditingContext editingContext) {
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

  public void setToOneEntityRelationship(your.app.eo.ToOneEntity value) {
    if (_RootEntity.LOG.isDebugEnabled()) {
      _RootEntity.LOG.debug("updating toOneEntity from " + toOneEntity() + " to " + value);
    }
    if (value == null) {
    	your.app.eo.ToOneEntity oldValue = toOneEntity();
    	if (oldValue != null) {
    		removeObjectFromBothSidesOfRelationshipWithKey(oldValue, "toOneEntity");
      }
    } else {
    	addObjectToBothSidesOfRelationshipWithKey(value, "toOneEntity");
    }
  }
  
  public NSArray toManyEntityObjects() {
    return (NSArray)storedValueForKey("toManyEntityObjects");
  }

  public NSArray toManyEntityObjects(EOQualifier qualifier) {
    return toManyEntityObjects(qualifier, null, false);
  }

  public NSArray toManyEntityObjects(EOQualifier qualifier, boolean fetch) {
    return toManyEntityObjects(qualifier, null, fetch);
  }

  public NSArray toManyEntityObjects(EOQualifier qualifier, NSArray sortOrderings, boolean fetch) {
    NSArray results;
    if (fetch) {
      EOQualifier fullQualifier;
      EOQualifier inverseQualifier = new EOKeyValueQualifier(your.app.eo.ToManyEntity.ROOT_ENTITY_OBJECT_KEY, EOQualifier.QualifierOperatorEqual, this);
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
      results = toManyEntityObjects();
      if (qualifier != null) {
        results = (NSArray)EOQualifier.filteredArrayWithQualifier(results, qualifier);
      }
      if (sortOrderings != null) {
        results = (NSArray)EOSortOrdering.sortedArrayUsingKeyOrderArray(results, sortOrderings);
      }
    }
    return results;
  }
  
  public void addToToManyEntityObjectsRelationship(your.app.eo.ToManyEntity object) {
    if (_RootEntity.LOG.isDebugEnabled()) {
      _RootEntity.LOG.debug("adding " + object + " to toManyEntityObjects relationship");
    }
    addObjectToBothSidesOfRelationshipWithKey(object, "toManyEntityObjects");
  }

  public void removeFromToManyEntityObjectsRelationship(your.app.eo.ToManyEntity object) {
    if (_RootEntity.LOG.isDebugEnabled()) {
      _RootEntity.LOG.debug("removing " + object + " from toManyEntityObjects relationship");
    }
    removeObjectFromBothSidesOfRelationshipWithKey(object, "toManyEntityObjects");
  }

  public your.app.eo.ToManyEntity createToManyEntityObjectsRelationship() {
    EOClassDescription eoClassDesc = EOClassDescription.classDescriptionForEntityName("ToManyEntity");
    EOEnterpriseObject eo = eoClassDesc.createInstanceWithEditingContext(editingContext(), null);
    editingContext().insertObject(eo);
    addObjectToBothSidesOfRelationshipWithKey(eo, "toManyEntityObjects");
    return (your.app.eo.ToManyEntity) eo;
  }

  public void deleteToManyEntityObjectsRelationship(your.app.eo.ToManyEntity object) {
    removeObjectFromBothSidesOfRelationshipWithKey(object, "toManyEntityObjects");
    editingContext().deleteObject(object);
  }

  public void deleteAllToManyEntityObjectsRelationships() {
    Enumeration objects = toManyEntityObjects().immutableClone().objectEnumerator();
    while (objects.hasMoreElements()) {
      deleteToManyEntityObjectsRelationship((your.app.eo.ToManyEntity)objects.nextElement());
    }
  }

  public static RootEntity createRootEntity(EOEditingContext editingContext) {
    RootEntity eo = (RootEntity)EOUtilities.createAndInsertInstance(editingContext, _RootEntity.ENTITY_NAME);
    return eo;
  }

  public static NSArray fetchAllRootEntities(EOEditingContext editingContext) {
    return _RootEntity.fetchAllRootEntities(editingContext, null);
  }

  public static NSArray fetchAllRootEntities(EOEditingContext editingContext, NSArray sortOrderings) {
    return _RootEntity.fetchRootEntities(editingContext, null, sortOrderings);
  }

  public static NSArray fetchRootEntities(EOEditingContext editingContext, EOQualifier qualifier, NSArray sortOrderings) {
    EOFetchSpecification fetchSpec = new EOFetchSpecification(_RootEntity.ENTITY_NAME, qualifier, sortOrderings);
    fetchSpec.setIsDeep(true);
    NSArray eoObjects = (NSArray)editingContext.objectsWithFetchSpecification(fetchSpec);
    return eoObjects;
  }

  public static RootEntity fetchRootEntity(EOEditingContext editingContext, String keyName, Object value) {
    return _RootEntity.fetchRootEntity(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static RootEntity fetchRootEntity(EOEditingContext editingContext, EOQualifier qualifier) {
    NSArray eoObjects = _RootEntity.fetchRootEntities(editingContext, qualifier, null);
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

  public static RootEntity localInstanceOfRootEntity(EOEditingContext editingContext, RootEntity eo) {
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
	  
	  your.app.gwt.eo.RootEntityClient rec = new your.app.gwt.eo.RootEntityClient( data ); 
	  return rec;
  }
  
}
