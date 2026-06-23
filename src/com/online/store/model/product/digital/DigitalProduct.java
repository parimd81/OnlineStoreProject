package com.online.store.model.product.digital;


import com.online.store.model.product.Product;
import com.online.store.model.product.category.Category;



public abstract class DigitalProduct extends Product {


    protected double weight;


    protected String dimension;




    public DigitalProduct(int id,
                          String name,
                          double price,
                          int quantity,
                          double weight,
                          String dimension){


        super(
                id,
                name,
                price,
                quantity,
                Category.DIGITAL
        );



        this.weight = weight;

        this.dimension = dimension;


    }





    public double getWeight(){

        return weight;

    }


    public void setWeight(double weight){

        if(weight < 0){

            throw new IllegalArgumentException(
                    "Weight cannot be negative"
            );

        }

        this.weight = weight;

    }





    public String getDimension(){

        return dimension;

    }


    public void setDimension(String dimension){

        this.dimension = dimension;

    }



}