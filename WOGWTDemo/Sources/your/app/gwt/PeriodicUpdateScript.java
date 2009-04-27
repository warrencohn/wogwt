package your.app.gwt;

import wogwt.translatable.WOGWTClientUtil;
import wogwt.translatable.http.PeriodicUpdater;

import com.allen_sauer.gwt.log.client.Log;
import com.google.gwt.core.client.EntryPoint;

public class PeriodicUpdateScript implements EntryPoint {

	/* This class must be declared as an entry-point in the module. */
	public void onModuleLoad() {
		if (!WOGWTClientUtil.hostPageNameEquals("PeriodicUpdate")) {
			return;
		}

		Log.debug(getClass().getName() + ": onModuleLoad");

		PeriodicUpdater periodicUpdater = new PeriodicUpdater("periodicContainer", 2000);
	}

}
