package com.online.store.service;


import com.online.store.model.users.User;

import java.util.List;



public class UserService {


    private static UserService instance;



    private AuthService authService;



    private UserService(){

        authService = AuthService.getInstance();

    }





    public static UserService getInstance(){


        if(instance == null){

            instance = new UserService();

        }


        return instance;

    }






    public boolean addUser(User user){

        return authService.register(user);

    }






    public User findUser(String username){


        for(User user : authService.getUsers()){


            if(user.getUsername()
                    .equals(username)){


                return user;

            }

        }


        return null;

    }






    public List<User> getAllUsers(){


        return authService.getUsers();

    }






    public void removeUser(User user){

        authService.removeUser(user);

    }



}