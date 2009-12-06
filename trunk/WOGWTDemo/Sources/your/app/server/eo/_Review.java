// $LastChangedRevision: 4733 $ DO NOT EDIT.  Make changes to Review.java instead.
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
public abstract class _Review extends  ERXGenericRecord implements WOGWTServerEO {
  public static final String ENTITY_NAME = "Review";

  // Attribute Keys
  public static final ERXKey<String> REVIEW = new ERXKey<String>("review");
  public static final ERXKey<String> REVIEWER = new ERXKey<String>("reviewer");
  // Relationship Keys
  public static final ERXKey<your.app.server.eo.Movie> MOVIE = new ERXKey<your.app.server.eo.Movie>("movie");

  // Attributes
  public static final String REVIEW_KEY = REVIEW.key();
  public static final String REVIEWER_KEY = REVIEWER.key();
  // Relationships
  public static final String MOVIE_KEY = MOVIE.key();

  private static Logger LOG = Logger.getLogger(_Review.class);

  public Review localInstanceIn(EOEditingContext editingContext) {
    Review localInstance = (Review)EOUtilities.localInstanceOfObject(editingContext, this);
    if (localInstance == null) {
      throw new IllegalStateException("You attempted to localInstance " + this + ", which has not yet committed.");
    }
    return localInstance;
  }

  public String review() {
    return (String) storedValueForKey("review");
  }

  public void setReview(String value) {
    if (_Review.LOG.isDebugEnabled()) {
    	_Review.LOG.debug( "updating review from " + review() + " to " + value);
    }
    takeStoredValueForKey(value, "review");
  }

  public String reviewer() {
    return (String) storedValueForKey("reviewer");
  }

  public void setReviewer(String value) {
    if (_Review.LOG.isDebugEnabled()) {
    	_Review.LOG.debug( "updating reviewer from " + reviewer() + " to " + value);
    }
    takeStoredValueForKey(value, "reviewer");
  }

  public your.app.server.eo.Movie movie() {
    return (your.app.server.eo.Movie)storedValueForKey("movie");
  }
  
  public void setMovie(your.app.server.eo.Movie value) {
    takeStoredValueForKey(value, "movie");
  }

  public void setMovieRelationship(your.app.server.eo.Movie value) {
    if (_Review.LOG.isDebugEnabled()) {
      _Review.LOG.debug("updating movie from " + movie() + " to " + value);
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
  

  public static Review createReview(EOEditingContext editingContext, your.app.server.eo.Movie movie) {
    Review eo = (Review) EOUtilities.createAndInsertInstance(editingContext, _Review.ENTITY_NAME);    
    eo.setMovieRelationship(movie);
    return eo;
  }

  public static NSArray<Review> fetchAllReviews(EOEditingContext editingContext) {
    return _Review.fetchAllReviews(editingContext, null);
  }

  public static NSArray<Review> fetchAllReviews(EOEditingContext editingContext, NSArray<EOSortOrdering> sortOrderings) {
    return _Review.fetchReviews(editingContext, null, sortOrderings);
  }

  public static NSArray<Review> fetchReviews(EOEditingContext editingContext, EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings) {
    EOFetchSpecification fetchSpec = new EOFetchSpecification(_Review.ENTITY_NAME, qualifier, sortOrderings);
    fetchSpec.setIsDeep(true);
    NSArray<Review> eoObjects = (NSArray<Review>)editingContext.objectsWithFetchSpecification(fetchSpec);
    return eoObjects;
  }

  public static Review fetchReview(EOEditingContext editingContext, String keyName, Object value) {
    return _Review.fetchReview(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static Review fetchReview(EOEditingContext editingContext, EOQualifier qualifier) {
    NSArray<Review> eoObjects = _Review.fetchReviews(editingContext, qualifier, null);
    Review eoObject;
    int count = eoObjects.count();
    if (count == 0) {
      eoObject = null;
    }
    else if (count == 1) {
      eoObject = (Review)eoObjects.objectAtIndex(0);
    }
    else {
      throw new IllegalStateException("There was more than one Review that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static Review fetchRequiredReview(EOEditingContext editingContext, String keyName, Object value) {
    return _Review.fetchRequiredReview(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static Review fetchRequiredReview(EOEditingContext editingContext, EOQualifier qualifier) {
    Review eoObject = _Review.fetchReview(editingContext, qualifier);
    if (eoObject == null) {
      throw new NoSuchElementException("There was no Review that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static Review localInstanceIn(EOEditingContext editingContext, Review eo) {
    Review localInstance = (eo == null) ? null : (Review)EOUtilities.localInstanceOfObject(editingContext, eo);
    if (localInstance == null && eo != null) {
      throw new IllegalStateException("You attempted to localInstance " + eo + ", which has not yet committed.");
    }
    return localInstance;
  }

  public WOGWTClientEO toClientEO() {
    return new your.app.gwt.eo.ReviewClient( WOGWTServerUtil.eoToDictionary(this) ); 
  }

  public WOGWTClientEO toClientEO(List<String> relatedKeyPathsToSerialize) {
    NSMutableDictionary data = WOGWTServerUtil.eoToDictionary(this).mutableClone();
	data.addEntriesFromDictionary(
			WOGWTServerUtil._keyPathsToClientEOs(this, relatedKeyPathsToSerialize));
    your.app.gwt.eo.ReviewClient rec = new your.app.gwt.eo.ReviewClient( data ); 
    return rec;
  }

}
