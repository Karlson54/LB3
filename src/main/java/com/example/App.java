package com.example;

public class App {
    public static void main(String[] args) {
        Product laptop = new Product(1, "Laptop", 1000.0);
        Product smartphone = new Product(2, "Smartphone", 500.0);
        Product headphones = new Product(3, "Headphones", 100.0);

        Cart cart = new Cart();
        cart.addProduct(laptop);
        cart.addProduct(smartphone);

        Order order = new Order(1, cart.getProducts(), "PROCESSING");

        String status = ECommerceSystem.getOrderStatus(order);
        System.out.println("Order Status: " + status);

        cart.addProduct(headphones);

        cart.removeProduct(smartphone);

        System.out.println("Products in Cart after removing a product:");
        for (Product p : cart.getProducts()) {
            System.out.println(p.getName());
        }

        Order newOrder = new Order(2, cart.getProducts(), "PROCESSING");

        String newOrderStatus = ECommerceSystem.getOrderStatus(newOrder);
        System.out.println("New Order Status: " + newOrderStatus);

        ECommerceSystem.updateOrderStatus(newOrder, "SHIPPED");

        String updatedStatus = ECommerceSystem.getOrderStatus(newOrder);
        System.out.println("Updated Order Status: " + updatedStatus);
    }
}
