package com.online.store.utils;


public class ValidationUtils {


    public static boolean isValidEmail(String email) {

        return email != null &&
                email.matches(
                        "^[A-Za-z0-9+_.-]+@(.+)$"
                );

    }



    public static boolean isValidPhone(String phone) {

        return phone != null &&
                phone.matches(
                        "^09\\d{9}$"
                );

    }



    public static boolean isValidPassword(String password) {

        return password != null &&
                password.matches(
                        "^(?=.*[A-Za-z])(?=.*\\d).{6,}$"
                );

    }



    public static boolean isValidUsername(String username) {

        return username != null &&
                username.length() >= 3;

    }

}