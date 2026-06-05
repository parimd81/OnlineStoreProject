package com.online.store.model.products.vehicle;

public class Bicycle extends Vehicle {

    private BicycleType type;

    public Bicycle(int id, String name, double price, int stock, double engineVolume, BicycleType type) {
        super(id, name, price, stock, engineVolume);
        this.type = type;
    }
}