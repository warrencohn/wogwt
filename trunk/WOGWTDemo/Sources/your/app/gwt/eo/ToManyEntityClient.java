package your.app.gwt.eo;
// this must be in a gwt translatable package

import java.util.Map;

//This class can be serialized from server to client and back
public class ToManyEntityClient extends _ToManyEntityClient {

	public ToManyEntityClient() {	
		super();
	}
	
	public ToManyEntityClient(Map map) {	
		super(map);
	}
	  
}
