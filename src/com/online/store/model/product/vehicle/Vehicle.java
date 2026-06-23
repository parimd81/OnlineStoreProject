package com.online.store.model.product.vehicle;


import com.online.store.model.product.Product;
import com.online.store.model.product.category.Category;


public abstract class Vehicle extends Product {


    protected String productionDate;

    protected String companyName;



    public Vehicle(
            int id,
            String name,
            double price,
            int quantity,
            String productionDate,
            String companyName
    ){

        super(
                id,
                name,
                price,
                quantity,
                Category.VEHICLE
        );


        this.productionDate = productionDate;
        this.companyName = companyName;

    }



    public String getCompanyName(){

        return companyName;
    }



    public String getProductionDate(){

        return productionDate;
    }


    public void setCompanyName(String companyName){

        this.companyName = companyName;

    }


    public void setProductionDate(String productionDate){

        this.productionDate = productionDate;

    }


}