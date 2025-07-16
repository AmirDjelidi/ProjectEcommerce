package com.ecommerce.service;

import com.ecommerce.strategy.IPaymentStrategy;

public class PaymentService {
    public void processPayment(IPaymentStrategy paymentStrategy, double amount) {
        paymentStrategy.pay(amount);
    }
}