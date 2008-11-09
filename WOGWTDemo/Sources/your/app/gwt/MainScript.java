package your.app.gwt;

import wogwt.translatable.AfterDOMUpdateCallback;
import wogwt.translatable.PeriodicUpdater;
import wogwt.translatable.SingleFieldSubmitOnChangeListener;
import wogwt.translatable.SubmitOnClickListener;
import wogwt.translatable.UpdateOnClickListener;
import wogwt.translatable.WOGWTClientUtil;

import com.allen_sauer.gwt.log.client.Log;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.http.client.Response;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.ChangeListener;
import com.google.gwt.user.client.ui.ClickListener;
import com.google.gwt.user.client.ui.Hyperlink;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.RootPanel;

public class MainScript implements EntryPoint {

	private ClickListener insideLinkClickListener;
	private ChangeListener partialSubmitFormChangeListener;
	
	/**
	 * This is the entry point method.
	 * 
	 * This is where can attach your GWT code to the page:
	 * 1) by adding event listeners to existing html elements - like adding a
	 *    ClickListener to an existing submit button
	 * 2) or by adding entirely new widgets to the page - like creating a new button
	 *    and adding it to an existing html container.
	 * 3) or by constructing the complete UI in code
	 */
	public void onModuleLoad() {
		if (!WOGWTClientUtil.hostPageNameEquals("Main")) {
			return;
		}
		
		Log.debug(getClass().getName() + ": onModuleLoad");
		
		HelloService.Util.getInstance().hello(new AsyncCallback<String>() {
			public void onSuccess(String response) {
				Window.alert(response);
			}
			public void onFailure(Throwable error) {
				Log.error(error.getMessage(), error);
			}
		});
		
		Anchor outsideLink = Anchor.wrap(DOM.getElementById("outsideLink"));
		outsideLink.addClickListener(new UpdateOnClickListener("outsideContainer"));
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		/* Widgets that are inside an update container present a bit of a problem
		 * because after the container is updated, the existing Widget is destroyed
		 * and a new element is there.  Because of this, we have to re-attach any
		 * listeners that are inside the update container after the update completes,
		 * which is what the AfterDOMUpdateCallback does here.
		 */ 
		insideLinkClickListener = new UpdateOnClickListener("insideContainer", 
				new AfterDOMUpdateCallback() {
					public void afterDOMUpdate(Object sender, String url, Response response) {
						attachInsideLinkClickListener();
					}
				}
		);
		attachInsideLinkClickListener();
		
		
		PeriodicUpdater periodicUpdater = new PeriodicUpdater("periodicContainer", 2000);
		
		
		Button helloButton = Button.wrap(DOM.getElementById("helloButton"));
		helloButton.addClickListener(new SubmitOnClickListener("formOutsideContainer"));
															    
		Button goodbyeButton = Button.wrap(DOM.getElementById("goodbyeButton"));
		goodbyeButton.addClickListener(new SubmitOnClickListener("formOutsideContainer"));
		
		
		
		partialSubmitFormChangeListener = new SingleFieldSubmitOnChangeListener("partialForm", 
				new AfterDOMUpdateCallback() {
					public void afterDOMUpdate(Object sender, String url, Response response) {
						attachPartialSubmitFormListeners();
					}
		});
		attachPartialSubmitFormListeners();
		
		
		
		Hyperlink gwtCreatedLink = new Hyperlink();
		gwtCreatedLink.setText("Count");
		gwtCreatedLink.addClickListener(
				new UpdateOnClickListener("countAction", "countContainer", null));
		RootPanel.get().add(gwtCreatedLink);
	}
	
	private void attachInsideLinkClickListener() {
		Anchor insideLink = Anchor.wrap(DOM.getElementById("insideLink"));
		/* removing the listener isn't actually necessary here, but doing things this
		 * way can prevent problems in the future.  If the existing widget wasn't 
		 * actually destroyed by the DOM update (because our code changed to do
		 * something different), then we could accidentally add the same listener
		 * multiple times, which would be bad.
		 */
		insideLink.removeClickListener(insideLinkClickListener);
		insideLink.addClickListener(insideLinkClickListener);
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
