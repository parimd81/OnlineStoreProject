package com.online.store.model.product.stationery;


public class Notebook extends Stationery {



    private int pageCount;


    private String paperType;






    public Notebook(
            int id,
            String name,
            double price,
            boolean stock,
            String country,
            int pageCount,
            String paperType
    ){


        super(
                id,
                name,
                price,
                stock,
                country
        );


        this.pageCount=pageCount;

        this.paperType=paperType;


    }





    public int getPageCount(){

        return pageCount;

    }




    public String getPaperType(){

        return paperType;

    }


}