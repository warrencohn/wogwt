// DO NOT EDIT.  Make changes to Director.java instead.
package your.app.gwt.eo;
// this must be in the client package

import java.util.*;
import java.math.BigDecimal;

import wogwt.translatable.WOGWTClientUtil;

import com.webobjects.eocontrol.*;
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
public abstract class _Director 
	extends com.webobjects.eocontrol.EOGenericRecord 
	implements wogwt.translatable.rpc.WOGWTSerializableEO {
		
	public static final transient String ENTITY_NAME = "Director";
	
	public Integer _rawPrimaryKey;

	public _Director() {
		super();
	}
	
	// Attributes
	@Override
	public NSArray<String> attributeKeys() {
		NSArray<String> result = super.attributeKeys();
		if (result != null)
			return result;

		NSArray<String> keys = new NSArray<String>( new String[] {
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
			else
				return handleQueryWithUnboundKey(key);
		}
	}
	
	@Override
	public void takeValueForKey(Object value, String key) {
		try {
			super.takeValueForKey(value, key);
		} catch (UnsupportedOperationException e) {
			handleTakeValueForUnboundKey(value, key);
		}
	}
	
	@Override
	public Object storedValueForKey(String key) {
		try {
			return super.storedValueForKey(key);
		} catch (UnsupportedOperationException e) {
			return handleQueryWithUnboundKey(key);
		}
	}
	
	@Override
	public void takeStoredValueForKey(Object value, String key) {
		try {
			super.takeStoredValueForKey(value, key);
		} catch (UnsupportedOperationException e) {
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
	
	@Override
	public String entityName() {
		return "Director";
	}
	
	public NSDictionary<String, Object> clientSnapshot() {
		NSDictionary<String, Object> result = new NSMutableDictionary();
		
		return result.immutableClone();
	}
		
	public static Director createDirector(EOEditingContext editingContext) {
		Director eo = (Director) new Director(); editingContext.insertObject(eo);    
		return eo;
	}

	public static NSArray<Director> fetchAllDirectors(EOEditingContext editingContext) {
		return _Director.fetchAllDirectors(editingContext, null);
	}

	public static NSArray<Director> fetchAllDirectors(EOEditingContext editingContext, NSArray<EOSortOrdering> sortOrderings) {
		return _Director.fetchDirectors(editingContext, null, sortOrderings);
	}

	public static NSArray<Director> fetchDirectors(EOEditingContext editingContext, EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings) {
		EOFetchSpecification fetchSpec = new EOFetchSpecification(Director.ENTITY_NAME, qualifier, sortOrderings);
		fetchSpec.setIsDeep(true);
		NSArray<Director> eoObjects = (NSArray<Director>)editingContext.objectsWithFetchSpecification(fetchSpec);
		return eoObjects;
	}

	public static Director fetchDirector(EOEditingContext editingContext, String keyName, Object value) {
		return _Director.fetchDirector(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
	}

	public static Director fetchDirector(EOEditingContext editingContext, EOQualifier qualifier) {
		NSArray<Director> eoObjects = _Director.fetchDirectors(editingContext, qualifier, null);
		Director eoObject;
		int count = eoObjects.count();
		if (count == 0) {
			eoObject = null;
		}
		else if (count == 1) {
			eoObject = (Director)eoObjects.objectAtIndex(0);
		}
		else {
			throw new IllegalStateException("There was more than one Director that matched the qualifier '" + qualifier + "'.");
		}
		return eoObject;
	}

	public static Director fetchRequiredDirector(EOEditingContext editingContext, String keyName, Object value) {
		return _Director.fetchRequiredDirector(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
	}

	public static Director fetchRequiredDirector(EOEditingContext editingContext, EOQualifier qualifier) {
		Director eoObject = _Director.fetchDirector(editingContext, qualifier);
		if (eoObject == null) {
			throw new NoSuchElementException("There was no Director that matched the qualifier '" + qualifier + "'.");
		}
		return eoObject;
	}


}
