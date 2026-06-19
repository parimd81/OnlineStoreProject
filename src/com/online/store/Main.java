package com.online.store;


import com.online.store.controller.AuthController;
import com.online.store.service.CommentService;
import com.online.store.service.OrderService;
import com.online.store.service.ProductService;
import com.online.store.service.RatingService;

import com.online.store.model.product.digital.SSD;

public class Main {



    public static void main(String[] args) {



        System.out.println(
                "===== Online Store System ====="
        );



        // Authentication

        AuthController auth =
                new AuthController();




        var customer =
                auth.registerCustomer(
                        "parnian",
                        "parnian@gmail.com",
                        "09123456789",
                        "Password123"
                );




        boolean login =
                auth.login(
                        "parnian",
                        "Password123"
                );



        System.out.println(
                "Login : " + login
        );




        // Services


        ProductService productService =
                new ProductService();



        OrderService orderService =
                new OrderService();



        CommentService commentService =
                new CommentService();



        RatingService ratingService =
                new RatingService();




        // Create Product


        SSD ssd =
                new SSD(
                        1,
                        "Samsung SSD",
                        500,
                        true,
                        0.1,
                        "10x5",
                        512,
                        3500,
                        3000
                );




        productService.addProduct(ssd);



        System.out.println(
                "Product Added : "
                        +
                        ssd.getName()
        );




        // Buy Product


        orderService.buyProduct(
                customer,
                ssd
        );



        System.out.println(
                "Product Purchased"
        );





        // Add Comment


        commentService.addComment(
                customer,
                ssd,
                "Very good SSD"
        );



        System.out.println(
                "Comment Added"
        );






        // Add Rating


        ratingService.addRating(
                customer,
                ssd,
                5
        );



        System.out.println(
                "Rating Added"
        );





        System.out.println(
                "Average Rating : "
                        +
                        ssd.getAverageRating()
        );




        System.out.println(
                "===== Finished ====="
        );


    }

}