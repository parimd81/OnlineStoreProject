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


        // ساخت Admin پیش فرض

        users.add(
                Admin.getInstance()
        );

    }






    // ثبت نام Buyer

    public void register(String username,
                         String email,
                         String phone,
                         String password) {



        Buyer buyer =
                new Buyer(
                        username,
                        email,
                        phone,
                        password
                );



        users.add(buyer);

    }







    // ورود کاربر

    public boolean login(String username,
                         String password) {



        User user =
                getUser(
                        username,
                        password
                );



        if(user != null) {


            currentUser = user;


            return true;

        }



        return false;

    }








    // پیدا کردن کاربر

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







    // گرفتن کاربر لاگین شده

    public User getCurrentUser() {


        return currentUser;

    }





}