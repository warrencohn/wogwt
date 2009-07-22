package your.app.gwt;

import wogwt.translatable.WOGWTClientUtil;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.gen2.logging.shared.Log;
import com.google.gwt.user.client.ui.DecoratorPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;

public class RoundedCornersScript implements EntryPoint {

	/* This class must be declared as an entry-point in the module. */
	public void onModuleLoad() {
		if (!WOGWTClientUtil.hostPageNameEquals("RoundedCorners")) {
			return;
		}
		
		Log.finest(getClass().getName() + ": onModuleLoad");
		
		DecoratorPanel panel = new DecoratorPanel();
		panel.setHeight("300px");
		panel.setWidth("300px");
		
		Label label = new Label("A DecoratorPanel that uses 3 images and css to provide rounded corners. There is a third-party solution that is more flexible, but maybe not as reliable.");
		panel.add(label);
		
		RootPanel.get("container").add(panel);
		
	}
	

}
