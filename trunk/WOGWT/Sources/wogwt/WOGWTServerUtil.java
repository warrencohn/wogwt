package wogwt;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.w3c.dom.Node;

import wogwt.translatable.WOGWTClientUtil;

import com.webobjects.appserver.WORequest;
import com.webobjects.appserver.WOResponse;
import com.webobjects.foundation.NSLog;

public class WOGWTServerUtil {

	/**
	 * Reads the updateContainerID from the url and then strips everything from the 
	 * response except the updateContainer's html
	 * 
	 * @param request
	 * @param response the fully populated response to extract the update container from
	 */
	public static void onlyIncludeUpdateContainerInResponse(WORequest request, WOResponse response) {		
    	String updateContainerID = request.stringFormValueForKey(WOGWTClientUtil.UPDATE_CONTAINER_ID_KEY);
    	if (updateContainerID != null) {
	    	Node updateContainer = XMLUtilsServer.xhtmlElementWithID(response.contentString(), updateContainerID);
	    	if (updateContainer != null) {
	    		String partialResponse = XMLUtilsServer.serializeChildren(updateContainer);
	    		//String partialResponse = XMLUtilsServer.childrenToString(updateContainer); 	
	    		response.setContent(partialResponse);
	    	} else {
	    		NSLog.debug.appendln("update container '" + updateContainerID + "' not present in response");
	    		response.appendHeader(updateContainerID, WOGWTClientUtil.WOGWTMissingUpdateContainer);
	    	}
    	}	
	}
	
	public static List toClientEOList(Collection serverEOs) {
		List result = new ArrayList(serverEOs.size());	  

		for (Iterator iterator = serverEOs.iterator(); iterator.hasNext();) {
			WOGWTServerEO eo = (WOGWTServerEO)iterator.next();
			result.add( eo.toClientEO() );
		}
		return result;
	}
}
