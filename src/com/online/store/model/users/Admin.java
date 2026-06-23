package com.online.store.model.users;



import com.online.store.model.product.Comment;
import com.online.store.model.product.Product;
import com.online.store.model.request.Request;
import com.online.store.service.ProductService;
import com.online.store.service.RequestService;
import com.online.store.service.ReviewService;



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


        if(instance==null){

            instance=new Admin();

        }


        return instance;

    }







    public void addProduct(Product product){


        ProductService
                .getInstance()
                .addProduct(product);


    }







    public void removeProduct(Product product){


        ProductService
                .getInstance()
                .removeProduct(product);


    }







    public void approveRequest(Request request){


        RequestService
                .getInstance()
                .approveRequest(request);


    }







    public void rejectRequest(Request request){


        RequestService
                .getInstance()
                .rejectRequest(request);


    }







    public void approveComment(Comment comment){


        ReviewService
                .getInstance()
                .approveComment(this,comment);


    }


}