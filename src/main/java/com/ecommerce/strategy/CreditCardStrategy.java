package com.ecommerce.strategy;

public class CreditCardStrategy implements IPaymentStrategy {
    private String cardNumber;
    public CreditCardStrategy(String cardNumber) { this.cardNumber = cardNumber; }
    @Override
    public void pay(double amount) {
        System.out.println("A payment of " + amount + "€ was successfully made using Credit Card: " + cardNumber);
    }
}