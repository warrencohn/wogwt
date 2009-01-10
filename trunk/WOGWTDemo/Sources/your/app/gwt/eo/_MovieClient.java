// DO NOT EDIT.  Make changes to MovieClient.java instead.
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
public abstract class _MovieClient implements IsSerializable, WOGWTClientEO, NSKeyValueCoding, NSKeyValueCodingAdditions {
	
	// Attributes
	public static final String CATEGORY_KEY = "category";
	public static final String DATE_RELEASED_KEY = "dateReleased";
	public static final String POSTER_NAME_KEY = "posterName";
	public static final String RATED_KEY = "rated";
	public static final String REVENUE_KEY = "revenue";
	public static final String TITLE_KEY = "title";
	public static final String TRAILER_NAME_KEY = "trailerName";

	// Relationships
	public static final String DIRECTORS_KEY = "directors";
	public static final String PLOT_SUMMARY_KEY = "plotSummary";
	public static final String REVIEWS_KEY = "reviews";
	public static final String ROLES_KEY = "roles";
	public static final String STUDIO_KEY = "studio";
	public static final String VOTING_KEY = "voting";
	
	private String category;
	private NSTimestamp dateReleased;
	private String posterName;
	private String rated;
	private BigDecimal revenue;
	private String title;
	private String trailerName;
	private your.app.gwt.eo.PlotSummaryClient plotSummary;
	private your.app.gwt.eo.StudioClient studio;
	private your.app.gwt.eo.VotingClient voting;
	private NSArray<your.app.gwt.eo.TalentClient> directors;
	private NSArray<your.app.gwt.eo.ReviewClient> reviews;
	private NSArray<your.app.gwt.eo.MovieRoleClient> roles;

	public _MovieClient() {
		super();
	}
	
	public _MovieClient(Map<String, ?> map) {
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
	
	public static NSArray<String> toOneRelationshipKeys() {
		NSArray<String> keys = new NSArray<String>( new String[] {	
			"plotSummary",			
			"studio",			
			"voting"			
		});
		return keys;
	}
	
	public static NSArray<String> toManyRelationshipKeys() {
		NSArray<String> keys = new NSArray<String>( new String[] {
			"directors",
			"reviews",
			"roles",
		});
    	return keys;
	}
	
	public Map<String, ?> toMap() {
		Map map = new HashMap();
		map.put("category", category);
		map.put("dateReleased", dateReleased);
		map.put("posterName", posterName);
		map.put("rated", rated);
		map.put("revenue", revenue);
		map.put("title", title);
		map.put("trailerName", trailerName);
		map.put("plotSummary", plotSummary);
		map.put("studio", studio);
		map.put("voting", voting);
		map.put("directors", directors);
		map.put("reviews", reviews);
		map.put("roles", roles);
		return map;
	}

	public void takeValuesFromMap(Map<String, ?> map) {
		category = (String)map.get("category");
		dateReleased = (NSTimestamp)map.get("dateReleased");
		posterName = (String)map.get("posterName");
		rated = (String)map.get("rated");
		revenue = (BigDecimal)map.get("revenue");
		title = (String)map.get("title");
		trailerName = (String)map.get("trailerName");
		plotSummary = (your.app.gwt.eo.PlotSummaryClient)map.get("plotSummary");
		studio = (your.app.gwt.eo.StudioClient)map.get("studio");
		voting = (your.app.gwt.eo.VotingClient)map.get("voting");
		directors = (NSArray)map.get("directors");
		reviews = (NSArray)map.get("reviews");
		roles = (NSArray)map.get("roles");
		if (map.get( "primaryKeyValue" ) != null)
			primaryKeyValue = (Integer)map.get( "primaryKeyValue" );
	}
	
	public Object valueForKey(String key) {
		if ("primaryKeyValue".equals(key))
			return primaryKeyValue();
		else if ("entityName".equals(key))
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
			throw new RuntimeException(getClass().getName() + " does not has a key named '" + key + "'");
	}
	
	public void takeValueForKey(Object value, String key) {
		if ("primaryKeyValue".equals(key))
			setPrimaryKeyValue((Integer)value);
		else if ("category".equals(key))
			setCategory((String)value);
		else if ("dateReleased".equals(key))
			setDateReleased((NSTimestamp)value);
		else if ("posterName".equals(key))
			setPosterName((String)value);
		else if ("rated".equals(key))
			setRated((String)value);
		else if ("revenue".equals(key))
			setRevenue((BigDecimal)value);
		else if ("title".equals(key))
			setTitle((String)value);
		else if ("trailerName".equals(key))
			setTrailerName((String)value);
		else if ("plotSummary".equals(key))
			setPlotSummary((your.app.gwt.eo.PlotSummaryClient)value);
		else if ("studio".equals(key))
			setStudio((your.app.gwt.eo.StudioClient)value);
		else if ("voting".equals(key))
			setVoting((your.app.gwt.eo.VotingClient)value);
		else if ("directors".equals(key))
			setDirectors((NSArray)value);
		else if ("reviews".equals(key))
			setReviews((NSArray)value);
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
		return "Movie";
	}
	
	// Attributes
	public String category() {
		return category;
	}
	
	public void setCategory(String category) {
		this.category = category;
	}

	public NSTimestamp dateReleased() {
		return dateReleased;
	}
	
	public void setDateReleased(NSTimestamp dateReleased) {
		this.dateReleased = dateReleased;
	}

	public String posterName() {
		return posterName;
	}
	
	public void setPosterName(String posterName) {
		this.posterName = posterName;
	}

	public String rated() {
		return rated;
	}
	
	public void setRated(String rated) {
		this.rated = rated;
	}

	public BigDecimal revenue() {
		return revenue;
	}
	
	public void setRevenue(BigDecimal revenue) {
		this.revenue = revenue;
	}

	public String title() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}

	public String trailerName() {
		return trailerName;
	}
	
	public void setTrailerName(String trailerName) {
		this.trailerName = trailerName;
	}

	private Integer primaryKeyValue;

	public Integer primaryKeyValue() {
		return primaryKeyValue;
	}
	
	public void setPrimaryKeyValue(Integer primaryKeyValue) {
		this.primaryKeyValue = primaryKeyValue;
	}

	// To One Relationships
	public your.app.gwt.eo.PlotSummaryClient plotSummary() {
		return plotSummary;
	}
	
	public void setPlotSummary(your.app.gwt.eo.PlotSummaryClient plotSummary) {
		this.plotSummary =  plotSummary;
	}
	
	public your.app.gwt.eo.StudioClient studio() {
		return studio;
	}
	
	public void setStudio(your.app.gwt.eo.StudioClient studio) {
		this.studio =  studio;
	}
	
	public your.app.gwt.eo.VotingClient voting() {
		return voting;
	}
	
	public void setVoting(your.app.gwt.eo.VotingClient voting) {
		this.voting =  voting;
	}
	
	//To Many Relationships
	public NSArray<your.app.gwt.eo.TalentClient> directors() {
		return directors;
	}
	
	public void setDirectors(NSArray<your.app.gwt.eo.TalentClient> directors) {
		this.directors = directors;
	}
	
	public NSArray<your.app.gwt.eo.ReviewClient> reviews() {
		return reviews;
	}
	
	public void setReviews(NSArray<your.app.gwt.eo.ReviewClient> reviews) {
		this.reviews = reviews;
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
