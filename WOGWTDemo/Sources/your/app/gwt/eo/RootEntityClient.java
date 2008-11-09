package your.app.gwt.eo;
// this must be in a gwt translatable package

import java.util.Map;

//This class can be serialized from server to client and back
public class RootEntityClient extends _RootEntityClient {

	public RootEntityClient() {	
		super();
	}
	
	public RootEntityClient(Map map) {	
		super(map);
	}
	  
}
