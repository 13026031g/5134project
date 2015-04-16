//Definition of class Decorator
package ice_cream_sales;

public class Decorator extends IceCreamDecorator{
	
	protected IceCream selectedFlavor;	//the selected ice-cream flavor	
	
	//Constructors 
	public Decorator(String theName, double thePrice) {
		super (theName, thePrice); 		
	}
	
	public Decorator(String theName, double thePrice, IceCream theFlavor){
		super (theName, thePrice);
		this.selectedFlavor = theFlavor;
	}
	
	// method to get the sum of the price of the selected flavor and decorator
	public double getPrice(){
		return this.price +  selectedFlavor.getPrice();
	}
	
	//method to get the name of the selected flavor and the decorator
	public String getName(){
		return selectedFlavor.getName() + " + " +  this.name;
	}

}
