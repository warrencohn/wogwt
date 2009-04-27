// DO NOT EDIT.  Make changes to PlotSummary.java instead.
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
public abstract class _PlotSummary 
	extends com.webobjects.eocontrol.EOGenericRecord 
	implements wogwt.translatable.rpc.WOGWTSerializableEO {
		
	public static final transient String ENTITY_NAME = "PlotSummary";
	public static final transient String SUMMARY_KEY = "summary";
	public static final transient String MOVIE_KEY = "movie";
	
	public Integer _rawPrimaryKey;
	public String _summary;
	public your.app.gwt.eo.Movie _movie;

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
		
		if ("movie".equals(relationshipKey))
			return "plotSummary";

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
				setSummary(WOGWTClientUtil.isNull(value) ? null : (String)value);
				return;
			}
			if ("movie".equals(key)) {
				setMovieRelationship(WOGWTClientUtil.isNull(value) ? null : (your.app.gwt.eo.Movie)value);
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
		
}
