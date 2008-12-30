package test.com.webobjects.foundation;

import junit.framework.Test;
import junit.framework.TestSuite;

public class AllTests {

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
