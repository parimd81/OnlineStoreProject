package com.online.store.model.users;

public class Admin extends User {

    private static Admin instance;

    private Admin(String username, String email, String phoneNumber, String password) {
        super(username, email, phoneNumber, password);
    }

    public static Admin getInstance() {
        if (instance == null) {
            instance = new Admin(
                    "admin",
                    "admin@store.com",
                    "09123456789",
                    "Admin123"
            );
        }
        return instance;
    }
}