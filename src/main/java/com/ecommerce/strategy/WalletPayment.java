package com.ecommerce.strategy;

public class WalletPayment implements IPaymentStrategy {
    private final String walletId;

    public WalletPayment(String walletId) {
        this.walletId = walletId;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Payment of " + amount + "€ made via Wallet " + walletId);
    }
}