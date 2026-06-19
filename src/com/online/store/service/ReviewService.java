package com.online.store.service;

import com.online.store.model.product.Comment;
import com.online.store.model.product.Rating;
import com.online.store.model.order.Invoice;
import com.online.store.model.users.Customer;

import java.util.*;

public class ReviewService {

    private List<Comment> comments = new ArrayList<>();
    private List<Rating> ratings = new ArrayList<>();

    // فقط اگر خرید کرده باشد
    private boolean hasBought(Customer c, int productId, List<Invoice> invoices) {
        return invoices.stream()
                .anyMatch(inv -> inv.contains(productId));
    }

    public void addComment(Customer c, Comment comment, List<Invoice> invoices) {

        if (!hasBought(c, comment.getProductId(), invoices)) {
            throw new RuntimeException("Only buyers can comment");
        }

        comments.add(comment);
    }

    public void addRating(Customer c, Rating rating, List<Invoice> invoices) {

        if (!hasBought(c, rating.getProductId(), invoices)) {
            throw new RuntimeException("Only buyers can rate");
        }

        ratings.add(rating);
    }
}