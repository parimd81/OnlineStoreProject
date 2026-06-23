package com.online.store.model.product.digital;



public abstract class StorageDevice extends DigitalProduct {


    protected int capacity;



    public StorageDevice(int id,
                         String name,
                         double price,
                         int quantity,
                         double weight,
                         String dimension,
                         int capacity){


        super(id,
                name,
                price,
                quantity,
                weight,
                dimension);


        this.capacity = capacity;


    }





    public int getCapacity(){

        return capacity;

    }




    public void setCapacity(int capacity){


        if(capacity < 0){

            throw new IllegalArgumentException(
                    "Capacity cannot be negative"
            );

        }


        this.capacity = capacity;


    }



}