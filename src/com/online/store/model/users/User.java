package com.online.store.model.users;

public abstract class User {

    private String username;
    private String email;
    private String phoneNumber;
    private String password;

    public User(String username,
                String email,
                String phoneNumber,
                String password) {

        this.username = username;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.password = password;
    }
}