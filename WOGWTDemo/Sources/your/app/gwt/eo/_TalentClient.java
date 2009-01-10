// DO NOT EDIT.  Make changes to TalentClient.java instead.
package your.app.gwt.eo;
// this must be in the client package

import java.util.*;
import java.math.BigDecimal;

import com.google.gwt.user.client.rpc.IsSerializable;
import com.webobjects.foundation.NSArray;
import com.webobjects.foundation.NSMutableArray;
import com.webobjects.foundation.NSDictionary;
import com.webobjects.foundation.NSMutableDictionary;
import com.webobjects.foundation.NSKeyValueCoding;
import com.webobjects.foundation.NSKeyValueCodingAdditions;
import com.webobjects.foundation.NSTimestamp;

import wogwt.translatable.rpc.WOGWTClientEO;

// This class can be serialized from server to client and back
public abstract class _TalentClient implements IsSerializable, WOGWTClientEO, NSKeyValueCoding, NSKeyValueCodingAdditions {
	
	// Attributes
	public static final String FIRST_NAME_KEY = "firstName";
	public static final String LAST_NAME_KEY = "lastName";

	// Relationships
	public static final String MOVIES_DIRECTED_KEY = "moviesDirected";
	public static final String PHOTO_KEY = "photo";
	public static final String ROLES_KEY = "roles";
	
	private String firstName;
	private String lastName;
	private your.app.gwt.eo.TalentPhotoClient photo;
	private NSArray<your.app.gwt.eo.MovieClient> moviesDirected;
	private NSArray<your.app.gwt.eo.MovieRoleClient> roles;

	public _TalentClient() {
		super();
	}
	
	public _TalentClient(Map<String, ?> map) {
		super();
		takeValuesFromMap( map );
	}
	
	public static NSArray<String> keys() {
		List<String> keys = new ArrayList();
		keys.addAll(attributeKeys());
		keys.addAll(toOneRelationshipKeys());
		keys.addAll(toManyRelationshipKeys());
    	return new NSArray(keys);
	}

	public static NSArray<String> attributeKeys() {
		NSArray<String> keys = new NSArray<String>( new String[] {
			"firstName",			
			"lastName"			
		});
		return keys;
	}
	
	public static NSArray<String> toOneRelationshipKeys() {
		NSArray<String> keys = new NSArray<String>( new String[] {	
			"photo"			
		});
		return keys;
	}
	
	public static NSArray<String> toManyRelationshipKeys() {
		NSArray<String> keys = new NSArray<String>( new String[] {
			"moviesDirected",
			"roles"
		});
    	return keys;
	}
	
	public Map<String, ?> toMap() {
		Map map = new HashMap();
		map.put("firstName", firstName);
		map.put("lastName", lastName);
		map.put("photo", photo);
		map.put("moviesDirected", moviesDirected);
		map.put("roles", roles);
		return map;
	}

	public void takeValuesFromMap(Map<String, ?> map) {
		firstName = (String)map.get("firstName");
		lastName = (String)map.get("lastName");
		photo = (your.app.gwt.eo.TalentPhotoClient)map.get("photo");
		moviesDirected = (NSArray)map.get("moviesDirected");
		roles = (NSArray)map.get("roles");
		if (map.get( "primaryKeyValue" ) != null)
			primaryKeyValue = (Integer)map.get( "primaryKeyValue" );
	}
	
	public Object valueForKey(String key) {
		if ("primaryKeyValue".equals(key))
			return primaryKeyValue();
		else if ("entityName".equals(key))
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
			throw new RuntimeException(getClass().getName() + " does not has a key named '" + key + "'");
	}
	
	public void takeValueForKey(Object value, String key) {
		if ("primaryKeyValue".equals(key))
			setPrimaryKeyValue((Integer)value);
		else if ("firstName".equals(key))
			setFirstName((String)value);
		else if ("lastName".equals(key))
			setLastName((String)value);
		else if ("photo".equals(key))
			setPhoto((your.app.gwt.eo.TalentPhotoClient)value);
		else if ("moviesDirected".equals(key))
			setMoviesDirected((NSArray)value);
		else if ("roles".equals(key))
			setRoles((NSArray)value);
		else
			throw new RuntimeException(getClass().getName() + " does not has a key named '" + key + "'");
	}
	
	public Object valueForKeyPath(String keyPath) {
		return NSKeyValueCodingAdditions.DefaultImplementation.valueForKeyPath(this, keyPath);
	}
	
	public void takeValueForKeyPath(Object value, String keyPath) {
		NSKeyValueCodingAdditions.DefaultImplementation.takeValueForKeyPath(this, value, keyPath);
	}
	
	public String entityName() {
		return "Talent";
	}
	
	// Attributes
	public String firstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String lastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	private Integer primaryKeyValue;

	public Integer primaryKeyValue() {
		return primaryKeyValue;
	}
	
	public void setPrimaryKeyValue(Integer primaryKeyValue) {
		this.primaryKeyValue = primaryKeyValue;
	}

	// To One Relationships
	public your.app.gwt.eo.TalentPhotoClient photo() {
		return photo;
	}
	
	public void setPhoto(your.app.gwt.eo.TalentPhotoClient photo) {
		this.photo =  photo;
	}
	
	//To Many Relationships
	public NSArray<your.app.gwt.eo.MovieClient> moviesDirected() {
		return moviesDirected;
	}
	
	public void setMoviesDirected(NSArray<your.app.gwt.eo.MovieClient> moviesDirected) {
		this.moviesDirected = moviesDirected;
	}
	
	public NSArray<your.app.gwt.eo.MovieRoleClient> roles() {
		return roles;
	}
	
	public void setRoles(NSArray<your.app.gwt.eo.MovieRoleClient> roles) {
		this.roles = roles;
	}
	

	public String toString() {
		return toMap().toString();
	}

}
