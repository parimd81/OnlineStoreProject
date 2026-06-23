package com.online.store.service;



import com.online.store.model.product.Product;
import com.online.store.model.product.Rating;
import com.online.store.model.users.Customer;



public class RatingService {



    public Rating addRating(
            Customer customer,
            Product product,
            int score
    ){



        Rating rating =
                new Rating(
                        customer,
                        product,
                        score
                );



        product.addRating(rating);



        customer.getRatings()
                .add(rating);



        return rating;


    }



}