package com.online.store.model.products.stationery;

import com.online.store.model.products.Product;

public abstract class Stationery extends Product {

    private String brand;


    public Stationery(String id,
                      String name,
                      double price,
                      int stock,
                      String brand) {

        super(id, name, price, stock);
        this.brand = brand;
    }


    public String getBrand() {
        return brand;
    }


    public void setBrand(String brand) {
        this.brand = brand;
    }


    @Override
    public String toString() {
        return "Stationery{" +
                "brand='" + brand + '\'' +
                '}';
    }
}
