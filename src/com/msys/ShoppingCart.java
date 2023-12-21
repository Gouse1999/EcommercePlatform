package com.msys;

import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {
    private Map<Integer, Integer> cartItems; // Map product ID to quantity

    public ShoppingCart() {
        this.cartItems = new HashMap<>();
    }

    // Add product to the cart
    public void addItem(int productId, int quantity) {
        cartItems.put(productId, cartItems.getOrDefault(productId, 0) + quantity);
    }

    // Remove product from the cart
    public void removeItem(int productId) {
        cartItems.remove(productId);
    }

    // Get items in the cart
    public Map<Integer, Integer> getCartItems() {
        return new HashMap<>(cartItems);
    }

    // Clear the cart
    public void clearCart() {
        cartItems.clear();
    }
}
