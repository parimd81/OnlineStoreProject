package com.online.store.model.product;


import com.online.store.model.users.Customer;



public class Rating {



    private Customer user;


    private Product product;


    private int score;






    public Rating(Customer user,
                  Product product,
                  int score){



        if(score < 1 || score > 5){

            throw new IllegalArgumentException(
                    "Score must be between 1 and 5"
            );

        }



        this.user=user;


        this.product=product;


        this.score=score;


    }






    public Customer getUser(){

        return user;

    }






    public Product getProduct(){

        return product;

    }






    public int getScore(){

        return score;

    }



}