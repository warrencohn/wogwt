// DO NOT EDIT.  Make changes to Studio.java instead.
package your.app.gwt.eo;
// this must be in the client package

import java.util.*;
import java.math.BigDecimal;

import wogwt.translatable.WOGWTClientUtil;

import com.webobjects.eocontrol.EOEnterpriseObject;
import com.webobjects.foundation.NSArray;
import com.webobjects.foundation.NSMutableArray;
import com.webobjects.foundation.NSDictionary;
import com.webobjects.foundation.NSMutableDictionary;
import com.webobjects.foundation.NSKeyValueCoding;
import com.webobjects.foundation.NSKeyValueCodingAdditions;
import com.webobjects.foundation.NSTimestamp;
import com.webobjects.foundation.NSData;

// This class can be serialized from server to client and back
@SuppressWarnings("all")
public abstract class _Studio 
	extends com.webobjects.eocontrol.EOGenericRecord 
	implements wogwt.translatable.rpc.WOGWTSerializableEO {
		
	public static final transient String ENTITY_NAME = "Studio";
	public static final transient String BUDGET_KEY = "budget";
	public static final transient String NAME_KEY = "name";
	public static final transient String MOVIES_KEY = "movies";
	
	public Integer _rawPrimaryKey;
	public java.math.BigDecimal _budget;
	public String _name;
	public NSArray<your.app.gwt.eo.Movie> _movies = new NSArray<your.app.gwt.eo.Movie>();

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
				setBudget(WOGWTClientUtil.isNull(value) ? null : (java.math.BigDecimal)value);
				return;
			}
			if ("name".equals(key)) {
				setName(WOGWTClientUtil.isNull(value) ? null : (String)value);
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
		
}
