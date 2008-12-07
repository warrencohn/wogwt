package your.app.gwt.eo;
// this must be in a gwt translatable package

import java.util.Map;

//This class can be serialized from server to client and back
public class MovieClient extends _MovieClient {

	public MovieClient() {	
		super();
	}
	
	public MovieClient(Map map) {	
		super(map);
	}
	  
}
