import java.util.ArrayList;
import java.util.Scanner;

public class Warehouse {
	
	String name;
	ArrayList<Item> items = new ArrayList<Item>();
	static Scanner s = new Scanner(System.in);
	/*
	 * constructor
	 */
	Warehouse () {
		System.out.println("name the warehouse");
		name = s.nextLine();
	}
	/*
	 * displays the menu of items in the warehouse and prompts user to select
	 */
	public int items() {
		boolean loop = true;
		if (items.size() == 0) {
			System.out.println("--empty--");
		} else {
			int item =0;
			System.out.println("Select an item");
			for (int i = 0; i < items.size(); i++) {
				System.out.println(i+1 + ": " + items.get(i).name);
			}
			while(loop) {
				item = s.nextInt()-1;
				switch(item) {
				case 0: 
					return item;
				case 1:
					return item;
				default:
						System.out.println("you must enter a number");
				}
			}
			return -1;
		}
		System.out.println("");
		return -1;
	}
	/*
	 * displays all the items the warehouse
	 */
	public void displayItems() {
		if (items.size() == 0) {
			System.out.println("--empty--");
		} else {
			for (int i = 0; i < items.size(); i++) {
				System.out.println(i+1 + ": " + items.get(i).name);
			}
		}
	}
}
