package com.ecommerce.observer;

import com.ecommerce.model.Order;

public class InAppNotifier implements IOrderObserver {
    @Override
    public void update(Order order) {
        System.out.println("--- IN-APP NOTIFIER ---");
        System.out.println("Push Notification: Order " + order.getOrderId() + " status updated to " + order.getStatus());
        System.out.println("-----------------------");
    }
}