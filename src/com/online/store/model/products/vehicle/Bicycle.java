package com.online.store.model.products.vehicle;

public class Bicycle extends Vehicle {

    private String type;

    public Bicycle(String id, String name, double price, int stock,
                   String manufacturer, String type) {
        super(id, name, price, stock, manufacturer);
        this.type = type;
    }

    public String getType() { return type; }
}