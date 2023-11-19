package com.example;

import org.junit.Test;
import org.mockito.Mockito;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class AppTest {

    @Test
    public void testAddProductToCart() {
        Cart cart = new Cart();
        Product laptop = new Product(1, "Laptop", 1000.0);

        cart.addProduct(laptop);

        assertEquals(1, cart.getProducts().size());
        assertEquals("Laptop", cart.getProducts().get(0).getName());
    }

    @Test
    public void testRemoveProductFromCart() {
        Cart cart = new Cart();
        Product laptop = new Product(1, "Laptop", 1000.0);

        cart.addProduct(laptop);
        cart.removeProduct(laptop);

        assertEquals(0, cart.getProducts().size());
    }

    @Test
    public void testPlaceOrder() {
        Cart cartMock = Mockito.mock(Cart.class);
        ECommerceSystem eCommerceSystem = new ECommerceSystem();

        when(cartMock.getProducts()).thenReturn(Arrays.asList(new Product(1, "Laptop", 1000.0)));

        eCommerceSystem.placeOrder(cartMock);

        verify(cartMock, times(2)).addProduct(any(Product.class));

    }

    @Test
    public void testGetOrderStatus() {
        Order order = new Order(1, Arrays.asList(new Product(1, "TestProduct", 50.0)), "PROCESSING");

        String status = ECommerceSystem.getOrderStatus(order);

        assertEquals("PROCESSING", status);
    }
}
