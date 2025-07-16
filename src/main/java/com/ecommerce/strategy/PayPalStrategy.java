package com.ecommerce.strategy;

public class PayPalStrategy implements IPaymentStrategy {
    private String email;
    public PayPalStrategy(String email) { this.email = email; }
    @Override
    public void pay(double amount) {
        System.out.println("A payment of " + amount + "€ was successfully made via PayPal account: " + email);
    }
}