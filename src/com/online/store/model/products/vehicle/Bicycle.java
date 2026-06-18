package com.online.store.model.products.vehicle;


public class Bicycle extends Vehicle {


    private String bicycleType;


    public Bicycle(String id,
                   String name,
                   double price,
                   int stock,
                   String manufacturer,
                   String bicycleType) {


        super(id, name, price, stock, manufacturer);

        this.bicycleType = bicycleType;
    }


    public String getBicycleType() {
        return bicycleType;
    }


    public void setBicycleType(String bicycleType) {
        this.bicycleType = bicycleType;
    }


    @Override
    public String toString() {
        return "Bicycle{" +
                "bicycleType='" + bicycleType + '\'' +
                '}';
    }
}