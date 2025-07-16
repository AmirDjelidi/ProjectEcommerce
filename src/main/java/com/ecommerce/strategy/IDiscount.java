package com.ecommerce.strategy;

// Note: Le diagramme l'appelle "Discount", on peut le nommer IDiscount par convention
public interface IDiscount {
    double apply(double amount);
}