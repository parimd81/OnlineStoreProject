package com.online.store.model.product.stationery;



public class Pen extends Stationery {



    private String color;





    public Pen(int id,
               String name,
               double price,
               int quantity,
               String countryOfOrigin,
               String color){


        super(id,
                name,
                price,
                quantity,
                countryOfOrigin);



        this.color = color;


    }






    public String getColor(){

        return color;

    }






    public void setColor(String color){

        this.color = color;

    }



}