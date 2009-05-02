package com.webobjects.eocontrol;

import java.io.Serializable;

import com.webobjects.foundation.NSArray;
import com.webobjects.foundation.NSDictionary;

/**
 * This class works except where indicated.
 *
 */
public class EOFetchSpecification implements Serializable, Cloneable {

	private String entityName = null;
	private EOQualifier qualifier = null;
	private NSArray<EOSortOrdering> sortOrderings = NSArray.EmptyArray;
	private boolean usesDistinct = false;
	private boolean isDeep = true;
	private NSDictionary hints = NSDictionary.EmptyDictionary;
	private boolean fetchesRawRows = false;
	private int fetchLimit = 0;
	private boolean locksObjects = false;
	private NSArray<String> prefetchingRelationshipKeyPaths = NSArray.EmptyArray;
	private boolean promptsAfterFetchLimit = false;
	private NSArray<String> rawRowKeyPaths = NSArray.EmptyArray;
	private boolean refreshesRefetchedObjects = false;
	private boolean requiresAllQualifierBindingVariables = false;
	
	/**
	 * not implemented
	 */
	public static EOFetchSpecification fetchSpecificationNamed(String name, String entityName) {
		return null;
	}
	
	public EOFetchSpecification() {
		super();
	}

	public EOFetchSpecification(String entityName, EOQualifier qualifier,
			NSArray<EOSortOrdering> sortOrderings) {
		super();
		this.entityName = entityName;
		this.qualifier = qualifier;
		this.sortOrderings = sortOrderings;
	}

	public EOFetchSpecification(String entityName, EOQualifier qualifier,
			NSArray<EOSortOrdering> sortOrderings, boolean usesDistinct,
			boolean isDeep, NSDictionary hints) {
		this(entityName, qualifier, sortOrderings);
		this.usesDistinct = usesDistinct;
		this.isDeep = isDeep;
		this.hints = hints;
	}

	public Object clone() {
		EOFetchSpecification result = new EOFetchSpecification();
		result.setEntityName(entityName);
		result.setFetchesRawRows(fetchesRawRows);
		result.setFetchLimit(fetchLimit);
		result.setHints(hints);
		result.setIsDeep(isDeep);
		result.setLocksObjects(locksObjects);
		result.setPrefetchingRelationshipKeyPaths(prefetchingRelationshipKeyPaths);
		result.setPromptsAfterFetchLimit(promptsAfterFetchLimit);
		result.setQualifier(qualifier);
		result.setRawRowKeyPaths(rawRowKeyPaths);
		result.setRefreshesRefetchedObjects(refreshesRefetchedObjects);
		result.setRequiresAllQualifierBindingVariables(requiresAllQualifierBindingVariables);
		result.setSortOrderings(sortOrderings);
		result.setUsesDistinct(usesDistinct);
		return result;
	}
	
	public String entityName() {
		return entityName;
	}
	
	public boolean fetchesRawRows() {
		return fetchesRawRows;
	}
	
	public int fetchLimit() {
		return fetchLimit;
	}
	
	/**
	 * not implemented
	 */
	public EOFetchSpecification fetchSpecificationWithQualifierBindings(
			NSDictionary arg0) {
		return (EOFetchSpecification) clone();
	}
	
	public NSDictionary hints() {
		return hints;
	}
	
	public boolean isDeep() {
		return isDeep;
	}
	
	public boolean locksObjects() {
		return locksObjects;
	}
	
	public NSArray<String> prefetchingRelationshipKeyPaths() {
		return prefetchingRelationshipKeyPaths;
	}
	
	public boolean promptsAfterFetchLimit() {
		return promptsAfterFetchLimit;
	}
	
	public EOQualifier qualifier() {
		return qualifier;
	}
	
	public NSArray<String> rawRowKeyPaths() {
		return rawRowKeyPaths;
	}
	
	public boolean refreshesRefetchedObjects() {
		return refreshesRefetchedObjects;
	}

	public boolean requiresAllQualifierBindingVariables() {
		return requiresAllQualifierBindingVariables;
	}
	
	public void setEntityName(String entityName) {
		this.entityName = entityName;
	}

	public void setFetchesRawRows(boolean fetchesRawRows) {
		this.fetchesRawRows = fetchesRawRows;
	}
	
	public void setFetchLimit(int fetchLimit) {
		this.fetchLimit = fetchLimit;
	}
	
	public void setHints(NSDictionary hints) {
		this.hints = hints;
	}
	
	public void setIsDeep(boolean isDeep) {
		this.isDeep = isDeep;
	}

	public void setLocksObjects(boolean locksObjects) {
		this.locksObjects = locksObjects;
	}
	
	public void setPrefetchingRelationshipKeyPaths(NSArray<String> keyPaths) {
		this.prefetchingRelationshipKeyPaths  = keyPaths;
	}
	
	public void setPromptsAfterFetchLimit(boolean value) {
		this.promptsAfterFetchLimit = value;
	}
	
	public void setQualifier(EOQualifier qualifier) {
		this.qualifier = qualifier;
	}
	
	public void setRawRowKeyPaths(NSArray<String> keyPaths) {
		this.rawRowKeyPaths = keyPaths;
	}
	
	public void setRefreshesRefetchedObjects(boolean refreshes) {
		this.refreshesRefetchedObjects = refreshes;
	}
	
	public void setRequiresAllQualifierBindingVariables(boolean requires) {
		this.requiresAllQualifierBindingVariables = requires;
	}
	
	public void setSortOrderings(NSArray<EOSortOrdering> sortOrderings) {
		this.sortOrderings = sortOrderings;
	}
	
	public void setUsesDistinct(boolean usesDistinct) {
		this.usesDistinct = usesDistinct;
	}
	
	public NSArray<EOSortOrdering> sortOrderings() {
		return sortOrderings;
	}
	
	public boolean usesDistinct() {
		return usesDistinct;
	}
	
}
