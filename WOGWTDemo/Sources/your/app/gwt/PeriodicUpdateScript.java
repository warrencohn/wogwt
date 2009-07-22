package your.app.gwt;

import wogwt.translatable.WOGWTClientUtil;
import wogwt.translatable.http.PeriodicUpdater;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.gen2.logging.shared.Log;

public class PeriodicUpdateScript implements EntryPoint {

	/* This class must be declared as an entry-point in the module. */
	public void onModuleLoad() {
		if (!WOGWTClientUtil.hostPageNameEquals("PeriodicUpdate")) {
			return;
		}

		Log.finest(getClass().getName() + ": onModuleLoad");

		PeriodicUpdater periodicUpdater = new PeriodicUpdater("periodicContainer", 2000);
	}

}
