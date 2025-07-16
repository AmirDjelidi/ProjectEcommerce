package com.ecommerce.model;

public class User {
    protected String userId;
    protected String name;
    public User(String userId, String name) {
        this.userId = userId;
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}