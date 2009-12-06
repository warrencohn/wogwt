// $LastChangedRevision: 4733 $ DO NOT EDIT.  Make changes to Voting.java instead.
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
public abstract class _Voting extends  ERXGenericRecord implements WOGWTServerEO {
  public static final String ENTITY_NAME = "Voting";

  // Attribute Keys
  public static final ERXKey<Integer> NUMBER_OF_VOTES = new ERXKey<Integer>("numberOfVotes");
  public static final ERXKey<Double> RUNNING_AVERAGE = new ERXKey<Double>("runningAverage");
  // Relationship Keys
  public static final ERXKey<your.app.server.eo.Movie> MOVIE = new ERXKey<your.app.server.eo.Movie>("movie");

  // Attributes
  public static final String NUMBER_OF_VOTES_KEY = NUMBER_OF_VOTES.key();
  public static final String RUNNING_AVERAGE_KEY = RUNNING_AVERAGE.key();
  // Relationships
  public static final String MOVIE_KEY = MOVIE.key();

  private static Logger LOG = Logger.getLogger(_Voting.class);

  public Voting localInstanceIn(EOEditingContext editingContext) {
    Voting localInstance = (Voting)EOUtilities.localInstanceOfObject(editingContext, this);
    if (localInstance == null) {
      throw new IllegalStateException("You attempted to localInstance " + this + ", which has not yet committed.");
    }
    return localInstance;
  }

  public Integer numberOfVotes() {
    return (Integer) storedValueForKey("numberOfVotes");
  }

  public void setNumberOfVotes(Integer value) {
    if (_Voting.LOG.isDebugEnabled()) {
    	_Voting.LOG.debug( "updating numberOfVotes from " + numberOfVotes() + " to " + value);
    }
    takeStoredValueForKey(value, "numberOfVotes");
  }

  public Double runningAverage() {
    return (Double) storedValueForKey("runningAverage");
  }

  public void setRunningAverage(Double value) {
    if (_Voting.LOG.isDebugEnabled()) {
    	_Voting.LOG.debug( "updating runningAverage from " + runningAverage() + " to " + value);
    }
    takeStoredValueForKey(value, "runningAverage");
  }

  public your.app.server.eo.Movie movie() {
    return (your.app.server.eo.Movie)storedValueForKey("movie");
  }
  
  public void setMovie(your.app.server.eo.Movie value) {
    takeStoredValueForKey(value, "movie");
  }

  public void setMovieRelationship(your.app.server.eo.Movie value) {
    if (_Voting.LOG.isDebugEnabled()) {
      _Voting.LOG.debug("updating movie from " + movie() + " to " + value);
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
  

  public static Voting createVoting(EOEditingContext editingContext, your.app.server.eo.Movie movie) {
    Voting eo = (Voting) EOUtilities.createAndInsertInstance(editingContext, _Voting.ENTITY_NAME);    
    eo.setMovieRelationship(movie);
    return eo;
  }

  public static NSArray<Voting> fetchAllVotings(EOEditingContext editingContext) {
    return _Voting.fetchAllVotings(editingContext, null);
  }

  public static NSArray<Voting> fetchAllVotings(EOEditingContext editingContext, NSArray<EOSortOrdering> sortOrderings) {
    return _Voting.fetchVotings(editingContext, null, sortOrderings);
  }

  public static NSArray<Voting> fetchVotings(EOEditingContext editingContext, EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings) {
    EOFetchSpecification fetchSpec = new EOFetchSpecification(_Voting.ENTITY_NAME, qualifier, sortOrderings);
    fetchSpec.setIsDeep(true);
    NSArray<Voting> eoObjects = (NSArray<Voting>)editingContext.objectsWithFetchSpecification(fetchSpec);
    return eoObjects;
  }

  public static Voting fetchVoting(EOEditingContext editingContext, String keyName, Object value) {
    return _Voting.fetchVoting(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static Voting fetchVoting(EOEditingContext editingContext, EOQualifier qualifier) {
    NSArray<Voting> eoObjects = _Voting.fetchVotings(editingContext, qualifier, null);
    Voting eoObject;
    int count = eoObjects.count();
    if (count == 0) {
      eoObject = null;
    }
    else if (count == 1) {
      eoObject = (Voting)eoObjects.objectAtIndex(0);
    }
    else {
      throw new IllegalStateException("There was more than one Voting that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static Voting fetchRequiredVoting(EOEditingContext editingContext, String keyName, Object value) {
    return _Voting.fetchRequiredVoting(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static Voting fetchRequiredVoting(EOEditingContext editingContext, EOQualifier qualifier) {
    Voting eoObject = _Voting.fetchVoting(editingContext, qualifier);
    if (eoObject == null) {
      throw new NoSuchElementException("There was no Voting that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static Voting localInstanceIn(EOEditingContext editingContext, Voting eo) {
    Voting localInstance = (eo == null) ? null : (Voting)EOUtilities.localInstanceOfObject(editingContext, eo);
    if (localInstance == null && eo != null) {
      throw new IllegalStateException("You attempted to localInstance " + eo + ", which has not yet committed.");
    }
    return localInstance;
  }

  public WOGWTClientEO toClientEO() {
    return new your.app.gwt.eo.VotingClient( WOGWTServerUtil.eoToDictionary(this) ); 
  }

  public WOGWTClientEO toClientEO(List<String> relatedKeyPathsToSerialize) {
    NSMutableDictionary data = WOGWTServerUtil.eoToDictionary(this).mutableClone();
	data.addEntriesFromDictionary(
			WOGWTServerUtil._keyPathsToClientEOs(this, relatedKeyPathsToSerialize));
    your.app.gwt.eo.VotingClient rec = new your.app.gwt.eo.VotingClient( data ); 
    return rec;
  }

}
