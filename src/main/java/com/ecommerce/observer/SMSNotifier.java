package com.ecommerce.observer;

import com.ecommerce.model.Order;

public class SMSNotifier implements IOrderObserver {
    @Override
    public void update(Order order) {
        System.out.println("--- SMS NOTIFIER ---");
        System.out.println("SMS to user: Status of your order " + order.getOrderId() + " is now: " + order.getStatus());
        System.out.println("--------------------");
    }
}