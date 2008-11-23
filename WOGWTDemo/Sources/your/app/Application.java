package your.app;

import wogwt.WOGWTServerUtil;
import wogwt.server.rpc.GWTRPCRequestHandler;

import com.webobjects.appserver.WORequest;
import com.webobjects.appserver.WOResponse;
import com.webobjects.foundation._NSUtilities;

import er.extensions.appserver.ERXApplication;

public class Application extends ERXApplication {
	
	public static void main(String[] argv) {
		ERXApplication.main(argv, Application.class);
	}

	public Application() {
		super();
		
		registerRequestHandler(new GWTRPCRequestHandler(), GWTRPCRequestHandler.KEY);

		// needed for proper class loading in GWT's Hosted Mode shell
		_NSUtilities.setClassForName( your.app.components.Main.class, "Main" );
		
		setPageCacheSize(5);
	}

    public WOResponse dispatchRequest(WORequest request) {
    	WOResponse response = super.dispatchRequest( request );
    	
    	WOGWTServerUtil.onlyIncludeUpdateContainerInResponse(request, response);
    	
    	return response;
    }
    
}
