package your.app.gwt;

import wogwt.translatable.WOGWTClientUtil;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.gen2.logging.handler.client.RemoteLogHandler;
import com.google.gwt.gen2.logging.shared.Level;
import com.google.gwt.gen2.logging.shared.Log;

public class MainScript implements EntryPoint {

	/* This class must be declared as an entry-point in the module. */
	public void onModuleLoad() {
		if (!WOGWTClientUtil.hostPageNameEquals("Main")) {
			return;
		}
		
		Log.setDefaultLevel(Level.ALL);
		Log.addLogHandler(new RemoteLogHandler());
		
		Log.info(getClass().getName() + ": onModuleLoad");
	}
	
}
