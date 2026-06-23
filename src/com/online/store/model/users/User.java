package com.online.store.model.users;


import com.online.store.utils.ValidationUtils;


public abstract class User {


    protected String username;

    protected String email;

    protected String phone;

    protected String password;

    protected Role role;



    public User(String username,
                String email,
                String phone,
                String password,
                Role role) {


        setUsername(username);
        setEmail(email);
        setPhone(phone);
        setPassword(password);

        this.role = role;

    }




    public String getUsername() {
        return username;
    }



    public void setUsername(String username) {

        if(username == null || username.isEmpty()){

            throw new IllegalArgumentException(
                    "Username cannot be empty"
            );

        }

        this.username = username;

    }




    public String getEmail() {
        return email;
    }



    public void setEmail(String email) {


        if(!ValidationUtils.isValidEmail(email)){

            throw new IllegalArgumentException(
                    "Invalid email format"
            );

        }


        this.email = email;

    }





    public String getPhone() {
        return phone;
    }



    public void setPhone(String phone) {


        if(!ValidationUtils.isValidPhone(phone)){


            throw new IllegalArgumentException(
                    "Invalid phone number"
            );


        }


        this.phone = phone;

    }






    public String getPassword() {
        return password;
    }


    public void setPassword(String password) {

        if(!ValidationUtils.isValidPassword(password)){

            throw new IllegalArgumentException(
                    "Invalid password format"
            );

        }

        this.password = password;

    }






    public Role getRole() {

        return role;

    }



}