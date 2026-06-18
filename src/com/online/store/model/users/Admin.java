package com.online.store.model.users;

public class Admin extends User {

    // تنها نمونه موجود از Admin
    private static Admin instance;


    // Constructor خصوصی
    // اجازه نمی‌دهد کسی بیرون کلاس بنویسد:
    // new Admin(...)
    private Admin(String username,
                  String email,
                  String phoneNumber,
                  String password) {

        super(username, email, phoneNumber, password);
    }


    // گرفتن تنها نمونه Admin
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


    @Override
    public String toString() {
        return "Admin{" +
                "username='" + getUsername() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", phoneNumber='" + getPhoneNumber() + '\'' +
                '}';
    }
}