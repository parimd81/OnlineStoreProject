package com.online.store.model.product.vehicle;


public class Car extends Vehicle {



    private int engineVolume;


    private boolean automatic;





    public Car(
            int id,
            String name,
            double price,
            boolean stock,
            String manufacturer,
            int engineVolume,
            boolean automatic
    ){


        super(
                id,
                name,
                price,
                stock,
                manufacturer
        );


        this.engineVolume=engineVolume;

        this.automatic=automatic;


    }





    public int getEngineVolume(){

        return engineVolume;

    }





    public boolean isAutomatic(){

        return automatic;

    }


}