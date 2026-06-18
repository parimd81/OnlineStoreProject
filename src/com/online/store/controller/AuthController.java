package com.online.store.controller;


import com.online.store.model.users.Buyer;
import com.online.store.model.users.User;
import com.online.store.utils.SessionManager;
import com.online.store.utils.ValidationUtils;

import java.util.ArrayList;
import java.util.List;


public class AuthController {


    private List<User> users;


    public AuthController() {

        users = new ArrayList<>();

    }



    public boolean register(String username,
                            String email,
                            String phone,
                            String password) {


        // بررسی اطلاعات

        if(!ValidationUtils.isValidEmail(email)) {

            System.out.println("Invalid email");
            return false;
        }


        if(!ValidationUtils.isValidPhone(phone)) {

            System.out.println("Invalid phone");
            return false;
        }


        if(!ValidationUtils.isValidPassword(password)) {

            System.out.println("Invalid password");
            return false;
        }



        Buyer buyer =
                new Buyer(
                        username,
                        email,
                        phone,
                        password,
                        0
                );


        users.add(buyer);


        return true;
    }





    public boolean login(String username,
                         String password) {


        for(User user : users) {


            if(user.getUsername().equals(username)
                    &&
                    user.getPassword().equals(password)) {


                SessionManager
                        .getInstance()
                        .setCurrentUser(user);


                return true;
            }
        }


        return false;
    }





    public void logout() {


        SessionManager
                .getInstance()
                .logout();

    }


}