package com.online.store.model.products.stationery;

import com.online.store.model.products.Product;

public abstract class Stationery extends Product {
    private String countryOfOrigin;

    public Stationery(String id, String name, double price, int stock, String countryOfOrigin) {
        super(id, name, price, stock);
        this.countryOfOrigin = countryOfOrigin;
    }

    public String getCountryOfOrigin() { return countryOfOrigin; }
}