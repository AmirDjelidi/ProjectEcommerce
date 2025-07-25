package com.ecommerce.model;

public class ItemCart {
    private final Product product;
    private int quantity;

    public ItemCart(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct() { return product; }
    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    public double getSubTotal() {
        return product.getPrice() * quantity;
    }
}