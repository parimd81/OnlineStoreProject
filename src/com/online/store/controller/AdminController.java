package com.online.store.controller;


import com.online.store.model.product.Comment;
import com.online.store.model.product.Product;
import com.online.store.service.ProductService;
import com.online.store.service.RequestService;




public class AdminController {



    private ProductService productService;

    private RequestService requestService;




    public AdminController(
            ProductService productService,
            RequestService requestService
    ){

        this.productService=productService;

        this.requestService=requestService;

    }






    public void addProduct(Product product){

        productService.addProduct(product);

    }






    public void deleteProduct(int id){

        Product product = productService.findById(id);

        if(product != null){
            productService.removeProduct(product);
        }

    }






    public void approveComment(Comment comment){

        comment.approve();

    }






    public void rejectComment(Comment comment){

        comment.reject();

    }



}