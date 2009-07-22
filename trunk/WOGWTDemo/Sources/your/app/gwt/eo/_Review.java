// DO NOT EDIT.  Make changes to Review.java instead.
package your.app.gwt.eo;
// this must be in the client package

import java.util.*;
import java.math.BigDecimal;

import wogwt.translatable.WOGWTClientUtil;

import com.webobjects.eocontrol.*;
import com.webobjects.foundation.*;

// This class can be serialized from server to client and back
@SuppressWarnings("all")
public abstract class _Review 
	extends com.webobjects.eocontrol.EOGenericRecord 
	implements wogwt.translatable.rpc.WOGWTSerializableEO {
		
	public static final transient String ENTITY_NAME = "Review";
	public static final transient String REVIEW_KEY = "review";
	public static final transient String REVIEWER_KEY = "reviewer";
	public static final transient String MOVIE_KEY = "movie";
	
	/* these fields are defined for serialization and to hold data on the client side;
	   can't use a plain Map because all the types must be explicit for optimal code */
	private String _review;
	private String _reviewer;
	private your.app.gwt.eo.Movie _movie;

	public _Review() {
		super();
	}
	
	// Attributes
	public String review() {
		return (String) storedValueForKey("review");
	}

	public void setReview(String value) {
		takeStoredValueForKey(value, "review");
	}
	
	public String reviewer() {
		return (String) storedValueForKey("reviewer");
	}

	public void setReviewer(String value) {
		takeStoredValueForKey(value, "reviewer");
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
			"review",			
			"reviewer"			
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
			else if ("review".equals(key))
				return review();
			else if ("reviewer".equals(key))
				return reviewer();
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
			if ("review".equals(key)) {
				setReview((value == null || value instanceof NSKeyValueCoding.Null) ? null : (String)value);
				return;
			}
			if ("reviewer".equals(key)) {
				setReviewer((value == null || value instanceof NSKeyValueCoding.Null) ? null : (String)value);
				return;
			}
			if ("movie".equals(key)) {
				setMovieRelationship((value == null || value instanceof NSKeyValueCoding.Null) ? null : (your.app.gwt.eo.Movie)value);
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
			if ("review".equals(key))
				return _review;
			if ("reviewer".equals(key))
				return _reviewer;
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
			if ("review".equals(key)) {
				_review = (String)value;
				return;
			}
			if ("reviewer".equals(key)) {
				_reviewer = (String)value;
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
		return "Review";
	}
	
	public NSDictionary<String, Object> clientSnapshot() {
		NSDictionary<String, Object> result = new NSMutableDictionary();
		
		if (valueForKey("review") != null)
			result.put("review", valueForKey("review"));
		else
			result.put("review", NSKeyValueCoding.NullValue);

		if (valueForKey("reviewer") != null)
			result.put("reviewer", valueForKey("reviewer"));
		else
			result.put("reviewer", NSKeyValueCoding.NullValue);

		if (valueForKey("movie") != null)
			result.put("movie", valueForKey("movie"));
		else
			result.put("movie", NSKeyValueCoding.NullValue);

		return result.immutableClone();
	}
		
	public static Review createReview(EOEditingContext editingContext, your.app.gwt.eo.Movie movie) {
		Review eo = (Review) new Review(); editingContext.insertObject(eo);    
		eo.setMovieRelationship(movie);
		return eo;
	}

	public static NSArray<Review> fetchAllReviews(EOEditingContext editingContext) {
		return _Review.fetchAllReviews(editingContext, null);
	}

	public static NSArray<Review> fetchAllReviews(EOEditingContext editingContext, NSArray<EOSortOrdering> sortOrderings) {
		return _Review.fetchReviews(editingContext, null, sortOrderings);
	}

	public static NSArray<Review> fetchReviews(EOEditingContext editingContext, EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings) {
		EOFetchSpecification fetchSpec = new EOFetchSpecification(Review.ENTITY_NAME, qualifier, sortOrderings);
		fetchSpec.setIsDeep(true);
		NSArray<Review> eoObjects = (NSArray<Review>)editingContext.objectsWithFetchSpecification(fetchSpec);
		return eoObjects;
	}

	public static Review fetchReview(EOEditingContext editingContext, String keyName, Object value) {
		return _Review.fetchReview(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
	}

	public static Review fetchReview(EOEditingContext editingContext, EOQualifier qualifier) {
		NSArray<Review> eoObjects = _Review.fetchReviews(editingContext, qualifier, null);
		Review eoObject;
		int count = eoObjects.count();
		if (count == 0) {
			eoObject = null;
		}
		else if (count == 1) {
			eoObject = (Review)eoObjects.objectAtIndex(0);
		}
		else {
			throw new IllegalStateException("There was more than one Review that matched the qualifier '" + qualifier + "'.");
		}
		return eoObject;
	}

	public static Review fetchRequiredReview(EOEditingContext editingContext, String keyName, Object value) {
		return _Review.fetchRequiredReview(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
	}

	public static Review fetchRequiredReview(EOEditingContext editingContext, EOQualifier qualifier) {
		Review eoObject = _Review.fetchReview(editingContext, qualifier);
		if (eoObject == null) {
			throw new NoSuchElementException("There was no Review that matched the qualifier '" + qualifier + "'.");
		}
		return eoObject;
	}


}
