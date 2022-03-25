import java.util.LinkedList;
import java.util.Scanner;

public class PlayingMain{

	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in); 					// Creates a Scanner scnr
		LinkedList<Item> menu = new LinkedList<>(); 			// Creates the linked list
	
		String running = "Y";
		
		while( running == "Y" ) {
			
			//Prints choice
			System.out.println("1. Add an Item");
			System.out.println("2. Delete an Item");
			System.out.println("3. Print the menu");
			System.out.println("4. To quit the program");
			System.out.println("");
			
			int selection = scnr.nextInt();					// Reads user input
			System.out.println("");
			
			switch( selection ) {
			case 1:
				addItem( menu, scnr );
				break;
			case 2:
				deleteItem( menu, scnr );
				break;
			case 3:
				System.out.println("Menu");
				printMenu( menu );
				break;
			case 4:
				running = "N";
				break;
			default: 
				System.out.println("Invalid Choice\n");
			}
			
		}//ENDS while loop
	
		System.out.println("\n\nEND OF PROGRAM ");
		
		scnr.close();
		

	}// ENDS main
	

	
	
	
	// Methods for the LinkedList
	//*****Prints out each of the Items in format********
	static void printMenu( LinkedList menu ) {
		for(int i = 0; i < menu.size(); i++) {
			//System.out.println(menu.get(i));
			((Item) menu.get(i)).printItem();
		}
	}
	
	//***** Adds an item to the menu by prompting for the data, building an Item, and adding it to the list.
	static void addItem( LinkedList<Item> menu, Scanner scnr ) {
		scnr.nextLine();
		//System.out.println("");
		System.out.print("Enter the Item Name: ");
		String itemName = scnr.nextLine();
		System.out.print("Enter the Item Description: ");
		String itemDesc = scnr.nextLine();
		System.out.print("Enter the Item Price: ");
		Double itemPrice = scnr.nextDouble();
		scnr.nextLine();
		System.out.println("");
		
		Item a = new Item( itemName, itemDesc, itemPrice );
		menu.add(a);
		
	}

	//***** Deletes an item from the list by prompting for a numbered Item, then checking if its good, then deleting from the list.
	static void deleteItem( LinkedList menu, Scanner scnr ) {
		System.out.print("Which numbered item would you like to delete?");
		int numbr = scnr.nextInt();
		if( numbr > menu.size() ) {
			System.out.println( "Item does not exist (too high)");
		}
		else {
			menu.remove(numbr -1);
		}
		
	}// ENDS deleteItem
	
	

	
	
	
	
	

		

}//ENDS Class




