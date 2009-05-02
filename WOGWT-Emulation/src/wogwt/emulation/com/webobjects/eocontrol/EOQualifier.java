package com.webobjects.eocontrol;

import java.io.Serializable;

import com.webobjects.foundation.NSArray;
import com.webobjects.foundation.NSDictionary;
import com.webobjects.foundation.NSMutableArray;
import com.webobjects.foundation.NSMutableSet;
import com.webobjects.foundation.NSSelector;
import com.webobjects.foundation.NSSet;

/**
 * This class does NOTHING.  It is only defined so that the same EO classes
 * can be used both on the server and client.
 *
 */
public abstract class EOQualifier implements EOQualifierEvaluation, Serializable {

	public static final NSSelector QualifierOperatorCaseInsensitiveLike = null;
	public static final NSSelector QualifierOperatorContains = null;
	public static final NSSelector QualifierOperatorEqual = null;
	public static final NSSelector QualifierOperatorGreaterThan = null;
	public static final NSSelector QualifierOperatorGreaterThanOrEqualTo = null;
	public static final NSSelector QualifierOperatorLessThan = null;
	public static final NSSelector QualifierOperatorLessThanOrEqualTo = null;
	public static final NSSelector QualifierOperatorLike = null;
	public static final NSSelector QualifierOperatorNotEqual = null;
	
	public static NSArray allQualifierOperators() {
		return NSArray.EmptyArray;
	}
	
	public static <E> void filterArrayWithQualifier(NSMutableArray<E> array, EOQualifier qualifier) {
	}

	public static <E> NSArray<E> filteredArrayWithQualifier(NSArray<E> array, EOQualifier qualifier) {
		return array;
	}
	
	public static NSSelector operatorSelectorForString(String string) {
		return null;
	}
	
	public static EOQualifier qualifierToMatchAllValues(NSDictionary<String,? extends Object> values) {
		return null;
	}
	
	public static EOQualifier qualifierToMatchAnyValue(NSDictionary<String,Object> values) {
		return null;
	}
	
	public static EOQualifier qualifierWithQualifierFormat(String format, NSArray arguments) {
		return null;
	}
	
	public static NSArray relationalQualifierOperators() {
		return NSArray.EmptyArray;
	}
	
	public static String stringForOperatorSelector(NSSelector selector) {
		return null;
	}
	
	public EOQualifier() {
		super();
	}

	public abstract void addQualifierKeysToSet(NSMutableSet arg0);

	public abstract EOQualifier qualifierWithBindings(NSDictionary arg0, boolean arg1);

	public abstract void validateKeysWithRootClassDescription(EOClassDescription arg0);

	public NSSet allQualifierKeys() {
		return NSSet.EmptySet;
	}
	
	public NSArray<String> bindingKeys() {
		return NSArray.EmptyArray;
	}
	
	public Object clone() {
		return null;
	}
	
	public boolean evaluateWithObject(Object object) {
		return false;
	}
	
	public String keyPathForBindingKey(String key) {
		return null;
	}
	
}
