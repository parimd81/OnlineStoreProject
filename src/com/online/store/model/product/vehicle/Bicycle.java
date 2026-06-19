package com.online.store.model.product.vehicle;

public class Bicycle extends Vehicle {



    public enum BikeType{

        MOUNTAIN,
        ROAD,
        URBAN,
        HYBRID

    }





    private BikeType type;






    public Bicycle(
            int id,
            String name,
            double price,
            boolean stock,
            String manufacturer,
            BikeType type
    ){


        super(
                id,
                name,
                price,
                stock,
                manufacturer
        );


        this.type=type;


    }





    public BikeType getType(){

        return type;

    }



}