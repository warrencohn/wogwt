package your.app.gwtrpc;

import java.util.List;

import wogwt.WOGWTRpcService;
import wogwt.WOGWTServerUtil;
import your.app.eo.RootEntity;
import your.app.gwt.EOService;
import your.app.gwt.eo.RootEntityClient;

import com.webobjects.appserver.WOContext;
import com.webobjects.foundation.NSArray;


public class EOServiceImpl extends WOGWTRpcService implements EOService {
	
	public EOServiceImpl(WOContext context) {
		super(context);
	}
	
	public List<RootEntityClient> allRootEntities() {
		NSArray eos = RootEntity.fetchAllRootEntities(session().defaultEditingContext());
		return WOGWTServerUtil.toClientEOList(eos, 
				new NSArray(new String[] {
						RootEntity.TO_ONE_ENTITY_KEY,
						RootEntity.TO_MANY_ENTITY_OBJECTS_KEY}));
	}
	
}
