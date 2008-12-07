package your.app.gwt.eo;
// this must be in a gwt translatable package

import java.util.Map;

//This class can be serialized from server to client and back
public class Voting extends _Voting {

	public Voting() {	
		super();
	}
	
	public Voting(Map map) {	
		super(map);
	}
	  
}
