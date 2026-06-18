package com.online.store.model.cart;


import java.util.ArrayList;
import java.util.List;



public class Cart {


    private List<CartItem> items;



    public Cart() {

        items = new ArrayList<>();

    }




    public void addItem(CartItem item) {


        items.add(item);

    }





    public void removeItem(CartItem item) {


        items.remove(item);

    }





    public List<CartItem> getItems() {


        return items;

    }





    public double getTotalPrice() {


        double total = 0;


        for(CartItem item : items) {


            total += item.getTotalPrice();

        }


        return total;

    }





    public void clear() {


        items.clear();

    }





    @Override
    public String toString() {


        return "Cart{" +
                "items=" + items +
                ", total=" + getTotalPrice() +
                '}';

    }

}