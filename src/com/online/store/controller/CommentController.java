package com.online.store.controller;


import com.online.store.enums.CommentStatus;
import com.online.store.model.comments.Comment;
import com.online.store.model.products.Product;
import com.online.store.model.users.Buyer;


import java.util.ArrayList;
import java.util.List;



public class CommentController {


    private List<Comment> comments;



    public CommentController() {

        comments = new ArrayList<>();

    }



    // ثبت کامنت جدید

    public Comment addComment(Buyer buyer,
                              Product product,
                              String text) {


        Comment comment =
                new Comment(
                        comments.size() + 1,
                        buyer,
                        product,
                        text
                );


        comments.add(comment);


        return comment;
    }





    // نمایش همه کامنت‌ها

    public List<Comment> getAllComments() {


        return comments;

    }





    // تایید کامنت

    public void approveComment(int commentId) {


        for(Comment comment : comments) {


            if(comment.getId() == commentId) {


                comment.setStatus(
                        CommentStatus.APPROVED
                );


                return;
            }

        }

    }





    // رد کامنت

    public void rejectComment(int commentId) {


        for(Comment comment : comments) {


            if(comment.getId() == commentId) {


                comment.setStatus(
                        CommentStatus.REJECTED
                );


                return;
            }

        }

    }





    // گرفتن کامنت‌های یک محصول

    public List<Comment> getProductComments(Product product) {


        List<Comment> result =
                new ArrayList<>();


        for(Comment comment : comments) {


            if(comment.getProduct()
                    .equals(product)) {


                result.add(comment);

            }

        }


        return result;

    }

}