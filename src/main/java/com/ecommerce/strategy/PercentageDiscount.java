package com.ecommerce.strategy;

public class PercentageDiscount implements IDiscount {
    private final double percentage;

    public PercentageDiscount(double percentage) {
        this.percentage = percentage;
    }

    @Override
    public double apply(double amount) {
        double discount = amount * (percentage / 100.0);
        System.out.println("A discount of " + percentage + "% has been applied: -" + discount + "€");
        return amount - discount;
    }
}