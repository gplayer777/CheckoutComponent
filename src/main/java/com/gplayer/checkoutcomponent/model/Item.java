package com.gplayer.checkoutcomponent.model;



public class Item {
    private String name;
    private double price; // price in cents
    private int multiPriceThreshold; // e.g., buy 3 for Y
    private double multiPriceValue; // cost for the threshold


    public Item(String name, double price, int multiPriceThreshold, double multiPriceValue) {
        this.name = name;
        this.price = price;
        this.multiPriceThreshold = multiPriceThreshold;
        this.multiPriceValue = multiPriceValue;
    }

    public String getName() {
        return name;
    }
    public double getPrice() {
        return price;
    }
    public int getMultiPriceThreshold() {
        return multiPriceThreshold;
    }
    public double getMultiPriceValue() {
        return multiPriceValue;
    }
}
