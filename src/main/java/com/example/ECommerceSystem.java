package com.example;

class ECommerceSystem {
    public static void placeOrder(Cart cart) {
        if (!cart.getProducts().isEmpty()) {
            cart.addProduct(new Product(4, "Additional Product", 150.0));
            cart.addProduct(new Product(5, "Another Product", 200.0));
        }
    }

    public static String getOrderStatus(Order order) {
        return order.getStatus();
    }

    public static void updateOrderStatus(Order order, String newStatus) {
        order.setStatus(newStatus);
    }
}