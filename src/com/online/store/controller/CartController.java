package com.online.store.controller;


import com.online.store.model.cart.Cart;
import com.online.store.model.cart.CartItem;
import com.online.store.model.products.Product;
import com.online.store.model.users.Buyer;



public class CartController {



    // اضافه کردن محصول به سبد خرید

    public void addToCart(Buyer buyer,
                          Product product,
                          int quantity) {



        if(quantity <= 0) {


            throw new RuntimeException(
                    "Invalid quantity"
            );

        }





        // بررسی موجودی انبار

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








    // حذف از سبد

    public void removeFromCart(Buyer buyer,
                               CartItem item) {



        Cart cart =
                buyer.getCart();



        cart.removeItem(item);

    }








    // نمایش سبد

    public Cart viewCart(Buyer buyer) {


        return buyer.getCart();

    }








    // محاسبه مبلغ کل

    public double calculateTotal(Buyer buyer) {


        return buyer.getCart()
                .getTotalPrice();

    }



}
