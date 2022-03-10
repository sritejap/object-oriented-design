package com.vending;

public class Product {
    private int id;
    private int availableCount;
    private double price;

    public Product(int id, int availableCount, double price) {
        this.id = id;
        this.availableCount = availableCount;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAvailableCount() {
        return availableCount;
    }

    public void setAvailableCount(int availableCount) {
        this.availableCount = availableCount;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
