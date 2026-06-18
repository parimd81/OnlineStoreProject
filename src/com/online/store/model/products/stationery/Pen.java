package com.online.store.model.products.stationery;


public class Pen extends Stationery {

    private String inkColor;


    public Pen(String id,
               String name,
               double price,
               int stock,
               String brand,
               String inkColor) {

        super(id, name, price, stock, brand);

        this.inkColor = inkColor;
    }


    public String getInkColor() {
        return inkColor;
    }


    public void setInkColor(String inkColor) {
        this.inkColor = inkColor;
    }


    @Override
    public String toString() {
        return "Pen{" +
                "inkColor='" + inkColor + '\'' +
                '}';
    }
}