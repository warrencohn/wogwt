package test.com.webobjects.foundation;

import junit.framework.Test;
import junit.framework.TestSuite;
import test.java.math.BigDecimalArithmeticTest;
import test.java.math.BigDecimalCompareTest;
import test.java.math.BigDecimalConstructorsTest;
import test.java.math.BigDecimalConvertTest;
import test.java.math.BigDecimalScaleOperationsTest;
import test.java.math.BigIntegerAddTest;
import test.java.math.BigIntegerAndTest;
import test.java.math.BigIntegerCompareTest;
import test.java.math.BigIntegerConstructorsTest;
import test.java.math.BigIntegerConvertTest;
import test.java.math.BigIntegerDivideTest;
import test.java.math.BigIntegerHashCodeTest;
import test.java.math.BigIntegerModPowTest;
import test.java.math.BigIntegerMultiplyTest;
import test.java.math.BigIntegerNotTest;
import test.java.math.BigIntegerOperateBitsTest;
import test.java.math.BigIntegerOrTest;
import test.java.math.BigIntegerSubtractTest;
import test.java.math.BigIntegerToStringTest;
import test.java.math.BigIntegerXorTest;

/**
 * The test suite covers only common cases now.  Edge cases are not well tested.
 *
 */
public class AllTests extends TestSuite {

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
		
		suite.addTestSuite(BigIntegerConstructorsTest.class);
		suite.addTestSuite(BigIntegerAddTest.class);
		suite.addTestSuite(BigIntegerAndTest.class);
		suite.addTestSuite(BigIntegerCompareTest.class);
		suite.addTestSuite(BigIntegerConvertTest.class);
		suite.addTestSuite(BigIntegerDivideTest.class);
		suite.addTestSuite(BigIntegerHashCodeTest.class);
		suite.addTestSuite(BigIntegerModPowTest.class);
		suite.addTestSuite(BigIntegerMultiplyTest.class);
		suite.addTestSuite(BigIntegerNotTest.class);
		suite.addTestSuite(BigIntegerOperateBitsTest.class);
		suite.addTestSuite(BigIntegerOrTest.class);
		suite.addTestSuite(BigIntegerSubtractTest.class);
		suite.addTestSuite(BigIntegerToStringTest.class);
		suite.addTestSuite(BigIntegerXorTest.class);
		
		suite.addTestSuite(BigDecimalConstructorsTest.class);
		suite.addTestSuite(BigDecimalArithmeticTest.class);
		suite.addTestSuite(BigDecimalCompareTest.class);
		suite.addTestSuite(BigDecimalConvertTest.class);
		suite.addTestSuite(BigDecimalScaleOperationsTest.class);

		//$JUnit-END$
		return suite;
	}

}
