package com.online.store.controller;


import com.online.store.model.users.Admin;
import com.online.store.model.users.Buyer;
import com.online.store.model.users.User;


import java.util.ArrayList;
import java.util.List;



public class AuthController {


    private List<User> users;


    private User currentUser;





    public AuthController() {


        users = new ArrayList<>();


        // اضافه کردن ادمین پیش فرض

        users.add(
                Admin.getInstance()
        );

    }





    public void register(String username,
                         String email,
                         String phoneNumber,
                         String password) {



        Buyer buyer =
                new Buyer(
                        username,
                        email,
                        phoneNumber,
                        password,
                        10000
                );


        users.add(buyer);

    }







    public boolean login(String username,
                         String password) {


        User user =
                getUser(username, password);



        if(user != null) {


            currentUser = user;


            return true;

        }



        return false;

    }







    public User getUser(String username,
                        String password) {



        for(User user : users) {



            if(user.getUsername()
                    .equals(username)
                    &&
                    user.getPassword()
                            .equals(password)) {



                return user;

            }

        }



        return null;

    }







    public User getCurrentUser() {


        return currentUser;

    }



}