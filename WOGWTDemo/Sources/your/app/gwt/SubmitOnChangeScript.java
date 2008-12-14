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

	private ChangeListener stateChangeListener;
	private ChangeListener countyChangeListener;
	private ChangeListener streetChangeListener;
	
	/* This class must be declared as an entry-point in the module. */
	public void onModuleLoad() {
		if (!WOGWTClientUtil.hostPageNameEquals("SubmitOnChange")) {
			return;
		}
		
		Log.debug(getClass().getName() + ": onModuleLoad");
		
		stateChangeListener = new SingleFieldSubmitOnChangeListener("countyDiv", 
				new AfterDOMUpdateCallback() {
					public void afterDOMUpdate(Object sender, String url, Response response) {
						attachPartialSubmitFormListeners();
					}
		});
		
		countyChangeListener = new SingleFieldSubmitOnChangeListener("streetDiv", 
				new AfterDOMUpdateCallback() {
					public void afterDOMUpdate(Object sender, String url, Response response) {
						attachPartialSubmitFormListeners();
					}
		});
		
		streetChangeListener = new SingleFieldSubmitOnChangeListener("resultDiv", 
				new AfterDOMUpdateCallback() {
					public void afterDOMUpdate(Object sender, String url, Response response) {
						attachPartialSubmitFormListeners();
					}
		});
		
		attachPartialSubmitFormListeners();
	}
	
	private void attachPartialSubmitFormListeners() {
		ListBox statePopup = ListBox.wrap(DOM.getElementById("statePopup"));
		statePopup.removeChangeListener(stateChangeListener);
		statePopup.addChangeListener(stateChangeListener);
		
		ListBox countyPopup = ListBox.wrap(DOM.getElementById("countyPopup"));
		countyPopup.removeChangeListener(countyChangeListener);
		countyPopup.addChangeListener(countyChangeListener);
		
		ListBox streetPopup = ListBox.wrap(DOM.getElementById("streetPopup"));
		streetPopup.removeChangeListener(streetChangeListener);
		streetPopup.addChangeListener(streetChangeListener);
	}

}
