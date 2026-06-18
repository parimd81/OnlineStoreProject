package com.online.store.model.products.stationery;

public abstract class Stationery extends Product {
    private String countryOfOrigin;

    public Stationery(String id, String name, double price, int stock, String countryOfOrigin) {
        super(id, name, price, stock, countryOfOrigin);
        this.countryOfOrigin = countryOfOrigin;
    }

    public String getCountryOfOrigin() { return countryOfOrigin; }
    public void setCountryOfOrigin(String countryOfOrigin) { this.countryOfOrigin = countryOfOrigin; }
}