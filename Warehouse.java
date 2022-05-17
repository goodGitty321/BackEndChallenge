import java.util.ArrayList;
import java.util.Scanner;

public class Warehouse {
	
	String name;
	ArrayList<Item> items = new ArrayList<Item>();
	static Scanner s = new Scanner(System.in);
	
	Warehouse () {
		System.out.println("name the warehouse");
		name = s.nextLine();
	}
	
	public int items() {
		if (items.size() == 0) {
			System.out.println("--empty--");
		} else {
			int item;
			System.out.println("Select an item");
			for (int i = 0; i < items.size(); i++) {
				System.out.println(i+1 + ": " + items.get(i).name);
			}
			item = s.nextInt()-1;
			return item;
		}
		System.out.println("");
		return -1;
	}
	
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
