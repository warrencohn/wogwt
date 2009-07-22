// DO NOT EDIT.  Make changes to PlotSummary.java instead.
package your.app.gwt.eo;
// this must be in the client package

import java.util.*;
import java.math.BigDecimal;

import wogwt.translatable.WOGWTClientUtil;

import com.webobjects.eocontrol.*;
import com.webobjects.foundation.*;

// This class can be serialized from server to client and back
@SuppressWarnings("all")
public abstract class _PlotSummary 
	extends com.webobjects.eocontrol.EOGenericRecord 
	implements wogwt.translatable.rpc.WOGWTSerializableEO {
		
	public static final transient String ENTITY_NAME = "PlotSummary";
	public static final transient String SUMMARY_KEY = "summary";
	public static final transient String MOVIE_KEY = "movie";
	
	/* these fields are defined for serialization and to hold data on the client side;
	   can't use a plain Map because all the types must be explicit for optimal code */
	private String _summary;
	private your.app.gwt.eo.Movie _movie;

	public _PlotSummary() {
		super();
	}
	
	// Attributes
	public String summary() {
		return (String) storedValueForKey("summary");
	}

	public void setSummary(String value) {
		takeStoredValueForKey(value, "summary");
	}
	
	public your.app.gwt.eo.Movie movie() {
		return (your.app.gwt.eo.Movie)storedValueForKey("movie");
	}
  
	public void setMovieRelationship(your.app.gwt.eo.Movie value) {
		if (value == null) {
			your.app.gwt.eo.Movie oldValue = movie();
			if (oldValue != null) {
				removeObjectFromBothSidesOfRelationshipWithKey(oldValue, "movie");
			}
		} else {
			addObjectToBothSidesOfRelationshipWithKey(value, "movie");
		}
	}
  
	@Override
	public NSArray<String> attributeKeys() {
		NSArray<String> result = super.attributeKeys();
		if (result != null)
			return result;

		NSArray<String> keys = new NSArray<String>( new String[] {
			"summary"			
		});
		return keys;
	}
	
	@Override
	public NSArray<String> toOneRelationshipKeys() {
		NSArray<String> result = super.toOneRelationshipKeys();
		if (result != null)
			return result;
		
		NSArray<String> keys = new NSArray<String>( new String[] {	
			"movie"			
		});
		
		return keys;
	}
	
	@Override
	public NSArray<String> toManyRelationshipKeys() {
		NSArray<String> result = super.toManyRelationshipKeys();
		if (result != null)
			return result;
		
		NSArray<String> keys = new NSArray<String>( new String[] {
		});
		
    	return keys;
	}
	
	public int deleteRuleNumber(String deleteRuleName) {
		if ("EODeleteRuleNullify".equals(deleteRuleName)) {
			return 0;
		} else if ("EODeleteRuleCascade".equals(deleteRuleName)) {
			return 1;
		} else if ("EODeleteRuleDeny".equals(deleteRuleName)) {
			return 2;
		} else if ("EODeleteRuleNoAction".equals(deleteRuleName)) {
			return 3;
		} else {
			return -1;
		}
	}
	
	@Override
	public int deleteRuleForRelationshipKey(String relationshipKey) {
		int result = super.deleteRuleForRelationshipKey(relationshipKey);
		if (result != -1)
			return result;
		
		if ("movie".equals(relationshipKey))
			return deleteRuleNumber("EODeleteRuleNullify");

		return result;
	}
	
	@Override
	public String inverseForRelationshipKey(String relationshipKey) {
		String result = super.inverseForRelationshipKey(relationshipKey);
		if (result != null)
			return result;
		

		return null;
	}
	
	@Override
	public boolean isReadOnly() {
		return false;
	}
	
	@Override
	public boolean ownsDestinationObjectsForRelationshipKey(String relationshipKey) {
		try {
			return super.ownsDestinationObjectsForRelationshipKey(relationshipKey);
		} catch (UnsupportedOperationException e) {
			return false;
		}
	}
	
	@Override
	public Object valueForKey(String key) {
		try {
			return super.valueForKey(key);
		} catch (UnsupportedOperationException e) {
			if ("entityName".equals(key))
				return entityName();
			else if ("summary".equals(key))
				return summary();
			else if ("movie".equals(key))
				return movie();
			else
				return handleQueryWithUnboundKey(key);
		}
	}
	
	@Override
	public void takeValueForKey(Object value, String key) {
		try {
			super.takeValueForKey(value, key);
		} catch (UnsupportedOperationException e) {
			if ("summary".equals(key)) {
				setSummary((value == null || value instanceof NSKeyValueCoding.Null) ? null : (String)value);
				return;
			}
			if ("movie".equals(key)) {
				setMovieRelationship((value == null || value instanceof NSKeyValueCoding.Null) ? null : (your.app.gwt.eo.Movie)value);
				return;
			}
			handleTakeValueForUnboundKey(value, key);
		}
	}
	
	@Override
	public Object storedValueForKey(String key) {
		try {
			return super.storedValueForKey(key);
		} catch (UnsupportedOperationException e) {
			if ("summary".equals(key))
				return _summary;
			if ("movie".equals(key))
				return _movie;
			return handleQueryWithUnboundKey(key);
		}
	}
	
	@Override
	public void takeStoredValueForKey(Object value, String key) {
		try {
			super.takeStoredValueForKey(value, key);
		} catch (UnsupportedOperationException e) {
			if ("summary".equals(key)) {
				_summary = (String)value;
				return;
			}
			if ("movie".equals(key)) {
				_movie = (your.app.gwt.eo.Movie)value;
				return;
			}
			handleTakeValueForUnboundKey(value, key);
		}
	}
	
	protected void includeObjectIntoPropertyWithKey(Object eo, String key) {
		try {
			super.includeObjectIntoPropertyWithKey(eo, key);
		} catch (UnsupportedOperationException e) {
		}		
	}
	
	@Override
	protected void excludeObjectFromPropertyWithKey(Object eo, String key) {
		try {
			super.excludeObjectFromPropertyWithKey(eo, key);
		} catch (UnsupportedOperationException e) {
		}
	}
	
	public Object handleQueryWithUnboundKey(String key) {
		if ("__globalID".equals(key) || "__isFault".equals(key)) {
			return null;
		} else {
			throw new NSKeyValueCoding.UnknownKeyException("Class '" + getClass().getName() + " does not have a client key named " + key, this, key);
		}	
	}
	
	public void handleTakeValueForUnboundKey(Object value, String key) {
		if ("__globalID".equals(key) || "__isFault".equals(key)) {
			return;
		} else {
			throw new NSKeyValueCoding.UnknownKeyException("Class '" + getClass().getName() + " does not have a client key named " + key, this, key);
		}
	}
	
	@Override
	public String entityName() {
		return "PlotSummary";
	}
	
	public NSDictionary<String, Object> clientSnapshot() {
		NSDictionary<String, Object> result = new NSMutableDictionary();
		
		if (valueForKey("summary") != null)
			result.put("summary", valueForKey("summary"));
		else
			result.put("summary", NSKeyValueCoding.NullValue);

		if (valueForKey("movie") != null)
			result.put("movie", valueForKey("movie"));
		else
			result.put("movie", NSKeyValueCoding.NullValue);

		return result.immutableClone();
	}
		
	public static PlotSummary createPlotSummary(EOEditingContext editingContext, your.app.gwt.eo.Movie movie) {
		PlotSummary eo = (PlotSummary) new PlotSummary(); editingContext.insertObject(eo);    
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
		EOFetchSpecification fetchSpec = new EOFetchSpecification(PlotSummary.ENTITY_NAME, qualifier, sortOrderings);
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


}
