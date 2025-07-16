package com.ecommerce.observer;

import com.ecommerce.model.Order;

public interface IOrderObserver {
    void update(Order order);
}