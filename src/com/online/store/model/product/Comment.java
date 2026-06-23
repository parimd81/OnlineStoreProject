package com.online.store.model.product;


import com.online.store.model.users.Customer;

import com.online.store.model.review.ReviewStatus;

public class Comment {


    private Customer user;


    private Product product;


    private String text;


    private ReviewStatus status;



    public Comment(Customer user,
                   Product product,
                   String text){


        this.user = user;

        this.product = product;

        this.text = text;

        // هر نظر جدید ابتدا در انتظار تایید است
        this.status = ReviewStatus.PENDING;

    }




    // تایید نظر توسط مدیر

    public void approve(){

        this.status = ReviewStatus.APPROVED;

    }




    // رد نظر توسط مدیر

    public void reject(){

        this.status = ReviewStatus.REJECTED;

    }




    // بررسی تایید بودن نظر

    public boolean isApproved(){

        return status == ReviewStatus.APPROVED;

    }




    // گرفتن وضعیت نظر

    public ReviewStatus getStatus(){

        return status;

    }




    public Customer getUser(){

        return user;

    }





    public Product getProduct(){

        return product;

    }





    public String getText(){

        return text;

    }

}