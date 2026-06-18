package com.online.store.model.users;


public class Admin extends User {


    private static Admin instance;



    private Admin(String username,
                  String email,
                  String phoneNumber,
                  String password) {


        super(username, email, phoneNumber, password);

    }





    public static Admin getInstance() {


        if(instance == null) {


            instance =
                    new Admin(
                            "admin",
                            "admin@gmail.com",
                            "0000000000",
                            "admin123"
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