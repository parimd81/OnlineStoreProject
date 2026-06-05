package com.online.store.model.products.stationery;

public class Pen extends Stationery {

    private String color;

    public Pen(int id, String name, double price, int stock, String color) {
        super(id, name, price, stock);
        this.color = color;
    }
}