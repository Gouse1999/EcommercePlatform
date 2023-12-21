package com.msys;

import java.util.Map;

public class Main {
    public static void main(String[] args) {
        // Initialize components
        ProductCatalog productCatalog = new ProductCatalog();
        ShoppingCart shoppingCart = new ShoppingCart();
        UserAuthentication userAuthentication = new UserAuthentication();
        OrderProcessing orderProcessing = new OrderProcessing();

        // Simulate user actions
        String username = "user123";
        String password = "password123";

        // User authentication
        if (userAuthentication.authenticateUser(username, password)) {
            // Display product catalog
            System.out.println("Product Catalog:");
            for (Product product : productCatalog.getAllProducts()) {
                System.out.println("Product ID: " + product.getProductId() +
                        ", Product Name: " + product.getProductName() +
                        ", Price: " + product.getPrice());
            }

            // Add items to the cart
            shoppingCart.addItem(1, 2); // Product ID 1, Quantity 2
            shoppingCart.addItem(2, 1); // Product ID 2, Quantity 1

            // Display cart items
            System.out.println("\nShopping Cart:");
            for (Map.Entry<Integer, Integer> entry : shoppingCart.getCartItems().entrySet()) {
                int productId = entry.getKey();
                int quantity = entry.getValue();
                Product product = productCatalog.getProductById(productId);

                if (product != null) {
                    System.out.println("Product: " + product.getProductName() +
                            ", Quantity: " + quantity);
                }
            }

            // Calculate and display order total
            double orderTotal = orderProcessing.calculateOrderTotal(shoppingCart.getCartItems(), productCatalog);
            System.out.println("\nOrder Total: " + orderTotal);

            // Place the order
            orderProcessing.placeOrder(shoppingCart.getCartItems(), productCatalog);

            // Clear the cart after placing the order
            shoppingCart.clearCart();
        } else {
            System.out.println("Authentication failed. Please check your username and password.");
        }
    }
}
