package com.online.store.model.products.digital;

public abstract class DigitalProduct extends Product {
    private String brand;

    public DigitalProduct(String id, String name, double price, int stock, String brand) {
        super(id, name, price, stock);
        this.brand = brand;
    }

    public String getBrand() { return brand; }
    public void setBrand(String brand) { this.brand = brand; }
}