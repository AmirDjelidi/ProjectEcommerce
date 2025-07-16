package com.ecommerce.strategy;

public class FixedDiscount implements IDiscount {
    private final double discountAmount;

    public FixedDiscount(double discountAmount) {
        this.discountAmount = discountAmount;
    }

    @Override
    public double apply(double amount) {
        System.out.println("A fixed discount of " + discountAmount + "€ has been applied.");
        return Math.max(0, amount - discountAmount);
    }
}