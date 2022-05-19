import java.util.ArrayList;
import java.util.Scanner;

class Main {
	
	static Scanner s = new Scanner(System.in);
	/*
	 * the recurring menu. A warehouse must be created first
	 */
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
	/*
	 * displays a menu for all of the warehouses created.
	 */
	public static int wMenu(ArrayList<Warehouse> wList) {
		int move = 0;
		int num;
		

		for (int i = 0; i < wList.size(); i++) {
			System.out.println(i+1 + ": " + wList.get(i).name);
		}
		num = s.nextInt();
		while(move == 0) {
			switch(num) {
				case 1:
					move = 1;
					break;
				case 2:
					move = 2;
					break;
				default: 
					System.out.println("You must enter a number");
					break;
			}
		}
		
		
		return move;
	}
	/*
	 * called after CRUD.moveItem(). Takes the selected Item and displays the 
	 * list of warehouses to move it to
	 */
	public static void moveMenu(Item item, ArrayList<Warehouse> wList) {
		int whNum;
		System.out.println("to which warehouse");
		whNum = wMenu(wList)-1;
		wList.get(whNum).items.add(item);
		System.out.println(wList.get(whNum).name + "warehouse added: " + item.name);
	}
	/*
	 * displays the list of5 items in each warehouse
	 */
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
		  choice = Menu(); //menu
		  switch(choice) {
			  case 1: //create
				  if(wList.size() == 0) {
					  System.out.println("you must create an warehouse\n");
				  } else {
					  item = CRUD.create();
					  moveMenu(item, wList);
				  }	
				  break;
			  case 2: //2read
				  if(wList.size() == 0) { 
					  System.out.println("you must create an item");
				  } else {
				  CRUD.read(wList);
				  }
				  break;
			  case 3: //3update
				  if(wList.size() == 0) {
					  System.out.println("you must create an item");
				  } else {
				  CRUD.update(wList);
				  }
				  break;
			  case 4: //4delete
				  if(wList.size() == 0) {
					  System.out.println("you must create an item");
				  } else {
					  CRUD.delete(wList);
				  }
				  break;
			  case 5: //5++warehouse
				  wList.add(new Warehouse());
				  break;
			  case 6: //move item
				  if(wList.size() == 0) {
					  System.out.println("you must create an item");
				  } else {
					  CRUD.moveItem(wList);
				  }
				  break;
			  case 7: //list
				  if(wList.size() == 0) {
					  System.out.println("you must create an item");
				  }
				  listWH(wList);
				  break;
			  case 8:
				  loop = false;
				  break;
				  default:
					  System.out.println("You must Enter 1-8\n");
		  	}		  
	  		}
	  }
  }