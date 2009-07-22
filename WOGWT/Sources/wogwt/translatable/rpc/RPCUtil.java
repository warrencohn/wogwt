package wogwt.translatable.rpc;

import java.util.Iterator;

import wogwt.translatable.FakeNull;
import wogwt.translatable.rpc.WOGWTSerializableEO;

import com.webobjects.eocontrol.EOGenericRecord;
import com.webobjects.eocontrol.EOGlobalID;
import com.webobjects.foundation.NSDictionary;
import com.webobjects.foundation.NSMutableDictionary;

public class RPCUtil {

	public static NSDictionary<String, Object> serializableSnapshot(WOGWTSerializableEO eo) {
    	
		if (eo.isFault() || Boolean.TRUE.equals(eo.valueForKey("__isFault"))) {
			NSMutableDictionary<String, Object> snapshot = new NSMutableDictionary<String, Object>();
	    	EOGlobalID id = ((EOGenericRecord)eo).__globalID();
	    	if (id != null) {
	    		snapshot.put("__globalID", id);
	    	}
			snapshot.put("__isFault", true);
			return snapshot;
		}
		
		NSMutableDictionary<String, Object> snapshot = eo.clientSnapshot().mutableClone();
    	
    	// replace null attributes
    	for (Iterator iterator = eo.attributeKeys().iterator(); iterator.hasNext();) {
			String key = (String) iterator.next();
			Object value = eo.valueForKey(key);
			if (value == null) {
				snapshot.takeValueForKey(FakeNull.NullValue, key);
			}
		}
    	
    	// replace null relationships
    	for (Iterator iterator = eo.toOneRelationshipKeys().iterator(); iterator.hasNext();) {
			String key = (String) iterator.next();
			Object value = eo.valueForKey(key);
			if (value == null) {
				snapshot.takeValueForKey(FakeNull.NullValue, key);
			}
		}
    	
    	// remove faults
//    	for (Iterator iterator = eo.toOneRelationshipKeys().iterator(); iterator.hasNext();) {
//			String key = (String) iterator.next();
//			EOEnterpriseObject relatedEO = (EOEnterpriseObject)eo.valueForKey(key);
//			if (relatedEO != null && relatedEO.isFault()) {
//				//System.out.println("removing fault: " + key);
//				snapshot.remove(key);
//			}
//		}
//
//    	for (Iterator keyIterator = eo.toManyRelationshipKeys().iterator(); keyIterator.hasNext();) {
//			String key = (String) keyIterator.next();
//			NSArray relatedArray = (NSArray)eo.valueForKey(key);
//			if (relatedArray == null || EOFaultHandler.isFault(relatedArray)) {
//				//System.out.println("removing array fault: " + key);
//				snapshot.remove(key);
//			} else if (relatedArray != null) {
//				relatedArray = relatedArray.mutableClone();
//				for (Iterator arrayIterator = relatedArray.iterator(); arrayIterator.hasNext();) {
//					EOEnterpriseObject relatedEO = (EOEnterpriseObject) arrayIterator.next();
//					if (relatedEO.isFault()) {
//						//System.out.println("removing fault: " + key);
//						relatedArray.remove(key);
//					}
//				}
//				snapshot.put(key, new NSArray(relatedArray));
//			} 
//		}
    	
    	EOGlobalID id = ((EOGenericRecord)eo).__globalID();
    	if (id != null) {
    		snapshot.put("__globalID", id);
    	}
    	
    	return snapshot.immutableClone();
	}
	
}
