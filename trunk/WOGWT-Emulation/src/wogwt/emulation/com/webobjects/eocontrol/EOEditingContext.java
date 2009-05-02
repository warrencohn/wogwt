package com.webobjects.eocontrol;

import java.io.Serializable;
import java.util.Map;

import com.webobjects.eocontrol.EOEditingContext.Editor;
import com.webobjects.foundation.NSArray;
import com.webobjects.foundation.NSDictionary;
import com.webobjects.foundation.NSDisposable;
import com.webobjects.foundation.NSLocking;

/**
 * This class does NOTHING.  It is only defined so that the same EO classes
 * can be used both on the server and client.
 *
 */
public class EOEditingContext implements EOObserving, NSDisposable, NSLocking, Serializable {

	public static interface Delegate {
		public void editingContextDidMergeChanges(EOEditingContext context);
		public NSArray editingContextShouldFetchObjects(EOEditingContext context, EOFetchSpecification fetchSpec);
		public boolean editingContextShouldInvalidateObject(EOEditingContext context, EOEnterpriseObject object, EOGlobalID globalID);
		public boolean editingContextShouldMergeChangesForObject(EOEditingContext context, EOEnterpriseObject object);
		public boolean editingContextShouldPresentException(EOEditingContext context, Throwable exception);
		public boolean editingContextShouldUndoUserActionsAfterFailure(EOEditingContext context);
		public boolean editingContextShouldValidateChanges(EOEditingContext context);
		public void editingContextWillSaveChanges(EOEditingContext context);
	}
	
	public static interface Editor {
		public void editingContextWillSaveChanges(EOEditingContext context);
		public boolean editorHasChangesForEditingContext(EOEditingContext context);
	}
	
	public static final String EditingContextDidSaveChangesNotification = "EOEditingContextDidSaveChangesNotification";
	public static final int EditingContextFlushChangesRunLoopOrdering = 300000;
	public static final String ObjectsChangedInEditingContextNotification = "EOObjectsChangedInEditingContextNotification";
	
	public EOEditingContext() {
		super();
	}

	public NSDictionary committedSnapshotForObject(EOEnterpriseObject object) {
		return null;
	}
	
	public NSDictionary currentEventSnapshotForObject(EOEnterpriseObject arg0) {
		return null;
	}

	public void addEditor(Object editor) {
	}
	
	public NSArray arrayFaultWithSourceGlobalID(EOGlobalID arg0, String arg1,
			EOEditingContext arg2) {
		return NSArray.EmptyArray;
	}

	public Object delegate() {
		return null;
	}
	
	public NSArray<EOEnterpriseObject> deletedObjects() {
		return NSArray.EmptyArray;
	}
	
	public void deleteObject(EOEnterpriseObject object) {
	}
	
	public void dispose() {
	}

	public void editingContextDidForgetObjectWithGlobalID(
			EOEditingContext context, EOGlobalID gid) {
	}

	public NSArray<Editor> editors() {
		return NSArray.EmptyArray;
	}

	public boolean editorsHaveChanges() {
		return false;
	}

	public EOEnterpriseObject faultForGlobalID(EOGlobalID arg0,
			EOEditingContext arg1) {
		return null;
	}

	public EOEnterpriseObject faultForRawRow(NSDictionary row, String entityName) {
		return null;
	}
	
	public EOEnterpriseObject faultForRawRow(NSDictionary row,
			String entityName, EOEditingContext context) {
		return null;
	}

	public long fetchTimestamp() {
		return 0;
	}
	
	public void forgetObject(EOEnterpriseObject object) {
	}
	
	public EOGlobalID globalIDForObject(EOEnterpriseObject arg0) {
		return null;
	}
	
	public boolean hasChanges() {
		return false;
	}
	
	public void initializeObject(EOEnterpriseObject arg0, EOGlobalID arg1,
			EOEditingContext arg2) {
	}
	
	public NSArray<EOEnterpriseObject> insertedObjects() {
		return NSArray.EmptyArray;
	}
	
	public void insertObject(EOEnterpriseObject object) {
	}
	
	public void insertObjectWithGlobalID(EOEnterpriseObject object,
			EOGlobalID gid) {
	}

