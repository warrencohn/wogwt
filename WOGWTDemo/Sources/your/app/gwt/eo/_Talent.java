// DO NOT EDIT.  Make changes to Talent.java instead.
package your.app.gwt.eo;
// this must be in the client package

import java.util.*;
import java.math.BigDecimal;

import wogwt.translatable.WOGWTClientUtil;

import com.webobjects.eocontrol.*;
import com.webobjects.foundation.*;

// This class can be serialized from server to client and back
@SuppressWarnings("all")
public abstract class _Talent 
	extends com.webobjects.eocontrol.EOGenericRecord 
	implements wogwt.translatable.rpc.WOGWTSerializableEO {
		
	public static final transient String ENTITY_NAME = "Talent";
	public static final transient String FIRST_NAME_KEY = "firstName";
	public static final transient String LAST_NAME_KEY = "lastName";
	public static final transient String MOVIES_DIRECTED_KEY = "moviesDirected";
	public static final transient String PHOTO_KEY = "photo";
	public static final transient String ROLES_KEY = "roles";
	
	/* these fields are defined for serialization and to hold data on the client side;
	   can't use a plain Map because all the types must be explicit for optimal code */
	private String _firstName;
	private String _lastName;
	private your.app.gwt.eo.TalentPhoto _photo;
	private NSArray<your.app.gwt.eo.Movie> _moviesDirected = new NSArray<your.app.gwt.eo.Movie>();
	private NSArray<your.app.gwt.eo.MovieRole> _roles = new NSArray<your.app.gwt.eo.MovieRole>();

	public _Talent() {
		super();
	}
	
	// Attributes
	public String firstName() {
		return (String) storedValueForKey("firstName");
	}

	public void setFirstName(String value) {
		takeStoredValueForKey(value, "firstName");
	}
	
	public String lastName() {
		return (String) storedValueForKey("lastName");
	}

	public void setLastName(String value) {
		takeStoredValueForKey(value, "lastName");
	}
	
	public your.app.gwt.eo.TalentPhoto photo() {
		return (your.app.gwt.eo.TalentPhoto)storedValueForKey("photo");
	}
  
	public void setPhotoRelationship(your.app.gwt.eo.TalentPhoto value) {
		if (value == null) {
			your.app.gwt.eo.TalentPhoto oldValue = photo();
			if (oldValue != null) {
				removeObjectFromBothSidesOfRelationshipWithKey(oldValue, "photo");
			}
		} else {
			addObjectToBothSidesOfRelationshipWithKey(value, "photo");
		}
	}
  
  public NSArray<your.app.gwt.eo.Movie> moviesDirected() {
    return (NSArray<your.app.gwt.eo.Movie>)storedValueForKey("moviesDirected");
  }

	public void setMoviesDirected(NSArray<your.app.gwt.eo.Movie> aValue) {
		takeStoredValueForKey(aValue, "moviesDirected");
	}

  public NSArray<your.app.gwt.eo.Movie> moviesDirected(EOQualifier qualifier) {
    return moviesDirected(qualifier, null);
  }

  public NSArray<your.app.gwt.eo.Movie> moviesDirected(EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings) {
    NSArray<your.app.gwt.eo.Movie> results;

    results = moviesDirected();
    if (qualifier != null) {
      results = (NSArray<your.app.gwt.eo.Movie>)EOQualifier.filteredArrayWithQualifier(results, qualifier);
    }
    if (sortOrderings != null) {
      results = (NSArray<your.app.gwt.eo.Movie>)EOSortOrdering.sortedArrayUsingKeyOrderArray(results, sortOrderings);
    }

    return results;
  }
  
  public void addToMoviesDirected(your.app.gwt.eo.Movie object) {
    includeObjectIntoPropertyWithKey(object, "moviesDirected");
  }

  public void removeFromMoviesDirected(your.app.gwt.eo.Movie object) {
    excludeObjectFromPropertyWithKey(object, "moviesDirected");
  }

  public void addToMoviesDirectedRelationship(your.app.gwt.eo.Movie object) {
    addObjectToBothSidesOfRelationshipWithKey(object, "moviesDirected");
  }

  public void removeFromMoviesDirectedRelationship(your.app.gwt.eo.Movie object) {
    removeObjectFromBothSidesOfRelationshipWithKey(object, "moviesDirected");
  }

  public your.app.gwt.eo.Movie createMoviesDirectedRelationship() {
    EOEnterpriseObject eo = new your.app.gwt.eo.Movie();
    editingContext().insertObject(eo);
    addObjectToBothSidesOfRelationshipWithKey(eo, "moviesDirected");
    return (your.app.gwt.eo.Movie) eo;
  }

  public void deleteMoviesDirectedRelationship(your.app.gwt.eo.Movie object) {
    removeObjectFromBothSidesOfRelationshipWithKey(object, "moviesDirected");
    editingContext().deleteObject(object);
  }

  public void deleteAllMoviesDirectedRelationships() {
    Enumeration objects = moviesDirected().immutableClone().objectEnumerator();
    while (objects.hasMoreElements()) {
      deleteMoviesDirectedRelationship((your.app.gwt.eo.Movie)objects.nextElement());
    }
  }

  public NSArray<your.app.gwt.eo.MovieRole> roles() {
    return (NSArray<your.app.gwt.eo.MovieRole>)storedValueForKey("roles");
  }

	public void setRoles(NSArray<your.app.gwt.eo.MovieRole> aValue) {
		takeStoredValueForKey(aValue, "roles");
	}

  public NSArray<your.app.gwt.eo.MovieRole> roles(EOQualifier qualifier) {
    return roles(qualifier, null, false);
  }

  public NSArray<your.app.gwt.eo.MovieRole> roles(EOQualifier qualifier, boolean fetch) {
    return roles(qualifier, null, fetch);
  }

  public NSArray<your.app.gwt.eo.MovieRole> roles(EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings, boolean fetch) {
    NSArray<your.app.gwt.eo.MovieRole> results;

    results = roles();
    if (qualifier != null) {
      results = (NSArray<your.app.gwt.eo.MovieRole>)EOQualifier.filteredArrayWithQualifier(results, qualifier);
    }
    if (sortOrderings != null) {
      results = (NSArray<your.app.gwt.eo.MovieRole>)EOSortOrdering.sortedArrayUsingKeyOrderArray(results, sortOrderings);
    }

    return results;
  }
  
  public void addToRoles(your.app.gwt.eo.MovieRole object) {
    includeObjectIntoPropertyWithKey(object, "roles");
  }

  public void removeFromRoles(your.app.gwt.eo.MovieRole object) {
    excludeObjectFromPropertyWithKey(object, "roles");
  }

  public void addToRolesRelationship(your.app.gwt.eo.MovieRole object) {
    addObjectToBothSidesOfRelationshipWithKey(object, "roles");
  }

  public void removeFromRolesRelationship(your.app.gwt.eo.MovieRole object) {
    removeObjectFromBothSidesOfRelationshipWithKey(object, "roles");
  }

  public your.app.gwt.eo.MovieRole createRolesRelationship() {
    EOEnterpriseObject eo = new your.app.gwt.eo.MovieRole();
    editingContext().insertObject(eo);
    addObjectToBothSidesOfRelationshipWithKey(eo, "roles");
    return (your.app.gwt.eo.MovieRole) eo;
  }

  public void deleteRolesRelationship(your.app.gwt.eo.MovieRole object) {
    removeObjectFromBothSidesOfRelationshipWithKey(object, "roles");
    editingContext().deleteObject(object);
  }

  public void deleteAllRolesRelationships() {
    Enumeration objects = roles().immutableClone().objectEnumerator();
    while (objects.hasMoreElements()) {
      deleteRolesRelationship((your.app.gwt.eo.MovieRole)objects.nextElement());
    }
  }

	@Override
	public NSArray<String> attributeKeys() {
		NSArray<String> result = super.attributeKeys();
		if (result != null)
			return result;

		NSArray<String> keys = new NSArray<String>( new String[] {
			"firstName",			
			"lastName"			
		});
		return keys;
	}
	
	@Override
	public NSArray<String> toOneRelationshipKeys() {
		NSArray<String> result = super.toOneRelationshipKeys();
		if (result != null)
			return result;
		
		NSArray<String> keys = new NSArray<String>( new String[] {	
			"photo"			
		});
		
		return keys;
	}
	
	@Override
	public NSArray<String> toManyRelationshipKeys() {
		NSArray<String> result = super.toManyRelationshipKeys();
		if (result != null)
			return result;
		
		NSArray<String> keys = new NSArray<String>( new String[] {
			"moviesDirected",
			"roles"
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
		
		if ("moviesDirected".equals(relationshipKey))
			return deleteRuleNumber("EODeleteRuleNullify");
		if ("photo".equals(relationshipKey))
			return deleteRuleNumber("EODeleteRuleCascade");
		if ("roles".equals(relationshipKey))
			return deleteRuleNumber("EODeleteRuleDeny");

		return result;
	}
	
	@Override
	public String inverseForRelationshipKey(String relationshipKey) {
		String result = super.inverseForRelationshipKey(relationshipKey);
		if (result != null)
			return result;
		
		if ("photo".equals(relationshipKey))
			return "talent";
		if ("roles".equals(relationshipKey))
			return "talent";

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
			if ("photo".equals(relationshipKey))
				return true;
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
			else if ("firstName".equals(key))
				return firstName();
			else if ("lastName".equals(key))
				return lastName();
			else if ("photo".equals(key))
				return photo();
			else if ("moviesDirected".equals(key))
				return moviesDirected();
			else if ("roles".equals(key))
				return roles();
			else
				return handleQueryWithUnboundKey(key);
		}
	}
	
	@Override
	public void takeValueForKey(Object value, String key) {
		try {
			super.takeValueForKey(value, key);
		} catch (UnsupportedOperationException e) {
			if ("firstName".equals(key)) {
				setFirstName((value == null || value instanceof NSKeyValueCoding.Null) ? null : (String)value);
				return;
			}
			if ("lastName".equals(key)) {
				setLastName((value == null || value instanceof NSKeyValueCoding.Null) ? null : (String)value);
				return;
			}
			if ("photo".equals(key)) {
				setPhotoRelationship((value == null || value instanceof NSKeyValueCoding.Null) ? null : (your.app.gwt.eo.TalentPhoto)value);
				return;
			}
			if ("moviesDirected".equals(key)) {
				setMoviesDirected((NSArray<your.app.gwt.eo.Movie>)value);
				return;
			}
			if ("roles".equals(key)) {
				setRoles((NSArray<your.app.gwt.eo.MovieRole>)value);
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
			if ("firstName".equals(key))
				return _firstName;
			if ("lastName".equals(key))
				return _lastName;
			if ("photo".equals(key))
				return _photo;
			if ("moviesDirected".equals(key))
				return _moviesDirected;
			if ("roles".equals(key))
				return _roles;
			return handleQueryWithUnboundKey(key);
		}
	}
	
	@Override
	public void takeStoredValueForKey(Object value, String key) {
		try {
			super.takeStoredValueForKey(value, key);
		} catch (UnsupportedOperationException e) {
			if ("firstName".equals(key)) {
				_firstName = (String)value;
				return;
			}
			if ("lastName".equals(key)) {
				_lastName = (String)value;
				return;
			}
			if ("photo".equals(key)) {
				_photo = (your.app.gwt.eo.TalentPhoto)value;
				return;
			}
			if ("moviesDirected".equals(key)) {
				_moviesDirected = (NSArray<your.app.gwt.eo.Movie>)value;
				return;
			}
			if ("roles".equals(key)) {
				_roles = (NSArray<your.app.gwt.eo.MovieRole>)value;
				return;
			}
			handleTakeValueForUnboundKey(value, key);
		}
	}
	
	protected void includeObjectIntoPropertyWithKey(Object eo, String key) {
		try {
			super.includeObjectIntoPropertyWithKey(eo, key);
		} catch (UnsupportedOperationException e) {
			if ("moviesDirected".equals(key)) {
				_moviesDirected = _moviesDirected.mutableClone();
				_moviesDirected.add((your.app.gwt.eo.Movie)eo);
				return;
			}
			if ("roles".equals(key)) {
				_roles = _roles.mutableClone();
				_roles.add((your.app.gwt.eo.MovieRole)eo);
				return;
			}
		}		
	}
	
	@Override
	protected void excludeObjectFromPropertyWithKey(Object eo, String key) {
		try {
			super.excludeObjectFromPropertyWithKey(eo, key);
		} catch (UnsupportedOperationException e) {
			if ("moviesDirected".equals(key)) {
				if (_moviesDirected.contains(eo)) {
					_moviesDirected = _moviesDirected.mutableClone();
					_moviesDirected.remove(eo);
					return;
				} else {
					throw new IllegalArgumentException("Relationship '" + key + "' does not contain object: " + eo);
				}
			}
			if ("roles".equals(key)) {
				if (_roles.contains(eo)) {
					_roles = _roles.mutableClone();
					_roles.remove(eo);
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
		return "Talent";
	}
	
	public NSDictionary<String, Object> clientSnapshot() {
		NSDictionary<String, Object> result = new NSMutableDictionary();
		
		if (valueForKey("firstName") != null)
			result.put("firstName", valueForKey("firstName"));
		else
			result.put("firstName", NSKeyValueCoding.NullValue);

		if (valueForKey("lastName") != null)
			result.put("lastName", valueForKey("lastName"));
		else
			result.put("lastName", NSKeyValueCoding.NullValue);

		if (valueForKey("photo") != null)
			result.put("photo", valueForKey("photo"));
		else
			result.put("photo", NSKeyValueCoding.NullValue);

		if (valueForKey("moviesDirected") != null)
			result.put("moviesDirected", valueForKey("moviesDirected"));
		else
			result.put("moviesDirected", NSArray.EmptyArray);

		if (valueForKey("roles") != null)
			result.put("roles", valueForKey("roles"));
		else
			result.put("roles", NSArray.EmptyArray);

		return result.immutableClone();
	}
		
	public static Talent createTalent(EOEditingContext editingContext, String firstName
, String lastName
) {
		Talent eo = (Talent) new Talent(); editingContext.insertObject(eo);    
		eo.setFirstName(firstName);
		eo.setLastName(lastName);
		return eo;
	}

	public static NSArray<Talent> fetchAllTalents(EOEditingContext editingContext) {
		return _Talent.fetchAllTalents(editingContext, null);
	}

	public static NSArray<Talent> fetchAllTalents(EOEditingContext editingContext, NSArray<EOSortOrdering> sortOrderings) {
		return _Talent.fetchTalents(editingContext, null, sortOrderings);
	}

	public static NSArray<Talent> fetchTalents(EOEditingContext editingContext, EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings) {
		EOFetchSpecification fetchSpec = new EOFetchSpecification(Talent.ENTITY_NAME, qualifier, sortOrderings);
		fetchSpec.setIsDeep(true);
		NSArray<Talent> eoObjects = (NSArray<Talent>)editingContext.objectsWithFetchSpecification(fetchSpec);
		return eoObjects;
	}

	public static Talent fetchTalent(EOEditingContext editingContext, String keyName, Object value) {
		return _Talent.fetchTalent(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
	}

	public static Talent fetchTalent(EOEditingContext editingContext, EOQualifier qualifier) {
		NSArray<Talent> eoObjects = _Talent.fetchTalents(editingContext, qualifier, null);
		Talent eoObject;
		int count = eoObjects.count();
		if (count == 0) {
			eoObject = null;
		}
		else if (count == 1) {
			eoObject = (Talent)eoObjects.objectAtIndex(0);
		}
		else {
			throw new IllegalStateException("There was more than one Talent that matched the qualifier '" + qualifier + "'.");
		}
		return eoObject;
	}

	public static Talent fetchRequiredTalent(EOEditingContext editingContext, String keyName, Object value) {
		return _Talent.fetchRequiredTalent(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
	}

	public static Talent fetchRequiredTalent(EOEditingContext editingContext, EOQualifier qualifier) {
		Talent eoObject = _Talent.fetchTalent(editingContext, qualifier);
		if (eoObject == null) {
			throw new NoSuchElementException("There was no Talent that matched the qualifier '" + qualifier + "'.");
		}
		return eoObject;
	}


}
