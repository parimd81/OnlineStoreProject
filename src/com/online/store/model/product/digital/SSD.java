package com.online.store.model.product.digital;



public class SSD extends StorageDevice {


    private double readSpeed;

    private double writeSpeed;




    public SSD(int id,
               String name,
               double price,
               int quantity,
               double weight,
               String dimension,
               int capacity,
               int readSpeed,
               int writeSpeed){


        super(id,
                name,
                price,
                quantity,
                weight,
                dimension,
                capacity);


        this.readSpeed = readSpeed;

        this.writeSpeed = writeSpeed;


    }





    public double getReadSpeed(){

        return readSpeed;

    }


    public void setReadSpeed(double readSpeed){

        if(readSpeed < 0){

            throw new IllegalArgumentException(
                    "Read speed cannot be negative"
            );

        }

        this.readSpeed = readSpeed;

    }





    public double getWriteSpeed(){

        return writeSpeed;

    }


    public void setWriteSpeed(double writeSpeed){

        if(writeSpeed < 0){

            throw new IllegalArgumentException(
                    "Write speed cannot be negative"
            );

        }

        this.writeSpeed = writeSpeed;

    }



}