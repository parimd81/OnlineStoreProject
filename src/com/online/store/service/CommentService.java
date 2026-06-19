package com.online.store.service;



import com.online.store.model.product.Comment;
import com.online.store.model.product.Product;
import com.online.store.model.users.Customer;



public class CommentService {



    public Comment addComment(
            Customer customer,
            Product product,
            String text
    ){



        Comment comment =
                new Comment(
                        customer,
                        product.getId(),
                        text
                );



        product.addComment(comment);



        customer.getComments()
                .add(comment);



        return comment;


    }






    public void approveComment(Comment comment){

        comment.approve();

    }




    public void rejectComment(Comment comment){

        comment.reject();

    }



}