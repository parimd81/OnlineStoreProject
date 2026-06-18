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


        // ساخت ادمین پیش فرض

        users.add(
                Admin.getInstance(
                        "admin",
                        "admin@store.com",
                        "09123456789",
                        "admin123"
                )
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
                        password,
                        10000
                );



        users.add(buyer);

    }








    // ورود کاربر

    public boolean login(String username,
                         String password) {



        for(User user : users) {



            if(user.getUsername()
                    .equals(username)
                    &&
                    user.getPassword()
                            .equals(password)) {



                currentUser = user;


                return true;

            }

        }



        return false;

    }








    // گرفتن کاربر وارد شده

    public User getCurrentUser() {


        return currentUser;

    }








    // خروج

    public void logout() {


        currentUser = null;

    }



}