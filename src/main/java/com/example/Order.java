package com.example;

import java.util.List;

class Order {
    private int orderId;
    private List<Product> products;
    private String status;

    public Order(int orderId, List<Product> products, String status) {
        this.orderId = orderId;
        this.products = products;
        this.status = status;
    }

    public int getOrderId() {
        return orderId;
    }

    public List<Product> getProducts() {
        return products;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String newStatus) {
        this.status = newStatus;
    }
}