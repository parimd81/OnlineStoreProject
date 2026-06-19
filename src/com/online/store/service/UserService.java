package com.online.store.service;


import com.online.store.model.users.User;


import java.util.List;



public class UserService {



    public User findUser(
            List<User> users,
            String username
    ){


        return users.stream()

                .filter(
                        u -> u.getUsername()
                                .equals(username)
                )

                .findFirst()

                .orElse(null);


    }



}