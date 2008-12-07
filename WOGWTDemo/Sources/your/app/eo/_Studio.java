// $LastChangedRevision: 4733 $ DO NOT EDIT.  Make changes to Studio.java instead.
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
public abstract class _Studio extends  ERXGenericRecord implements WOGWTServerEO {
  public static final String ENTITY_NAME = "Studio";

  // Attribute Keys
  public static final ERXKey<BigDecimal> BUDGET = new ERXKey<BigDecimal>("budget");
  public static final ERXKey<String> NAME = new ERXKey<String>("name");
  // Relationship Keys
  public static final ERXKey<your.app.eo.Movie> MOVIES = new ERXKey<your.app.eo.Movie>("movies");

  // Attributes
  public static final String BUDGET_KEY = BUDGET.key();
  public static final String NAME_KEY = NAME.key();
  // Relationships
  public static final String MOVIES_KEY = MOVIES.key();

  private static Logger LOG = Logger.getLogger(_Studio.class);

  public Studio localInstanceIn(EOEditingContext editingContext) {
    Studio localInstance = (Studio)EOUtilities.localInstanceOfObject(editingContext, this);
    if (localInstance == null) {
      throw new IllegalStateException("You attempted to localInstance " + this + ", which has not yet committed.");
    }
    return localInstance;
  }

  public BigDecimal budget() {
    return (BigDecimal) storedValueForKey("budget");
  }

  public void setBudget(BigDecimal value) {
    if (_Studio.LOG.isDebugEnabled()) {
    	_Studio.LOG.debug( "updating budget from " + budget() + " to " + value);
    }
    takeStoredValueForKey(value, "budget");
  }

  public String name() {
    return (String) storedValueForKey("name");
  }

  public void setName(String value) {
    if (_Studio.LOG.isDebugEnabled()) {
    	_Studio.LOG.debug( "updating name from " + name() + " to " + value);
    }
    takeStoredValueForKey(value, "name");
  }

  public NSArray<your.app.eo.Movie> movies() {
    return (NSArray<your.app.eo.Movie>)storedValueForKey("movies");
  }

  public NSArray<your.app.eo.Movie> movies(EOQualifier qualifier) {
    return movies(qualifier, null, false);
  }

  public NSArray<your.app.eo.Movie> movies(EOQualifier qualifier, boolean fetch) {
    return movies(qualifier, null, fetch);
  }

  public NSArray<your.app.eo.Movie> movies(EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings, boolean fetch) {
    NSArray<your.app.eo.Movie> results;
    if (fetch) {
      EOQualifier fullQualifier;
      EOQualifier inverseQualifier = new EOKeyValueQualifier(your.app.eo.Movie.STUDIO_KEY, EOQualifier.QualifierOperatorEqual, this);
    	
      if (qualifier == null) {
        fullQualifier = inverseQualifier;
      }
      else {
        NSMutableArray qualifiers = new NSMutableArray();
        qualifiers.addObject(qualifier);
        qualifiers.addObject(inverseQualifier);
        fullQualifier = new EOAndQualifier(qualifiers);
      }

      results = your.app.eo.Movie.fetchMovies(editingContext(), fullQualifier, sortOrderings);
    }
    else {
      results = movies();
      if (qualifier != null) {
        results = (NSArray<your.app.eo.Movie>)EOQualifier.filteredArrayWithQualifier(results, qualifier);
      }
      if (sortOrderings != null) {
        results = (NSArray<your.app.eo.Movie>)EOSortOrdering.sortedArrayUsingKeyOrderArray(results, sortOrderings);
      }
    }
    return results;
  }
  
  public void addToMovies(your.app.eo.Movie object) {
    includeObjectIntoPropertyWithKey(object, "movies");
  }

  public void removeFromMovies(your.app.eo.Movie object) {
    excludeObjectFromPropertyWithKey(object, "movies");
  }

