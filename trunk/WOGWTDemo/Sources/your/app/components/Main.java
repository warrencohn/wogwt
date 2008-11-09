package your.app.components;


import com.webobjects.appserver.WOActionResults;
import com.webobjects.appserver.WOComponent;
import com.webobjects.appserver.WOContext;
import com.webobjects.appserver.WORequest;
import com.webobjects.foundation.NSArray;
import com.webobjects.foundation.NSTimestamp;

import er.extensions.components.ERXComponent;

public class Main extends ERXComponent {
	
	public NSTimestamp now = new NSTimestamp();
	
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
	
	private String selectedState;
	public String stateItem;
	public NSArray stateList = new NSArray(new String[] {
		"State 1",
		"State 2",
		"State 3"
	});
	
	private String selectedCounty;
	public String countyItem;
	public NSArray countyList() {
		if (selectedState == null) {
			return null;
		}
		
		return new NSArray(new String[] {
			selectedState + " - County 1",
			selectedState + " - County 2",
			selectedState + " - County 3"
		});
	}
	
	public String selectedStreet;
	public String streetItem;
	public NSArray streetList() {
		if (selectedState == null || selectedCounty == null) {
			return null;
		}
		
		return new NSArray(new String[] {
			selectedCounty + " - Street 1",
			selectedCounty + " - Street 2",
			selectedCounty + " - Street 3"
		});
	}
	
	public Main(WOContext context) {
		super(context);
	}

	@Override
	public void takeValuesFromRequest(WORequest request, WOContext context) {
		super.takeValuesFromRequest(request, context);
	}
	
	@Override
	public WOActionResults invokeAction(WORequest request, WOContext context) {
		return super.invokeAction(request, context);
	}
	
	public void updateTimeAction() {
		now = new NSTimestamp();
	}
	
	public String componentActionURL() {
		return context().componentActionURL();
	}
	
	public void periodicUpdateAction() {
		now = new NSTimestamp();
	}
	
	public void helloAction() {
		greeting = "Hello";
		now = new NSTimestamp();
	}
	
	public WOComponent goodbyeAction() {
		greeting = "Goodbye";
		now = new NSTimestamp();
		return null;
	}

	public boolean isFemale() {
		return !isMale;
	}
	
	public void setIsFemale(boolean value) {
		isMale = !value;
	}
	
	public WOActionResults page2Action() {
		return pageWithName(Page2.class);
	}

	public void setSelectedState(String selectedState) {
		this.selectedState = selectedState;
		selectedCounty = null;
		selectedStreet = null;
	}
	public String selectedState() {
		return selectedState;
	}

	public void setSelectedCounty(String selectedCounty) {
		this.selectedCounty = selectedCounty;
		selectedStreet = null;
	}
	public String selectedCounty() {
		return selectedCounty;
	}
	
	public int count = 0;
	public WOActionResults countAction() {
		count++;
		return null;
	}
	
}
