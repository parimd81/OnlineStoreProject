package com.online.store.model.product;


import com.online.store.model.product.category.Category;


import java.util.ArrayList;
import java.util.List;



public abstract class Product {


    protected int id;


    protected String name;


    protected double price;


    protected boolean inStock;

    protected int quantity;

    protected Category category;



    protected double averageRating;



    protected List<Comment> comments =
            new ArrayList<>();


    protected List<Rating> ratings =
            new ArrayList<>();





    public Product(int id,
                   String name,
                   double price,
                   int quantity,
                   Category category){


        this.id = id;
        this.name = name;
        this.price = price;

        this.quantity = quantity;
        this.inStock = quantity > 0;

        this.category = category;


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

            sum+=r.getScore();

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

    public int getQuantity(){

        return quantity;

    }



    public void setQuantity(int quantity){


        if(quantity < 0){

            throw new IllegalArgumentException(
                    "Quantity cannot be negative"
            );

        }


        this.quantity = quantity;


        // هماهنگ کردن boolean با quantity

        this.inStock = quantity > 0;


    }



    public Category getCategory(){

        return category;

    }



    public double getAverageRating(){

        return averageRating;

    }



    public List<Comment> getComments(){

        return new ArrayList<>(comments);

    }




    public void setName(String name){

        this.name=name;

    }



    public void setPrice(double price){

        this.price=price;

    }



    public void setInStock(boolean stock){

        this.inStock=stock;

    }

    public void increaseQuantity(int amount){


        if(amount <= 0){

            throw new IllegalArgumentException(
                    "Invalid quantity"
            );

        }


        this.quantity += amount;

        this.inStock = true;


    }



    public void decreaseQuantity(int amount){


        if(amount <= 0){

            throw new IllegalArgumentException(
                    "Invalid quantity"
            );

        }


        if(quantity < amount){

            throw new IllegalStateException(
                    "Not enough stock"
            );

        }


        quantity -= amount;


        inStock = quantity > 0;


    }


}