package your.app;

import your.app.components.Main;
import your.app.components.Page2;

import com.webobjects.appserver.WOActionResults;
import com.webobjects.appserver.WORequest;

import er.extensions.appserver.ERXDirectAction;

public class DirectAction extends ERXDirectAction {
	
	public DirectAction(WORequest request) {
		super(request);
	}

	@Override
	public WOActionResults defaultAction() {
		return pageWithName(Main.class.getName());
	}

	public WOActionResults page2Action() {
		return pageWithName(Page2.class.getName());
	}
	
}
