// DO NOT EDIT.  Make changes to Studio.java instead.
package your.app.gwt.eo;
// this must be in the client package

import java.util.*;
import java.math.BigDecimal;

import wogwt.translatable.WOGWTClientUtil;

import com.webobjects.eocontrol.*;
import com.webobjects.foundation.*;

// This class can be serialized from server to client and back
@SuppressWarnings("all")
public abstract class _Studio 
	extends com.webobjects.eocontrol.EOGenericRecord 
	implements wogwt.translatable.rpc.WOGWTSerializableEO {
		
	public static final transient String ENTITY_NAME = "Studio";
	public static final transient String BUDGET_KEY = "budget";
	public static final transient String NAME_KEY = "name";
	public static final transient String MOVIES_KEY = "movies";
	
	/* these fields are defined for serialization and to hold data on the client side;
	   can't use a plain Map because all the types must be explicit for optimal code */
	private java.math.BigDecimal _budget;
	private String _name;
	private NSArray<your.app.gwt.eo.Movie> _movies = new NSArray<your.app.gwt.eo.Movie>();

	public _Studio() {
		super();
	}
	
	// Attributes
	public java.math.BigDecimal budget() {
		return (java.math.BigDecimal) storedValueForKey("budget");
	}

	public void setBudget(java.math.BigDecimal value) {
		takeStoredValueForKey(value, "budget");
	}
	
	public String name() {
		return (String) storedValueForKey("name");
	}

	public void setName(String value) {
		takeStoredValueForKey(value, "name");
	}
	
  public NSArray<your.app.gwt.eo.Movie> movies() {
    return (NSArray<your.app.gwt.eo.Movie>)storedValueForKey("movies");
  }

	public void setMovies(NSArray<your.app.gwt.eo.Movie> aValue) {
		takeStoredValueForKey(aValue, "movies");
	}

  public NSArray<your.app.gwt.eo.Movie> movies(EOQualifier qualifier) {
    return movies(qualifier, null, false);
  }

  public NSArray<your.app.gwt.eo.Movie> movies(EOQualifier qualifier, boolean fetch) {
    return movies(qualifier, null, fetch);
  }

  public NSArray<your.app.gwt.eo.Movie> movies(EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings, boolean fetch) {
    NSArray<your.app.gwt.eo.Movie> results;

    results = movies();
    if (qualifier != null) {
      results = (NSArray<your.app.gwt.eo.Movie>)EOQualifier.filteredArrayWithQualifier(results, qualifier);
    }
    if (sortOrderings != null) {
      results = (NSArray<your.app.gwt.eo.Movie>)EOSortOrdering.sortedArrayUsingKeyOrderArray(results, sortOrderings);
    }

    return results;
  }
  
  public void addToMovies(your.app.gwt.eo.Movie object) {
    includeObjectIntoPropertyWithKey(object, "movies");
  }

  public void removeFromMovies(your.app.gwt.eo.Movie object) {
    excludeObjectFromPropertyWithKey(object, "movies");
  }

  public void addToMoviesRelationship(your.app.gwt.eo.Movie object) {
    addObjectToBothSidesOfRelationshipWithKey(object, "movies");
  }

  public void removeFromMoviesRelationship(your.app.gwt.eo.Movie object) {
    removeObjectFromBothSidesOfRelationshipWithKey(object, "movies");
  }

  public your.app.gwt.eo.Movie createMoviesRelationship() {
    EOEnterpriseObject eo = new your.app.gwt.eo.Movie();
    editingContext().insertObject(eo);
    addObjectToBothSidesOfRelationshipWithKey(eo, "movies");
    return (your.app.gwt.eo.Movie) eo;
  }

  public void deleteMoviesRelationship(your.app.gwt.eo.Movie object) {
    removeObjectFromBothSidesOfRelationshipWithKey(object, "movies");
    editingContext().deleteObject(object);
  }

  public void deleteAllMoviesRelationships() {
    Enumeration objects = movies().immutableClone().objectEnumerator();
    while (objects.hasMoreElements()) {
      deleteMoviesRelationship((your.app.gwt.eo.Movie)objects.nextElement());
    }
  }

	@Override
	public NSArray<String> attributeKeys() {
		NSArray<String> result = super.attributeKeys();
		if (result != null)
			return result;

		NSArray<String> keys = new NSArray<String>( new String[] {
			"budget",			
			"name"			
		});
		return keys;
	}
	
	@Override
	public NSArray<String> toOneRelationshipKeys() {
		NSArray<String> result = super.toOneRelationshipKeys();
		if (result != null)
			return result;
		
		NSArray<String> keys = new NSArray<String>( new String[] {	
		});
		
		return keys;
	}
	
	@Override
	public NSArray<String> toManyRelationshipKeys() {
		NSArray<String> result = super.toManyRelationshipKeys();
		if (result != null)
			return result;
		
		NSArray<String> keys = new NSArray<String>( new String[] {
			"movies",
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
		
		if ("movies".equals(relationshipKey))
			return deleteRuleNumber("EODeleteRuleNullify");

		return result;
	}
	
	@Override
	public String inverseForRelationshipKey(String relationshipKey) {
		String result = super.inverseForRelationshipKey(relationshipKey);
		if (result != null)
			return result;
		
		if ("movies".equals(relationshipKey))
			return "studio";

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
			else if ("budget".equals(key))
				return budget();
			else if ("name".equals(key))
				return name();
			else if ("movies".equals(key))
				return movies();
			else
				return handleQueryWithUnboundKey(key);
		}
	}
	
	@Override
	public void takeValueForKey(Object value, String key) {
		try {
			super.takeValueForKey(value, key);
		} catch (UnsupportedOperationException e) {
			if ("budget".equals(key)) {
				setBudget((value == null || value instanceof NSKeyValueCoding.Null) ? null : (java.math.BigDecimal)value);
				return;
			}
			if ("name".equals(key)) {
				setName((value == null || value instanceof NSKeyValueCoding.Null) ? null : (String)value);
				return;
			}
			if ("movies".equals(key)) {
				setMovies((NSArray<your.app.gwt.eo.Movie>)value);
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
			if ("budget".equals(key))
				return _budget;
			if ("name".equals(key))
				return _name;
			if ("movies".equals(key))
				return _movies;
			return handleQueryWithUnboundKey(key);
		}
	}
	
	@Override
	public void takeStoredValueForKey(Object value, String key) {
		try {
			super.takeStoredValueForKey(value, key);
		} catch (UnsupportedOperationException e) {
			if ("budget".equals(key)) {
				_budget = (java.math.BigDecimal)value;
				return;
			}
			if ("name".equals(key)) {
				_name = (String)value;
				return;
			}
			if ("movies".equals(key)) {
				_movies = (NSArray<your.app.gwt.eo.Movie>)value;
				return;
			}
			handleTakeValueForUnboundKey(value, key);
		}
	}
	
	protected void includeObjectIntoPropertyWithKey(Object eo, String key) {
		try {
			super.includeObjectIntoPropertyWithKey(eo, key);
		} catch (UnsupportedOperationException e) {
			if ("movies".equals(key)) {
				_movies = _movies.mutableClone();
				_movies.add((your.app.gwt.eo.Movie)eo);
				return;
			}
		}		
	}
	
	@Override
	protected void excludeObjectFromPropertyWithKey(Object eo, String key) {
		try {
			super.excludeObjectFromPropertyWithKey(eo, key);
		} catch (UnsupportedOperationException e) {
			if ("movies".equals(key)) {
				if (_movies.contains(eo)) {
					_movies = _movies.mutableClone();
					_movies.remove(eo);
					return;
				} else {
					throw new IllegalArgumentException("Relationship '" + key + "' does not contain object: " + eo);
				}
			}
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
		return "Studio";
	}
	
	public NSDictionary<String, Object> clientSnapshot() {
		NSDictionary<String, Object> result = new NSMutableDictionary();
		
		if (valueForKey("budget") != null)
			result.put("budget", valueForKey("budget"));
		else
			result.put("budget", NSKeyValueCoding.NullValue);

		if (valueForKey("name") != null)
			result.put("name", valueForKey("name"));
		else
			result.put("name", NSKeyValueCoding.NullValue);

		if (valueForKey("movies") != null)
			result.put("movies", valueForKey("movies"));
		else
			result.put("movies", NSArray.EmptyArray);

		return result.immutableClone();
	}
		
	public static Studio createStudio(EOEditingContext editingContext, java.math.BigDecimal budget
, String name
) {
		Studio eo = (Studio) new Studio(); editingContext.insertObject(eo);    
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
		EOFetchSpecification fetchSpec = new EOFetchSpecification(Studio.ENTITY_NAME, qualifier, sortOrderings);
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

	public static EOFetchSpecification RawFetchAllStudiosFetchSpec() {
        return EOFetchSpecification.fetchSpecificationNamed("RawFetchAllStudios", Studio.ENTITY_NAME);
	}
	
	public static EOFetchSpecification bindRawFetchAllStudios() {
	    EOFetchSpecification spec = EOFetchSpecification.fetchSpecificationNamed("RawFetchAllStudios", Studio.ENTITY_NAME);
	    return spec;
	} 

	/**
	 * RAW ROW KEY PATHS:
     * name
     * studioID
	 */
	public static NSArray<NSDictionary> objectsForRawFetchAllStudios(EOEditingContext ec) {
        EOFetchSpecification spec = bindRawFetchAllStudios();
        return ec.objectsWithFetchSpecification(spec);        
	}
	

}
