package com.online.store.model.requests;


import com.online.store.enums.RequestStatus;
import com.online.store.model.users.User;

import java.time.LocalDate;


public class Request {


    private int id;

    private User sender;

    private String description;

    private RequestStatus status;

    private LocalDate date;



    public Request(int id,
                   User sender,
                   String description) {


        this.id = id;

        this.sender = sender;

        this.description = description;


        this.status = RequestStatus.PENDING;


        this.date = LocalDate.now();
    }



    public int getId() {
        return id;
    }



    public void setId(int id) {
        this.id = id;
    }



    public User getSender() {
        return sender;
    }



    public void setSender(User sender) {
        this.sender = sender;
    }



    public String getDescription() {
        return description;
    }



    public void setDescription(String description) {
        this.description = description;
    }



    public RequestStatus getStatus() {
        return status;
    }



    public void setStatus(RequestStatus status) {
        this.status = status;
    }



    public LocalDate getDate() {
        return date;
    }



    @Override
    public String toString() {

        return "Request{" +
                "id=" + id +
                ", sender=" + sender.getUsername() +
                ", description='" + description + '\'' +
                ", status=" + status +
                ", date=" + date +
                '}';
    }
}