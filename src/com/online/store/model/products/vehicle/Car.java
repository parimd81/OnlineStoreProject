package com.online.store.model.products.vehicle;

public class Car extends Vehicle {
    private int engineCapacity;
    private boolean isAutomatic;

    public Car(String id, String name, double price, int stock, String manufacturer, int engineCapacity, boolean isAutomatic) {
        super(id, name, price, stock, manufacturer); // پاس دادن به Vehicle
        this.engineCapacity = engineCapacity;
        this.isAutomatic = isAutomatic;
    }
}