package com.online.store.model.products.stationery;

public class Pencil extends Stationery {

    private PencilType type;

    public Pencil(int id, String name, double price, int stock, PencilType type) {
        super(id, name, price, stock);
        this.type = type;
    }
}