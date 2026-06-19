package com.online.store.model.product.stationery;

import com.online.store.model.product.Product;
import com.online.store.model.product.category.Category;



public abstract class Stationery extends Product {



    protected String manufacturerCountry;





    public Stationery(
            int id,
            String name,
            double price,
            boolean stock,
            String manufacturerCountry
    ){


        super(
                id,
                name,
                price,
                stock,
                Category.STATIONERY
        );


        this.manufacturerCountry=
                manufacturerCountry;


    }



    public String getManufacturerCountry(){

        return manufacturerCountry;

    }


}