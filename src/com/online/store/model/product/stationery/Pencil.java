package com.online.store.model.product.stationery;



public class Pencil extends Stationery {



    private PencilType type;





    public Pencil(int id,
                  String name,
                  double price,
                  int quantity,
                  String countryOfOrigin,
                  PencilType type){


        super(id,
                name,
                price,
                quantity,
                countryOfOrigin);



        this.type = type;


    }






    public PencilType getType(){

        return type;

    }






    public void setType(PencilType type){

        this.type = type;

    }



}