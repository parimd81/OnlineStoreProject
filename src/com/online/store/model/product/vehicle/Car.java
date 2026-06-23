package com.online.store.model.product.vehicle;


public class Car extends Vehicle {


    private double engineVolume;


    private boolean automatic;



    public Car(
            int id,
            String name,
            double price,
            int quantity,
            String productionDate,
            String companyName,
            double engineVolume,
            boolean automatic
    ){

        super(
                id,
                name,
                price,
                quantity,
                productionDate,
                companyName
        );


        this.engineVolume = engineVolume;
        this.automatic = automatic;

    }





    public double getEngineVolume(){

        return engineVolume;

    }




    public void setEngineVolume(double engineVolume){

        this.engineVolume = engineVolume;

    }





    public boolean isAutomatic(){

        return automatic;

    }



    public void setAutomatic(boolean automatic){

        this.automatic = automatic;

    }



}