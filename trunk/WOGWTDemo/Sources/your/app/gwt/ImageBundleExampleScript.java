package your.app.gwt;

import wogwt.translatable.WOGWTClientUtil;

import com.allen_sauer.gwt.log.client.Log;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.AbstractImagePrototype;
import com.google.gwt.user.client.ui.RootPanel;

public class ImageBundleExampleScript implements EntryPoint {

	/* This class must be declared as an entry-point in the module. */
	public void onModuleLoad() {
		if (!WOGWTClientUtil.hostPageNameEquals("ImageBundleExample")) {
			return;
		}
		
		Log.debug(getClass().getName() + ": onModuleLoad");
		
		AppImageBundle imageBundle = GWT.create(AppImageBundle.class);

		AbstractImagePrototype wait16 = imageBundle.wait16();
		AbstractImagePrototype wait18 = imageBundle.wait18();
		AbstractImagePrototype wait20 = imageBundle.wait20();
		AbstractImagePrototype wait22 = imageBundle.wait22();
		
		RootPanel.get("imageContainer1").add(wait16.createImage());
		RootPanel.get("imageContainer2").add(wait18.createImage());
		RootPanel.get("imageContainer3").add(wait20.createImage());
		RootPanel.get("imageContainer4").add(wait22.createImage());
		
	}

}
