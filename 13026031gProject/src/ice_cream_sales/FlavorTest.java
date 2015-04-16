//JUnit TestCase for all the public methods of class Flavor
package ice_cream_sales;

import junit.framework.TestCase;

public class FlavorTest extends TestCase {
	
	private Flavor flavor1;
	private Flavor flavor2;
	private Flavor flavor3;
	private Flavor flavor4;
	
	public void setUp() {
		
		flavor1 = new Flavor("Chocolate",15.0);
		flavor2 = new Flavor("Vanilla", 10.0);
		flavor3 = new Flavor("Mango",20.0);
		flavor4 = new Flavor("Coffee", 25.0);
		
	}
	
	//To test the getPrice method of class Flavor
	public void testGetPrice() {
		double price = 15.0;
		assertEquals(price, flavor1.getPrice());
		
		price = 10.0;
		assertEquals(price, flavor2.getPrice());
		
		price = 20.0;
		assertEquals(price, flavor3.getPrice());
		
		price = 25.0;
		assertEquals(price, flavor4.getPrice());		
	}
	
	//To test the getName() method of class Flavor
	public void testGetName() {
		
		String name = "Chocolate";
		assertEquals(name, flavor1.getName());
		
		name = "Vanilla";
		assertEquals(name, flavor2.getName());
		
		name = "Mango";
		assertEquals(name, flavor3.getName());
		
		name = "Coffee";
		assertEquals(name, flavor4.getName());	
	
	}
}
