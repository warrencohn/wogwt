package test.com.webobjects.foundation;

import com.google.gwt.junit.client.GWTTestCase;

public class BaseTestCase extends GWTTestCase {

	@Override
	public String getModuleName() {
		return "wogwt.emulation.WOGWTEmulationTest";
	}

}
