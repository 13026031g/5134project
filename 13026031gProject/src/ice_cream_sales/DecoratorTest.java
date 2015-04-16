//JUnit TestCase for all the public method of class Decorator
package ice_cream_sales;

import junit.framework.TestCase;

public class DecoratorTest extends TestCase {
	
	
	private Flavor flavor1;
	private Flavor flavor2;
	private Decorator decorator1;
	private Decorator decorator2;
	private Decorator decorator3;
	private Decorator decorator4;
	
	
	protected void setUp() {
		flavor1 = new Flavor("Chocolate",15.0);
		flavor2 = new Flavor("Vanilla", 10.0);
		decorator1 = new Decorator("M&M", 5.0, flavor1);
		decorator2 = new Decorator("Strawberry", 4.0, flavor1);
		decorator3 = new Decorator("M&M", 5.0, flavor2);
		decorator4 = new Decorator("Strawberry", 4.0, flavor2);		
	}
	
	//To test the getPrice() method
	public void testGetPrice() {
		double price = 20.0;
		assertEquals(price, decorator1.getPrice());
		
		price = 19.0;
		assertEquals(price, decorator2.getPrice());
		
		price = 15.0;
		assertEquals(price, decorator3.getPrice());
		
		price = 14.0;
		assertEquals(price, decorator4.getPrice());		
	}
	
	//To test the getName() method
	public void testGetName() {
		
		String name = "Chocolate + M&M";
		assertEquals(name, decorator1.getName());
		
		name = "Chocolate + Strawberry";
		assertEquals(name, decorator2.getName());
		
		name = "Vanilla + M&M";
		assertEquals(name, decorator3.getName());
		
		name = "Vanilla + Strawberry";
		assertEquals(name, decorator4.getName());	
	
	}

}
