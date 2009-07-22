// DO NOT EDIT.  Make changes to MovieRole.java instead.
package your.app.gwt.eo;
// this must be in the client package

import java.util.*;
import java.math.BigDecimal;

import wogwt.translatable.WOGWTClientUtil;

import com.webobjects.eocontrol.*;
import com.webobjects.foundation.*;

// This class can be serialized from server to client and back
@SuppressWarnings("all")
public abstract class _MovieRole 
	extends com.webobjects.eocontrol.EOGenericRecord 
	implements wogwt.translatable.rpc.WOGWTSerializableEO {
		
	public static final transient String ENTITY_NAME = "MovieRole";
	public static final transient String ROLE_NAME_KEY = "roleName";
	public static final transient String MOVIE_KEY = "movie";
	public static final transient String TALENT_KEY = "talent";
	
	/* these fields are defined for serialization and to hold data on the client side;
	   can't use a plain Map because all the types must be explicit for optimal code */
	private String _roleName;
	private your.app.gwt.eo.Movie _movie;
	private your.app.gwt.eo.Talent _talent;

	public _MovieRole() {
		super();
	}
	
	// Attributes
	public String roleName() {
		return (String) storedValueForKey("roleName");
	}

	public void setRoleName(String value) {
		takeStoredValueForKey(value, "roleName");
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
  
	public your.app.gwt.eo.Talent talent() {
		return (your.app.gwt.eo.Talent)storedValueForKey("talent");
	}
  
	public void setTalentRelationship(your.app.gwt.eo.Talent value) {
		if (value == null) {
			your.app.gwt.eo.Talent oldValue = talent();
			if (oldValue != null) {
				removeObjectFromBothSidesOfRelationshipWithKey(oldValue, "talent");
			}
		} else {
			addObjectToBothSidesOfRelationshipWithKey(value, "talent");
		}
	}
  
	@Override
	public NSArray<String> attributeKeys() {
		NSArray<String> result = super.attributeKeys();
		if (result != null)
			return result;

		NSArray<String> keys = new NSArray<String>( new String[] {
			"roleName"			
		});
		return keys;
	}
	
	@Override
	public NSArray<String> toOneRelationshipKeys() {
		NSArray<String> result = super.toOneRelationshipKeys();
		if (result != null)
			return result;
		
		NSArray<String> keys = new NSArray<String>( new String[] {	
			"movie",			
			"talent"			
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
		if ("talent".equals(relationshipKey))
			return deleteRuleNumber("EODeleteRuleNullify");

		return result;
	}
	
	@Override
	public String inverseForRelationshipKey(String relationshipKey) {
		String result = super.inverseForRelationshipKey(relationshipKey);
		if (result != null)
			return result;
		
		if ("talent".equals(relationshipKey))
			return "roles";

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
			else if ("roleName".equals(key))
				return roleName();
			else if ("movie".equals(key))
				return movie();
			else if ("talent".equals(key))
				return talent();
			else
				return handleQueryWithUnboundKey(key);
		}
	}
	
	@Override
	public void takeValueForKey(Object value, String key) {
		try {
			super.takeValueForKey(value, key);
		} catch (UnsupportedOperationException e) {
			if ("roleName".equals(key)) {
				setRoleName((value == null || value instanceof NSKeyValueCoding.Null) ? null : (String)value);
				return;
			}
			if ("movie".equals(key)) {
				setMovieRelationship((value == null || value instanceof NSKeyValueCoding.Null) ? null : (your.app.gwt.eo.Movie)value);
				return;
			}
			if ("talent".equals(key)) {
				setTalentRelationship((value == null || value instanceof NSKeyValueCoding.Null) ? null : (your.app.gwt.eo.Talent)value);
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
			if ("roleName".equals(key))
				return _roleName;
			if ("movie".equals(key))
				return _movie;
			if ("talent".equals(key))
				return _talent;
			return handleQueryWithUnboundKey(key);
		}
	}
	
	@Override
	public void takeStoredValueForKey(Object value, String key) {
		try {
			super.takeStoredValueForKey(value, key);
		} catch (UnsupportedOperationException e) {
			if ("roleName".equals(key)) {
				_roleName = (String)value;
				return;
			}
			if ("movie".equals(key)) {
				_movie = (your.app.gwt.eo.Movie)value;
				return;
			}
			if ("talent".equals(key)) {
				_talent = (your.app.gwt.eo.Talent)value;
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
		return "MovieRole";
	}
	
	public NSDictionary<String, Object> clientSnapshot() {
		NSDictionary<String, Object> result = new NSMutableDictionary();
		
		if (valueForKey("roleName") != null)
			result.put("roleName", valueForKey("roleName"));
		else
			result.put("roleName", NSKeyValueCoding.NullValue);

		if (valueForKey("movie") != null)
			result.put("movie", valueForKey("movie"));
		else
			result.put("movie", NSKeyValueCoding.NullValue);

		if (valueForKey("talent") != null)
			result.put("talent", valueForKey("talent"));
		else
			result.put("talent", NSKeyValueCoding.NullValue);

		return result.immutableClone();
	}
		
	public static MovieRole createMovieRole(EOEditingContext editingContext, your.app.gwt.eo.Movie movie, your.app.gwt.eo.Talent talent) {
		MovieRole eo = (MovieRole) new MovieRole(); editingContext.insertObject(eo);    
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
		EOFetchSpecification fetchSpec = new EOFetchSpecification(MovieRole.ENTITY_NAME, qualifier, sortOrderings);
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


}
