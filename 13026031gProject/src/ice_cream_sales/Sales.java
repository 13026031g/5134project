//GUI of the point-of-sale system for ice-cream shop
package ice_cream_sales;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Sales extends JFrame implements ActionListener{
	
		//Panels, buttons and text field for the GUI
		private JPanel flavorPanel, decoratorPanel, transactionPanel, adminPanel;
		private JButton startButton,  adminButton,finishButton;	
		private JButton flavorButton1, flavorButton2, decoratorButton1, decoratorButton2;
		private JButton newFlavorButton, newDecoratorButton; 
		private JTextField total, item;
		
		
		private double sum; // the total price
		
		//condition of starting a new transaction and selecting the flavor
		private boolean startTransaction = false, selectedFlavor = false;
		
		private IceCream iceCream;	
		
		//type of the flavor and decorator selected
		private int flavorType,decoratorType ;	 
		
		//name and price of the newly added flavor and decorator
		private String newFlavorName,newDecoratorName;		
		private double newFlavorPrice, newDecoratorPrice;
		
		
		
		public static final long serialVersionUID=138938123;
		
			
		public Sales(){
			
			super("Ice-cream POS");
			this.setSize(800, 400);    
				
					
			// Panel and button for ice-cream flavor
			flavorPanel = new JPanel();
			flavorPanel.setLayout(new FlowLayout());
			flavorButton1  = new JButton("Chocolate  $20");
			flavorButton2 = new JButton("Vanilla  $20");
			flavorPanel.add( new JLabel("ICE-CREAM Flavor"));
			flavorPanel.add(flavorButton1);
			flavorPanel.add(flavorButton2); 
			
			//Panel and buttons for decorator
			decoratorPanel = new JPanel();
			decoratorPanel.setLayout(new FlowLayout());
			decoratorButton1  = new JButton("M&M  $5");
			decoratorButton2  = new JButton("Strawberry  $4");
			decoratorPanel.add(new JLabel("ICE-CREAM Decorator"));
			decoratorPanel.add(decoratorButton1);
			decoratorPanel.add(decoratorButton2);
			
			//Panel contains button and text field for transaction
			transactionPanel = new JPanel();
			transactionPanel.setLayout(new FlowLayout());
			startButton  = new JButton("New IceCream");
			finishButton = new JButton("Finish");
			total = new JTextField(10);
			item = new JTextField(35);
			total.setText("Total: ");		
			transactionPanel.add(startButton);		
			transactionPanel.add(total);			
			transactionPanel.add(item);
			transactionPanel.add(finishButton);
			
			//Panel for system administration
			adminPanel = new JPanel();
			adminPanel.setLayout(new FlowLayout());
			adminButton  = new JButton("System Administrator");
			adminPanel.add(adminButton);
			
			//Build the GUI components
			Container pane = getContentPane();
			pane.setLayout(new GridLayout (4,1));
			pane.add(flavorPanel);
			pane.add(decoratorPanel);
			pane.add(transactionPanel);
			pane.add(adminPanel);
			
			
			//register event handlers to the buttons
			startButton.addActionListener(this);
			finishButton.addActionListener(this);
			flavorButton1.addActionListener(this);
			flavorButton2.addActionListener(this); 			
			decoratorButton1.addActionListener(this);
			decoratorButton2.addActionListener(this);
			adminButton.addActionListener(this);
			
			this.setVisible(true);		    
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
		}
		
		// method called if any of the buttons is clicked
		public void actionPerformed(ActionEvent e) {
			
			Object source = e.getSource();			
					
			if (source == startButton){						
				newTransaction(e);		
			}
					
			else if (source == flavorButton1){
				flavorType = 1;				
				selectFlavor(e);
					
			}
			
			else if (source == flavorButton2){
				flavorType = 2;
				selectFlavor(e);
		}		
			
			
			else if (source == decoratorButton1){
				decoratorType = 1 ;
				addDecorator(e);
			}
			
			
			else if (source == decoratorButton2){
				decoratorType = 2;
				addDecorator(e);					
			}
			
			
			else if (source == adminButton){
				addNewItem(e);	
			}
			
			else if (source == newFlavorButton){
				flavorType = 3;
				selectFlavor(e);
				}
			
			else if (source == newDecoratorButton){
				decoratorType =3;
				addDecorator(e);
			}				
			
			else if (source == finishButton){
				endTransaction(e);
				
			}
		
		}
		
		//method called if the NewIceCream button is clicked to start the transaction
		private void newTransaction (ActionEvent e){
			sum = 0;
			startTransaction = true;
			total.setText("Total:  " + sum);
			item.setText("");			
		}
		
				
		// method called if the flavor button is clicked to select ice-cream flavor
		private void selectFlavor(ActionEvent e){
			
			if (startTransaction == true){
									
			if (flavorType == 1){
				iceCream = new Flavor("Chocolate", 20.0);			
			}
			else if (flavorType == 2){
				iceCream = new Flavor("Vanilla", 20.0);			
			}
			else if (flavorType == 3){
				iceCream = new Flavor (newFlavorName, newFlavorPrice);
			}
			selectedFlavor = true;
			sum = iceCream.getPrice();
			total.setText("Total:  " + sum);
			item.setText("Item: " + iceCream.getName());
			}
			else{
				JOptionPane.showMessageDialog(null, "Press the NewIceCream button");
			}
		}
		
			
		//method called if the decorator button is clicked to add ice-cream decorator
		private void addDecorator(ActionEvent e){
			if (selectedFlavor == true ){	
				
			if ( decoratorType == 1){
				iceCream = new Decorator("M&M", 5.0, this.iceCream);
			}
			else if ( decoratorType == 2){
				iceCream = new Decorator("Strawberry", 4.0, this.iceCream);
			}
			else if ( decoratorType == 3){
				iceCream = new Decorator(newDecoratorName, newDecoratorPrice,  this.iceCream);
			}
			sum = iceCream.getPrice();
			total.setText("Total:  " + sum);
			item.setText("Item: " + iceCream.getName());
			}
			
			else{
				JOptionPane.showMessageDialog(null, "Select ice-cream flavor first");
			}			
		}
			
		
		//method called if the system administration button is clicked to add a new item at certain price
		private void addNewItem(ActionEvent e ) {
			int option = 0; 	//check condition of the do-while loop
			int inputOption;	//user input option for adding new flavor or new decorator
			String inputName;	//user input name of the new item
			double inputPrice;	//user input price of the new item
			
			// dialog for user to enter the option of new item, 1 for flavor and 2 for decorator
			do{
				inputOption =	Integer.parseInt(JOptionPane.showInputDialog("Enter 1 for a new flavor or 2 for a new decorator"));
				System.out.println(inputOption);
				 if (inputOption == 1  || inputOption == 2){
					option ++; 
				 }
				 else {
					 JOptionPane.showMessageDialog(null, "Invalid input\n Enter 1 for new flavor or 2 for new decorator");
				 }
				} while(option == 0); //terminate the loop if user correctly enter either 1 or 2
			
			// dialog for user to input the name and price of new item	
			inputName = JOptionPane.showInputDialog("Enter the new item name");		
			inputPrice = Integer.parseInt(JOptionPane.showInputDialog("Enter the new item price"));
			
			// create the button for new ice-cream flavor or decorator according to user input
				if (inputOption == 1){
					newFlavorName = inputName;
					newFlavorPrice = inputPrice;
					newFlavorButton = new JButton(newFlavorName + "  $" + newFlavorPrice); 
					flavorPanel.add(newFlavorButton);
					newFlavorButton.addActionListener(this);
				}
				else if (inputOption == 2){
					newDecoratorName = inputName;
					newDecoratorPrice = inputPrice;				
					newDecoratorButton= new JButton(newDecoratorName + "  $" + newDecoratorPrice);
					decoratorPanel.add(newDecoratorButton);
					newDecoratorButton.addActionListener(this);
				}								
		}
		
		//method called if the finish button is clicked to end the transaction
		private void endTransaction(ActionEvent e){
			startTransaction = false;
			selectedFlavor = false;
			iceCream = null;	
				
		}
		
		public static void main(String[] args) {
			
			new Sales();
						
		}
		

}
