//Definition of class Flavor
package ice_cream_sales;

public class Flavor extends IceCream {
	
	//Constructor
	public Flavor(String theName, Double thePrice) {
		super (theName, thePrice);
	}
	
	//method to get the price of the ice-cream flavor
	public double getPrice(){
		return price;
	}

}
