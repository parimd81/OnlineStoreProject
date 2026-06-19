package com.online.store.model.product.stationery;


public class Pen extends Stationery {



    private String color;





    public Pen(
            int id,
            String name,
            double price,
            boolean stock,
            String country,
            String color
    ){


        super(
                id,
                name,
                price,
                stock,
                country
        );


        this.color=color;


    }






    public String getColor(){

        return color;

    }


}