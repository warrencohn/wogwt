package your.app.gwt.eo;
// this must be in a gwt translatable package

import com.webobjects.foundation.NSDictionary;

//This class can be serialized from server to client and back
public class PlotSummaryClient extends _PlotSummaryClient {

	public PlotSummaryClient() {	
		super();
	}
	
	public PlotSummaryClient(NSDictionary<String, Object> snapshot) {	
		super(snapshot);
	}
	  
}
