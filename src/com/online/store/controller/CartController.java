package com.online.store.controller;


import com.online.store.model.cart.Cart;
import com.online.store.model.cart.CartItem;
import com.online.store.model.products.Product;
import com.online.store.model.users.Buyer;


public class CartController {


    // اضافه کردن کالا به سبد خرید

    public void addToCart(Buyer buyer,
                          Product product,
                          int quantity) {


        Cart cart = buyer.getCart();


        CartItem item =
                new CartItem(product, quantity);


        cart.addItem(item);
    }



    // حذف کالا از سبد

    public void removeFromCart(Buyer buyer,
                               CartItem item) {


        Cart cart = buyer.getCart();


        cart.removeItem(item);
    }



    // نمایش سبد خرید

    public Cart viewCart(Buyer buyer) {


        return buyer.getCart();

    }



    // محاسبه مبلغ کل

    public double calculateTotal(Buyer buyer) {


        return buyer.getCart()
                .getTotalPrice();

    }

}