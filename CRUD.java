import java.util.ArrayList;
import java.util.Scanner;

public class CRUD extends Main{
	
	static Scanner s = new Scanner(System.in);

	public static Item create() {
		
		Scanner s = new Scanner(System.in);
		Item item = new Item();

		System.out.println("What is the name of your item");
		item.name = s.nextLine();
		System.out.println("What is the description of your item");
		item.description = s.nextLine();

		return item;
	}
	public static void read(ArrayList<Warehouse> wList) {
		int wh;
		int item;
		System.out.println("select a warehouse.");
		whList(wList);
		wh = s.nextInt()-1;
		if (wList.get(wh).items.size() == 0) {
			System.out.println("warehouse is empty.");
			return;
		}
		item = wList.get(wh).items();
		
		System.out.println("Name: " + wList.get(wh).items.get(item).name);
		System.out.println("Description: " + wList.get(wh).items.get(item).description);
		System.out.println("");
	}
	
	public static void update(ArrayList<Warehouse> wList) {
		int wh;
		int item;
		int up;
		Scanner s2 = new Scanner(System.in);
		System.out.println("select a warehouse.");
		whList(wList);
		wh = s.nextInt()-1;
		item = wList.get(wh).items();
		System.out.println("select what to update");
		System.out.println("1: name");
		System.out.println("2: description");
		up = s.nextInt();
		if (up == 1) {
			String name;
			System.out.println("Name: ");
			name = s2.nextLine();
		    wList.get(wh).items.get(item).name = name;
		} else if (up == 2){
			String desc;
			System.out.println("Description: ");
			desc = s2.nextLine();
			wList.get(wh).items.get(item).description = desc;
		} else {
			System.out.println("invaled entry start over");
		}		
	}
	
	public static Warehouse wh(ArrayList<Warehouse> wh) {
		Warehouse wh0 = new Warehouse();
		System.out.println("Name your warehouse");
		wh0.name = s.toString();
		
		return wh0;
	}
		
	public static void delete(ArrayList<Warehouse> wList) {
		if (wList.size() == 0) {
			System.out.println("list is empty");
			return;
		}
		int wh, item;
		
		System.out.println("select a warehouse.");
		whList(wList);
		wh = s.nextInt()-1;
		if (wList.get(wh).items.size() == 0) {
			System.out.println("There are no items there");
			return;
		}
		item = wList.get(wh).items();
		System.out.println("item: " + wList.get(wh).items.remove(item).name + " removed");		
	}
	
	public static void moveItem(ArrayList<Warehouse> wList) {
		if (wList.size() < 2) {
			System.out.println("There is only 1 warehouse");
			return;
		}
		int wh0, wh1, item0;

		Scanner s2 = new Scanner(System.in);
		System.out.println("select a warehouse.");
		whList(wList);
		wh0 = s.nextInt()-1;
		item0 = wList.get(wh0).items();
		if (wList.get(wh0).items.size() == 0) {
			return;
		}
		System.out.println("move to where?");
		whList(wList);
		wh1 = s2.nextInt()-1;
		wList.get(wh1).items.add(wList.get(wh0).items.remove(item0));		
	}
	
	public static void display(ArrayList<Item> myItems) {
		for (int i = 0; i < myItems.size(); i++) {
			System.out.println(i+1 + ": " + myItems.get(i).name);
		}
	}
	
	public static void whList(ArrayList<Warehouse> wList) {
		for (int i = 0; i < wList.size(); i++) {
			System.out.println(i+1 + ": " + wList.get(i).name);
		}
	}
}
