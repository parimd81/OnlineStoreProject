package com.online.store.model.products.stationery;

public class Notebook extends Stationery {
    private int pages;

    public Notebook(String id, String name, double price, int stock, String countryOfOrigin, int pages) {
        super(id, name, price, stock, countryOfOrigin);
        this.pages = pages;
    }

    public int getPages() { return pages; }
    public void setPages(int pages) { this.pages = pages; }
}