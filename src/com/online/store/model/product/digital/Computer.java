package com.online.store.model.product.digital;


public class Computer extends DigitalProduct {


    private String processorModel;


    private int ram;


    private SSD storage;



    public Computer(int id,
                    String name,
                    double price,
                    int quantity,
                    double weight,
                    String dimension,
                    String processorModel,
                    int ram,
                    SSD storage) {



        super(id,
                name,
                price,
                quantity,
                weight,
                dimension);



        this.processorModel = processorModel;

        this.ram = ram;

        this.storage = storage;

    }





    public String getProcessorModel(){

        return processorModel;

    }


    public void setProcessorModel(String processorModel){

        this.processorModel = processorModel;

    }





    public int getRam(){

        return ram;

    }


    public void setRam(int ram){

        if(ram < 0){

            throw new IllegalArgumentException(
                    "RAM cannot be negative"
            );

        }

        this.ram = ram;

    }





    public SSD getStorage(){

        return storage;

    }


    public void setStorage(SSD storage){

        this.storage = storage;

    }





    public int getStorageCapacity(){

        if(storage == null){

            return 0;

        }

        return storage.getCapacity();

    }





    public double getReadSpeed(){

        if(storage == null){

            return 0;

        }

        return storage.getReadSpeed();

    }





    public double getWriteSpeed(){

        if(storage == null){

            return 0;

        }

        return storage.getWriteSpeed();

    }



}