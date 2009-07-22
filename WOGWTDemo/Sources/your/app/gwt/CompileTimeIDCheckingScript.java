package your.app.gwt;

import wogwt.translatable.WOGWTClientUtil;
import wogwt.translatable.http.UpdateOnClickListener;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.gen2.logging.shared.Log;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.ui.Anchor;

public class CompileTimeIDCheckingScript implements EntryPoint {

	public static final String CONTAINER_ID = "container";
	public static final String UPDATE_LINK_ID = "updateLink";
	
	/* This class must be declared as an entry-point in the module. */
	public void onModuleLoad() {
		if (!WOGWTClientUtil.hostPageNameEquals("CompileTimeIDChecking")) {
			return;
		}
		
		Log.finest(getClass().getName() + ": onModuleLoad");
		
		Anchor anchor = Anchor.wrap(DOM.getElementById(UPDATE_LINK_ID));
		anchor.addClickHandler(new UpdateOnClickListener(CONTAINER_ID));
	}
	
}
