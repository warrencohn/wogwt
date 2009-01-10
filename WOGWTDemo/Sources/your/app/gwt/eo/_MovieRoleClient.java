// DO NOT EDIT.  Make changes to MovieRoleClient.java instead.
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
public abstract class _MovieRoleClient implements IsSerializable, WOGWTClientEO, NSKeyValueCoding, NSKeyValueCodingAdditions {
	
	// Attributes
	public static final String ROLE_NAME_KEY = "roleName";

	// Relationships
	public static final String MOVIE_KEY = "movie";
	public static final String TALENT_KEY = "talent";
	
	private String roleName;
	private your.app.gwt.eo.MovieClient movie;
	private your.app.gwt.eo.TalentClient talent;

	public _MovieRoleClient() {
		super();
	}
	
	public _MovieRoleClient(Map<String, ?> map) {
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
			"roleName"			
		});
		return keys;
	}
	
	public static NSArray<String> toOneRelationshipKeys() {
		NSArray<String> keys = new NSArray<String>( new String[] {	
			"movie",			
			"talent"			
		});
		return keys;
	}
	
	public static NSArray<String> toManyRelationshipKeys() {
		NSArray<String> keys = new NSArray<String>( new String[] {
		});
    	return keys;
	}
	
	public Map<String, ?> toMap() {
		Map map = new HashMap();
		map.put("roleName", roleName);
		map.put("movie", movie);
		map.put("talent", talent);
		return map;
	}

	public void takeValuesFromMap(Map<String, ?> map) {
		roleName = (String)map.get("roleName");
		movie = (your.app.gwt.eo.MovieClient)map.get("movie");
		talent = (your.app.gwt.eo.TalentClient)map.get("talent");
		if (map.get( "primaryKeyValue" ) != null)
			primaryKeyValue = (Integer)map.get( "primaryKeyValue" );
	}
	
	public Object valueForKey(String key) {
		if ("primaryKeyValue".equals(key))
			return primaryKeyValue();
		else if ("entityName".equals(key))
			return entityName();
		else if ("roleName".equals(key))
			return roleName();
		else if ("movie".equals(key))
			return movie();
		else if ("talent".equals(key))
			return talent();
		else
			throw new RuntimeException(getClass().getName() + " does not has a key named '" + key + "'");
	}
	
	public void takeValueForKey(Object value, String key) {
		if ("primaryKeyValue".equals(key))
			setPrimaryKeyValue((Integer)value);
		else if ("roleName".equals(key))
			setRoleName((String)value);
		else if ("movie".equals(key))
			setMovie((your.app.gwt.eo.MovieClient)value);
		else if ("talent".equals(key))
			setTalent((your.app.gwt.eo.TalentClient)value);
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
		return "MovieRole";
	}
	
	// Attributes
	public String roleName() {
		return roleName;
	}
	
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	private Integer primaryKeyValue;

	public Integer primaryKeyValue() {
		return primaryKeyValue;
	}
	
	public void setPrimaryKeyValue(Integer primaryKeyValue) {
		this.primaryKeyValue = primaryKeyValue;
	}

	// To One Relationships
	public your.app.gwt.eo.MovieClient movie() {
		return movie;
	}
	
	public void setMovie(your.app.gwt.eo.MovieClient movie) {
		this.movie =  movie;
	}
	
	public your.app.gwt.eo.TalentClient talent() {
		return talent;
	}
	
	public void setTalent(your.app.gwt.eo.TalentClient talent) {
		this.talent =  talent;
	}
	
	//To Many Relationships

	public String toString() {
		return toMap().toString();
	}

}
