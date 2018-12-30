package com.company;
import java.util.ArrayList;

public class ListOfItems {
    ArrayList<Inventory> inventory = new ArrayList<>();
    private ArrayList<Integer> result = new ArrayList<>();

    public void listItem()
    {
        inventory.add(new Inventory("Eggs","Costco",0.99,20));
        inventory.add(new Inventory("Eggs","Whole Food",1.50,35));
        inventory.add(new Inventory("Soft Drink","Coke",3.99,14));
        inventory.add(new Inventory("Soft Drink","PepSi",3.99,28));
        inventory.add(new Inventory("Bread","Allison",1.99,39));
        inventory.add(new Inventory("Bread","Boudin Bakery",2.99,12));
        inventory.add(new Inventory("Bread","King Sooper",0.99,10));
        inventory.add(new Inventory("Milk","Ensure",5.99,17));
        inventory.add(new Inventory("Milk","Whole Food",4.99,5));
        inventory.add(new Inventory("Chip","Lay",1.99,29));
        inventory.add(new Inventory("Chip", "Walmart",1.49,17));
        inventory.add(new Inventory("Ice Cream","Haagen",2.99,20));
        inventory.add(new Inventory("Ice Cream","Breyer",2.49,18));
    }

    public void displayInventory()
    {
        double value = 0;
        System.out.printf("%3s%15s%15s%10s%10s%10s\n","Number","Brand","Product","Price","Quantity","Value");
        for(int i=0;i<inventory.size();i++)
        {
            inventory.get(i).setItemNumber(i+1);
            inventory.get(i).display();
            value += inventory.get(i).getTotal();
        }
        System.out.println("Total Value: $"+value);
    }

    public ArrayList<Integer> search(String context)
    {
        for (int i=0;i<inventory.size();i++)
        {
            if(inventory.get(i).getBrand().equalsIgnoreCase(context)||inventory.get(i).getItem().equalsIgnoreCase(context))
            {
                result.add(i);
            }
        }
        return result;
    }

    public void displaySearch()
    {
        double total=0;
        int totalItem=0;
            for(int i=0;i<result.size();i++)
            {
                total +=inventory.get(result.get(i)).getTotal();
                totalItem +=inventory.get(result.get(i)).getQuantity();
            }
            System.out.println(inventory.get(result.get(0)).getItem()+" - in stock: " + totalItem);
            for (int i = 0; i < result.size(); i++) {
                System.out.println(inventory.get(result.get(i)).getBrand() + " " + inventory.get(result.get(i)).getItem()
                        + " - in stock: " + inventory.get((result.get(i))).getQuantity() + ", price: "
                        + inventory.get(result.get(i)).getPrice());
            }
            System.out.println("Total Value: $"+total);
    }

    public void addItem(String product,String brand,double price,int quantity)
    {
        inventory.add(new Inventory(product,brand,price,quantity));
    }

    public void removeItem(int number)
    {
        try {
        inventory.remove(number - 1);
        }catch (IndexOutOfBoundsException e){
        System.out.println(e.getMessage());
        }
        System.out.println("Product is removed");
    }

    public void modifyItem(int number,String product,String brand,double price,int quantity)
    {
        if (number>inventory.size()){
            System.out.println("That item's number is out of index, can not modify");
        }
        else {
            inventory.set(number - 1,new Inventory(product,brand,price,quantity));
        }    }
}
