// DO NOT EDIT.  Make changes to Talent.java instead.
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
public abstract class _Talent 
	extends com.webobjects.eocontrol.EOGenericRecord 
	implements wogwt.translatable.rpc.WOGWTSerializableEO {
		
	public static final transient String ENTITY_NAME = "Talent";
	public static final transient String FIRST_NAME_KEY = "firstName";
	public static final transient String LAST_NAME_KEY = "lastName";
	public static final transient String MOVIES_DIRECTED_KEY = "moviesDirected";
	public static final transient String PHOTO_KEY = "photo";
	public static final transient String ROLES_KEY = "roles";
	
	public Integer _rawPrimaryKey;
	public String _firstName;
	public String _lastName;
	public your.app.gwt.eo.TalentPhoto _photo;
	public NSArray<your.app.gwt.eo.Movie> _moviesDirected = new NSArray<your.app.gwt.eo.Movie>();
	public NSArray<your.app.gwt.eo.MovieRole> _roles = new NSArray<your.app.gwt.eo.MovieRole>();

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
	
	public NSArray<your.app.gwt.eo.MovieRole> roles() {
		return (NSArray<your.app.gwt.eo.MovieRole>)storedValueForKey("roles");
	}
	
	public void setRoles(NSArray<your.app.gwt.eo.MovieRole> aValue) {
		takeStoredValueForKey(aValue, "roles");
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
				setFirstName(WOGWTClientUtil.isNull(value) ? null : (String)value);
				return;
			}
			if ("lastName".equals(key)) {
				setLastName(WOGWTClientUtil.isNull(value) ? null : (String)value);
				return;
			}
			if ("photo".equals(key)) {
				setPhotoRelationship(WOGWTClientUtil.isNull(value) ? null : (your.app.gwt.eo.TalentPhoto)value);
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
		
}
