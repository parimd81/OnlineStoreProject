package com.online.store.model.product.vehicle;


public class Bicycle extends Vehicle {


    private BicycleType type;



    public Bicycle(
            int id,
            String name,
            double price,
            int quantity,
            String productionDate,
            String companyName,
            BicycleType type
    ) {


        super(
                id,
                name,
                price,
                quantity,
                productionDate,
                companyName
        );


        this.type = type;

    }



    public BicycleType getType() {

        return type;

    }



    public void setType(BicycleType type){

        this.type = type;

    }


}