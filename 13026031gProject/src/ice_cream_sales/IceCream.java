//Definition of class IceCream
package ice_cream_sales;

public abstract class IceCream {
	
	protected String name;		//name of the ice-cream 
	protected double price;		//price of the ice-cream	
	
	//Constructor	
	public IceCream(String theName, double thePrice){
		name = theName;
		price = thePrice;
	}
	
	//method to get the name of the ice-cream
	public String getName(){
		return name;
	}
	
	//abstract method to be defined in concrete subclass to get the price of the ice-cream 
	public abstract double getPrice();		

}
