package com.online.store.controller;


import com.online.store.model.users.Admin;
import com.online.store.model.users.Buyer;
import com.online.store.model.users.User;


import java.util.ArrayList;
import java.util.List;



public class AuthController {


    private List<User> users;



    public AuthController() {


        users = new ArrayList<>();


        // اضافه کردن Admin پیش فرض

        users.add(
                Admin.getInstance()
        );

    }






    public void register(String username,
                         String email,
                         String phone,
                         String password) {


        Buyer buyer =
                new Buyer(
                        username,
                        email,
                        phone,
                        password,
                        0
                );


        users.add(buyer);

    }







    public boolean login(String username,
                         String password) {


        for(User user : users) {


            if(user.getUsername()
                    .equals(username)
                    &&
                    user.getPassword()
                            .equals(password)) {


                return true;

            }

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

}