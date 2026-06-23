package com.online.store.model.order;


import java.time.LocalDate;

import java.util.ArrayList;

import java.util.List;



public class Invoice {



    private int id;


    private LocalDate date;


    private double total;


    private List<CartItem> items;





    public Invoice(int id){


        this.id=id;

        this.date=LocalDate.now();

        this.items=new ArrayList<>();


    }







    public void addItem(CartItem item){


        items.add(item);


        total += item.getTotalPrice();


    }








    public boolean containsProduct(int productId){



        return items.stream()

                .anyMatch(item ->

                        item.getProduct()
                                .getId()
                                ==
                                productId

                );


    }








    public int getId(){

        return id;

    }





    public LocalDate getDate(){

        return date;

    }





    public double getTotal(){

        return total;

    }





    public List<CartItem> getItems(){

        return new ArrayList<>(items);

    }


}