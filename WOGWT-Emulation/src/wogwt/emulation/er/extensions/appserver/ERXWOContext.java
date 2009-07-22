package er.extensions.appserver;

import com.webobjects.appserver.WOContext;
import com.webobjects.foundation.NSMutableDictionary;

public class ERXWOContext extends WOContext {

	public static WOContext currentContext() {
		throw new UnsupportedOperationException("not implemented");
	}
	
	public static NSMutableDictionary contextDictionary() {
		throw new UnsupportedOperationException("not implemented");
	}
	
}
