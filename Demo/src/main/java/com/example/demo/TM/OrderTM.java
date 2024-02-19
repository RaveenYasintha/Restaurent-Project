package com.example.demo.TM;

public class OrderTM {

    private int ordId;

    public OrderTM(int ordId, String foodName, double uniPrice, int quanti, double tot) {
        this.ordId = ordId;
        this.foodName = foodName;
        this.uniPrice = uniPrice;
        this.quanti = quanti;
        this.tot = tot;
    }

    private String foodName;
    private double uniPrice;
    private int quanti;
    private double tot;

    public int getOrdId() {
        return ordId;
    }

    public void setOrdId(int ordId) {
        this.ordId = ordId;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public double getUniPrice() {
        return uniPrice;
    }

    public void setUniPrice(double uniPrice) {
        this.uniPrice = uniPrice;
    }

    public int getQuanti() {
        return quanti;
    }

    public void setQuanti(int quanti) {
        this.quanti = quanti;
    }

    public double getTot() {
        return tot;
    }

    public void setTot(double tot) {
        this.tot = tot;
    }
}
