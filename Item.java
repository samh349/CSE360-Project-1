import java.io.Serializable;
import java.util.Scanner;


public class Item implements Serializable{
	
	// Data
	private String name;
	private String desc;
	private double price;
	
	// Constructors
	public Item() {}
	
	public Item( String name, String desc, Double price) {
		this.name = name;
		this.desc = desc;
		this.price = price;
	}
	
	// Methods 
	//Prints Menu Items
	public void printItem() {
		System.out.print(this.name);
		System.out.printf("\t % 20.2f\n", this.price);
		System.out.println(this.desc);
		System.out.println();
	}
	
	// Setters
	public void setName( String name ) {
		this.name = name;
	}

	public void setDesc( String desc ) {
		this.desc = desc;
	}
	
	public void setPrice( double price ) {
		this.price = price;
	}
	
	// Getters
	public String getName() {
		return this.name;
	}
	
	public String getDesc() {
		return this.desc;
	}
	 
	public Double getPrice() {
		return this.price;
	}

}
