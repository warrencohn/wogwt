package your.app.components;

import com.webobjects.appserver.WOActionResults;
import com.webobjects.appserver.WOContext;

import er.extensions.components.ERXComponent;

// Generated by the WOLips Templateengine Plug-in at Nov 23, 2008 3:04:50 PM
public class DynamicUI extends ERXComponent {
	
	public int count = 0;

    public DynamicUI(WOContext context) {
        super(context);
    }
    
	public WOActionResults countAction() {
		count++;
		return null;
	}
	
}