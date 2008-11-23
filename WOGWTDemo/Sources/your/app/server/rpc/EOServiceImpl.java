package your.app.server.rpc;

import wogwt.WOGWTServerUtil;
import wogwt.server.rpc.WOGWTRpcService;
import your.app.eo.RootEntity;
import your.app.gwt.eo.RootEntityClient;
import your.app.gwt.rpc.EOService;

import com.webobjects.appserver.WOContext;
import com.webobjects.foundation.NSArray;


public class EOServiceImpl extends WOGWTRpcService implements EOService {
	
	public EOServiceImpl(WOContext context) {
		super(context);
	}
	
	public NSArray<RootEntityClient> allRootEntities() {
		NSArray<RootEntity> eos = RootEntity.fetchAllRootEntities(session().defaultEditingContext());
		NSArray result = WOGWTServerUtil.toClientEOList(eos, 
				new NSArray<String>(new String[] {
						RootEntity.TO_ONE_ENTITY_KEY,
						RootEntity.TO_MANY_ENTITIES_KEY}));
		return result;
	}
		
}
