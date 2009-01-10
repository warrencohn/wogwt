package test.com.webobjects.foundation;

import junit.framework.Test;
import junit.framework.TestSuite;

import com.google.gwt.junit.tools.GWTTestSuite;

/**
 * The test suite covers only common cases now.  Edge cases are not well tested.
 * 
 * Running these tests in Web Mode tests for correctness.  
 * Running the tests in Hosted Mode tests for consistency with the real 
 * WO classes since they are the classes being used in Hosted Mode.  For this
 * to work it is VERY important the the WO Foundation framework is before the
 * source for this project on the classpath.
 *
 */
public class AllTests extends GWTTestSuite {

	public static Test suite() {
		TestSuite suite = new TestSuite(
				"Test for test.com.webobjects.foundation");
		//$JUnit-BEGIN$
		suite.addTestSuite(TestNSRange.class);
		suite.addTestSuite(TestNSMutableRange.class);
		suite.addTestSuite(TestNSArray.class);
		suite.addTestSuite(TestNSMutableArray.class);
		suite.addTestSuite(TestNSDictionary.class);
		suite.addTestSuite(TestNSMutableDictionary.class);
		suite.addTestSuite(TestNSSet.class);
		suite.addTestSuite(TestNSMutableSet.class);
		suite.addTestSuite(TestNSTimestamp.class);
		//$JUnit-END$
		return suite;
	}

}
