package com.ecommerce.model;

public class Customer extends User {
    private ShoppingCart cart;
    public Customer(String userId, String name) {
        super(userId, name);
        this.cart = new ShoppingCart();
    }
    public ShoppingCart getCart() { return cart; }
}