package com.online.store.model.product.stationery;


import com.online.store.model.product.Product;
import com.online.store.model.product.category.Category;



public abstract class Stationery extends Product {



    protected String countryOfOrigin;



    public Stationery(int id,
                      String name,
                      double price,
                      int quantity,
                      String countryOfOrigin){


        super(id,
                name,
                price,
                quantity,
                Category.STATIONERY);



        this.countryOfOrigin = countryOfOrigin;

    }







    public String getCountryOfOrigin(){

        return countryOfOrigin;

    }







    public void setCountryOfOrigin(String countryOfOrigin){

        this.countryOfOrigin = countryOfOrigin;

    }



}