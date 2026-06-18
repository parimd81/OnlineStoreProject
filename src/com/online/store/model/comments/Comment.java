package com.online.store.model.comments;


import com.online.store.enums.CommentStatus;
import com.online.store.model.products.Product;
import com.online.store.model.users.Buyer;


import java.time.LocalDate;


public class Comment {


    private int id;

    private Buyer buyer;

    private Product product;

    private String text;

    private CommentStatus status;

    private LocalDate date;



    public Comment(int id,
                   Buyer buyer,
                   Product product,
                   String text) {


        this.id = id;
        this.buyer = buyer;
        this.product = product;
        this.text = text;

        this.status = CommentStatus.PENDING;

        this.date = LocalDate.now();
    }



    public int getId() {
        return id;
    }



    public void setId(int id) {
        this.id = id;
    }



    public Buyer getBuyer() {
        return buyer;
    }



    public void setBuyer(Buyer buyer) {
        this.buyer = buyer;
    }



    public Product getProduct() {
        return product;
    }



    public void setProduct(Product product) {
        this.product = product;
    }



    public String getText() {
        return text;
    }



    public void setText(String text) {
        this.text = text;
    }



    public CommentStatus getStatus() {
        return status;
    }



    public void setStatus(CommentStatus status) {
        this.status = status;
    }



    public LocalDate getDate() {
        return date;
    }



    @Override
    public String toString() {

        return "Comment{" +
                "id=" + id +
                ", buyer=" + buyer.getUsername() +
                ", product=" + product.getName() +
                ", text='" + text + '\'' +
                ", status=" + status +
                '}';
    }
}