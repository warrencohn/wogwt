package your.app.gwt.eo;
// this must be in a gwt translatable package

import java.util.Map;

//This class can be serialized from server to client and back
public class ReviewClient extends _ReviewClient {

	public ReviewClient() {	
		super();
	}
	
	public ReviewClient(Map map) {	
		super(map);
	}
	  
}