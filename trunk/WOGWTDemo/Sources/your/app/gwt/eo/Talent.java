package your.app.gwt.eo;
// this must be in a gwt translatable package

import java.util.Map;

//This class can be serialized from server to client and back
public class Talent extends _Talent {

	public Talent() {	
		super();
	}
	
	public Talent(Map map) {	
		super(map);
	}
	  
}
