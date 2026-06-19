package com.online.store.model.product.digital;

public class SSD extends StorageDevice {



    private int readSpeed;


    private int writeSpeed;





    public SSD(
            int id,
            String name,
            double price,
            boolean stock,
            double weight,
            String dimensions,
            int capacity,
            int readSpeed,
            int writeSpeed
    ){


        super(
                id,
                name,
                price,
                stock,
                weight,
                dimensions,
                capacity
        );


        this.readSpeed=readSpeed;

        this.writeSpeed=writeSpeed;

    }





    public int getReadSpeed(){

        return readSpeed;

    }




    public int getWriteSpeed(){

        return writeSpeed;

    }



}