  public void addToMoviesRelationship(your.app.eo.Movie object) {
    if (_Studio.LOG.isDebugEnabled()) {
      _Studio.LOG.debug("adding " + object + " to movies relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	addToMovies(object);
    }
    else {
    	addObjectToBothSidesOfRelationshipWithKey(object, "movies");
    }
  }

  public void removeFromMoviesRelationship(your.app.eo.Movie object) {
    if (_Studio.LOG.isDebugEnabled()) {
      _Studio.LOG.debug("removing " + object + " from movies relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	removeFromMovies(object);
    }
    else {
    	removeObjectFromBothSidesOfRelationshipWithKey(object, "movies");
    }
  }

  public your.app.eo.Movie createMoviesRelationship() {
    EOClassDescription eoClassDesc = EOClassDescription.classDescriptionForEntityName("Movie");
    EOEnterpriseObject eo = eoClassDesc.createInstanceWithEditingContext(editingContext(), null);
    editingContext().insertObject(eo);
    addObjectToBothSidesOfRelationshipWithKey(eo, "movies");
    return (your.app.eo.Movie) eo;
  }

  public void deleteMoviesRelationship(your.app.eo.Movie object) {
    removeObjectFromBothSidesOfRelationshipWithKey(object, "movies");
    editingContext().deleteObject(object);
  }

  public void deleteAllMoviesRelationships() {
    Enumeration objects = movies().immutableClone().objectEnumerator();
    while (objects.hasMoreElements()) {
      deleteMoviesRelationship((your.app.eo.Movie)objects.nextElement());
    }
  }


  public static Studio createStudio(EOEditingContext editingContext, BigDecimal budget
, String name
) {
    Studio eo = (Studio) EOUtilities.createAndInsertInstance(editingContext, _Studio.ENTITY_NAME);    
		eo.setBudget(budget);
		eo.setName(name);
    return eo;
  }

  public static NSArray<Studio> fetchAllStudios(EOEditingContext editingContext) {
    return _Studio.fetchAllStudios(editingContext, null);
  }

  public static NSArray<Studio> fetchAllStudios(EOEditingContext editingContext, NSArray<EOSortOrdering> sortOrderings) {
    return _Studio.fetchStudios(editingContext, null, sortOrderings);
  }

  public static NSArray<Studio> fetchStudios(EOEditingContext editingContext, EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings) {
    EOFetchSpecification fetchSpec = new EOFetchSpecification(_Studio.ENTITY_NAME, qualifier, sortOrderings);
    fetchSpec.setIsDeep(true);
    NSArray<Studio> eoObjects = (NSArray<Studio>)editingContext.objectsWithFetchSpecification(fetchSpec);
    return eoObjects;
  }

  public static Studio fetchStudio(EOEditingContext editingContext, String keyName, Object value) {
    return _Studio.fetchStudio(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static Studio fetchStudio(EOEditingContext editingContext, EOQualifier qualifier) {
    NSArray<Studio> eoObjects = _Studio.fetchStudios(editingContext, qualifier, null);
    Studio eoObject;
    int count = eoObjects.count();
    if (count == 0) {
      eoObject = null;
    }
    else if (count == 1) {
      eoObject = (Studio)eoObjects.objectAtIndex(0);
    }
    else {
      throw new IllegalStateException("There was more than one Studio that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static Studio fetchRequiredStudio(EOEditingContext editingContext, String keyName, Object value) {
    return _Studio.fetchRequiredStudio(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static Studio fetchRequiredStudio(EOEditingContext editingContext, EOQualifier qualifier) {
    Studio eoObject = _Studio.fetchStudio(editingContext, qualifier);
    if (eoObject == null) {
      throw new NoSuchElementException("There was no Studio that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static Studio localInstanceIn(EOEditingContext editingContext, Studio eo) {
    Studio localInstance = (eo == null) ? null : (Studio)EOUtilities.localInstanceOfObject(editingContext, eo);
    if (localInstance == null && eo != null) {
      throw new IllegalStateException("You attempted to localInstance " + eo + ", which has not yet committed.");
    }
    return localInstance;
  }
  public static NSArray<NSDictionary> fetchRawFetchAllStudios(EOEditingContext editingContext, NSDictionary<String, Object> bindings) {
    EOFetchSpecification fetchSpec = EOFetchSpecification.fetchSpecificationNamed("RawFetchAllStudios", "Studio");
    fetchSpec = fetchSpec.fetchSpecificationWithQualifierBindings(bindings);
    return editingContext.objectsWithFetchSpecification(fetchSpec);
  }
  
  public static NSArray<NSDictionary> fetchRawFetchAllStudios(EOEditingContext editingContext)
  {
    EOFetchSpecification fetchSpec = EOFetchSpecification.fetchSpecificationNamed("RawFetchAllStudios", "Studio");
    return editingContext.objectsWithFetchSpecification(fetchSpec);
  }
  

  public WOGWTClientEO toClientEO() {
    return new your.app.gwt.eo.StudioClient( WOGWTServerUtil.eoToDictionary(this) ); 
  }

  public WOGWTClientEO toClientEO(List<String> relationshipsToSerialize) {
    NSMutableDictionary data = WOGWTServerUtil.eoToDictionary(this).mutableClone();
	data.addEntriesFromDictionary(
			WOGWTServerUtil.relationshipsToClientEOs(this, relationshipsToSerialize));
    your.app.gwt.eo.StudioClient rec = new your.app.gwt.eo.StudioClient( data ); 
    return rec;
  }

}
