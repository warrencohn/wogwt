// $LastChangedRevision: 4733 $ DO NOT EDIT.  Make changes to Talent.java instead.
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
public abstract class _Talent extends  ERXGenericRecord implements WOGWTServerEO {
  public static final String ENTITY_NAME = "Talent";

  // Attribute Keys
  public static final ERXKey<String> FIRST_NAME = new ERXKey<String>("firstName");
  public static final ERXKey<String> LAST_NAME = new ERXKey<String>("lastName");
  // Relationship Keys
  public static final ERXKey<your.app.eo.Movie> MOVIES_DIRECTED = new ERXKey<your.app.eo.Movie>("moviesDirected");
  public static final ERXKey<your.app.eo.TalentPhoto> PHOTO = new ERXKey<your.app.eo.TalentPhoto>("photo");
  public static final ERXKey<your.app.eo.MovieRole> ROLES = new ERXKey<your.app.eo.MovieRole>("roles");

  // Attributes
  public static final String FIRST_NAME_KEY = FIRST_NAME.key();
  public static final String LAST_NAME_KEY = LAST_NAME.key();
  // Relationships
  public static final String MOVIES_DIRECTED_KEY = MOVIES_DIRECTED.key();
  public static final String PHOTO_KEY = PHOTO.key();
  public static final String ROLES_KEY = ROLES.key();

  private static Logger LOG = Logger.getLogger(_Talent.class);

  public Talent localInstanceIn(EOEditingContext editingContext) {
    Talent localInstance = (Talent)EOUtilities.localInstanceOfObject(editingContext, this);
    if (localInstance == null) {
      throw new IllegalStateException("You attempted to localInstance " + this + ", which has not yet committed.");
    }
    return localInstance;
  }

  public String firstName() {
    return (String) storedValueForKey("firstName");
  }

  public void setFirstName(String value) {
    if (_Talent.LOG.isDebugEnabled()) {
    	_Talent.LOG.debug( "updating firstName from " + firstName() + " to " + value);
    }
    takeStoredValueForKey(value, "firstName");
  }

  public String lastName() {
    return (String) storedValueForKey("lastName");
  }

  public void setLastName(String value) {
    if (_Talent.LOG.isDebugEnabled()) {
    	_Talent.LOG.debug( "updating lastName from " + lastName() + " to " + value);
    }
    takeStoredValueForKey(value, "lastName");
  }

  public your.app.eo.TalentPhoto photo() {
    return (your.app.eo.TalentPhoto)storedValueForKey("photo");
  }
  
  public void setPhoto(your.app.eo.TalentPhoto value) {
    takeStoredValueForKey(value, "photo");
  }

  public void setPhotoRelationship(your.app.eo.TalentPhoto value) {
    if (_Talent.LOG.isDebugEnabled()) {
      _Talent.LOG.debug("updating photo from " + photo() + " to " + value);
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	setPhoto(value);
    }
    else if (value == null) {
    	your.app.eo.TalentPhoto oldValue = photo();
    	if (oldValue != null) {
    		removeObjectFromBothSidesOfRelationshipWithKey(oldValue, "photo");
      }
    } else {
    	addObjectToBothSidesOfRelationshipWithKey(value, "photo");
    }
  }
  
  public NSArray<your.app.eo.Movie> moviesDirected() {
    return (NSArray<your.app.eo.Movie>)storedValueForKey("moviesDirected");
  }

  public NSArray<your.app.eo.Movie> moviesDirected(EOQualifier qualifier) {
    return moviesDirected(qualifier, null);
  }

  public NSArray<your.app.eo.Movie> moviesDirected(EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings) {
    NSArray<your.app.eo.Movie> results;
      results = moviesDirected();
      if (qualifier != null) {
        results = (NSArray<your.app.eo.Movie>)EOQualifier.filteredArrayWithQualifier(results, qualifier);
      }
      if (sortOrderings != null) {
        results = (NSArray<your.app.eo.Movie>)EOSortOrdering.sortedArrayUsingKeyOrderArray(results, sortOrderings);
      }
    return results;
  }
  
  public void addToMoviesDirected(your.app.eo.Movie object) {
    includeObjectIntoPropertyWithKey(object, "moviesDirected");
  }

