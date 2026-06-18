package com.online.store.model.products.stationery;


public class Pencil extends Stationery {

    private String hardness;


    public Pencil(String id,
                  String name,
                  double price,
                  int stock,
                  String brand,
                  String hardness) {

        super(id, name, price, stock, brand);

        this.hardness = hardness;
    }


    public String getHardness() {
        return hardness;
    }


    public void setHardness(String hardness) {
        this.hardness = hardness;
    }


    @Override
    public String toString() {

        return "Pencil{" +
                "id='" + getId() + '\'' +
                ", name='" + getName() + '\'' +
                ", price=" + getPrice() +
                ", stock=" + getStock() +
                ", brand='" + getBrand() + '\'' +
                ", hardness='" + hardness + '\'' +
                '}';
    }
}