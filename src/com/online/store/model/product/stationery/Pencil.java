package com.online.store.model.product.stationery;


public class Pencil extends Stationery {



    public enum PencilType{

        HB,
        B,
        F,
        H,
        H2

    }




    private PencilType type;





    public Pencil(
            int id,
            String name,
            double price,
            boolean stock,
            String country,
            PencilType type
    ){


        super(
                id,
                name,
                price,
                stock,
                country
        );


        this.type=type;


    }





    public PencilType getType(){

        return type;

    }



}