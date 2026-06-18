package com.online.store.model.cart;


import java.util.ArrayList;
import java.util.List;


public class Cart {


    private List<CartItem> items;


    public Cart() {

        items = new ArrayList<>();
    }


    public List<CartItem> getItems() {

        return items;
    }


    public void setItems(List<CartItem> items) {

        this.items = items;
    }


    public void addItem(CartItem item) {

        items.add(item);
    }


    public void removeItem(CartItem item) {

        items.remove(item);
    }


    public double getTotalPrice() {

        double total = 0;

        for (CartItem item : items) {

            total += item.getTotalPrice();
        }

        return total;
    }


    @Override
    public String toString() {

        return "Cart{" +
                "items=" + items +
                '}';
    }
}