  public void removeFromMoviesDirected(your.app.eo.Movie object) {
    excludeObjectFromPropertyWithKey(object, "moviesDirected");
  }

  public void addToMoviesDirectedRelationship(your.app.eo.Movie object) {
    if (_Talent.LOG.isDebugEnabled()) {
      _Talent.LOG.debug("adding " + object + " to moviesDirected relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	addToMoviesDirected(object);
    }
    else {
    	addObjectToBothSidesOfRelationshipWithKey(object, "moviesDirected");
    }
  }

  public void removeFromMoviesDirectedRelationship(your.app.eo.Movie object) {
    if (_Talent.LOG.isDebugEnabled()) {
      _Talent.LOG.debug("removing " + object + " from moviesDirected relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	removeFromMoviesDirected(object);
    }
    else {
    	removeObjectFromBothSidesOfRelationshipWithKey(object, "moviesDirected");
    }
  }

  public your.app.eo.Movie createMoviesDirectedRelationship() {
    EOClassDescription eoClassDesc = EOClassDescription.classDescriptionForEntityName("Movie");
    EOEnterpriseObject eo = eoClassDesc.createInstanceWithEditingContext(editingContext(), null);
    editingContext().insertObject(eo);
    addObjectToBothSidesOfRelationshipWithKey(eo, "moviesDirected");
    return (your.app.eo.Movie) eo;
  }

  public void deleteMoviesDirectedRelationship(your.app.eo.Movie object) {
    removeObjectFromBothSidesOfRelationshipWithKey(object, "moviesDirected");
    editingContext().deleteObject(object);
  }

  public void deleteAllMoviesDirectedRelationships() {
    Enumeration objects = moviesDirected().immutableClone().objectEnumerator();
    while (objects.hasMoreElements()) {
      deleteMoviesDirectedRelationship((your.app.eo.Movie)objects.nextElement());
    }
  }

  public NSArray<your.app.eo.MovieRole> roles() {
    return (NSArray<your.app.eo.MovieRole>)storedValueForKey("roles");
  }

  public NSArray<your.app.eo.MovieRole> roles(EOQualifier qualifier) {
    return roles(qualifier, null, false);
  }

  public NSArray<your.app.eo.MovieRole> roles(EOQualifier qualifier, boolean fetch) {
    return roles(qualifier, null, fetch);
  }

  public NSArray<your.app.eo.MovieRole> roles(EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings, boolean fetch) {
    NSArray<your.app.eo.MovieRole> results;
    if (fetch) {
      EOQualifier fullQualifier;
      EOQualifier inverseQualifier = new EOKeyValueQualifier(your.app.eo.MovieRole.TALENT_KEY, EOQualifier.QualifierOperatorEqual, this);
    	
      if (qualifier == null) {
        fullQualifier = inverseQualifier;
      }
      else {
        NSMutableArray qualifiers = new NSMutableArray();
        qualifiers.addObject(qualifier);
        qualifiers.addObject(inverseQualifier);
        fullQualifier = new EOAndQualifier(qualifiers);
      }

      results = your.app.eo.MovieRole.fetchMovieRoles(editingContext(), fullQualifier, sortOrderings);
    }
    else {
      results = roles();
      if (qualifier != null) {
        results = (NSArray<your.app.eo.MovieRole>)EOQualifier.filteredArrayWithQualifier(results, qualifier);
      }
      if (sortOrderings != null) {
        results = (NSArray<your.app.eo.MovieRole>)EOSortOrdering.sortedArrayUsingKeyOrderArray(results, sortOrderings);
      }
    }
    return results;
  }
  
  public void addToRoles(your.app.eo.MovieRole object) {
    includeObjectIntoPropertyWithKey(object, "roles");
  }

  public void removeFromRoles(your.app.eo.MovieRole object) {
    excludeObjectFromPropertyWithKey(object, "roles");
  }

  public void addToRolesRelationship(your.app.eo.MovieRole object) {
    if (_Talent.LOG.isDebugEnabled()) {
      _Talent.LOG.debug("adding " + object + " to roles relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	addToRoles(object);
    }
    else {
    	addObjectToBothSidesOfRelationshipWithKey(object, "roles");
    }
  }

  public void removeFromRolesRelationship(your.app.eo.MovieRole object) {
    if (_Talent.LOG.isDebugEnabled()) {
      _Talent.LOG.debug("removing " + object + " from roles relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	removeFromRoles(object);
    }
    else {
    	removeObjectFromBothSidesOfRelationshipWithKey(object, "roles");
    }
  }

  public your.app.eo.MovieRole createRolesRelationship() {
    EOClassDescription eoClassDesc = EOClassDescription.classDescriptionForEntityName("MovieRole");
    EOEnterpriseObject eo = eoClassDesc.createInstanceWithEditingContext(editingContext(), null);
    editingContext().insertObject(eo);
    addObjectToBothSidesOfRelationshipWithKey(eo, "roles");
    return (your.app.eo.MovieRole) eo;
  }

  public void deleteRolesRelationship(your.app.eo.MovieRole object) {
    removeObjectFromBothSidesOfRelationshipWithKey(object, "roles");
    editingContext().deleteObject(object);
  }

  public void deleteAllRolesRelationships() {
    Enumeration objects = roles().immutableClone().objectEnumerator();
    while (objects.hasMoreElements()) {
      deleteRolesRelationship((your.app.eo.MovieRole)objects.nextElement());
    }
  }


  public static Talent createTalent(EOEditingContext editingContext, String firstName
, String lastName
) {
    Talent eo = (Talent) EOUtilities.createAndInsertInstance(editingContext, _Talent.ENTITY_NAME);    
		eo.setFirstName(firstName);
		eo.setLastName(lastName);
    return eo;
  }

  public static NSArray<Talent> fetchAllTalents(EOEditingContext editingContext) {
    return _Talent.fetchAllTalents(editingContext, null);
  }

  public static NSArray<Talent> fetchAllTalents(EOEditingContext editingContext, NSArray<EOSortOrdering> sortOrderings) {
    return _Talent.fetchTalents(editingContext, null, sortOrderings);
  }

  public static NSArray<Talent> fetchTalents(EOEditingContext editingContext, EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings) {
    EOFetchSpecification fetchSpec = new EOFetchSpecification(_Talent.ENTITY_NAME, qualifier, sortOrderings);
    fetchSpec.setIsDeep(true);
    NSArray<Talent> eoObjects = (NSArray<Talent>)editingContext.objectsWithFetchSpecification(fetchSpec);
    return eoObjects;
  }

  public static Talent fetchTalent(EOEditingContext editingContext, String keyName, Object value) {
    return _Talent.fetchTalent(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static Talent fetchTalent(EOEditingContext editingContext, EOQualifier qualifier) {
    NSArray<Talent> eoObjects = _Talent.fetchTalents(editingContext, qualifier, null);
    Talent eoObject;
    int count = eoObjects.count();
    if (count == 0) {
      eoObject = null;
    }
    else if (count == 1) {
      eoObject = (Talent)eoObjects.objectAtIndex(0);
    }
    else {
      throw new IllegalStateException("There was more than one Talent that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static Talent fetchRequiredTalent(EOEditingContext editingContext, String keyName, Object value) {
    return _Talent.fetchRequiredTalent(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static Talent fetchRequiredTalent(EOEditingContext editingContext, EOQualifier qualifier) {
    Talent eoObject = _Talent.fetchTalent(editingContext, qualifier);
    if (eoObject == null) {
      throw new NoSuchElementException("There was no Talent that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static Talent localInstanceIn(EOEditingContext editingContext, Talent eo) {
    Talent localInstance = (eo == null) ? null : (Talent)EOUtilities.localInstanceOfObject(editingContext, eo);
    if (localInstance == null && eo != null) {
      throw new IllegalStateException("You attempted to localInstance " + eo + ", which has not yet committed.");
    }
    return localInstance;
  }

  public WOGWTClientEO toClientEO() {
    return new your.app.gwt.eo.Talent( WOGWTServerUtil.eoToDictionary(this) ); 
  }

  public WOGWTClientEO toClientEO(List<String> relationshipsToSerialize) {
    NSMutableDictionary data = WOGWTServerUtil.eoToDictionary(this).mutableClone();
	data.addEntriesFromDictionary(
			WOGWTServerUtil.relationshipsToClientEOs(this, relationshipsToSerialize));
    your.app.gwt.eo.Talent rec = new your.app.gwt.eo.Talent( data ); 
    return rec;
  }

}