	public void invalidateAllObjects() {
	}
	
	public void invalidateObjectsWithGlobalIDs(NSArray<EOGlobalID> arg0) {
	}
	
	public boolean invalidatesObjectsWhenFinalized() {
		return false;
	}

	public Object invokeRemoteMethod(EOEditingContext context, EOGlobalID gid,
			String methodName, Class[] argumentTypes, Object[] arguments) {
				return null;
	}
	
	public boolean isObjectLockedWithGlobalID(EOGlobalID gid,
			EOEditingContext context) {
		return false;
	}

	public void lock() {
	}
	
	public void lockObject(EOEnterpriseObject object) {
	}
	
	public void lockObjectStore() {
	}
	
	public void lockObjectWithGlobalID(EOGlobalID gid, EOEditingContext context) {
	}
	
	public boolean locksObjectsBeforeFirstModification() {
		return true;
	}
	
	public Object messageHandler() {
		return null;
	}

	public EOEnterpriseObject objectForGlobalID(EOGlobalID gid) {
		return null;
	}

	public NSArray objectsForSourceGlobalID(EOGlobalID arg0, String arg1,
			EOEditingContext arg2) {
		return NSArray.EmptyArray;
	}
	
	public NSArray objectsWithFetchSpecification(EOFetchSpecification arg0,
			EOEditingContext arg1) {
		return NSArray.EmptyArray;
	}
	
	public NSArray objectsWithFetchSpecification(
			EOFetchSpecification fetchSpecification) {
		return NSArray.EmptyArray;
	}
	
	public void objectWillChange(Object object) {
	}
	
//	public EOObjectStore parentObjectStore() {
//		return null;
//	}

	public void processRecentChanges() {
	}

	public boolean propagatesDeletesAtEndOfEvent() {
		return false;
	}

	public void recordObject(EOEnterpriseObject object, EOGlobalID gid) {
	}
	
	public void redo() {
	}
	
	public void refaultAllObjects() {
	}

	public void refaultObject(EOEnterpriseObject arg0, EOGlobalID arg1,
			EOEditingContext arg2) {
	}
	
	public void refaultObject(EOEnterpriseObject object) {
	}
	
	public void refaultObjects() {
	}

	public void refetch() {
	}

	public void refreshAllObjects() {
	}

	public void refreshObject(EOEnterpriseObject arg0) {
	}

	public NSArray registeredObjects() {
		return NSArray.EmptyArray;
	}

	public void removeEditor(Object editor) {
	}
	
	public void reset() {
	}
	
	public boolean retainsRegisteredObjects() {
		return true;
	}
	
	public void revert() {
	}
	
//	public EOObjectStore rootObjectStore() {
//		return null;
//	}
	
	public void saveChanges() {
	}
	
	public void saveChanges(Object arg0) {
	}
	
	public void saveChangesInEditingContext(EOEditingContext arg0) {
	}

	public void setDelegate(Object delegate) {
	}

	public void setFetchTimestamp(long timestamp) {
	}

	public void setInvalidatesObjectsWhenFinalized(boolean yn) {
	}
	
	public void setLocksObjectsBeforeFirstModification(boolean yn) {
	}

	public void setMessageHandler(Object handler) {
	}

	public void setPropagatesDeletesAtEndOfEvent(
			boolean propagatesDeletesAtEndOfEvent) {
	}

	public void setRetainsRegisteredObjects(boolean flag) {
	}
	
	public void setStopsValidationAfterFirstError(boolean yn) {
	}

	public void setUserInfo(Map<String, Object> dictionary) {
	}
	
	public void setUserInfoForKey(Object value, String key) {
	}
	
	public boolean stopsValidationAfterFirstError() {
		return false;
	}
	
	public boolean tryLock() {
		return true;
	}
	
	public Throwable tryToSaveChanges() {
		return null;
	}
	
	public void undo() {
	}
	
	public void unlock() {
	}
	
	public void unlockObjectStore() {
	}

	public NSArray<EOEnterpriseObject> updatedObjects() {
		return null;
	}
	
	public NSDictionary<String, Object> userInfo() {
		return null;
	}
	
	public Object userInfoForKey(String key) {
		return null;
	}
	
}
