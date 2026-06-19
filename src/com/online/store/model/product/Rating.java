package com.online.store.model.product;


import com.online.store.model.users.Customer;



public class Rating {



    private Customer customer;


    private int productId;


    private int score;






    public Rating(Customer customer,
                  int productId,
                  int score){



        if(!customer.hasBoughtProduct(productId)){


            throw new IllegalStateException(
                    "Only buyers can rate this product."
            );


        }




        if(score < 1 || score > 5){


            throw new IllegalArgumentException(
                    "Score must be between 1 and 5"
            );


        }



        this.customer=customer;

        this.productId=productId;

        this.score=score;


    }







    public int getScore(){

        return score;

    }




    public int getProductId(){

        return productId;

    }



    public Customer getCustomer(){

        return customer;

    }


}