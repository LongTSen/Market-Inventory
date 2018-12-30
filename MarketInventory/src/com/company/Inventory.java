package com.company;

public class Inventory {
    private int itemNumber;
    private String item;
    private String brand;
    private double price;
    private int quantity;
    private double value;

    public Inventory(String item,String brand,double price,int quantity)
    {
        this.item = item;
        this.brand = brand;
        this.price = price;
        this.quantity = quantity;
        value = price*quantity;
    }

    public void setItemNumber(int itemNumber) {
        this.itemNumber = itemNumber;
    }

    public String getBrand() {
        return brand;
    }

    public String getItem(){
        return item;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getTotal(){
        return value;
    }

    public void display()
    {
        System.out.printf("%3s%15s%15s%10.2f%10s%10.2f\n",itemNumber,brand,item,price,quantity,value);
    }
}
