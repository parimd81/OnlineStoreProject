package com.online.store.model.product;


import com.online.store.model.users.Customer;



public class Comment {



    public enum Status{

        PENDING,
        APPROVED,
        REJECTED

    }





    private Customer customer;


    private int productId;


    private String text;


    private Status status =
            Status.PENDING;




    private boolean hasBought;






    public Comment(Customer customer,
                   int productId,
                   String text){



        this.customer=customer;

        this.productId=productId;

        this.text=text;



        this.hasBought =
                customer.hasBoughtProduct(productId);


    }








    public void approve(){

        status=Status.APPROVED;

    }




    public void reject(){

        status=Status.REJECTED;

    }





    public boolean isHasBought(){

        return hasBought;

    }





    public Status getStatus(){

        return status;

    }





    public String getText(){

        return text;

    }



    public int getProductId(){

        return productId;

    }


}