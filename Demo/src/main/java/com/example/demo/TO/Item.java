package com.example.demo.TO;

public class Item {
        private int f_id;
        private String f_name;
        private double price;

        private int f_quantity;


    public Item() {
    }

    public Item(int f_id, String f_name, double price, int f_quantity) {
        this.f_id = f_id;
        this.f_name = f_name;
        this.price = price;
        this.f_quantity = f_quantity;
    }





    public int getF_id() {return f_id;}

    public void setF_id(int f_id) {this.f_id = f_id;}

    public String getF_name() {return f_name;}

    public void setF_name(String f_name) {this.f_name = f_name;}

    public double getPrice() {return price;}

    public void setPrice(double price) {this.price = price;}

    public int getF_quantity() {
        return f_quantity;
    }

    public void setF_quantity(int f_quantity) {
        this.f_quantity = f_quantity;
    }
}
