package your.app.gwt;

import wogwt.translatable.WOGWTClientUtil;
import wogwt.translatable.http.AfterDOMUpdateCallback;
import wogwt.translatable.http.SingleFieldSubmitOnChangeListener;

import com.allen_sauer.gwt.log.client.Log;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.http.client.Response;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.ui.ListBox;

public class SubmitOnChangeScript implements EntryPoint {

	private HandlerRegistration stateChangeRegistrar;
	private HandlerRegistration countyChangeRegistrar;
	private HandlerRegistration streetChangeRegistrar;
	
	/* This class must be declared as an entry-point in the module. */
	public void onModuleLoad() {
		if (!WOGWTClientUtil.hostPageNameEquals("SubmitOnChange")) {
			return;
		}
		
		Log.debug(getClass().getName() + ": onModuleLoad");

		attachPartialSubmitFormListeners();
	}
	
	private void attachPartialSubmitFormListeners() {
		ListBox statePopup = ListBox.wrap(DOM.getElementById("statePopup"));
		
		if (stateChangeRegistrar != null) {
			stateChangeRegistrar.removeHandler();
		}
		stateChangeRegistrar = statePopup.addChangeHandler(new SingleFieldSubmitOnChangeListener("countyDiv", 
				new AfterDOMUpdateCallback() {
					public void afterDOMUpdate(Object sender, String url, Response response) {
						attachPartialSubmitFormListeners();
					}
				}
		));

		ListBox countyPopup = ListBox.wrap(DOM.getElementById("countyPopup"));
		if (countyChangeRegistrar != null) {
			countyChangeRegistrar.removeHandler();
		}
		countyChangeRegistrar = countyPopup.addChangeHandler(new SingleFieldSubmitOnChangeListener("streetDiv", 
				new AfterDOMUpdateCallback() {
					public void afterDOMUpdate(Object sender, String url, Response response) {
						attachPartialSubmitFormListeners();
					}
				}
		));

		ListBox streetPopup = ListBox.wrap(DOM.getElementById("streetPopup"));
		if (streetChangeRegistrar != null) {
			streetChangeRegistrar.removeHandler();
		}
		streetChangeRegistrar = streetPopup.addChangeHandler(new SingleFieldSubmitOnChangeListener("resultDiv", 
				new AfterDOMUpdateCallback() {
					public void afterDOMUpdate(Object sender, String url, Response response) {
						attachPartialSubmitFormListeners();
					}
				}
		));
	}

}
