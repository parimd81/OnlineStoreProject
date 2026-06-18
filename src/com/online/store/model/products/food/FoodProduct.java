package com.online.store.model.products.food;

import com.online.store.model.products.Product;

import java.time.LocalDate;

public class FoodProduct extends Product {

    private LocalDate productionDate;
    private LocalDate expirationDate;


    public FoodProduct(String id,
                       String name,
                       double price,
                       int stock,
                       LocalDate productionDate,
                       LocalDate expirationDate) {

        super(id, name, price, stock);

        this.productionDate = productionDate;
        this.expirationDate = expirationDate;
    }


    public LocalDate getProductionDate() {
        return productionDate;
    }


    public void setProductionDate(LocalDate productionDate) {
        this.productionDate = productionDate;
    }


    public LocalDate getExpirationDate() {
        return expirationDate;
    }


    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }


    @Override
    public String toString() {
        return "FoodProduct{" +
                "productionDate=" + productionDate +
                ", expirationDate=" + expirationDate +
                '}';
    }
}
