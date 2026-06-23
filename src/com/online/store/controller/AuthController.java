package com.online.store.controller;


import com.online.store.model.request.Request;
import com.online.store.model.request.RequestManager;
import com.online.store.model.users.Admin;
import com.online.store.model.users.Customer;
import com.online.store.model.users.User;


import java.util.ArrayList;
import java.util.List;



public class AuthController {


    private List<User> users =
            new ArrayList<>();


    private RequestManager requestManager =
            new RequestManager();



    private int nextRequestId = 1;



    private User currentUser;




    public AuthController(){


        users.add(
                Admin.getInstance()
        );


    }









    public Customer registerCustomer(
            String username,
            String email,
            String phone,
            String password
    ){



        // check duplicate username

        for(User user : users){


            if(user.getUsername()
                    .equals(username)){


                throw new IllegalArgumentException(
                        "Username already exists"
                );


            }


        }





        Customer customer =
                new Customer(
                        username,
                        email,
                        phone,
                        password
                );






        // ساخت درخواست ثبت نام

        Request request =
                new Request(
                        nextRequestId++,
                        customer,
                        "New customer registration"
                );



        requestManager.addRequest(request);





        // فعلاً برای تست نگه می‌داریم
        // بعد از approve باید اضافه شود

        users.add(customer);




        return customer;


    }









    public boolean login(
            String username,
            String password
    ){



        for(User user : users){


            if(user.getUsername()
                    .equals(username)
                    &&
                    user.getPassword()
                            .equals(password)){



                currentUser = user;


                return true;


            }


        }



        return false;


    }








    public User getCurrentUser(){


        return currentUser;


    }









    public List<User> getUsers(){


        return users;


    }








    public RequestManager getRequestManager(){


        return requestManager;


    }



}