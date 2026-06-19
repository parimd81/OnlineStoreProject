package com.online.store.model.ratings;


import com.online.store.model.product.Product;
import com.online.store.model.users.Buyer;


public class Rating {


    private int id;

    private Buyer buyer;

    private Product product;

    private int score;



    public Rating(int id,
                  Buyer buyer,
                  Product product,
                  int score) {


        this.id = id;
        this.buyer = buyer;
        this.product = product;


        if(score < 1 || score > 5) {
            throw new IllegalArgumentException(
                    "Rating score must be between 1 and 5"
            );
        }


        this.score = score;
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



    public int getScore() {
        return score;
    }



    public void setScore(int score) {


        if(score < 1 || score > 5) {

            throw new IllegalArgumentException(
                    "Rating score must be between 1 and 5"
            );
        }


        this.score = score;
    }



    @Override
    public String toString() {

        return "Rating{" +
                "id=" + id +
                ", buyer=" + buyer.getUsername() +
                ", product=" + product.getName() +
                ", score=" + score +
                '}';
    }
}
