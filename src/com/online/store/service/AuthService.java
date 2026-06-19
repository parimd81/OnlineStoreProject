package com.online.store.service;

import com.online.store.model.users.User;

import java.util.ArrayList;
import java.util.List;

public class AuthService {

    private List<User> users = new ArrayList<>();
    private User currentUser;

    public void register(User u) {
        users.add(u);
    }

    public User login(String u, String p) {
        for (User user : users) {
            if (user.getUsername().equals(u)
                    && user.getPassword().equals(p)) {
                currentUser = user;
                return user;
            }
        }
        return null;
    }
}