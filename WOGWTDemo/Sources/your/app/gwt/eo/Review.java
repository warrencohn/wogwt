package your.app.gwt.eo;
// this must be in a gwt translatable package

import java.util.Map;

//This class can be serialized from server to client and back
public class Review extends _Review {

	public Review() {	
		super();
	}
	
	public Review(Map map) {	
		super(map);
	}
	  
}
