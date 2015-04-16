//JUnit test suite for all the public methods of classes Flavor and Decorator
package ice_cream_sales;

import junit.framework.Test;
import junit.framework.TestSuite;

public class AllTests {

	public static Test suite() {
		TestSuite suite = new TestSuite(AllTests.class.getName());		
		//$JUnit-BEGIN$
		suite.addTestSuite(DecoratorTest.class);
		suite.addTestSuite(FlavorTest.class);
		//$JUnit-END$
		return suite;
	}

}
