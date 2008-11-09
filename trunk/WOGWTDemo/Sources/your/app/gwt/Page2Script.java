package your.app.gwt;

import wogwt.translatable.WOGWTClientUtil;

import com.allen_sauer.gwt.log.client.Log;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.Window;

public class Page2Script implements EntryPoint {

	/**
	 * This is the entry point method.
	 * 
	 * This is where can attach your GWT code to the page:
	 * 1) by adding event listeners to existing html elements - like adding a
	 *    ClickListener to an existing submit button
	 * 2) or by adding entirely new widgets to the page - like creating a new button
	 *    and adding it to an existing html container.
	 * 3) or by constructing the complete UI in code here
	 */
	public void onModuleLoad() {
		if (!WOGWTClientUtil.hostPageNameEquals("Page2")) {
			return;
		}
		
		Log.debug(getClass().getName() + ": onModuleLoad");
		
		Window.alert("This is the Page2 component");
	}
}
