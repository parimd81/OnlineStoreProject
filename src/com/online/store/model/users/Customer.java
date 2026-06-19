package com.online.store.model.users;


import com.online.store.model.order.Invoice;
import com.online.store.model.product.Comment;
import com.online.store.model.product.Rating;


import java.util.ArrayList;
import java.util.List;



public class Customer extends User {



    private List<Invoice> invoices = new ArrayList<>();

    private List<Comment> comments = new ArrayList<>();

    private List<Rating> ratings = new ArrayList<>();




    public Customer(String username,
                    String email,
                    String phone,
                    String password){


        super(username,email,phone,password,Role.CUSTOMER);

    }





    public boolean hasBoughtProduct(int productId){


        return invoices.stream()
                .anyMatch(invoice ->
                        invoice.containsProduct(productId));

    }




    public void addInvoice(Invoice invoice){

        invoices.add(invoice);

    }





    public void addComment(Comment comment){

        comments.add(comment);

    }





    public void addRating(Rating rating){

        ratings.add(rating);

    }





    public List<Invoice> getInvoices(){

        return invoices;

    }



    public List<Comment> getComments(){

        return comments;

    }



    public List<Rating> getRatings(){

        return ratings;

    }

}