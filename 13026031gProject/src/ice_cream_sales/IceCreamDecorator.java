//Definition of class IceCreamDecorator
package ice_cream_sales;

public abstract class IceCreamDecorator extends IceCream {
	
	//Constructor
	public IceCreamDecorator(String theName, double thePrice) {
		super (theName, thePrice);		
	}	
	
	//abstract method to be defined in concrete subclass to get the name of the decorator
	public abstract String getName();

}
