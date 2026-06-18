package com.online.store.model.users;

import com.online.store.model.cart.Cart;


public class Buyer extends User {


    private double walletBalance;

    private Cart cart;



    public Buyer(String username,
                 String email,
                 String phoneNumber,
                 String password,
                 double walletBalance) {


        super(username, email, phoneNumber, password);


        this.walletBalance = walletBalance;


        // هر خریدار هنگام ساخته شدن یک سبد خرید دارد
        this.cart = new Cart();
    }



    public double getWalletBalance() {

        return walletBalance;
    }



    public void setWalletBalance(double walletBalance) {

        this.walletBalance = walletBalance;
    }



    public Cart getCart() {

        return cart;
    }



    public void setCart(Cart cart) {

        this.cart = cart;
    }



    @Override
    public String toString() {

        return "Buyer{" +
                "username='" + getUsername() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", phoneNumber='" + getPhoneNumber() + '\'' +
                ", walletBalance=" + walletBalance +
                '}';
    }
}