package com.online.store.controller;


import com.online.store.model.cart.Cart;
import com.online.store.model.cart.CartItem;
import com.online.store.model.products.Product;
import com.online.store.model.users.Buyer;



public class CartController {



    public void addToCart(Buyer buyer,
                          Product product,
                          int quantity) {



        if(quantity <= 0) {


            throw new RuntimeException(
                    "Invalid quantity"
            );

        }





        if(product.getStock() < quantity) {


            throw new RuntimeException(
                    "Not enough stock"
            );

        }






        Cart cart =
                buyer.getCart();






        CartItem item =
                new CartItem(

                        product,

                        quantity

                );






        cart.addItem(item);



    }









    public void removeFromCart(Buyer buyer,
                               CartItem item) {



        buyer.getCart()
                .removeItem(item);


    }









    public Cart viewCart(Buyer buyer) {


        return buyer.getCart();


    }









    public double calculateTotal(Buyer buyer) {


        return buyer.getCart()
                .getTotalPrice();


    }



}