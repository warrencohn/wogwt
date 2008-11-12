package your.app.gwt;

import java.util.List;

import wogwt.translatable.WOGWTClientUtil;
import your.app.gwt.eo.RootEntityClient;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.ServiceDefTarget;

public interface EOService extends RemoteService {
	
	public static class Util {
		public static EOServiceAsync getInstance() {
			EOServiceAsync service = (EOServiceAsync)GWT.create(EOService.class);
			((ServiceDefTarget)service).setServiceEntryPoint(WOGWTClientUtil.rpcUrl());
			return service;
		}
	}

	public List<RootEntityClient> allRootEntities();
	
}
