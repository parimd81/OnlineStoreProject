package com.online.store.model.products.vehicle;

public class Car extends Vehicle {
    private int engineCapacity;
    private boolean isAutomatic;

    public Car(String id, String name, double price, int stock, String manufacturer, int engineCapacity, boolean isAutomatic) {
        super(id, name, price, stock, manufacturer);
        this.engineCapacity = engineCapacity;
        this.isAutomatic = isAutomatic;
    }

    public int getEngineCapacity() { return engineCapacity; }
    public void setEngineCapacity(int engineCapacity) { this.engineCapacity = engineCapacity; }

    public boolean isAutomatic() { return isAutomatic; }
    public void setAutomatic(boolean automatic) { isAutomatic = automatic; }
}