package com.online.store.model.products.food;

import com.online.store.model.products.Product;
import java.time.LocalDate;

public class FoodProduct extends Product {
    private LocalDate expiryDate;

    public FoodProduct(String id, String name, double price, int stock, LocalDate expiryDate) {
        super(id, name, price, stock);
        this.expiryDate = expiryDate;
    }

    public LocalDate getExpiryDate() { return expiryDate; }
}