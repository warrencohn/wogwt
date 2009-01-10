package your.app.gwt.eo;
// this must be in a gwt translatable package

import java.util.Map;

//This class can be serialized from server to client and back
public class VotingClient extends _VotingClient {

	public VotingClient() {	
		super();
	}
	
	public VotingClient(Map map) {	
		super(map);
	}
	  
}
