// $LastChangedRevision: 4733 $ DO NOT EDIT.  Make changes to Movie.java instead.
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
public abstract class _Movie extends  ERXGenericRecord implements WOGWTServerEO {
  public static final String ENTITY_NAME = "Movie";

  // Attribute Keys
  public static final ERXKey<String> CATEGORY = new ERXKey<String>("category");
  public static final ERXKey<NSTimestamp> DATE_RELEASED = new ERXKey<NSTimestamp>("dateReleased");
  public static final ERXKey<String> POSTER_NAME = new ERXKey<String>("posterName");
  public static final ERXKey<String> RATED = new ERXKey<String>("rated");
  public static final ERXKey<BigDecimal> REVENUE = new ERXKey<BigDecimal>("revenue");
  public static final ERXKey<String> TITLE = new ERXKey<String>("title");
  public static final ERXKey<String> TRAILER_NAME = new ERXKey<String>("trailerName");
  // Relationship Keys
  public static final ERXKey<your.app.eo.Talent> DIRECTORS = new ERXKey<your.app.eo.Talent>("directors");
  public static final ERXKey<your.app.eo.PlotSummary> PLOT_SUMMARY = new ERXKey<your.app.eo.PlotSummary>("plotSummary");
  public static final ERXKey<your.app.eo.Review> REVIEWS = new ERXKey<your.app.eo.Review>("reviews");
  public static final ERXKey<your.app.eo.MovieRole> ROLES = new ERXKey<your.app.eo.MovieRole>("roles");
  public static final ERXKey<your.app.eo.Studio> STUDIO = new ERXKey<your.app.eo.Studio>("studio");
  public static final ERXKey<your.app.eo.Voting> VOTING = new ERXKey<your.app.eo.Voting>("voting");

  // Attributes
  public static final String CATEGORY_KEY = CATEGORY.key();
  public static final String DATE_RELEASED_KEY = DATE_RELEASED.key();
  public static final String POSTER_NAME_KEY = POSTER_NAME.key();
  public static final String RATED_KEY = RATED.key();
  public static final String REVENUE_KEY = REVENUE.key();
  public static final String TITLE_KEY = TITLE.key();
  public static final String TRAILER_NAME_KEY = TRAILER_NAME.key();
  // Relationships
  public static final String DIRECTORS_KEY = DIRECTORS.key();
  public static final String PLOT_SUMMARY_KEY = PLOT_SUMMARY.key();
  public static final String REVIEWS_KEY = REVIEWS.key();
  public static final String ROLES_KEY = ROLES.key();
  public static final String STUDIO_KEY = STUDIO.key();
  public static final String VOTING_KEY = VOTING.key();

  private static Logger LOG = Logger.getLogger(_Movie.class);

  public Movie localInstanceIn(EOEditingContext editingContext) {
    Movie localInstance = (Movie)EOUtilities.localInstanceOfObject(editingContext, this);
    if (localInstance == null) {
      throw new IllegalStateException("You attempted to localInstance " + this + ", which has not yet committed.");
    }
    return localInstance;
  }

  public String category() {
    return (String) storedValueForKey("category");
  }

  public void setCategory(String value) {
    if (_Movie.LOG.isDebugEnabled()) {
    	_Movie.LOG.debug( "updating category from " + category() + " to " + value);
    }
    takeStoredValueForKey(value, "category");
  }

  public NSTimestamp dateReleased() {
    return (NSTimestamp) storedValueForKey("dateReleased");
  }

  public void setDateReleased(NSTimestamp value) {
    if (_Movie.LOG.isDebugEnabled()) {
    	_Movie.LOG.debug( "updating dateReleased from " + dateReleased() + " to " + value);
    }
    takeStoredValueForKey(value, "dateReleased");
  }

  public String posterName() {
    return (String) storedValueForKey("posterName");
  }

  public void setPosterName(String value) {
    if (_Movie.LOG.isDebugEnabled()) {
    	_Movie.LOG.debug( "updating posterName from " + posterName() + " to " + value);
    }
    takeStoredValueForKey(value, "posterName");
  }

  public String rated() {
    return (String) storedValueForKey("rated");
  }

  public void setRated(String value) {
    if (_Movie.LOG.isDebugEnabled()) {
    	_Movie.LOG.debug( "updating rated from " + rated() + " to " + value);
    }
    takeStoredValueForKey(value, "rated");
  }

