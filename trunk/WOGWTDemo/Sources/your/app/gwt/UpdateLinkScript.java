package your.app.gwt;

import wogwt.translatable.WOGWTClientUtil;
import wogwt.translatable.http.AfterDOMUpdateCallback;
import wogwt.translatable.http.UpdateOnClickListener;

import com.allen_sauer.gwt.log.client.Log;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.http.client.Response;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.ClickListener;

public class UpdateLinkScript implements EntryPoint {

	private ClickListener insideLinkClickListener;

	/* This class must be declared as an entry-point in the module. */
	public void onModuleLoad() {
		if (!WOGWTClientUtil.hostPageNameEquals("UpdateLink")) {
			return;
		}
		
		Log.debug(getClass().getName() + ": onModuleLoad");
		
		Anchor outsideLink = Anchor.wrap(DOM.getElementById("outsideLink"));
		outsideLink.addClickListener(new UpdateOnClickListener("outsideContainer"));
		
		
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
	
}
