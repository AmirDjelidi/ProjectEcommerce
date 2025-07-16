package com.ecommerce;

import com.ecommerce.controller.OrderController;
import com.ecommerce.factory.UserFactory;
import com.ecommerce.model.Customer;
import com.ecommerce.model.Order;
import com.ecommerce.model.Product;
import com.ecommerce.service.InventoryService;
import com.ecommerce.service.PaymentService;
import com.ecommerce.strategy.CreditCardStrategy;
import com.ecommerce.strategy.IPaymentStrategy;
import com.ecommerce.strategy.PayPalStrategy;

public class Main {
    public static void main(String[] args) {
        InventoryService inventoryService = new InventoryService();
        PaymentService paymentService = new PaymentService();
        OrderController orderController = new OrderController(inventoryService, paymentService);

        Customer alice = (Customer) UserFactory.createUser("CUSTOMER", "U123", "Alice");

        Product laptop = new Product("SKU001", "Laptop", 1200.00);
        Product mouse = new Product("SKU002", "Mouse Wireless", 25.50);
        alice.getCart().addItem(laptop);
        alice.getCart().addItem(mouse);

        System.out.println(alice.getName() + "'s shopping cart contains " + alice.getCart().getItems().size() + " item(s) totaling " + alice.getCart().getTotalPrice() + "€");


        IPaymentStrategy alicePayment = new CreditCardStrategy("**** **** **** 9876");
        //IPaymentStrategy alicePayment = new PayPalStrategy("alice.customer@gmail.com");
        Order aliceOrder = orderController.placeOrder(alice, alicePayment);

        if (aliceOrder != null) {
            aliceOrder.setStatus("SHIPPED");
            aliceOrder.setStatus("DELIVERED");

        }
    }
}