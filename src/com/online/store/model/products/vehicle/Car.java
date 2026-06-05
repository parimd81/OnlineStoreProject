package com.online.store.model.products.vehicle;

public class Car extends Vehicle {

    private int engineCapacity;
    private boolean automatic;

    public Car(String id, String name, double price, int stock,
               String manufacturer, int engineCapacity, boolean automatic) {
        super(id, name, price, stock, manufacturer);
        this.engineCapacity = engineCapacity;
        this.automatic = automatic;
    }

    public int getEngineCapacity() { return engineCapacity; }
    public boolean isAutomatic() { return automatic; }
}