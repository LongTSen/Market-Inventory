package com.company;
import java.util.Scanner;

public class InventoryDriver {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ListOfItems inventory = new ListOfItems();
		Validation validation = new Validation();
		String password;
		int select, itemNum;
		String search, product, brand;
		int quantity;
		double price;
		String restart;
		inventory.listItem();
		do {
			System.out.println("Enter password to entry(admin): ");
			password = sc.next();
		} while (!(password.equalsIgnoreCase("admin")));
		do {
			System.out.println("Welcome to Inventory. Select:\n" +
					"1.Display Inventory\n2.Search product\n3.Add new product" +
					"\n4.Modify product\n5.Remove product");
			select = validation.intValidation();
			sc.nextLine();
			switch (select) {
				case 1:
					inventory.displayInventory();
					break;
				case 2:
					System.out.println("Entry product's description or brand");
					search = sc.nextLine();
					if(inventory.search(search).size()==0)
					{
						System.out.println("Product does not exist.");
						System.out.println("Do you want to add?Press 1 to add, any key to skip");
						if (validation.intValidation()==1){}
						else {break;}
					}
					else{inventory.displaySearch();
					break;}
				case 3:
					System.out.println("What's product");
					product = sc.nextLine();
					System.out.println("What's brand");
					brand = sc.nextLine();
					System.out.println("Entry the price:");
					price = validation.doubleValidation();
					System.out.println("Entry the quantity of product:");
					quantity = validation.intValidation();
					inventory.addItem(product, brand, price, quantity);
					System.out.println("Product is added.");
					break;
				case 4:
					System.out.println("Enter a product number to modify: ");
					itemNum = validation.intValidation();
					System.out.println("What's product");
					product = sc.nextLine();
					System.out.println("What's brand");
					brand = sc.nextLine();
					System.out.println("Entry the price:");
					price = validation.doubleValidation();
					System.out.println("Entry the quantity of product:");
					quantity = validation.intValidation();
					inventory.modifyItem(itemNum, product, brand, price, quantity);
					System.out.println("Product is modified");
					break;
				case 5:
					System.out.println("Entry product number to remove");
					itemNum = validation.intValidation();
					inventory.removeItem(itemNum);
					break;
				default:
					System.out.println("Entry out of index");
					break;
			}
			System.out.println("Enter 1 to restart, any key to logout");
			restart = sc.next();
		}while (restart.equalsIgnoreCase("1"));
	}
}

