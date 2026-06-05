package com.online.store.model.products.digital;

import com.online.store.model.products.Product;

public abstract class DigitalProduct extends Product {
    private String brand;
    private double weight;

    public DigitalProduct(String id, String name, double price, int stock, String brand, double weight) {
        super(id, name, price, stock);
        this.brand = brand;
        this.weight = weight;
    }

    // Getters and Setters ...
}