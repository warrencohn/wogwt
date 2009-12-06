// $LastChangedRevision: 4733 $ DO NOT EDIT.  Make changes to TalentPhoto.java instead.
package your.app.server.eo;

import java.util.List;
import java.util.NoSuchElementException;

import org.apache.log4j.Logger;

import wogwt.WOGWTServerUtil;
import wogwt.server.rpc.WOGWTServerEO;
import wogwt.translatable.rpc.WOGWTClientEO;

import com.webobjects.eoaccess.EOUtilities;
import com.webobjects.eocontrol.EOEditingContext;
import com.webobjects.eocontrol.EOFetchSpecification;
import com.webobjects.eocontrol.EOKeyValueQualifier;
import com.webobjects.eocontrol.EOQualifier;
import com.webobjects.eocontrol.EOSortOrdering;
import com.webobjects.foundation.NSArray;
import com.webobjects.foundation.NSMutableDictionary;

import er.extensions.eof.ERXGenericRecord;
import er.extensions.eof.ERXKey;

// This class can only be used on the server-side
@SuppressWarnings("all")
public abstract class _TalentPhoto extends  ERXGenericRecord implements WOGWTServerEO {
  public static final String ENTITY_NAME = "TalentPhoto";

  // Attribute Keys
  // Relationship Keys
  public static final ERXKey<your.app.server.eo.Talent> TALENT = new ERXKey<your.app.server.eo.Talent>("talent");

  // Attributes
  // Relationships
  public static final String TALENT_KEY = TALENT.key();

  private static Logger LOG = Logger.getLogger(_TalentPhoto.class);

  public TalentPhoto localInstanceIn(EOEditingContext editingContext) {
    TalentPhoto localInstance = (TalentPhoto)EOUtilities.localInstanceOfObject(editingContext, this);
    if (localInstance == null) {
      throw new IllegalStateException("You attempted to localInstance " + this + ", which has not yet committed.");
    }
    return localInstance;
  }

  public your.app.server.eo.Talent talent() {
    return (your.app.server.eo.Talent)storedValueForKey("talent");
  }
  
  public void setTalent(your.app.server.eo.Talent value) {
    takeStoredValueForKey(value, "talent");
  }

  public void setTalentRelationship(your.app.server.eo.Talent value) {
    if (_TalentPhoto.LOG.isDebugEnabled()) {
      _TalentPhoto.LOG.debug("updating talent from " + talent() + " to " + value);
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	setTalent(value);
    }
    else if (value == null) {
    	your.app.server.eo.Talent oldValue = talent();
    	if (oldValue != null) {
    		removeObjectFromBothSidesOfRelationshipWithKey(oldValue, "talent");
      }
    } else {
    	addObjectToBothSidesOfRelationshipWithKey(value, "talent");
    }
  }
  

  public static TalentPhoto createTalentPhoto(EOEditingContext editingContext, your.app.server.eo.Talent talent) {
    TalentPhoto eo = (TalentPhoto) EOUtilities.createAndInsertInstance(editingContext, _TalentPhoto.ENTITY_NAME);    
    eo.setTalentRelationship(talent);
    return eo;
  }

  public static NSArray<TalentPhoto> fetchAllTalentPhotos(EOEditingContext editingContext) {
    return _TalentPhoto.fetchAllTalentPhotos(editingContext, null);
  }

  public static NSArray<TalentPhoto> fetchAllTalentPhotos(EOEditingContext editingContext, NSArray<EOSortOrdering> sortOrderings) {
    return _TalentPhoto.fetchTalentPhotos(editingContext, null, sortOrderings);
  }

  public static NSArray<TalentPhoto> fetchTalentPhotos(EOEditingContext editingContext, EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings) {
    EOFetchSpecification fetchSpec = new EOFetchSpecification(_TalentPhoto.ENTITY_NAME, qualifier, sortOrderings);
    fetchSpec.setIsDeep(true);
    NSArray<TalentPhoto> eoObjects = (NSArray<TalentPhoto>)editingContext.objectsWithFetchSpecification(fetchSpec);
    return eoObjects;
  }

  public static TalentPhoto fetchTalentPhoto(EOEditingContext editingContext, String keyName, Object value) {
    return _TalentPhoto.fetchTalentPhoto(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static TalentPhoto fetchTalentPhoto(EOEditingContext editingContext, EOQualifier qualifier) {
    NSArray<TalentPhoto> eoObjects = _TalentPhoto.fetchTalentPhotos(editingContext, qualifier, null);
    TalentPhoto eoObject;
    int count = eoObjects.count();
    if (count == 0) {
      eoObject = null;
    }
    else if (count == 1) {
      eoObject = (TalentPhoto)eoObjects.objectAtIndex(0);
    }
    else {
      throw new IllegalStateException("There was more than one TalentPhoto that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static TalentPhoto fetchRequiredTalentPhoto(EOEditingContext editingContext, String keyName, Object value) {
    return _TalentPhoto.fetchRequiredTalentPhoto(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static TalentPhoto fetchRequiredTalentPhoto(EOEditingContext editingContext, EOQualifier qualifier) {
    TalentPhoto eoObject = _TalentPhoto.fetchTalentPhoto(editingContext, qualifier);
    if (eoObject == null) {
      throw new NoSuchElementException("There was no TalentPhoto that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static TalentPhoto localInstanceIn(EOEditingContext editingContext, TalentPhoto eo) {
    TalentPhoto localInstance = (eo == null) ? null : (TalentPhoto)EOUtilities.localInstanceOfObject(editingContext, eo);
    if (localInstance == null && eo != null) {
      throw new IllegalStateException("You attempted to localInstance " + eo + ", which has not yet committed.");
    }
    return localInstance;
  }

  public WOGWTClientEO toClientEO() {
    return new your.app.gwt.eo.TalentPhotoClient( WOGWTServerUtil.eoToDictionary(this) ); 
  }

  public WOGWTClientEO toClientEO(List<String> relatedKeyPathsToSerialize) {
    NSMutableDictionary data = WOGWTServerUtil.eoToDictionary(this).mutableClone();
	data.addEntriesFromDictionary(
			WOGWTServerUtil._keyPathsToClientEOs(this, relatedKeyPathsToSerialize));
    your.app.gwt.eo.TalentPhotoClient rec = new your.app.gwt.eo.TalentPhotoClient( data ); 
    return rec;
  }

}