  public BigDecimal revenue() {
    return (BigDecimal) storedValueForKey("revenue");
  }

  public void setRevenue(BigDecimal value) {
    if (_Movie.LOG.isDebugEnabled()) {
    	_Movie.LOG.debug( "updating revenue from " + revenue() + " to " + value);
    }
    takeStoredValueForKey(value, "revenue");
  }

  public String title() {
    return (String) storedValueForKey("title");
  }

  public void setTitle(String value) {
    if (_Movie.LOG.isDebugEnabled()) {
    	_Movie.LOG.debug( "updating title from " + title() + " to " + value);
    }
    takeStoredValueForKey(value, "title");
  }

  public String trailerName() {
    return (String) storedValueForKey("trailerName");
  }

  public void setTrailerName(String value) {
    if (_Movie.LOG.isDebugEnabled()) {
    	_Movie.LOG.debug( "updating trailerName from " + trailerName() + " to " + value);
    }
    takeStoredValueForKey(value, "trailerName");
  }

  public your.app.eo.PlotSummary plotSummary() {
    return (your.app.eo.PlotSummary)storedValueForKey("plotSummary");
  }
  
  public void setPlotSummary(your.app.eo.PlotSummary value) {
    takeStoredValueForKey(value, "plotSummary");
  }

  public void setPlotSummaryRelationship(your.app.eo.PlotSummary value) {
    if (_Movie.LOG.isDebugEnabled()) {
      _Movie.LOG.debug("updating plotSummary from " + plotSummary() + " to " + value);
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	setPlotSummary(value);
    }
    else if (value == null) {
    	your.app.eo.PlotSummary oldValue = plotSummary();
    	if (oldValue != null) {
    		removeObjectFromBothSidesOfRelationshipWithKey(oldValue, "plotSummary");
      }
    } else {
    	addObjectToBothSidesOfRelationshipWithKey(value, "plotSummary");
    }
  }
  
  public your.app.eo.Studio studio() {
    return (your.app.eo.Studio)storedValueForKey("studio");
  }
  
  public void setStudio(your.app.eo.Studio value) {
    takeStoredValueForKey(value, "studio");
  }

  public void setStudioRelationship(your.app.eo.Studio value) {
    if (_Movie.LOG.isDebugEnabled()) {
      _Movie.LOG.debug("updating studio from " + studio() + " to " + value);
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	setStudio(value);
    }
    else if (value == null) {
    	your.app.eo.Studio oldValue = studio();
    	if (oldValue != null) {
    		removeObjectFromBothSidesOfRelationshipWithKey(oldValue, "studio");
      }
    } else {
    	addObjectToBothSidesOfRelationshipWithKey(value, "studio");
    }
  }
  
  public your.app.eo.Voting voting() {
    return (your.app.eo.Voting)storedValueForKey("voting");
  }
  
  public void setVoting(your.app.eo.Voting value) {
    takeStoredValueForKey(value, "voting");
  }

  public void setVotingRelationship(your.app.eo.Voting value) {
    if (_Movie.LOG.isDebugEnabled()) {
      _Movie.LOG.debug("updating voting from " + voting() + " to " + value);
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	setVoting(value);
    }
    else if (value == null) {
    	your.app.eo.Voting oldValue = voting();
    	if (oldValue != null) {
    		removeObjectFromBothSidesOfRelationshipWithKey(oldValue, "voting");
      }
    } else {
    	addObjectToBothSidesOfRelationshipWithKey(value, "voting");
    }
  }
  
  public NSArray<your.app.eo.Talent> directors() {
    return (NSArray<your.app.eo.Talent>)storedValueForKey("directors");
  }

  public NSArray<your.app.eo.Talent> directors(EOQualifier qualifier) {
    return directors(qualifier, null);
  }

  public NSArray<your.app.eo.Talent> directors(EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings) {
    NSArray<your.app.eo.Talent> results;
      results = directors();
      if (qualifier != null) {
        results = (NSArray<your.app.eo.Talent>)EOQualifier.filteredArrayWithQualifier(results, qualifier);
      }
      if (sortOrderings != null) {
        results = (NSArray<your.app.eo.Talent>)EOSortOrdering.sortedArrayUsingKeyOrderArray(results, sortOrderings);
      }
    return results;
  }
  
