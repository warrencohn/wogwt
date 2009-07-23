package your.app.components;

import com.webobjects.appserver.WOContext;
import com.webobjects.foundation.NSArray;

import er.extensions.components.ERXComponent;

// Generated by the WOLips Templateengine Plug-in at Nov 23, 2008 3:03:45 PM
public class SubmitButton extends ERXComponent {
	
	public String firstName;
	public String lastName;
	public String greeting;
	public boolean isMale = true;
	public boolean isBig = false;
	public boolean isTall = false;
	public String notes;
	
	public String selectedHairColor;
	public String hairColorItem;
	public NSArray hairColorList = new NSArray(new String[] {
		"brown",
		"blond",
		"red",
		"black"
	});
	
    public SubmitButton(WOContext context) {
        super(context);
    }

	public void helloAction() {
		greeting = "Hello";
	}
	
	public void goodbyeAction() {
		greeting = "Goodbye";
	}

	public boolean isFemale() {
		return !isMale;
	}
	
	public void setIsFemale(boolean value) {
		isMale = !value;
	}
	
}