package com.online.store.model.users;


import com.online.store.model.order.Invoice;
import com.online.store.model.order.ShoppingCart;
import com.online.store.model.product.Comment;
import com.online.store.model.product.Rating;
import com.online.store.model.order.CartItem;


import java.util.ArrayList;
import java.util.List;



public class Customer extends User {



    private ShoppingCart cart;


    private Account account;


    private List<Invoice> invoices;


    private List<Comment> comments;


    private List<Rating> ratings;





    public Customer(String username,
                    String email,
                    String phone,
                    String password) {


        super(username,
                email,
                phone,
                password,
                Role.CUSTOMER);



        cart = new ShoppingCart();


        account = new CustomerAccount();



        invoices = new ArrayList<>();

        comments = new ArrayList<>();

        ratings = new ArrayList<>();


    }







    public boolean hasBoughtProduct(int productId){


        return invoices.stream()

                .anyMatch(invoice ->
                        invoice.containsProduct(productId)
                );


    }







    public void addInvoice(Invoice invoice){

        invoices.add(invoice);

    }







    public void addToCart(CartItem item){

        cart.addItem(item);

    }







    public void addComment(Comment comment){

        comments.add(comment);

    }







    public void addRating(Rating rating){

        ratings.add(rating);

    }








    public ShoppingCart getCart(){

        return cart;

    }







    public Account getAccount(){

        return account;

    }







    public double getBalance(){

        return account.getBalance();

    }







    public List<Invoice> getInvoices(){

        return new ArrayList<>(invoices);

    }







    public List<Comment> getComments(){

        return new ArrayList<>(comments);

    }







    public List<Rating> getRatings(){

        return new ArrayList<>(ratings);

    }



}