package com.online.store.model.request;


import com.online.store.model.users.Customer;



public class Request {


    private int id;


    private Customer customer;


    private String description;


    private RequestStatus status;




    public Request(
            int id,
            Customer customer,
            String description
    ){

        this.id=id;

        this.customer=customer;

        this.description=description;

        this.status=RequestStatus.PENDING;

    }





    public void accept(){

        status=RequestStatus.ACCEPTED;

    }





    public void reject(){

        status=RequestStatus.REJECTED;

    }







    public int getId(){

        return id;

    }





    public Customer getCustomer(){

        return customer;

    }





    public String getDescription(){

        return description;

    }





    public RequestStatus getStatus(){

        return status;

    }


}