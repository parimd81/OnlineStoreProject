package com.online.store.model.order;


import com.online.store.model.product.Product;



public class CartItem {


    private Product product;


    private int quantity;



    public CartItem(Product product, int quantity){


        if(product == null){

            throw new IllegalArgumentException(
                    "Product cannot be null"
            );

        }


        if(quantity <= 0){

            throw new IllegalArgumentException(
                    "Quantity must be positive"
            );

        }


        this.product = product;

        this.quantity = quantity;


    }





    public Product getProduct(){

        return product;

    }





    public int getQuantity(){

        return quantity;

    }




    public double getTotalPrice(){

        return product.getPrice() * quantity;

    }



}