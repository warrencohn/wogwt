// $LastChangedRevision: 4733 $ DO NOT EDIT.  Make changes to MovieRole.java instead.
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
public abstract class _MovieRole extends  ERXGenericRecord implements WOGWTServerEO {
  public static final String ENTITY_NAME = "MovieRole";

  // Attribute Keys
  public static final ERXKey<String> ROLE_NAME = new ERXKey<String>("roleName");
  // Relationship Keys
  public static final ERXKey<your.app.eo.Movie> MOVIE = new ERXKey<your.app.eo.Movie>("movie");
  public static final ERXKey<your.app.eo.Talent> TALENT = new ERXKey<your.app.eo.Talent>("talent");

  // Attributes
  public static final String ROLE_NAME_KEY = ROLE_NAME.key();
  // Relationships
  public static final String MOVIE_KEY = MOVIE.key();
  public static final String TALENT_KEY = TALENT.key();

  private static Logger LOG = Logger.getLogger(_MovieRole.class);

  public MovieRole localInstanceIn(EOEditingContext editingContext) {
    MovieRole localInstance = (MovieRole)EOUtilities.localInstanceOfObject(editingContext, this);
    if (localInstance == null) {
      throw new IllegalStateException("You attempted to localInstance " + this + ", which has not yet committed.");
    }
    return localInstance;
  }

  public String roleName() {
    return (String) storedValueForKey("roleName");
  }

  public void setRoleName(String value) {
    if (_MovieRole.LOG.isDebugEnabled()) {
    	_MovieRole.LOG.debug( "updating roleName from " + roleName() + " to " + value);
    }
    takeStoredValueForKey(value, "roleName");
  }

  public your.app.eo.Movie movie() {
    return (your.app.eo.Movie)storedValueForKey("movie");
  }
  
  public void setMovie(your.app.eo.Movie value) {
    takeStoredValueForKey(value, "movie");
  }

  public void setMovieRelationship(your.app.eo.Movie value) {
    if (_MovieRole.LOG.isDebugEnabled()) {
      _MovieRole.LOG.debug("updating movie from " + movie() + " to " + value);
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	setMovie(value);
    }
    else if (value == null) {
    	your.app.eo.Movie oldValue = movie();
    	if (oldValue != null) {
    		removeObjectFromBothSidesOfRelationshipWithKey(oldValue, "movie");
      }
    } else {
    	addObjectToBothSidesOfRelationshipWithKey(value, "movie");
    }
  }
  
  public your.app.eo.Talent talent() {
    return (your.app.eo.Talent)storedValueForKey("talent");
  }
  
  public void setTalent(your.app.eo.Talent value) {
    takeStoredValueForKey(value, "talent");
  }

  public void setTalentRelationship(your.app.eo.Talent value) {
    if (_MovieRole.LOG.isDebugEnabled()) {
      _MovieRole.LOG.debug("updating talent from " + talent() + " to " + value);
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	setTalent(value);
    }
    else if (value == null) {
    	your.app.eo.Talent oldValue = talent();
    	if (oldValue != null) {
    		removeObjectFromBothSidesOfRelationshipWithKey(oldValue, "talent");
      }
    } else {
    	addObjectToBothSidesOfRelationshipWithKey(value, "talent");
    }
  }
  

  public static MovieRole createMovieRole(EOEditingContext editingContext, your.app.eo.Movie movie, your.app.eo.Talent talent) {
    MovieRole eo = (MovieRole) EOUtilities.createAndInsertInstance(editingContext, _MovieRole.ENTITY_NAME);    
    eo.setMovieRelationship(movie);
    eo.setTalentRelationship(talent);
    return eo;
  }

  public static NSArray<MovieRole> fetchAllMovieRoles(EOEditingContext editingContext) {
    return _MovieRole.fetchAllMovieRoles(editingContext, null);
  }

  public static NSArray<MovieRole> fetchAllMovieRoles(EOEditingContext editingContext, NSArray<EOSortOrdering> sortOrderings) {
    return _MovieRole.fetchMovieRoles(editingContext, null, sortOrderings);
  }

  public static NSArray<MovieRole> fetchMovieRoles(EOEditingContext editingContext, EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings) {
    EOFetchSpecification fetchSpec = new EOFetchSpecification(_MovieRole.ENTITY_NAME, qualifier, sortOrderings);
    fetchSpec.setIsDeep(true);
    NSArray<MovieRole> eoObjects = (NSArray<MovieRole>)editingContext.objectsWithFetchSpecification(fetchSpec);
    return eoObjects;
  }

  public static MovieRole fetchMovieRole(EOEditingContext editingContext, String keyName, Object value) {
    return _MovieRole.fetchMovieRole(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static MovieRole fetchMovieRole(EOEditingContext editingContext, EOQualifier qualifier) {
    NSArray<MovieRole> eoObjects = _MovieRole.fetchMovieRoles(editingContext, qualifier, null);
    MovieRole eoObject;
    int count = eoObjects.count();
    if (count == 0) {
      eoObject = null;
    }
    else if (count == 1) {
      eoObject = (MovieRole)eoObjects.objectAtIndex(0);
    }
    else {
      throw new IllegalStateException("There was more than one MovieRole that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static MovieRole fetchRequiredMovieRole(EOEditingContext editingContext, String keyName, Object value) {
    return _MovieRole.fetchRequiredMovieRole(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static MovieRole fetchRequiredMovieRole(EOEditingContext editingContext, EOQualifier qualifier) {
    MovieRole eoObject = _MovieRole.fetchMovieRole(editingContext, qualifier);
    if (eoObject == null) {
      throw new NoSuchElementException("There was no MovieRole that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static MovieRole localInstanceIn(EOEditingContext editingContext, MovieRole eo) {
    MovieRole localInstance = (eo == null) ? null : (MovieRole)EOUtilities.localInstanceOfObject(editingContext, eo);
    if (localInstance == null && eo != null) {
      throw new IllegalStateException("You attempted to localInstance " + eo + ", which has not yet committed.");
    }
    return localInstance;
  }

  public WOGWTClientEO toClientEO() {
    return new your.app.gwt.eo.MovieRoleClient( WOGWTServerUtil.eoToDictionary(this) ); 
  }

  public WOGWTClientEO toClientEO(List<String> keyPathsToSerialize) {
    NSMutableDictionary data = WOGWTServerUtil.eoToDictionary(this).mutableClone();
	data.addEntriesFromDictionary(
			WOGWTServerUtil._keyPathsToClientEOs(this, keyPathsToSerialize));
    your.app.gwt.eo.MovieRoleClient rec = new your.app.gwt.eo.MovieRoleClient( data ); 
    return rec;
  }

}
