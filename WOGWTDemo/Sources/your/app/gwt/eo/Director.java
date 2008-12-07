package your.app.gwt.eo;
// this must be in a gwt translatable package

import java.util.Map;

//This class can be serialized from server to client and back
public class Director extends _Director {

	public Director() {	
		super();
	}
	
	public Director(Map map) {	
		super(map);
	}
	  
}
