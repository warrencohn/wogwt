package your.app.gwt;

import wogwt.translatable.ErrorDialog;
import wogwt.translatable.WOGWTClientUtil;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.gen2.logging.shared.Log;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.ClickListener;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;

public class DialogExampleScript implements EntryPoint {

	/* This class must be declared as an entry-point in the module. */
	public void onModuleLoad() {
		if (!WOGWTClientUtil.hostPageNameEquals("DialogExample")) {
			return;
		}
		
		Log.finest(getClass().getName() + ": onModuleLoad");
		
		Button button = new Button();
		button.setText("Show Dialog");
		button.addClickListener(new ClickListener() {
			public void onClick(Widget arg0) {
				ErrorDialog dialog = new ErrorDialog(
						"Your own error message can be displayed in a fancy dialog like this.");
				dialog.showModal();
			}
		});
		RootPanel.get("container").add(button);
	}
	
}
