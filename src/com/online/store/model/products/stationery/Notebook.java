package com.online.store.model.products.stationery;


public class Notebook extends Stationery {

    private int pageCount;


    public Notebook(String id,
                    String name,
                    double price,
                    int stock,
                    String brand,
                    int pageCount) {

        super(id, name, price, stock, brand);

        this.pageCount = pageCount;
    }


    public int getPageCount() {
        return pageCount;
    }


    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }


    @Override
    public String toString() {
        return "Notebook{" +
                "pageCount=" + pageCount +
                '}';
    }
}