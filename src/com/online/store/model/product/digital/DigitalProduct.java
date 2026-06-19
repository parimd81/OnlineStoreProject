package com.online.store.model.product.digital;

import com.online.store.model.product.Product;
import com.online.store.model.product.category.Category;



public abstract class DigitalProduct extends Product {


    protected double weight;

    protected String dimensions;



    public DigitalProduct(
            int id,
            String name,
            double price,
            boolean stock,
            double weight,
            String dimensions
    ){


        super(
                id,
                name,
                price,
                stock,
                Category.DIGITAL
        );


        this.weight = weight;

        this.dimensions = dimensions;

    }




    public double getWeight(){

        return weight;

    }



    public String getDimensions(){

        return dimensions;

    }


}