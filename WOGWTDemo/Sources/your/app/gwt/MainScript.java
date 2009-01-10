package your.app.gwt;

import java.math.BigDecimal;

import wogwt.translatable.WOGWTClientUtil;

import com.allen_sauer.gwt.log.client.Log;
import com.google.gwt.core.client.EntryPoint;

public class MainScript implements EntryPoint {

	/* This class must be declared as an entry-point in the module. */
	public void onModuleLoad() {
		if (!WOGWTClientUtil.hostPageNameEquals("Main")) {
			return;
		}
		
		Log.debug(getClass().getName() + ": onModuleLoad");
		
		BigDecimal b = new BigDecimal(5);
		Log.debug(b.toString());
	}
	
}
