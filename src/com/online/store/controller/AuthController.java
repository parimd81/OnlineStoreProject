package com.online.store.controller;


import com.online.store.model.users.Buyer;
import com.online.store.model.users.User;

import java.util.ArrayList;
import java.util.List;



public class AuthController {


    private List<User> users;



    private User currentUser;



    public AuthController() {

        users = new ArrayList<>();

    }





    // ثبت نام

    public Buyer register(String username,
                          String email,
                          String phoneNumber,
                          String password) {


        Buyer buyer =
                new Buyer(
                        username,
                        email,
                        phoneNumber,
                        password,
                        0
                );


        users.add(buyer);


        return buyer;

    }





    // ورود

    public boolean login(String username,
                         String password) {


        for(User user : users) {


            if(user.getUsername().equals(username)
                    &&
                    user.getPassword().equals(password)) {


                currentUser = user;


                return true;

            }

        }


        return false;

    }





    // خروج

    public void logout() {


        currentUser = null;

    }





    public User getCurrentUser() {


        return currentUser;

    }





    public List<User> getUsers() {


        return users;

    }

}