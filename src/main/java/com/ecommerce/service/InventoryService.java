package com.ecommerce.service;

import com.ecommerce.model.Order;
import com.ecommerce.model.Product;
import com.ecommerce.observer.IOrderObserver;
import java.util.List;

public class InventoryService implements IOrderObserver {
    public boolean checkStock(List<Product> items) {
        System.out.println("Checking stock... Stock OK.");
        return true;
    }

    @Override
    public void update(Order order) {
        if ("PAYEE".equals(order.getStatus())) {
            System.out.println("--- INVENTORY SERVICE ---");
            System.out.println("Notification: Payment confirmed. Updating stock for order " + order.getOrderId() + "...");
            System.out.println("-------------------------");
        }
    }

}