package wogwt.server.rpc;

import com.webobjects.appserver.WOApplication;
import com.webobjects.appserver.WOContext;
import com.webobjects.appserver.WOSession;
import com.webobjects.eocontrol.EOEditingContext;

import er.extensions.appserver.ERXWOContext;

/**
 * Base class for all GWT RPC Service classes.
 * Subclasses should implement the WOContext constructor.
 * 
 * This class provides access to the context for a request and the session.
 *
 */
public class WOGWTRpcService {

	public static final String EDITING_CONTEXT_KEY = "editingContext";
	
	private WOContext _context;
	
	public WOGWTRpcService(WOContext context) {
		super();
		_context = context;
	}
	
	public WOContext context() {
		return _context;
	}
	
	public WOApplication application() {
		return WOApplication.application();
	}
	
	public <T extends WOApplication> T application(Class<T> applicationClass) {
		return (T) application();
	}
	
	public WOSession session() {
		return context().session();
	}
	
	public <T extends WOSession> T session(Class<T> sessionClass) {
		return (T) session();
	}
	
	/**
	 * 
	 * @return a request-level editing context, created and locked by
	 * the request handler
	 */
	public EOEditingContext editingContext() {
		return (EOEditingContext) ERXWOContext.contextDictionary().valueForKey(EDITING_CONTEXT_KEY);
	}
	
}
