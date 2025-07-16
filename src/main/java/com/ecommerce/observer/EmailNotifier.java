package com.ecommerce.observer;

import com.ecommerce.model.Order;

public class EmailNotifier implements IOrderObserver {
    @Override
    public void update(Order order) {
        System.out.println("--- EMAIL NOTIFIER ---");
        System.out.println("Notification: The status of order " + order.getOrderId() + " is now: " + order.getStatus());
        System.out.println("----------------------");

    }
}