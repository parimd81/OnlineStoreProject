package com.online.store.utils;


public class ValidationUtils {


    private ValidationUtils() {
        // جلوگیری از ساخت object
    }



    public static boolean isValidEmail(String email) {

        String emailRegex =
                "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";


        return email.matches(emailRegex);
    }



    public static boolean isValidPhone(String phone) {

        String phoneRegex =
                "^09\\d{9}$";


        return phone.matches(phoneRegex);
    }



    public static boolean isValidPassword(String password) {


        String passwordRegex =
                "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d).{8,}$";


        return password.matches(passwordRegex);
    }

}