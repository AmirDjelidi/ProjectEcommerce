package com.ecommerce.model;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private final List<ItemCart> items = new ArrayList<>();

    public void addItem(Product product, int quantity) {
        this.items.add(new ItemCart(product, quantity));
    }

    public List<ItemCart> getItems() { return List.copyOf(items); }

    public double getTotalPrice() {
        return items.stream().mapToDouble(ItemCart::getSubTotal).sum();
    }
}