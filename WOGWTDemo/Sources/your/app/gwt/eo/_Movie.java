// DO NOT EDIT.  Make changes to Movie.java instead.
package your.app.gwt.eo;
// this must be in the client package

import java.util.*;
import java.math.BigDecimal;

import wogwt.translatable.WOGWTClientUtil;

import com.webobjects.eocontrol.*;
import com.webobjects.foundation.*;

// This class can be serialized from server to client and back
@SuppressWarnings("all")
public abstract class _Movie 
	extends com.webobjects.eocontrol.EOGenericRecord 
	implements wogwt.translatable.rpc.WOGWTSerializableEO {
		
	public static final transient String ENTITY_NAME = "Movie";
	public static final transient String CATEGORY_KEY = "category";
	public static final transient String DATE_RELEASED_KEY = "dateReleased";
	public static final transient String POSTER_NAME_KEY = "posterName";
	public static final transient String RATED_KEY = "rated";
	public static final transient String REVENUE_KEY = "revenue";
	public static final transient String TITLE_KEY = "title";
	public static final transient String TRAILER_NAME_KEY = "trailerName";
	public static final transient String STUDIO_KEY = "studio";
	
	/* these fields are defined for serialization and to hold data on the client side;
	   can't use a plain Map because all the types must be explicit for optimal code */
	private String _category;
	private NSTimestamp _dateReleased;
	private String _posterName;
	private String _rated;
	private java.math.BigDecimal _revenue;
	private String _title;
	private String _trailerName;
	private your.app.gwt.eo.Studio _studio;

	public _Movie() {
		super();
	}
	
	// Attributes
	public String category() {
		return (String) storedValueForKey("category");
	}

	public void setCategory(String value) {
		takeStoredValueForKey(value, "category");
	}
	
	public NSTimestamp dateReleased() {
		return (NSTimestamp) storedValueForKey("dateReleased");
	}

	public void setDateReleased(NSTimestamp value) {
		takeStoredValueForKey(value, "dateReleased");
	}
	
	public String posterName() {
		return (String) storedValueForKey("posterName");
	}

	public void setPosterName(String value) {
		takeStoredValueForKey(value, "posterName");
	}
	
	public String rated() {
		return (String) storedValueForKey("rated");
	}

	public void setRated(String value) {
		takeStoredValueForKey(value, "rated");
	}
	
	public java.math.BigDecimal revenue() {
		return (java.math.BigDecimal) storedValueForKey("revenue");
	}

	public void setRevenue(java.math.BigDecimal value) {
		takeStoredValueForKey(value, "revenue");
	}
	
	public String title() {
		return (String) storedValueForKey("title");
	}

	public void setTitle(String value) {
		takeStoredValueForKey(value, "title");
	}
	
	public String trailerName() {
		return (String) storedValueForKey("trailerName");
	}

	public void setTrailerName(String value) {
		takeStoredValueForKey(value, "trailerName");
	}
	
	public your.app.gwt.eo.Studio studio() {
		return (your.app.gwt.eo.Studio)storedValueForKey("studio");
	}
  
	public void setStudioRelationship(your.app.gwt.eo.Studio value) {
		if (value == null) {
			your.app.gwt.eo.Studio oldValue = studio();
			if (oldValue != null) {
				removeObjectFromBothSidesOfRelationshipWithKey(oldValue, "studio");
			}
		} else {
			addObjectToBothSidesOfRelationshipWithKey(value, "studio");
		}
	}
  
	@Override
	public NSArray<String> attributeKeys() {
		NSArray<String> result = super.attributeKeys();
		if (result != null)
			return result;

		NSArray<String> keys = new NSArray<String>( new String[] {
			"category",			
			"dateReleased",			
			"posterName",			
			"rated",			
			"revenue",			
			"title",			
			"trailerName"			
		});
		return keys;
	}
	
	@Override
	public NSArray<String> toOneRelationshipKeys() {
		NSArray<String> result = super.toOneRelationshipKeys();
		if (result != null)
			return result;
		
		NSArray<String> keys = new NSArray<String>( new String[] {	
			"studio"			
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
		
		if ("studio".equals(relationshipKey))
			return deleteRuleNumber("EODeleteRuleNullify");

		return result;
	}
	
	@Override
	public String inverseForRelationshipKey(String relationshipKey) {
		String result = super.inverseForRelationshipKey(relationshipKey);
		if (result != null)
			return result;
		
		if ("studio".equals(relationshipKey))
			return "movies";

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
			else if ("category".equals(key))
				return category();
			else if ("dateReleased".equals(key))
				return dateReleased();
			else if ("posterName".equals(key))
				return posterName();
			else if ("rated".equals(key))
				return rated();
			else if ("revenue".equals(key))
				return revenue();
			else if ("title".equals(key))
				return title();
			else if ("trailerName".equals(key))
				return trailerName();
			else if ("studio".equals(key))
				return studio();
			else
				return handleQueryWithUnboundKey(key);
		}
	}
	
	@Override
	public void takeValueForKey(Object value, String key) {
		try {
			super.takeValueForKey(value, key);
		} catch (UnsupportedOperationException e) {
			if ("category".equals(key)) {
				setCategory((value == null || value instanceof NSKeyValueCoding.Null) ? null : (String)value);
				return;
			}
			if ("dateReleased".equals(key)) {
				setDateReleased((value == null || value instanceof NSKeyValueCoding.Null) ? null : (NSTimestamp)value);
				return;
			}
			if ("posterName".equals(key)) {
				setPosterName((value == null || value instanceof NSKeyValueCoding.Null) ? null : (String)value);
				return;
			}
			if ("rated".equals(key)) {
				setRated((value == null || value instanceof NSKeyValueCoding.Null) ? null : (String)value);
				return;
			}
			if ("revenue".equals(key)) {
				setRevenue((value == null || value instanceof NSKeyValueCoding.Null) ? null : (java.math.BigDecimal)value);
				return;
			}
			if ("title".equals(key)) {
				setTitle((value == null || value instanceof NSKeyValueCoding.Null) ? null : (String)value);
				return;
			}
			if ("trailerName".equals(key)) {
				setTrailerName((value == null || value instanceof NSKeyValueCoding.Null) ? null : (String)value);
				return;
			}
			if ("studio".equals(key)) {
				setStudioRelationship((value == null || value instanceof NSKeyValueCoding.Null) ? null : (your.app.gwt.eo.Studio)value);
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
			if ("category".equals(key))
				return _category;
			if ("dateReleased".equals(key))
				return _dateReleased;
			if ("posterName".equals(key))
				return _posterName;
			if ("rated".equals(key))
				return _rated;
			if ("revenue".equals(key))
				return _revenue;
			if ("title".equals(key))
				return _title;
			if ("trailerName".equals(key))
				return _trailerName;
			if ("studio".equals(key))
				return _studio;
			return handleQueryWithUnboundKey(key);
		}
	}
	
	@Override
	public void takeStoredValueForKey(Object value, String key) {
		try {
			super.takeStoredValueForKey(value, key);
		} catch (UnsupportedOperationException e) {
			if ("category".equals(key)) {
				_category = (String)value;
				return;
			}
			if ("dateReleased".equals(key)) {
				_dateReleased = (NSTimestamp)value;
				return;
			}
			if ("posterName".equals(key)) {
				_posterName = (String)value;
				return;
			}
			if ("rated".equals(key)) {
				_rated = (String)value;
				return;
			}
			if ("revenue".equals(key)) {
				_revenue = (java.math.BigDecimal)value;
				return;
			}
			if ("title".equals(key)) {
				_title = (String)value;
				return;
			}
			if ("trailerName".equals(key)) {
				_trailerName = (String)value;
				return;
			}
			if ("studio".equals(key)) {
				_studio = (your.app.gwt.eo.Studio)value;
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
		return "Movie";
	}
	
	public NSDictionary<String, Object> clientSnapshot() {
		NSDictionary<String, Object> result = new NSMutableDictionary();
		
		if (valueForKey("category") != null)
			result.put("category", valueForKey("category"));
		else
			result.put("category", NSKeyValueCoding.NullValue);

		if (valueForKey("dateReleased") != null)
			result.put("dateReleased", valueForKey("dateReleased"));
		else
			result.put("dateReleased", NSKeyValueCoding.NullValue);

		if (valueForKey("posterName") != null)
			result.put("posterName", valueForKey("posterName"));
		else
			result.put("posterName", NSKeyValueCoding.NullValue);

		if (valueForKey("rated") != null)
			result.put("rated", valueForKey("rated"));
		else
			result.put("rated", NSKeyValueCoding.NullValue);

		if (valueForKey("revenue") != null)
			result.put("revenue", valueForKey("revenue"));
		else
			result.put("revenue", NSKeyValueCoding.NullValue);

		if (valueForKey("title") != null)
			result.put("title", valueForKey("title"));
		else
			result.put("title", NSKeyValueCoding.NullValue);

		if (valueForKey("trailerName") != null)
			result.put("trailerName", valueForKey("trailerName"));
		else
			result.put("trailerName", NSKeyValueCoding.NullValue);

		if (valueForKey("studio") != null)
			result.put("studio", valueForKey("studio"));
		else
			result.put("studio", NSKeyValueCoding.NullValue);

		return result.immutableClone();
	}
		
	public static Movie createMovie(EOEditingContext editingContext, String title
) {
		Movie eo = (Movie) new Movie(); editingContext.insertObject(eo);    
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
		EOFetchSpecification fetchSpec = new EOFetchSpecification(Movie.ENTITY_NAME, qualifier, sortOrderings);
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

	public static EOFetchSpecification DeepFetchOneMovieFetchSpec() {
        return EOFetchSpecification.fetchSpecificationNamed("DeepFetchOneMovie", Movie.ENTITY_NAME);
	}
	
	public static EOFetchSpecification QualifierVariableFetchSpec() {
        return EOFetchSpecification.fetchSpecificationNamed("QualifierVariable", Movie.ENTITY_NAME);
	}
	
	public static EOFetchSpecification RawFetchAllMoviesFetchSpec() {
        return EOFetchSpecification.fetchSpecificationNamed("RawFetchAllMovies", Movie.ENTITY_NAME);
	}
	
	public static EOFetchSpecification bindDeepFetchOneMovie(Integer myMovieBinding) {
	    EOFetchSpecification spec = EOFetchSpecification.fetchSpecificationNamed("DeepFetchOneMovie", Movie.ENTITY_NAME);
	    	
	    NSMutableDictionary bindings = new NSMutableDictionary();
	    if (myMovieBinding != null)
	        bindings.setObjectForKey(myMovieBinding, "myMovie");
	    spec = spec.fetchSpecificationWithQualifierBindings(bindings);
	    
	    return spec;
	} 

	public static EOFetchSpecification bindQualifierVariable(java.math.BigDecimal revenueBinding, your.app.gwt.eo.Studio studioBinding, String studioNameBinding, String titleBinding) {
	    EOFetchSpecification spec = EOFetchSpecification.fetchSpecificationNamed("QualifierVariable", Movie.ENTITY_NAME);
	    	
	    NSMutableDictionary bindings = new NSMutableDictionary();
	    if (revenueBinding != null)
	        bindings.setObjectForKey(revenueBinding, "revenue");
	    if (studioBinding != null)
	        bindings.setObjectForKey(studioBinding, "studio");
	    if (studioNameBinding != null)
	        bindings.setObjectForKey(studioNameBinding, "studioName");
	    if (titleBinding != null)
	        bindings.setObjectForKey(titleBinding, "title");
	    spec = spec.fetchSpecificationWithQualifierBindings(bindings);
	    
	    return spec;
	} 

	public static EOFetchSpecification bindRawFetchAllMovies() {
	    EOFetchSpecification spec = EOFetchSpecification.fetchSpecificationNamed("RawFetchAllMovies", Movie.ENTITY_NAME);
	    return spec;
	} 

	public static NSArray<Movie> objectsForDeepFetchOneMovie(EOEditingContext ec,
			Integer myMovieBinding) {
        EOFetchSpecification spec = bindDeepFetchOneMovie(myMovieBinding);
        return ec.objectsWithFetchSpecification(spec);        
	}
	
	public static NSArray<Movie> objectsForQualifierVariable(EOEditingContext ec,
			java.math.BigDecimal revenueBinding,
			your.app.gwt.eo.Studio studioBinding,
			String studioNameBinding,
			String titleBinding) {
        EOFetchSpecification spec = bindQualifierVariable(revenueBinding, studioBinding, studioNameBinding, titleBinding);
        return ec.objectsWithFetchSpecification(spec);        
	}
	
	/**
	 * RAW ROW KEY PATHS:
     * movieID
     * title
	 */
	public static NSArray<NSDictionary> objectsForRawFetchAllMovies(EOEditingContext ec) {
        EOFetchSpecification spec = bindRawFetchAllMovies();
        return ec.objectsWithFetchSpecification(spec);        
	}
	

}
