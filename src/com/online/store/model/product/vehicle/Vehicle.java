package com.online.store.model.product.vehicle;


import com.online.store.model.product.Product;
import com.online.store.model.product.category.Category;



public abstract class Vehicle extends Product {



    protected String manufacturer;



    public Vehicle(
            int id,
            String name,
            double price,
            boolean stock,
            String manufacturer
    ){


        super(
                id,
                name,
                price,
                stock,
                Category.VEHICLE
        );


        this.manufacturer=manufacturer;


    }


}