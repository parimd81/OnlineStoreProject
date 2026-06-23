package com.online.store.service;



import com.online.store.model.product.Comment;
import com.online.store.model.product.Product;
import com.online.store.model.product.Rating;

import com.online.store.model.users.Admin;
import com.online.store.model.users.Customer;


import java.util.ArrayList;
import java.util.List;




public class ReviewService {



    private static ReviewService instance;



    private List<Comment> pendingComments;






    private ReviewService(){


        pendingComments =
                new ArrayList<>();


    }







    public static ReviewService getInstance(){



        if(instance==null){

            instance=
                    new ReviewService();

        }


        return instance;


    }








    // ثبت نظر


    public void addComment(Customer customer,
                           Product product,
                           String text){



        if(!customer.hasBoughtProduct(product.getId())){


            throw new IllegalStateException(
                    "You must buy product first"
            );


        }






        Comment comment =
                new Comment(
                        customer,
                        product,
                        text
                );



        pendingComments.add(comment);


    }








    // ثبت امتیاز


    public void addRating(Customer customer,
                          Product product,
                          int score){



        if(!customer.hasBoughtProduct(product.getId())){


            throw new IllegalStateException(
                    "You must buy product first"
            );


        }





        Rating rating =
                new Rating(
                        customer,
                        product,
                        score
                );




        product.addRating(rating);


        customer.addRating(rating);


    }









    public List<Comment> getPendingComments(){


        return new ArrayList<>(
                pendingComments
        );


    }










    // تایید نظر توسط مدیر


    public void approveComment(Admin admin,
                               Comment comment){



        if(pendingComments.contains(comment)){



            comment.approve();



            comment.getProduct()
                    .addComment(comment);



            comment.getUser()
                    .addComment(comment);




            pendingComments.remove(comment);



        }



    }









    public void rejectComment(Admin admin,
                              Comment comment){



        pendingComments.remove(comment);


    }





}