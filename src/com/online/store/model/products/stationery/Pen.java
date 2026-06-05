package com.online.store.model.products.stationery;

public class Pen extends Stationery {
    private String color;

    public Pen(String id, String name, double price, int stock, String countryOfOrigin, String color) {
        super(id, name, price, stock, countryOfOrigin);
        this.color = color;
    }

    public String getColor() { return color; }
    public void setColor(String color) { this.color = color; }
}