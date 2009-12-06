// $LastChangedRevision: 4733 $ DO NOT EDIT.  Make changes to PlotSummary.java instead.
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
public abstract class _PlotSummary extends  ERXGenericRecord implements WOGWTServerEO {
  public static final String ENTITY_NAME = "PlotSummary";

  // Attribute Keys
  public static final ERXKey<String> SUMMARY = new ERXKey<String>("summary");
  // Relationship Keys
  public static final ERXKey<your.app.server.eo.Movie> MOVIE = new ERXKey<your.app.server.eo.Movie>("movie");

  // Attributes
  public static final String SUMMARY_KEY = SUMMARY.key();
  // Relationships
  public static final String MOVIE_KEY = MOVIE.key();

  private static Logger LOG = Logger.getLogger(_PlotSummary.class);

  public PlotSummary localInstanceIn(EOEditingContext editingContext) {
    PlotSummary localInstance = (PlotSummary)EOUtilities.localInstanceOfObject(editingContext, this);
    if (localInstance == null) {
      throw new IllegalStateException("You attempted to localInstance " + this + ", which has not yet committed.");
    }
    return localInstance;
  }

  public String summary() {
    return (String) storedValueForKey("summary");
  }

  public void setSummary(String value) {
    if (_PlotSummary.LOG.isDebugEnabled()) {
    	_PlotSummary.LOG.debug( "updating summary from " + summary() + " to " + value);
    }
    takeStoredValueForKey(value, "summary");
  }

  public your.app.server.eo.Movie movie() {
    return (your.app.server.eo.Movie)storedValueForKey("movie");
  }
  
  public void setMovie(your.app.server.eo.Movie value) {
    takeStoredValueForKey(value, "movie");
  }

  public void setMovieRelationship(your.app.server.eo.Movie value) {
    if (_PlotSummary.LOG.isDebugEnabled()) {
      _PlotSummary.LOG.debug("updating movie from " + movie() + " to " + value);
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
  

  public static PlotSummary createPlotSummary(EOEditingContext editingContext, your.app.server.eo.Movie movie) {
    PlotSummary eo = (PlotSummary) EOUtilities.createAndInsertInstance(editingContext, _PlotSummary.ENTITY_NAME);    
    eo.setMovieRelationship(movie);
    return eo;
  }

  public static NSArray<PlotSummary> fetchAllPlotSummaries(EOEditingContext editingContext) {
    return _PlotSummary.fetchAllPlotSummaries(editingContext, null);
  }

  public static NSArray<PlotSummary> fetchAllPlotSummaries(EOEditingContext editingContext, NSArray<EOSortOrdering> sortOrderings) {
    return _PlotSummary.fetchPlotSummaries(editingContext, null, sortOrderings);
  }

  public static NSArray<PlotSummary> fetchPlotSummaries(EOEditingContext editingContext, EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings) {
    EOFetchSpecification fetchSpec = new EOFetchSpecification(_PlotSummary.ENTITY_NAME, qualifier, sortOrderings);
    fetchSpec.setIsDeep(true);
    NSArray<PlotSummary> eoObjects = (NSArray<PlotSummary>)editingContext.objectsWithFetchSpecification(fetchSpec);
    return eoObjects;
  }

  public static PlotSummary fetchPlotSummary(EOEditingContext editingContext, String keyName, Object value) {
    return _PlotSummary.fetchPlotSummary(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static PlotSummary fetchPlotSummary(EOEditingContext editingContext, EOQualifier qualifier) {
    NSArray<PlotSummary> eoObjects = _PlotSummary.fetchPlotSummaries(editingContext, qualifier, null);
    PlotSummary eoObject;
    int count = eoObjects.count();
    if (count == 0) {
      eoObject = null;
    }
    else if (count == 1) {
      eoObject = (PlotSummary)eoObjects.objectAtIndex(0);
    }
    else {
      throw new IllegalStateException("There was more than one PlotSummary that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static PlotSummary fetchRequiredPlotSummary(EOEditingContext editingContext, String keyName, Object value) {
    return _PlotSummary.fetchRequiredPlotSummary(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static PlotSummary fetchRequiredPlotSummary(EOEditingContext editingContext, EOQualifier qualifier) {
    PlotSummary eoObject = _PlotSummary.fetchPlotSummary(editingContext, qualifier);
    if (eoObject == null) {
      throw new NoSuchElementException("There was no PlotSummary that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static PlotSummary localInstanceIn(EOEditingContext editingContext, PlotSummary eo) {
    PlotSummary localInstance = (eo == null) ? null : (PlotSummary)EOUtilities.localInstanceOfObject(editingContext, eo);
    if (localInstance == null && eo != null) {
      throw new IllegalStateException("You attempted to localInstance " + eo + ", which has not yet committed.");
    }
    return localInstance;
  }

  public WOGWTClientEO toClientEO() {
    return new your.app.gwt.eo.PlotSummaryClient( WOGWTServerUtil.eoToDictionary(this) ); 
  }

  public WOGWTClientEO toClientEO(List<String> relatedKeyPathsToSerialize) {
    NSMutableDictionary data = WOGWTServerUtil.eoToDictionary(this).mutableClone();
	data.addEntriesFromDictionary(
			WOGWTServerUtil._keyPathsToClientEOs(this, relatedKeyPathsToSerialize));
    your.app.gwt.eo.PlotSummaryClient rec = new your.app.gwt.eo.PlotSummaryClient( data ); 
    return rec;
  }

}
