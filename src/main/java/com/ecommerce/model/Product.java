package com.ecommerce.model;

public class Product {
    private String sku;
    private String name;
    private double price;

    public Product(String sku, String name, double price) {
        this.sku = sku;
        this.name = name;
        this.price = price;
    }

    public double getPrice() { return price; }
    public String getName() { return name; }
    @Override
    public String toString() { return name + " (Price: " + price + "€)"; }
}