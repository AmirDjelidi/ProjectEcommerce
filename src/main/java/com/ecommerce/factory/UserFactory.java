package com.ecommerce.factory;

import com.ecommerce.model.Admin;
import com.ecommerce.model.Customer;
import com.ecommerce.model.User;

public class UserFactory {
    public static User createUser(String type, String id, String name) {
        if ("CUSTOMER".equalsIgnoreCase(type)) {
            return new Customer(id, name);
        } else if ("ADMIN".equalsIgnoreCase(type)) {
            return new Admin(id, name);
        }
        throw new IllegalArgumentException("Unknown user type.");

    }
}