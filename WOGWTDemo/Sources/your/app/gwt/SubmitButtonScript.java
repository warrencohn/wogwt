package your.app.gwt;

import wogwt.translatable.WOGWTClientUtil;
import wogwt.translatable.http.SubmitOnClickListener;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.gen2.logging.shared.Log;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.ui.Button;

public class SubmitButtonScript implements EntryPoint {

	/* This class must be declared as an entry-point in the module. */
	public void onModuleLoad() {
		if (!WOGWTClientUtil.hostPageNameEquals("SubmitButton")) {
			return;
		}
		
		Log.finest(getClass().getName() + ": onModuleLoad");
		
		Button helloButton = Button.wrap(DOM.getElementById("helloButton"));
		helloButton.addClickHandler(new SubmitOnClickListener("formOutsideContainer"));
															    
		Button goodbyeButton = Button.wrap(DOM.getElementById("goodbyeButton"));
		goodbyeButton.addClickHandler(new SubmitOnClickListener("formOutsideContainer"));
	}
	
}
