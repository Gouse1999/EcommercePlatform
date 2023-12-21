package com.msys;

import java.util.ArrayList;
import java.util.List;

public class ProductCatalog {
    private List<Product> products;

    public ProductCatalog() {
        this.products = new ArrayList<>();
        initializeProducts(); // Add some sample products
    }

    // Add sample products
    private void initializeProducts() {
        products.add(new Product(1, "Laptop", 899.99));
        products.add(new Product(2, "Smartphone", 499.99));
        // Add more products as needed
    }

    // Get all products in the catalog
    public List<Product> getAllProducts() {
        return new ArrayList<>(products);
    }

    // Get product by ID
    public Product getProductById(int productId) {
        for (Product product : products) {
            if (product.getProductId() == productId) {
                return product;
            }
        }
        return null;
    }
}
