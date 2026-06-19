package com.online.store.model.review;

import com.online.store.model.users.Customer;

public class Review {

    private int id;
    private Customer user;
    private int productId;
    private String text;
    private int rating;
    private ReviewStatus status;

    public Review(int id, Customer user, int productId, String text, int rating) {
        this.id = id;
        this.user = user;
        this.productId = productId;
        this.text = text;
        this.rating = rating;
        this.status = ReviewStatus.PENDING;
    }

    public int getId() { return id; }

    public int getProductId() { return productId; }

    public Customer getUser() { return user; }

    public String getText() { return text; }

    public int getRating() { return rating; }

    public ReviewStatus getStatus() { return status; }

    public void approve() {
        status = ReviewStatus.APPROVED;
    }

    public void reject() {
        status = ReviewStatus.REJECTED;
    }
}