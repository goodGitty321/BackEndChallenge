import java.util.ArrayList;
import java.util.Scanner;

class Main {
	
	static Scanner s = new Scanner(System.in);
	
	public static int Menu() {
		int menu;

	    System.out.println("1: Create item");
	    System.out.println("2: Read item");
	    System.out.println("3: Update item");
	    System.out.println("4: Delete item");
	    System.out.println("5: create warehouse");
	    System.out.println("6: move to warehouse");
	    System.out.println("7: list items");
	    System.out.println("8: Exit");
	    menu = s.nextInt();
	    
	    return menu;
	}
	
	public static int wMenu(ArrayList<Warehouse> wList) {
		int move;

		for (int i = 0; i < wList.size(); i++) {
			System.out.println(i+1 + ": " + wList.get(i).name);
		}
		move = s.nextInt();
		return move;
	}
	
	public static void moveMenu(Item item, ArrayList<Warehouse> wList) {
		int whNum;
		System.out.println("to which warehouse");
		whNum = wMenu(wList)-1;
		wList.get(whNum).items.add(item);
		System.out.println(wList.get(whNum).name + "warehouse added: " + item.name);
	}
	
	public static void listWH(ArrayList<Warehouse> wList) {
		for (int i = 0; i < wList.size(); i++) {
			System.out.println("warehouse: " + wList.get(i).name);
			wList.get(i).displayItems();
		}
		System.out.println("");
	}
	
  public static void main(String[] args) {
	  boolean loop = true;
	  int choice;
	  Item item;
	  ArrayList<Warehouse> wList = new ArrayList<Warehouse>();
	  
	  System.out.println("Hello world, this is an inventory tracking app!\n");
	  while(loop) {
		  choice = Menu();
		  if (choice == 1) { //create
			  if(wList.size() == 0) {
				  System.out.println("you must create an warehouse\n");
			  } else {
				  item = CRUD.create();
				  moveMenu(item, wList);
			  }			  
		  } else if (choice == 2) { //2read
			  if(wList.size() == 0) { 
				  System.out.println("you must create an item");
			  } else {
			  CRUD.read(wList);
			  }
		  } else if (choice == 3) { //3update
			  if(wList.size() == 0) {
				  System.out.println("you must create an item");
			  } else {
			  CRUD.update(wList);
			  }
		  } else if (choice == 4) { //4delete
			  if(wList.size() == 0) {
				  System.out.println("you must create an item");
			  } else {
				  CRUD.delete(wList);
			  }
		  } else if (choice == 5) { //5++warehouse
			  wList.add(new Warehouse());
		  } else if (choice == 6) { //move item
			  if(wList.size() == 0) {
				  System.out.println("you must create an item");
			  } else {
				  CRUD.moveItem(wList);
			  }		 
		  } else if (choice == 7) { //list
			  if(wList.size() == 0) {
				  System.out.println("you must create an item");
			  }
			  listWH(wList);
			 
		  }else if (choice == 8) {
			  loop = false;
		  }		  
	  }
  }
}