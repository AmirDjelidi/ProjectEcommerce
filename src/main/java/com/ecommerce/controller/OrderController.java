// In the file src/main/java/com/ecommerce/controller/OrderController.java

package com.ecommerce.controller;

import com.ecommerce.model.*;
import com.ecommerce.observer.EmailNotifier;
import com.ecommerce.observer.InAppNotifier;
import com.ecommerce.observer.SMSNotifier;
import com.ecommerce.service.InventoryService;
import com.ecommerce.service.PaymentService;
import com.ecommerce.strategy.IDiscount;
import com.ecommerce.strategy.IPaymentStrategy;

public class OrderController {
    private final InventoryService inventoryService;
    private final PaymentService paymentService;

    public OrderController(InventoryService inventoryService, PaymentService paymentService) {
        this.inventoryService = inventoryService;
        this.paymentService = paymentService;
    }

    // Method signature now includes IDiscount
    public Order placeOrder(Customer customer, IPaymentStrategy paymentStrategy, IDiscount discountStrategy) {
        System.out.println("\n== Order process begins for " + customer.getName() + " ==");
        ShoppingCart cart = customer.getCart();

        if (inventoryService.checkStock(cart.getItems())) {
            double totalAmount = cart.getTotalPrice();
            System.out.println("Total before discount: " + totalAmount + "€");

            // Applying the discount strategy
            double finalAmount = discountStrategy.apply(totalAmount);
            System.out.println("Total after discount: " + finalAmount + "€");

            Order order = new Order("ORD-" + System.currentTimeMillis(), finalAmount);

            // Attach all notifiers for demonstration purposes
            order.attach(new EmailNotifier());
            order.attach(new SMSNotifier());
            order.attach(new InAppNotifier());
            order.attach(inventoryService); // Inventory service also acts as an observer

            // Process payment on the final amount
            paymentService.processPayment(paymentStrategy, finalAmount);
            order.setStatus("PAID");

            order.setStatus("PROCESSING");

            System.out.println("== End of order process ==\n");
            return order;
        } else {
            System.out.println("Order failed: insufficient stock.");
            return null;
        }
    }
}
