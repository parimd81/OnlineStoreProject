package com.online.store.model.product.stationery;



public class Notebook extends Stationery {



    private int pages;


    private String paperType;





    public Notebook(int id,
                    String name,
                    double price,
                    int quantity,
                    String countryOfOrigin,
                    int pages,
                    String paperType){



        super(id,
                name,
                price,
                quantity,
                countryOfOrigin);



        this.pages = pages;


        this.paperType = paperType;


    }






    public int getPages(){

        return pages;

    }






    public String getPaperType(){

        return paperType;

    }






    public void setPages(int pages){

        this.pages = pages;

    }






    public void setPaperType(String paperType){

        this.paperType = paperType;

    }



}