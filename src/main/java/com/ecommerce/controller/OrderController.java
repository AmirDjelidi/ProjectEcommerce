package com.ecommerce.controller;

import com.ecommerce.model.Customer;
import com.ecommerce.model.Order;
import com.ecommerce.model.ShoppingCart;
import com.ecommerce.observer.EmailNotifier;
import com.ecommerce.service.InventoryService;
import com.ecommerce.service.PaymentService;
import com.ecommerce.strategy.IPaymentStrategy;

public class OrderController {
    private final InventoryService inventoryService;
    private final PaymentService paymentService;

    public OrderController(InventoryService inventoryService, PaymentService paymentService) {
        this.inventoryService = inventoryService;
        this.paymentService = paymentService;
    }

    public Order placeOrder(Customer customer, IPaymentStrategy paymentStrategy) {
        System.out.println("\n== Starting order process for " + customer.getName() + " ==");
        ShoppingCart cart = customer.getCart();

        if (inventoryService.checkStock(cart.getItems())) {
            double total = cart.getTotalPrice();

            Order order = new Order("ORD-" + System.currentTimeMillis(), total);

            order.attach(new EmailNotifier());
            order.attach(inventoryService);

            paymentService.processPayment(paymentStrategy, total);
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