package com.online.store.model.request;


import com.online.store.model.users.User;



public class Request {


    private int id;


    private User requester;


    private String description;


    private RequestStatus status;





    public Request(int id,
                   User requester,
                   String description){



        this.id = id;


        this.requester = requester;


        this.description = description;


        this.status =
                RequestStatus.PENDING;


    }






    public void approve(){

        status = RequestStatus.APPROVED;

    }






    public void reject(){

        status = RequestStatus.REJECTED;

    }






    public int getId(){

        return id;

    }






    public User getRequester(){

        return requester;

    }






    public String getDescription(){

        return description;

    }






    public RequestStatus getStatus(){

        return status;

    }






    public void setStatus(RequestStatus status){

        this.status=status;

    }



}