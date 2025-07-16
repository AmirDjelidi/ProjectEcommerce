package com.ecommerce.model;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private List<Product> items = new ArrayList<>();

    public void addItem(Product p) { items.add(p); }
    public void removeItem(Product p) { items.remove(p); }
    public List<Product> getItems() { return List.copyOf(items); }

    public double getTotalPrice() {
        return items.stream().mapToDouble(Product::getPrice).sum();
    }
}