  public void addToDirectors(your.app.eo.Talent object) {
    includeObjectIntoPropertyWithKey(object, "directors");
  }

  public void removeFromDirectors(your.app.eo.Talent object) {
    excludeObjectFromPropertyWithKey(object, "directors");
  }

  public void addToDirectorsRelationship(your.app.eo.Talent object) {
    if (_Movie.LOG.isDebugEnabled()) {
      _Movie.LOG.debug("adding " + object + " to directors relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	addToDirectors(object);
    }
    else {
    	addObjectToBothSidesOfRelationshipWithKey(object, "directors");
    }
  }

  public void removeFromDirectorsRelationship(your.app.eo.Talent object) {
    if (_Movie.LOG.isDebugEnabled()) {
      _Movie.LOG.debug("removing " + object + " from directors relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	removeFromDirectors(object);
    }
    else {
    	removeObjectFromBothSidesOfRelationshipWithKey(object, "directors");
    }
  }

  public your.app.eo.Talent createDirectorsRelationship() {
    EOClassDescription eoClassDesc = EOClassDescription.classDescriptionForEntityName("Talent");
    EOEnterpriseObject eo = eoClassDesc.createInstanceWithEditingContext(editingContext(), null);
    editingContext().insertObject(eo);
    addObjectToBothSidesOfRelationshipWithKey(eo, "directors");
    return (your.app.eo.Talent) eo;
  }

  public void deleteDirectorsRelationship(your.app.eo.Talent object) {
    removeObjectFromBothSidesOfRelationshipWithKey(object, "directors");
    editingContext().deleteObject(object);
  }

  public void deleteAllDirectorsRelationships() {
    Enumeration objects = directors().immutableClone().objectEnumerator();
    while (objects.hasMoreElements()) {
      deleteDirectorsRelationship((your.app.eo.Talent)objects.nextElement());
    }
  }

  public NSArray<your.app.eo.Review> reviews() {
    return (NSArray<your.app.eo.Review>)storedValueForKey("reviews");
  }

  public NSArray<your.app.eo.Review> reviews(EOQualifier qualifier) {
    return reviews(qualifier, null, false);
  }

  public NSArray<your.app.eo.Review> reviews(EOQualifier qualifier, boolean fetch) {
    return reviews(qualifier, null, fetch);
  }

  public NSArray<your.app.eo.Review> reviews(EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings, boolean fetch) {
    NSArray<your.app.eo.Review> results;
    if (fetch) {
      EOQualifier fullQualifier;
      EOQualifier inverseQualifier = new EOKeyValueQualifier(your.app.eo.Review.MOVIE_KEY, EOQualifier.QualifierOperatorEqual, this);
    	
      if (qualifier == null) {
        fullQualifier = inverseQualifier;
      }
      else {
        NSMutableArray qualifiers = new NSMutableArray();
        qualifiers.addObject(qualifier);
        qualifiers.addObject(inverseQualifier);
        fullQualifier = new EOAndQualifier(qualifiers);
      }

      results = your.app.eo.Review.fetchReviews(editingContext(), fullQualifier, sortOrderings);
    }
    else {
      results = reviews();
      if (qualifier != null) {
        results = (NSArray<your.app.eo.Review>)EOQualifier.filteredArrayWithQualifier(results, qualifier);
      }
      if (sortOrderings != null) {
        results = (NSArray<your.app.eo.Review>)EOSortOrdering.sortedArrayUsingKeyOrderArray(results, sortOrderings);
      }
    }
    return results;
  }
  
  public void addToReviews(your.app.eo.Review object) {
    includeObjectIntoPropertyWithKey(object, "reviews");
  }

  public void removeFromReviews(your.app.eo.Review object) {
    excludeObjectFromPropertyWithKey(object, "reviews");
  }

  public void addToReviewsRelationship(your.app.eo.Review object) {
    if (_Movie.LOG.isDebugEnabled()) {
      _Movie.LOG.debug("adding " + object + " to reviews relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	addToReviews(object);
    }
    else {
    	addObjectToBothSidesOfRelationshipWithKey(object, "reviews");
    }
  }

  public void removeFromReviewsRelationship(your.app.eo.Review object) {
    if (_Movie.LOG.isDebugEnabled()) {
      _Movie.LOG.debug("removing " + object + " from reviews relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	removeFromReviews(object);
    }
    else {
    	removeObjectFromBothSidesOfRelationshipWithKey(object, "reviews");
    }
  }

  public your.app.eo.Review createReviewsRelationship() {
    EOClassDescription eoClassDesc = EOClassDescription.classDescriptionForEntityName("Review");
    EOEnterpriseObject eo = eoClassDesc.createInstanceWithEditingContext(editingContext(), null);
    editingContext().insertObject(eo);
    addObjectToBothSidesOfRelationshipWithKey(eo, "reviews");
    return (your.app.eo.Review) eo;
  }

  public void deleteReviewsRelationship(your.app.eo.Review object) {
    removeObjectFromBothSidesOfRelationshipWithKey(object, "reviews");
  }

  public void deleteAllReviewsRelationships() {
    Enumeration objects = reviews().immutableClone().objectEnumerator();
    while (objects.hasMoreElements()) {
      deleteReviewsRelationship((your.app.eo.Review)objects.nextElement());
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
      EOQualifier inverseQualifier = new EOKeyValueQualifier(your.app.eo.MovieRole.MOVIE_KEY, EOQualifier.QualifierOperatorEqual, this);
    	
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
    if (_Movie.LOG.isDebugEnabled()) {
      _Movie.LOG.debug("adding " + object + " to roles relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	addToRoles(object);
    }
    else {
    	addObjectToBothSidesOfRelationshipWithKey(object, "roles");
    }
  }

  public void removeFromRolesRelationship(your.app.eo.MovieRole object) {
    if (_Movie.LOG.isDebugEnabled()) {
      _Movie.LOG.debug("removing " + object + " from roles relationship");
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
  }

  public void deleteAllRolesRelationships() {
    Enumeration objects = roles().immutableClone().objectEnumerator();
    while (objects.hasMoreElements()) {
      deleteRolesRelationship((your.app.eo.MovieRole)objects.nextElement());
    }
  }


  public static Movie createMovie(EOEditingContext editingContext, String title
) {
    Movie eo = (Movie) EOUtilities.createAndInsertInstance(editingContext, _Movie.ENTITY_NAME);    
		eo.setTitle(title);
    return eo;
  }

  public static NSArray<Movie> fetchAllMovies(EOEditingContext editingContext) {
    return _Movie.fetchAllMovies(editingContext, null);
  }

  public static NSArray<Movie> fetchAllMovies(EOEditingContext editingContext, NSArray<EOSortOrdering> sortOrderings) {
    return _Movie.fetchMovies(editingContext, null, sortOrderings);
  }

  public static NSArray<Movie> fetchMovies(EOEditingContext editingContext, EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings) {
    EOFetchSpecification fetchSpec = new EOFetchSpecification(_Movie.ENTITY_NAME, qualifier, sortOrderings);
    fetchSpec.setIsDeep(true);
    NSArray<Movie> eoObjects = (NSArray<Movie>)editingContext.objectsWithFetchSpecification(fetchSpec);
    return eoObjects;
  }

  public static Movie fetchMovie(EOEditingContext editingContext, String keyName, Object value) {
    return _Movie.fetchMovie(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static Movie fetchMovie(EOEditingContext editingContext, EOQualifier qualifier) {
    NSArray<Movie> eoObjects = _Movie.fetchMovies(editingContext, qualifier, null);
    Movie eoObject;
    int count = eoObjects.count();
    if (count == 0) {
      eoObject = null;
    }
    else if (count == 1) {
      eoObject = (Movie)eoObjects.objectAtIndex(0);
    }
    else {
      throw new IllegalStateException("There was more than one Movie that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static Movie fetchRequiredMovie(EOEditingContext editingContext, String keyName, Object value) {
    return _Movie.fetchRequiredMovie(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static Movie fetchRequiredMovie(EOEditingContext editingContext, EOQualifier qualifier) {
    Movie eoObject = _Movie.fetchMovie(editingContext, qualifier);
    if (eoObject == null) {
      throw new NoSuchElementException("There was no Movie that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static Movie localInstanceIn(EOEditingContext editingContext, Movie eo) {
    Movie localInstance = (eo == null) ? null : (Movie)EOUtilities.localInstanceOfObject(editingContext, eo);
    if (localInstance == null && eo != null) {
      throw new IllegalStateException("You attempted to localInstance " + eo + ", which has not yet committed.");
    }
    return localInstance;
  }
  public static NSArray<your.app.eo.Movie> fetchDeepFetchOneMovie(EOEditingContext editingContext, NSDictionary<String, Object> bindings) {
    EOFetchSpecification fetchSpec = EOFetchSpecification.fetchSpecificationNamed("DeepFetchOneMovie", "Movie");
    fetchSpec = fetchSpec.fetchSpecificationWithQualifierBindings(bindings);
    return editingContext.objectsWithFetchSpecification(fetchSpec);
  }
  
  public static NSArray<your.app.eo.Movie> fetchDeepFetchOneMovie(EOEditingContext editingContext,
	Integer myMovieBinding)
  {
    EOFetchSpecification fetchSpec = EOFetchSpecification.fetchSpecificationNamed("DeepFetchOneMovie", "Movie");
    NSMutableDictionary<String, Object> bindings = new NSMutableDictionary<String, Object>();
    bindings.takeValueForKey(myMovieBinding, "myMovie");
	fetchSpec = fetchSpec.fetchSpecificationWithQualifierBindings(bindings);
    return editingContext.objectsWithFetchSpecification(fetchSpec);
  }
  
  public static NSArray<your.app.eo.Movie> fetchQualifierVariable(EOEditingContext editingContext, NSDictionary<String, Object> bindings) {
    EOFetchSpecification fetchSpec = EOFetchSpecification.fetchSpecificationNamed("QualifierVariable", "Movie");
    fetchSpec = fetchSpec.fetchSpecificationWithQualifierBindings(bindings);
    return editingContext.objectsWithFetchSpecification(fetchSpec);
  }
  
  public static NSArray<your.app.eo.Movie> fetchQualifierVariable(EOEditingContext editingContext,
	BigDecimal revenueBinding,
	your.app.eo.Studio studioBinding,
	String studioNameBinding,
	String titleBinding)
  {
    EOFetchSpecification fetchSpec = EOFetchSpecification.fetchSpecificationNamed("QualifierVariable", "Movie");
    NSMutableDictionary<String, Object> bindings = new NSMutableDictionary<String, Object>();
    bindings.takeValueForKey(revenueBinding, "revenue");
    bindings.takeValueForKey(studioBinding, "studio");
    bindings.takeValueForKey(studioNameBinding, "studioName");
    bindings.takeValueForKey(titleBinding, "title");
	fetchSpec = fetchSpec.fetchSpecificationWithQualifierBindings(bindings);
    return editingContext.objectsWithFetchSpecification(fetchSpec);
  }
  
  public static NSArray<NSDictionary> fetchRawFetchAllMovies(EOEditingContext editingContext, NSDictionary<String, Object> bindings) {
    EOFetchSpecification fetchSpec = EOFetchSpecification.fetchSpecificationNamed("RawFetchAllMovies", "Movie");
    fetchSpec = fetchSpec.fetchSpecificationWithQualifierBindings(bindings);
    return editingContext.objectsWithFetchSpecification(fetchSpec);
  }
  
  public static NSArray<NSDictionary> fetchRawFetchAllMovies(EOEditingContext editingContext)
  {
    EOFetchSpecification fetchSpec = EOFetchSpecification.fetchSpecificationNamed("RawFetchAllMovies", "Movie");
    return editingContext.objectsWithFetchSpecification(fetchSpec);
  }
  

  public WOGWTClientEO toClientEO() {
    return new your.app.gwt.eo.MovieClient( WOGWTServerUtil.eoToDictionary(this) ); 
  }

  public WOGWTClientEO toClientEO(List<String> keyPathsToSerialize) {
    NSMutableDictionary data = WOGWTServerUtil.eoToDictionary(this).mutableClone();
	data.addEntriesFromDictionary(
			WOGWTServerUtil._keyPathsToClientEOs(this, keyPathsToSerialize));
    your.app.gwt.eo.MovieClient rec = new your.app.gwt.eo.MovieClient( data ); 
    return rec;
  }

}
