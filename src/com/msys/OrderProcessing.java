package com.msys;

import java.util.Map;

public class OrderProcessing {
    public double calculateOrderTotal(Map<Integer, Integer> cartItems, ProductCatalog productCatalog) {
        double total = 0;

        for (Map.Entry<Integer, Integer> entry : cartItems.entrySet()) {
            int productId = entry.getKey();
            int quantity = entry.getValue();
            Product product = productCatalog.getProductById(productId);

            if (product != null) {
                total += product.getPrice() * quantity;
            }
        }

        return total;
    }

    public void placeOrder(Map<Integer, Integer> cartItems, ProductCatalog productCatalog) {
        System.out.println("Order Details:");

        // For simplicity, print the order details
        for (Map.Entry<Integer, Integer> entry : cartItems.entrySet()) {
            int productId = entry.getKey();
            int quantity = entry.getValue();
            Product product = productCatalog.getProductById(productId);

            if (product != null) {
                System.out.println("Product: " + product.getProductName() +
                        ", Quantity: " + quantity +
                        ", Total: " + product.getPrice() * quantity);
            }
        }

        System.out.println("Order placed successfully!");
    }
}
