/*Restaurant Menu System (ADMIN)
 * Daniel Olma
 * Team 2
 * 03.29.22
 * 
 * 
 * 
 */


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.LinkedList;
import java.util.Scanner;


public class PlayingMain{

	public static void main(String[] args) throws FileNotFoundException {
		Scanner scnr = new Scanner(System.in); 					// Creates a Scanner scnr
		LinkedList<Item> menu = new LinkedList<>(); 			// Creates the linked list
	
		String running = "Y";
		
		while( running == "Y" ) {
			
			//Prints choice
			System.out.println("1. Add an Item");
			System.out.println("2. Delete an Item");
			System.out.println("3. Print the menu");
			System.out.println("4. Save Menu");
			System.out.println("5. Load Menu");
			System.out.println("9. End program");
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
				listSave( menu );
				System.out.println("Saved");
				break;
			case 5:
				System.out.println("Retrieving");
				listImport( menu );				
				printMenu( menu );
				break;
			case 9:
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
	
	
	//***** Saves the LinkedList by reading out each item of the list, separated by a comma. 
	static void listSave( LinkedList<Item> menu ) {
		
		PrintWriter writer;
		try {
			writer = new PrintWriter("menu.txt", "UTF-8");			// Initializes the writer and sets the file name
			writer.print( menu.size() + ",");							// Gives quantity of Items in the menu

			for(int i = 0; i < menu.size(); i++) {					// Gets name, desc, and price from each item in the menu
				
				writer.print(((Item) menu.get(i)).getName() + ",");
				writer.print(((Item) menu.get(i)).getDesc() + ",");
				writer.print(((Item) menu.get(i)).getPrice() + ",");
			}
			writer.close();											// Closes the txt file
	
		} catch (FileNotFoundException e) {
			System.out.println("SAVE FAILED");
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			System.out.println("SAVE FAILED TWO");
			e.printStackTrace();
		}
	}// ENDS listSave

	
	//***** Reads in the first char (this is the quantity of Items in the list) 
	//      then builds the list by reading in the name, desc, price; creates an Item
	//      from them and adds them to the menu LinkedList.
	static void listImport( LinkedList<Item> menu) throws FileNotFoundException {
		
		menu.clear();														// Clears the menu LinkedList so that we can load the file and only the file.
		
		File file = new File("menu.txt");									// Loads the menu.txt file
		Scanner sc = new Scanner(file);										// Scans the menu.txt file
		
		sc.useDelimiter(",");												// Creates the breaks needed to parse the file
		
		int qtyItems = Integer.parseInt( sc.next() );							// Pulls out the quantity of Items in the file list
		//System.out.println( "Menu has " + qtyItems + " Items in the list." );	// TEST LINE
		
		for(int i = 0; i < qtyItems; i++) {								// Grabs name, desc, price at a time from the file.
			String itemName = sc.next();
			String itemDesc = sc.next();
			Double itemPrice = Double.parseDouble( sc.next() );

			Item a = new Item( itemName, itemDesc, itemPrice );			// Creates an Item
			menu.add(a);												// Add the Item to the LinkedList
			
		}// ENDS for

	}//ENDS listImport

		

}//ENDS Class




