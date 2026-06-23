package com.online.store.model.product.food;


import com.online.store.model.product.Product;
import com.online.store.model.product.category.Category;



public class Food extends Product {


    private String productionDate;


    private String expirationDate;




    public Food(int id,
                String name,
                double price,
                int quantity,
                String productionDate,
                String expirationDate){


        super(
                id,
                name,
                price,
                quantity,
                Category.FOOD
        );


        this.productionDate = productionDate;

        this.expirationDate = expirationDate;


    }




    public String getProductionDate(){

        return productionDate;

    }




    public String getExpirationDate(){

        return expirationDate;

    }


}