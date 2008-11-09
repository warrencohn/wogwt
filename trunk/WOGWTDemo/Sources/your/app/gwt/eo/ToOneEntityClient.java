package your.app.gwt.eo;
// this must be in a gwt translatable package

import java.util.Map;

//This class can be serialized from server to client and back
public class ToOneEntityClient extends _ToOneEntityClient {

	public ToOneEntityClient() {	
		super();
	}
	
	public ToOneEntityClient(Map map) {	
		super(map);
	}
	  
}
