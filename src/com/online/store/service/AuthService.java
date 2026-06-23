package com.online.store.service;


import com.online.store.model.users.Admin;
import com.online.store.model.users.User;

import java.util.ArrayList;
import java.util.List;



public class AuthService {


    private static AuthService instance;


    private List<User> users;


    private User currentUser;



    private AuthService(){


        users = new ArrayList<>();


        users.add(
                Admin.getInstance()
        );


    }




    public static AuthService getInstance(){


        if(instance == null){

            instance = new AuthService();

        }


        return instance;

    }





    public User login(
            String username,
            String password
    ){


        for(User user : users){


            if(user.getUsername().equals(username)
                    &&
                    user.getPassword().equals(password)){


                currentUser = user;

                return user;

            }

        }


        return null;

    }





    public boolean register(User user){


        for(User existingUser : users){


            if(existingUser.getUsername()
                    .equalsIgnoreCase(user.getUsername())){


                return false;

            }


        }



        users.add(user);


        return true;


    }





    public User getCurrentUser(){

        return currentUser;

    }

    public void removeUser(User user){

        users.remove(user);

    }



    public List<User> getUsers(){

        return new ArrayList<>(users);

    }




}

