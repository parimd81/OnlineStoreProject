package com.online.store.model.product.digital;


public abstract class StorageDevice extends DigitalProduct {



    protected int capacity;




    public StorageDevice(
            int id,
            String name,
            double price,
            boolean stock,
            double weight,
            String dimensions,
            int capacity
    ){

        super(
                id,
                name,
                price,
                stock,
                weight,
                dimensions
        );


        this.capacity=capacity;

    }




    public int getCapacity(){

        return capacity;

    }

}