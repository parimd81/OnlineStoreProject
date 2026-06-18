package com.online.store.model.products.digital;

import com.online.store.model.products.Product;

public abstract class DigitalProduct extends Product {

    private String brand;


    public DigitalProduct(String id,
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
        return "DigitalProduct{" +
                "brand='" + brand + '\'' +
                '}';
    }
}
