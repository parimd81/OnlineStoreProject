package com.online.store.model.users;


import java.util.regex.Pattern;


public abstract class User {


    protected String username;
    protected String email;
    protected String phoneNumber;
    protected String password;

    protected Role role;


    private static final Pattern EMAIL_REGEX =
            Pattern.compile("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$");


    private static final Pattern PHONE_REGEX =
            Pattern.compile("^09\\d{9}$");


    private static final Pattern PASSWORD_REGEX =
            Pattern.compile("^(?=.*[a-zA-Z])(?=.*[0-9]).{8,}$");



    public enum Role{
        CUSTOMER,
        ADMIN
    }



    public User(String username,
                String email,
                String phoneNumber,
                String password,
                Role role){


        setUsername(username);
        setEmail(email);
        setPhoneNumber(phoneNumber);
        setPassword(password);

        this.role = role;

    }




    public void setUsername(String username){

        this.username=username;

    }



    public void setEmail(String email){

        if(!EMAIL_REGEX.matcher(email).matches())
            throw new IllegalArgumentException("Invalid Email");


        this.email=email;

    }




    public void setPhoneNumber(String phoneNumber){

        if(!PHONE_REGEX.matcher(phoneNumber).matches())
            throw new IllegalArgumentException("Invalid Phone");


        this.phoneNumber=phoneNumber;

    }




    public void setPassword(String password){

        if(!PASSWORD_REGEX.matcher(password).matches())
            throw new IllegalArgumentException("Weak Password");


        this.password=password;

    }



    public String getUsername(){
        return username;
    }



    public String getEmail(){
        return email;
    }



    public String getPhoneNumber(){
        return phoneNumber;
    }



    public String getPassword(){
        return password;
    }



    public Role getRole(){
        return role;
    }

}