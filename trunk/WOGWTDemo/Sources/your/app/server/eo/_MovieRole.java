// $LastChangedRevision: 4733 $ DO NOT EDIT.  Make changes to MovieRole.java instead.
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
public abstract class _MovieRole extends  ERXGenericRecord implements WOGWTServerEO {
  public static final String ENTITY_NAME = "MovieRole";

  // Attribute Keys
  public static final ERXKey<String> ROLE_NAME = new ERXKey<String>("roleName");
  // Relationship Keys
  public static final ERXKey<your.app.server.eo.Movie> MOVIE = new ERXKey<your.app.server.eo.Movie>("movie");
  public static final ERXKey<your.app.server.eo.Talent> TALENT = new ERXKey<your.app.server.eo.Talent>("talent");

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

  public your.app.server.eo.Movie movie() {
    return (your.app.server.eo.Movie)storedValueForKey("movie");
  }
  
  public void setMovie(your.app.server.eo.Movie value) {
    takeStoredValueForKey(value, "movie");
  }

  public void setMovieRelationship(your.app.server.eo.Movie value) {
    if (_MovieRole.LOG.isDebugEnabled()) {
      _MovieRole.LOG.debug("updating movie from " + movie() + " to " + value);
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	setMovie(value);
    }
    else if (value == null) {
    	your.app.server.eo.Movie oldValue = movie();
    	if (oldValue != null) {
    		removeObjectFromBothSidesOfRelationshipWithKey(oldValue, "movie");
      }
    } else {
    	addObjectToBothSidesOfRelationshipWithKey(value, "movie");
    }
  }
  
  public your.app.server.eo.Talent talent() {
    return (your.app.server.eo.Talent)storedValueForKey("talent");
  }
  
  public void setTalent(your.app.server.eo.Talent value) {
    takeStoredValueForKey(value, "talent");
  }

  public void setTalentRelationship(your.app.server.eo.Talent value) {
    if (_MovieRole.LOG.isDebugEnabled()) {
      _MovieRole.LOG.debug("updating talent from " + talent() + " to " + value);
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
  

  public static MovieRole createMovieRole(EOEditingContext editingContext, your.app.server.eo.Movie movie, your.app.server.eo.Talent talent) {
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

  public WOGWTClientEO toClientEO(List<String> relatedKeyPathsToSerialize) {
    NSMutableDictionary data = WOGWTServerUtil.eoToDictionary(this).mutableClone();
	data.addEntriesFromDictionary(
			WOGWTServerUtil._keyPathsToClientEOs(this, relatedKeyPathsToSerialize));
    your.app.gwt.eo.MovieRoleClient rec = new your.app.gwt.eo.MovieRoleClient( data ); 
    return rec;
  }

}
