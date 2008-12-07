package your.app.gwt;

import wogwt.translatable.WOGWTClientUtil;
import wogwt.translatable.http.AfterDOMUpdateCallback;
import wogwt.translatable.http.SingleFieldSubmitOnChangeListener;

import com.allen_sauer.gwt.log.client.Log;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.http.client.Response;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.ui.ChangeListener;
import com.google.gwt.user.client.ui.ListBox;

public class SubmitOnChangeScript implements EntryPoint {

	private ChangeListener partialSubmitFormChangeListener;
	
	/* This class must be declared as an entry-point in the module. */
	public void onModuleLoad() {
		if (!WOGWTClientUtil.hostPageNameEquals("SubmitOnChange")) {
			return;
		}
		
		Log.debug(getClass().getName() + ": onModuleLoad");
		
		partialSubmitFormChangeListener = new SingleFieldSubmitOnChangeListener("partialForm", 
				new AfterDOMUpdateCallback() {
					public void afterDOMUpdate(Object sender, String url, Response response) {
						attachPartialSubmitFormListeners();
					}
		});
		attachPartialSubmitFormListeners();
	}
	
	private void attachPartialSubmitFormListeners() {
		ListBox statePopup = ListBox.wrap(DOM.getElementById("statePopup"));
		statePopup.removeChangeListener(partialSubmitFormChangeListener);
		statePopup.addChangeListener(partialSubmitFormChangeListener);
		
		ListBox countyPopup = ListBox.wrap(DOM.getElementById("countyPopup"));
		countyPopup.removeChangeListener(partialSubmitFormChangeListener);
		countyPopup.addChangeListener(partialSubmitFormChangeListener);
		
		ListBox streetPopup = ListBox.wrap(DOM.getElementById("streetPopup"));
		streetPopup.removeChangeListener(partialSubmitFormChangeListener);
		streetPopup.addChangeListener(partialSubmitFormChangeListener);
	}

}
