// Dans le fichier src/main/java/com/ecommerce/Main.java

package com.ecommerce;

import com.ecommerce.controller.OrderController;
import com.ecommerce.factory.UserFactory;
import com.ecommerce.model.Customer;
import com.ecommerce.model.Order;
import com.ecommerce.model.Product;
import com.ecommerce.service.InventoryService;
import com.ecommerce.service.PaymentService;
import com.ecommerce.strategy.*;

public class Main {
    public static void main(String[] args) {

        // ===================================================================
        // 1. INITIALISATION DU SYSTÈME
        // ===================================================================
        InventoryService inventoryService = new InventoryService();
        PaymentService paymentService = new PaymentService();
        OrderController orderController = new OrderController(inventoryService, paymentService);

        // ===================================================================
        // 2. SCÉNARIO 1 : Alice, avec Réduction en Pourcentage
        // ===================================================================
        Customer alice = (Customer) UserFactory.createUser("CUSTOMER", "U123", "Alice");

        // Alice remplit son panier (avec la nouvelle méthode `addItem`)
        alice.getCart().addItem(new Product("SKU001", "Laptop", 1200.00), 1);
        alice.getCart().addItem(new Product("SKU002", "Mouse Wireless", 25.50), 2);

        System.out.println(alice.getName() + "'s cart contains " + alice.getCart().getItems().size() + " types of items, for a total of " + alice.getCart().getTotalPrice() + "€");

        // Choix des stratégies pour Alice
        IPaymentStrategy alicesPaymentMethod = new CreditCardStrategy("**** **** **** 1234");
        IDiscount alicesDiscount = new PercentageDiscount(10); // Réduction de 10%

        // Alice passe commande
        Order alicesOrder = orderController.placeOrder(alice, alicesPaymentMethod, alicesDiscount);

        if (alicesOrder != null) {
            alicesOrder.setStatus("SHIPPED");
            alicesOrder.setStatus("DELIVERED");
        }

        // ===================================================================
        // 3. SCÉNARIO 2 : Bob, avec Réduction Fixe et autre paiement
        // ===================================================================
        Customer bob = (Customer) UserFactory.createUser("CUSTOMER", "U456", "Bob");

        // Bob remplit son panier
        bob.getCart().addItem(new Product("SKU003", "Mechanical Keyboard", 150.00), 1);

        System.out.println(bob.getName() + "'s cart contains " + bob.getCart().getItems().size() + " types of items, for a total of " + bob.getCart().getTotalPrice() + "€");

        // Choix des stratégies pour Bob
        IPaymentStrategy bobsPaymentMethod = new WalletPayment("bob-wallet-id");
        IDiscount bobsDiscount = new FixedDiscount(20); // Réduction de 20€

        // Bob passe commande
        Order bobsOrder = orderController.placeOrder(bob, bobsPaymentMethod, bobsDiscount);

        if (bobsOrder != null) {
            bobsOrder.setStatus("DELIVERED");
        }
    }
}