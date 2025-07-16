package com.ecommerce.model;

import com.ecommerce.observer.IOrderObserver;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private String orderId;
    private double totalAmount;
    private String status;
    private List<IOrderObserver> observers = new ArrayList<>();

    public Order(String orderId, double totalAmount) {
        this.orderId = orderId;
        this.totalAmount = totalAmount;
        this.status = "WAITING";
    }

    public void attach(IOrderObserver observer) { observers.add(observer); }
    public void detach(IOrderObserver observer) { observers.remove(observer); }

    public void notifyObservers() {
        for (IOrderObserver observer : observers) {
            observer.update(this);
        }
    }

    public void setStatus(String status) {
        this.status = status;
        System.out.println("ORDER STATUS " + orderId + ": " + status);
        notifyObservers();
    }

    public String getStatus() { return status; }
    public String getOrderId() { return orderId; }
}