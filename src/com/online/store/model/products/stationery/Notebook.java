package com.online.store.model.products.stationery;

public class Notebook extends Stationery {

    private int pageCount;

    public Notebook(int id, String name, double price, int stock, int pageCount) {
        super(id, name, price, stock);
        this.pageCount = pageCount;
    }
}