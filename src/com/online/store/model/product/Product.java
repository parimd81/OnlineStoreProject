package com.online.store.model.product;


import com.online.store.model.product.category.Category;

import java.util.ArrayList;
import java.util.List;



public class Product {


    protected int id;
    protected String name;
    protected double price;
    protected boolean inStock;
    protected Category category;


    protected double averageRating;


    protected List<Comment> comments = new ArrayList<>();

    protected List<Rating> ratings = new ArrayList<>();




    public Product(
            int id,
            String name,
            double price,
            boolean inStock,
            Category category
    ){

        this.id=id;
        this.name=name;
        this.price=price;
        this.inStock=inStock;
        this.category=category;

    }





    public void addComment(Comment comment){

        comments.add(comment);

    }





    public void addRating(Rating rating){

        ratings.add(rating);

        calculateAverageRating();

    }





    private void calculateAverageRating(){


        if(ratings.isEmpty()){

            averageRating=0;
            return;

        }



        double sum=0;


        for(Rating r:ratings){

            sum += r.getScore();

        }



        averageRating =
                sum / ratings.size();


    }





    public int getId(){

        return id;

    }




    public String getName(){

        return name;

    }





    public double getPrice(){

        return price;

    }





    public boolean isInStock(){

        return inStock;

    }





    public Category getCategory(){

        return category;

    }





    public double getAverageRating(){

        return averageRating;

    }


}