package com.online.store.model.products.vehicle;

import com.online.store.model.products.Product;

public abstract class Vehicle extends Product {
    private String manufacturer;

    public Vehicle(String id, String name, double price, int stock, String manufacturer) {
        super(id, name, price, stock);
        this.manufacturer = manufacturer;
    }

    public String getManufacturer() { return manufacturer; }
    public void setManufacturer(String manufacturer) { this.manufacturer = manufacturer; }
}