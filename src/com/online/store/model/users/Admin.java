package com.online.store.model.users;



public class Admin extends User {


    private static Admin instance;



    private Admin(){

        super(
                "admin",
                "admin@store.com",
                "09120000000",
                "Admin123",
                Role.ADMIN
        );

    }




    public static Admin getInstance(){


        if(instance==null)
            instance=new Admin();


        return instance;

    }


}