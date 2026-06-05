package com.online.store.model.products.stationery;

public class Pencil extends Stationery {
    private String hardness; // مثلاً HB, 2B

    public Pencil(String id, String name, double price, int stock, String countryOfOrigin, String hardness) {
        super(id, name, price, stock, countryOfOrigin);
        this.hardness = hardness;
    }

    public String getHardness() { return hardness; }
}