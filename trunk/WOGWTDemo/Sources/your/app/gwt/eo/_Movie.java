// DO NOT EDIT.  Make changes to Movie.java instead.
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
public abstract class _Movie 
	extends com.webobjects.eocontrol.EOGenericRecord 
	implements wogwt.translatable.rpc.WOGWTSerializableEO {
		
	public static final transient String ENTITY_NAME = "Movie";
	public static final transient String CATEGORY_KEY = "category";
	public static final transient String DATE_RELEASED_KEY = "dateReleased";
	public static final transient String POSTER_NAME_KEY = "posterName";
	public static final transient String RATED_KEY = "rated";
	public static final transient String REVENUE_KEY = "revenue";
	public static final transient String TITLE_KEY = "title";
	public static final transient String TRAILER_NAME_KEY = "trailerName";
	public static final transient String DIRECTORS_KEY = "directors";
	public static final transient String PLOT_SUMMARY_KEY = "plotSummary";
	public static final transient String REVIEWS_KEY = "reviews";
	public static final transient String ROLES_KEY = "roles";
	public static final transient String STUDIO_KEY = "studio";
	public static final transient String VOTING_KEY = "voting";
	
	public Integer _rawPrimaryKey;
	public String _category;
	public NSTimestamp _dateReleased;
	public String _posterName;
	public String _rated;
	public java.math.BigDecimal _revenue;
	public String _title;
	public String _trailerName;
	public your.app.gwt.eo.PlotSummary _plotSummary;
	public your.app.gwt.eo.Studio _studio;
	public your.app.gwt.eo.Voting _voting;
	public NSArray<your.app.gwt.eo.Talent> _directors = new NSArray<your.app.gwt.eo.Talent>();
	public NSArray<your.app.gwt.eo.Review> _reviews = new NSArray<your.app.gwt.eo.Review>();
	public NSArray<your.app.gwt.eo.MovieRole> _roles = new NSArray<your.app.gwt.eo.MovieRole>();

	public _Movie() {
		super();
	}
	
	// Attributes
	public String category() {
		return (String) storedValueForKey("category");
	}

	public void setCategory(String value) {
		takeStoredValueForKey(value, "category");
	}
	
	public NSTimestamp dateReleased() {
		return (NSTimestamp) storedValueForKey("dateReleased");
	}

	public void setDateReleased(NSTimestamp value) {
		takeStoredValueForKey(value, "dateReleased");
	}
	
	public String posterName() {
		return (String) storedValueForKey("posterName");
	}

	public void setPosterName(String value) {
		takeStoredValueForKey(value, "posterName");
	}
	
	public String rated() {
		return (String) storedValueForKey("rated");
	}

	public void setRated(String value) {
		takeStoredValueForKey(value, "rated");
	}
	
	public java.math.BigDecimal revenue() {
		return (java.math.BigDecimal) storedValueForKey("revenue");
	}

	public void setRevenue(java.math.BigDecimal value) {
		takeStoredValueForKey(value, "revenue");
	}
	
	public String title() {
		return (String) storedValueForKey("title");
	}

	public void setTitle(String value) {
		takeStoredValueForKey(value, "title");
	}
	
	public String trailerName() {
		return (String) storedValueForKey("trailerName");
	}

	public void setTrailerName(String value) {
		takeStoredValueForKey(value, "trailerName");
	}
	
	public your.app.gwt.eo.PlotSummary plotSummary() {
		return (your.app.gwt.eo.PlotSummary)storedValueForKey("plotSummary");
	}
  
	public void setPlotSummaryRelationship(your.app.gwt.eo.PlotSummary value) {
		if (value == null) {
			your.app.gwt.eo.PlotSummary oldValue = plotSummary();
			if (oldValue != null) {
				removeObjectFromBothSidesOfRelationshipWithKey(oldValue, "plotSummary");
			}
		} else {
			addObjectToBothSidesOfRelationshipWithKey(value, "plotSummary");
		}
	}
  
	public your.app.gwt.eo.Studio studio() {
		return (your.app.gwt.eo.Studio)storedValueForKey("studio");
	}
  
	public void setStudioRelationship(your.app.gwt.eo.Studio value) {
		if (value == null) {
			your.app.gwt.eo.Studio oldValue = studio();
			if (oldValue != null) {
				removeObjectFromBothSidesOfRelationshipWithKey(oldValue, "studio");
			}
		} else {
			addObjectToBothSidesOfRelationshipWithKey(value, "studio");
		}
	}
  
	public your.app.gwt.eo.Voting voting() {
		return (your.app.gwt.eo.Voting)storedValueForKey("voting");
	}
  
	public void setVotingRelationship(your.app.gwt.eo.Voting value) {
		if (value == null) {
			your.app.gwt.eo.Voting oldValue = voting();
			if (oldValue != null) {
				removeObjectFromBothSidesOfRelationshipWithKey(oldValue, "voting");
			}
		} else {
			addObjectToBothSidesOfRelationshipWithKey(value, "voting");
		}
	}
  
	public NSArray<your.app.gwt.eo.Talent> directors() {
		return (NSArray<your.app.gwt.eo.Talent>)storedValueForKey("directors");
	}
	
	public void setDirectors(NSArray<your.app.gwt.eo.Talent> aValue) {
		takeStoredValueForKey(aValue, "directors");
	}
	
	public void addToDirectors(your.app.gwt.eo.Talent object) {
		includeObjectIntoPropertyWithKey(object, "directors");
	}

	public void removeFromDirectors(your.app.gwt.eo.Talent object) {
		excludeObjectFromPropertyWithKey(object, "directors");
	}

	public void addToDirectorsRelationship(your.app.gwt.eo.Talent object) {
		addObjectToBothSidesOfRelationshipWithKey(object, "directors");
	}

	public void removeFromDirectorsRelationship(your.app.gwt.eo.Talent object) {
		removeObjectFromBothSidesOfRelationshipWithKey(object, "directors");
	}
	
	public NSArray<your.app.gwt.eo.Review> reviews() {
		return (NSArray<your.app.gwt.eo.Review>)storedValueForKey("reviews");
	}
	
	public void setReviews(NSArray<your.app.gwt.eo.Review> aValue) {
		takeStoredValueForKey(aValue, "reviews");
	}
	
	public void addToReviews(your.app.gwt.eo.Review object) {
		includeObjectIntoPropertyWithKey(object, "reviews");
	}

	public void removeFromReviews(your.app.gwt.eo.Review object) {
		excludeObjectFromPropertyWithKey(object, "reviews");
	}

	public void addToReviewsRelationship(your.app.gwt.eo.Review object) {
		addObjectToBothSidesOfRelationshipWithKey(object, "reviews");
	}

	public void removeFromReviewsRelationship(your.app.gwt.eo.Review object) {
		removeObjectFromBothSidesOfRelationshipWithKey(object, "reviews");
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
			"category",			
			"dateReleased",			
			"posterName",			
			"rated",			
			"revenue",			
			"title",			
			"trailerName"			
		});
		return keys;
	}
	
	@Override
	public NSArray<String> toOneRelationshipKeys() {
		NSArray<String> result = super.toOneRelationshipKeys();
		if (result != null)
			return result;
		
		NSArray<String> keys = new NSArray<String>( new String[] {	
			"plotSummary",			
			"studio",			
			"voting"			
		});
		
		return keys;
	}
	
	@Override
	public NSArray<String> toManyRelationshipKeys() {
		NSArray<String> result = super.toManyRelationshipKeys();
		if (result != null)
			return result;
		
		NSArray<String> keys = new NSArray<String>( new String[] {
			"directors",
			"reviews",
			"roles",
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
		
		if ("directors".equals(relationshipKey))
			return deleteRuleNumber("EODeleteRuleNullify");
		if ("plotSummary".equals(relationshipKey))
			return deleteRuleNumber("EODeleteRuleCascade");
		if ("reviews".equals(relationshipKey))
			return deleteRuleNumber("EODeleteRuleCascade");
		if ("roles".equals(relationshipKey))
			return deleteRuleNumber("EODeleteRuleCascade");
		if ("studio".equals(relationshipKey))
			return deleteRuleNumber("EODeleteRuleNullify");
		if ("voting".equals(relationshipKey))
			return deleteRuleNumber("EODeleteRuleCascade");

		return result;
	}
	
	@Override
	public String inverseForRelationshipKey(String relationshipKey) {
		String result = super.inverseForRelationshipKey(relationshipKey);
		if (result != null)
			return result;
		
		if ("plotSummary".equals(relationshipKey))
			return "movie";
		if ("reviews".equals(relationshipKey))
			return "movie";
		if ("roles".equals(relationshipKey))
			return "movie";
		if ("studio".equals(relationshipKey))
			return "movies";
		if ("voting".equals(relationshipKey))
			return "movie";

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
			if ("plotSummary".equals(relationshipKey))
				return true;
			if ("reviews".equals(relationshipKey))
				return true;
			if ("roles".equals(relationshipKey))
				return true;
			if ("voting".equals(relationshipKey))
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
			else if ("category".equals(key))
				return category();
			else if ("dateReleased".equals(key))
				return dateReleased();
			else if ("posterName".equals(key))
				return posterName();
			else if ("rated".equals(key))
				return rated();
			else if ("revenue".equals(key))
				return revenue();
			else if ("title".equals(key))
				return title();
			else if ("trailerName".equals(key))
				return trailerName();
			else if ("plotSummary".equals(key))
				return plotSummary();
			else if ("studio".equals(key))
				return studio();
			else if ("voting".equals(key))
				return voting();
			else if ("directors".equals(key))
				return directors();
			else if ("reviews".equals(key))
				return reviews();
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
			if ("category".equals(key)) {
				setCategory(WOGWTClientUtil.isNull(value) ? null : (String)value);
				return;
			}
			if ("dateReleased".equals(key)) {
				setDateReleased(WOGWTClientUtil.isNull(value) ? null : (NSTimestamp)value);
				return;
			}
			if ("posterName".equals(key)) {
				setPosterName(WOGWTClientUtil.isNull(value) ? null : (String)value);
				return;
			}
			if ("rated".equals(key)) {
				setRated(WOGWTClientUtil.isNull(value) ? null : (String)value);
				return;
			}
			if ("revenue".equals(key)) {
				setRevenue(WOGWTClientUtil.isNull(value) ? null : (java.math.BigDecimal)value);
				return;
			}
			if ("title".equals(key)) {
				setTitle(WOGWTClientUtil.isNull(value) ? null : (String)value);
				return;
			}
			if ("trailerName".equals(key)) {
				setTrailerName(WOGWTClientUtil.isNull(value) ? null : (String)value);
				return;
			}
			if ("plotSummary".equals(key)) {
				setPlotSummaryRelationship(WOGWTClientUtil.isNull(value) ? null : (your.app.gwt.eo.PlotSummary)value);
				return;
			}
			if ("studio".equals(key)) {
				setStudioRelationship(WOGWTClientUtil.isNull(value) ? null : (your.app.gwt.eo.Studio)value);
				return;
			}
			if ("voting".equals(key)) {
				setVotingRelationship(WOGWTClientUtil.isNull(value) ? null : (your.app.gwt.eo.Voting)value);
				return;
			}
			if ("directors".equals(key)) {
				setDirectors((NSArray<your.app.gwt.eo.Talent>)value);
				return;
			}
			if ("reviews".equals(key)) {
				setReviews((NSArray<your.app.gwt.eo.Review>)value);
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
			if ("category".equals(key))
				return _category;
			if ("dateReleased".equals(key))
				return _dateReleased;
			if ("posterName".equals(key))
				return _posterName;
			if ("rated".equals(key))
				return _rated;
			if ("revenue".equals(key))
				return _revenue;
			if ("title".equals(key))
				return _title;
			if ("trailerName".equals(key))
				return _trailerName;
			if ("plotSummary".equals(key))
				return _plotSummary;
			if ("studio".equals(key))
				return _studio;
			if ("voting".equals(key))
				return _voting;
			if ("directors".equals(key))
				return _directors;
			if ("reviews".equals(key))
				return _reviews;
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
			if ("category".equals(key)) {
				_category = (String)value;
				return;
			}
			if ("dateReleased".equals(key)) {
				_dateReleased = (NSTimestamp)value;
				return;
			}
			if ("posterName".equals(key)) {
				_posterName = (String)value;
				return;
			}
			if ("rated".equals(key)) {
				_rated = (String)value;
				return;
			}
			if ("revenue".equals(key)) {
				_revenue = (java.math.BigDecimal)value;
				return;
			}
			if ("title".equals(key)) {
				_title = (String)value;
				return;
			}
			if ("trailerName".equals(key)) {
				_trailerName = (String)value;
				return;
			}
			if ("plotSummary".equals(key)) {
				_plotSummary = (your.app.gwt.eo.PlotSummary)value;
				return;
			}
			if ("studio".equals(key)) {
				_studio = (your.app.gwt.eo.Studio)value;
				return;
			}
			if ("voting".equals(key)) {
				_voting = (your.app.gwt.eo.Voting)value;
				return;
			}
			if ("directors".equals(key)) {
				_directors = (NSArray<your.app.gwt.eo.Talent>)value;
				return;
			}
			if ("reviews".equals(key)) {
				_reviews = (NSArray<your.app.gwt.eo.Review>)value;
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
			if ("directors".equals(key)) {
				_directors = _directors.mutableClone();
				_directors.add((your.app.gwt.eo.Talent)eo);
				return;
			}
			if ("reviews".equals(key)) {
				_reviews = _reviews.mutableClone();
				_reviews.add((your.app.gwt.eo.Review)eo);
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
			if ("directors".equals(key)) {
				if (_directors.contains(eo)) {
					_directors = _directors.mutableClone();
					_directors.remove(eo);
					return;
				} else {
					throw new IllegalArgumentException("Relationship '" + key + "' does not contain object: " + eo);
				}
			}
			if ("reviews".equals(key)) {
				if (_reviews.contains(eo)) {
					_reviews = _reviews.mutableClone();
					_reviews.remove(eo);
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
		return "Movie";
	}
	
	public NSDictionary<String, Object> clientSnapshot() {
		NSDictionary<String, Object> result = new NSMutableDictionary();
		
		if (valueForKey("category") != null)
			result.put("category", valueForKey("category"));
		else
			result.put("category", NSKeyValueCoding.NullValue);

		if (valueForKey("dateReleased") != null)
			result.put("dateReleased", valueForKey("dateReleased"));
		else
			result.put("dateReleased", NSKeyValueCoding.NullValue);

		if (valueForKey("posterName") != null)
			result.put("posterName", valueForKey("posterName"));
		else
			result.put("posterName", NSKeyValueCoding.NullValue);

		if (valueForKey("rated") != null)
			result.put("rated", valueForKey("rated"));
		else
			result.put("rated", NSKeyValueCoding.NullValue);

		if (valueForKey("revenue") != null)
			result.put("revenue", valueForKey("revenue"));
		else
			result.put("revenue", NSKeyValueCoding.NullValue);

		if (valueForKey("title") != null)
			result.put("title", valueForKey("title"));
		else
			result.put("title", NSKeyValueCoding.NullValue);

		if (valueForKey("trailerName") != null)
			result.put("trailerName", valueForKey("trailerName"));
		else
			result.put("trailerName", NSKeyValueCoding.NullValue);

		if (valueForKey("plotSummary") != null)
			result.put("plotSummary", valueForKey("plotSummary"));
		else
			result.put("plotSummary", NSKeyValueCoding.NullValue);

		if (valueForKey("studio") != null)
			result.put("studio", valueForKey("studio"));
		else
			result.put("studio", NSKeyValueCoding.NullValue);

		if (valueForKey("voting") != null)
			result.put("voting", valueForKey("voting"));
		else
			result.put("voting", NSKeyValueCoding.NullValue);

		if (valueForKey("directors") != null)
			result.put("directors", valueForKey("directors"));
		else
			result.put("directors", NSArray.EmptyArray);

		if (valueForKey("reviews") != null)
			result.put("reviews", valueForKey("reviews"));
		else
			result.put("reviews", NSArray.EmptyArray);

		if (valueForKey("roles") != null)
			result.put("roles", valueForKey("roles"));
		else
			result.put("roles", NSArray.EmptyArray);

		return result.immutableClone();
	}
		
}
