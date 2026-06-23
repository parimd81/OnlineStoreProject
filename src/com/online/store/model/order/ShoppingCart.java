package com.online.store.model.order;


import java.util.ArrayList;
import java.util.List;



import com.online.store.model.product.Product;



public class ShoppingCart {


    private List<CartItem> items =
            new ArrayList<>();













        public void addItem(CartItem item){

            items.add(item);

        }









    public void removeItem(CartItem item){

        items.remove(item);

    }








    public double getTotalPrice(){

        return items.stream()
                .mapToDouble(
                        CartItem::getTotalPrice
                )
                .sum();

    }












    public boolean isEmpty(){

        return items.isEmpty();

    }






    public void clear(){

        items.clear();

    }








    public List<CartItem> getItems(){

        return new ArrayList<>(items);

    }



}