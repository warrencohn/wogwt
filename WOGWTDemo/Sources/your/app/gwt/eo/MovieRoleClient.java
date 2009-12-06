package your.app.gwt.eo;
// this must be in a gwt translatable package

import com.webobjects.foundation.NSDictionary;

//This class can be serialized from server to client and back
public class MovieRoleClient extends _MovieRoleClient {

	public MovieRoleClient() {	
		super();
	}
	
	public MovieRoleClient(NSDictionary<String, Object> snapshot) {	
		super(snapshot);
	}
	  
}
