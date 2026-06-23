package com.online.store.controller;


import com.online.store.model.users.Admin;
import com.online.store.model.users.Customer;
import com.online.store.model.users.User;


import java.util.ArrayList;
import java.util.List;



public class AuthController {


    private List<User> users =
            new ArrayList<>();


    private User currentUser;



    public AuthController(){


        users.add(Admin.getInstance());


    }






    public Customer registerCustomer(
            String username,
            String email,
            String phone,
            String password
    ){

        // check duplicate username
        for(User user : users){

            if(user.getUsername().equals(username)){

                throw new IllegalArgumentException(
                        "Username already exists"
                );

            }

        }


        Customer customer =
                new Customer(
                        username,
                        email,
                        phone,
                        password
                );


        users.add(customer);


        return customer;

    }







    public boolean login(
            String username,
            String password
    ){


        for(User user : users){


            if(user.getUsername()
                    .equals(username)
                    &&
                    user.getPassword()
                            .equals(password)){


                currentUser=user;

                return true;

            }

        }


        return false;


    }







    public User getCurrentUser(){

        return currentUser;

    }




    public List<User> getUsers(){

        return users;

    }


}