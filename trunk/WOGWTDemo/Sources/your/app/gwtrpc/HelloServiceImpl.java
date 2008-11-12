package your.app.gwtrpc;

import wogwt.WOGWTRpcService;
import your.app.Session;
import your.app.gwt.HelloService;

import com.webobjects.appserver.WOContext;


public class HelloServiceImpl extends WOGWTRpcService implements HelloService {
	
	public HelloServiceImpl(WOContext context) {
		super(context);
	}
	
	public String hello() {
		session(Session.class).counter++;
		return "hello! " + session(Session.class).counter;
	}
	
}
