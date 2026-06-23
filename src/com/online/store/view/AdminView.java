package com.online.store.view;


import com.online.store.model.product.Product;
import com.online.store.model.product.Comment;

import com.online.store.model.product.digital.*;
import com.online.store.model.product.stationery.*;
import com.online.store.model.product.vehicle.*;
import com.online.store.model.product.food.Food;

import com.online.store.model.request.Request;

import com.online.store.model.users.Admin;
import com.online.store.model.users.User;

import com.online.store.service.ProductService;
import com.online.store.service.RequestService;
import com.online.store.service.ReviewService;
import com.online.store.service.UserService;


import java.util.List;
import java.util.Scanner;


public class AdminView {


    private Scanner scanner =
            new Scanner(System.in);


    private Admin admin =
            Admin.getInstance();


    private ProductService productService =
            ProductService.getInstance();


    private RequestService requestService =
            RequestService.getInstance();


    private ReviewService reviewService =
            ReviewService.getInstance();


    private UserService userService =
            UserService.getInstance();


    public void showMenu() {


        while (true) {


            System.out.println("\n========== ADMIN MENU ==========");


            System.out.println("1. Show Products");
            System.out.println("2. Add Product");
            System.out.println("3. Remove Product");
            System.out.println("4. Edit Product");

            System.out.println("5. Show Users");

            System.out.println("6. Show Pending Requests");
            System.out.println("7. Approve Request");
            System.out.println("8. Reject Request");

            System.out.println("9. Show Pending Comments");
            System.out.println("10. Approve Comment");
            System.out.println("11. Reject Comment");

            System.out.println("0. Logout");


            System.out.print("Choice: ");


            int choice = getChoice();


            if (choice == 0) {

                System.out.println("Logging out...");
                return;

            }


            switch (choice) {


                case 1:
                    showProducts();
                    break;


                case 2:
                    addProduct();
                    break;


                case 3:
                    removeProduct();
                    break;


                case 4:
                    editProduct();
                    break;


                case 5:
                    showUsers();
                    break;


                case 6:
                    showRequests();
                    break;


                case 7:
                    approveRequest();
                    break;


                case 8:
                    rejectRequest();
                    break;


                case 9:
                    showComments();
                    break;


                case 10:
                    approveComment();
                    break;


                case 11:
                    rejectComment();
                    break;


                default:

                    System.out.println(
                            "Invalid choice"
                    );

            }

        }

    }


    private int getChoice() {


        while (true) {

            try {

                return Integer.parseInt(
                        scanner.nextLine()
                );


            } catch (Exception e) {

                System.out.print(
                        "Enter a valid number: "
                );

            }

        }

    }


    private void showProducts() {


        List<Product> products =
                productService.getAllProducts();


        System.out.println(
                "\n------ PRODUCTS ------"
        );


        if (products.isEmpty()) {

            System.out.println(
                    "No products available"
            );

            return;

        }

        for (Product p : products) {


            System.out.println("--------------------");


            System.out.println(
                    "ID: " + p.getId()
            );


            System.out.println(
                    "Name: " + p.getName()
            );


            System.out.println(
                    "Price: " + p.getPrice()
            );


            System.out.println(
                    "Category: " + p.getCategory()
            );

            System.out.println(
                    "In Stock: " + p.isInStock()
            );

            System.out.println(
                    "Quantity: " + p.getQuantity()
            );

            System.out.println(
                    "Average Rating: " + p.getAverageRating()
            );

            System.out.println(
                    "Comments Count: " + p.getComments().size()
            );


            if (p instanceof Car car) {


                System.out.println(
                        "Company: "
                                + car.getCompanyName()
                );


                System.out.println(
                        "Engine: "
                                + car.getEngineVolume()
                );


                System.out.println(
                        "Automatic: "
                                + car.isAutomatic()
                );


            } else if (p instanceof Bicycle bicycle) {


                System.out.println(
                        "Company: "
                                + bicycle.getCompanyName()
                );


                System.out.println(
                        "Type: "
                                + bicycle.getType()
                );


            }

        }


    }


    private void addProduct() {


        System.out.print(
                "Name (0 to cancel): "
        );


        String name =
                scanner.nextLine();


        if (name.equals("0")) {

            return;

        }


        System.out.print(
                "Price(0 to cancel): "
        );


        double price =
                getDouble();


        if (price == 0) {

            System.out.println(
                    "Cancelled"
            );

            return;

        }


        System.out.print(
                "ID (0 to cancel): "
        );


        int id =
                getChoice();


        if (id == 0) {

            System.out.println(
                    "Cancelled"
            );

            return;

        }


        System.out.print(
                "Quantity: "
        );


        int quantity =
                getChoice();


        System.out.println(
                "\nChoose Category:"
        );


        System.out.println(
                "1. DIGITAL"
        );


        System.out.println(
                "2. STATIONERY"
        );


        System.out.println(
                "3. VEHICLE"
        );


        System.out.println(
                "4. FOOD"
        );


        System.out.println(
                "0. CANCEL"
        );


        int choice =
                getChoice();


        if (choice == 0) {

            return;

        }


        Product product = null;


        switch (choice) {


            case 1:

                product =
                        addDigital(
                                id,
                                name,
                                price,
                                quantity
                        );

                break;


            case 2:

                product =
                        addStationery(
                                id,
                                name,
                                price,
                                quantity
                        );

                break;


            case 3:

                product =
                        addVehicle(
                                id,
                                name,
                                price,
                                quantity
                        );

                break;


            case 4:


                System.out.print(
                        "Production Date: "
                );


                String pd =
                        scanner.nextLine();


                System.out.print(
                        "Expiration Date: "
                );


                String ed =
                        scanner.nextLine();


                product =
                        new Food(
                                id,
                                name,
                                price,
                                quantity,
                                pd,
                                ed
                        );


                break;


            default:

                System.out.println(
                        "Invalid category"
                );

        }


        if (product != null) {


            boolean result =
                    productService.addProduct(product);


            if (result) {

                System.out.println(
                        "Product added successfully"
                );

            } else {

                System.out.println(
                        "Product ID already exists"
                );

            }


        }


    }


    private Product addDigital(
            int id,
            String name,
            double price,
            int quantity) {


        System.out.println(
                "\nDIGITAL TYPE:"
        );


        System.out.println(
                "1. Computer"
        );


        System.out.println(
                "2. SSD"
        );


        System.out.println(
                "3. USB Flash"
        );


        System.out.println(
                "0. Cancel"
        );


        int type = getChoice();


        if (type == 0) {

            return null;

        }


        System.out.print(
                "Weight: "
        );


        double weight =
                Double.parseDouble(
                        scanner.nextLine()
                );


        System.out.print(
                "Dimension: "
        );


        String dimension =
                scanner.nextLine();



        switch (type) {


            case 1:


                System.out.print(
                        "Processor Model: "
                );


                String processor =
                        scanner.nextLine();



                System.out.print(
                        "RAM: "
                );


                int ram =
                        getChoice();



                System.out.print(
                        "SSD Capacity: "
                );


                int capacity =
                        getChoice();



                System.out.print(
                        "Read Speed: "
                );


                int read =
                        getChoice();



                System.out.print(
                        "Write Speed: "
                );


                int write =
                        getChoice();



                SSD ssd =
                        new SSD(
                                id + 1000,
                                "Internal SSD",
                                0,
                                quantity,
                                weight,
                                dimension,
                                capacity,
                                read,
                                write
                        );



                return new Computer(
                        id,
                        name,
                        price,
                        quantity,
                        weight,
                        dimension,
                        processor,
                        ram,
                        ssd
                );





            case 2:


                System.out.print(
                        "Capacity: "
                );


                int sCapacity =
                        getChoice();



                System.out.print(
                        "Read Speed: "
                );


                int readSpeed =
                        getChoice();



                System.out.print(
                        "Write Speed: "
                );


                int writeSpeed =
                        getChoice();



                return new SSD(
                        id,
                        name,
                        price,
                        quantity,
                        weight,
                        dimension,
                        sCapacity,
                        readSpeed,
                        writeSpeed
                );






            case 3:


                System.out.print(
                        "Capacity: "
                );


                int usbCapacity =
                        getChoice();



                System.out.print(
                        "USB Version: "
                );


                String version =
                        scanner.nextLine();



                return new USBFlash(
                        id,
                        name,
                        price,
                        quantity,
                        weight,
                        dimension,
                        usbCapacity,
                        version
                );





            default:

                return null;

        }


    }

    private Product addStationery(
            int id,
            String name,
            double price,
            int quantity) {


        System.out.println("\nSTATIONERY TYPE:");

        System.out.println("1. Pencil");
        System.out.println("2. Pen");
        System.out.println("3. Notebook");
        System.out.println("0. Cancel");


        int type =
                getChoice();


        if (type == 0) {

            return null;

        }


        System.out.print(
                "Manufacturer: "
        );


        String manufacturer =
                scanner.nextLine();


        switch (type) {


            case 1:


                System.out.println(
                        "1.H 2.HB 3.B 4.F 5.TWO_H"
                );


                int t =
                        getChoice();


                PencilType pencilType;


                switch (t) {


                    case 1:
                        pencilType = PencilType.H;
                        break;


                    case 2:
                        pencilType = PencilType.HB;
                        break;


                    case 3:
                        pencilType = PencilType.B;
                        break;


                    case 4:
                        pencilType = PencilType.F;
                        break;


                    default:
                        pencilType = PencilType.TWO_H;

                }


                return new Pencil(
                        id,
                        name,
                        price,
                        quantity,
                        manufacturer,
                        pencilType
                );


            case 2:


                System.out.print(
                        "Color: "
                );


                String color =
                        scanner.nextLine();


                return new Pen(
                        id,
                        name,
                        price,
                        quantity,
                        manufacturer,
                        color
                );


            case 3:


                System.out.print(
                        "Pages: "
                );


                int pages =
                        getChoice();


                System.out.print(
                        "Paper Type: "
                );


                String paper =
                        scanner.nextLine();


                return new Notebook(
                        id,
                        name,
                        price,
                        quantity,
                        manufacturer,
                        pages,
                        paper
                );


            default:

                return null;

        }


    }









    private Product addVehicle(
            int id,
            String name,
            double price,
            int quantity){



        System.out.println("\nVEHICLE TYPE:");

        System.out.println("1. Car");
        System.out.println("2. Bicycle");
        System.out.println("0. Cancel");



        int type =
                getChoice();



        if(type == 0){

            return null;

        }



        System.out.print(
                "Production Date: "
        );


        String date =
                scanner.nextLine();



        System.out.print(
                "Company Name: "
        );


        String companyName =
                scanner.nextLine();




        switch(type){


            case 1:


                System.out.print(
                        "Engine Volume: "
                );


                double volume =
                        Double.parseDouble(
                                scanner.nextLine()
                        );



                System.out.print(
                        "Automatic(true/false): "
                );


                boolean automatic =
                        Boolean.parseBoolean(
                                scanner.nextLine()
                        );



                return new Car(
                        id,
                        name,
                        price,
                        quantity,
                        date,
                        companyName,
                        volume,
                        automatic
                );





            case 2:


                System.out.println(
                        "1.MOUNTAIN"
                );


                System.out.println(
                        "2.ROAD"
                );


                System.out.println(
                        "3.CITY"
                );


                System.out.println(
                        "4.HYBRID"
                );



                BicycleType bicycleType;



                int b =
                        getChoice();



                switch(b){


                    case 1:
                        bicycleType = BicycleType.MOUNTAIN;
                        break;


                    case 2:
                        bicycleType = BicycleType.ROAD;
                        break;


                    case 3:
                        bicycleType = BicycleType.CITY;
                        break;


                    default:
                        bicycleType = BicycleType.HYBRID;

                }




                return new Bicycle(
                        id,
                        name,
                        price,
                        quantity,
                        date,
                        companyName,
                        bicycleType
                );



            default:

                return null;


        }


    }








    private void removeProduct(){


        System.out.print(
                "Product ID (0 cancel): "
        );


        int id =
                getChoice();



        if(id == 0){

            return;

        }



        Product product =
                productService.findById(id);



        if(product == null){


            System.out.println(
                    "Product not found"
            );


            return;

        }



        productService.removeProduct(product);



        System.out.println(
                "Removed successfully"
        );


    }








    private void editProduct(){


        System.out.print(
                "Product ID (0 cancel): "
        );


        int id =
                getChoice();



        if(id == 0){

            return;

        }



        Product product =
                productService.findById(id);



        if(product == null){


            System.out.println(
                    "Product not found"
            );


            return;

        }



        System.out.print(
                "New Name: "
        );


        product.setName(
                scanner.nextLine()
        );



        System.out.print(
                "New Price: "
        );


        product.setPrice(
                getDouble()
        );



        System.out.println(
                "Product updated successfully"
        );


    }









    private void showUsers(){


        System.out.println(
                "\n------ USERS ------"
        );



        List<User> users =
                userService.getAllUsers();



        for(User user : users){


            System.out.println(
                    user.getUsername()
                            +
                            " | "
                            +
                            user.getRole()
            );


        }


    }








    private void showRequests(){


        List<Request> requests =
                requestService.getPendingRequests();



        System.out.println(
                "\n------ PENDING REQUESTS ------"
        );



        if(requests.isEmpty()){


            System.out.println(
                    "No pending requests"
            );


            return;

        }



        for(int i=0;i<requests.size();i++){


            System.out.println(
                    i +
                            " | "
                            +
                            requests.get(i)
            );


        }


    }








    private void approveRequest(){


        List<Request> requests =
                requestService.getPendingRequests();



        if(requests.isEmpty()){

            System.out.println(
                    "No requests"
            );

            return;

        }



        System.out.print(
                "Request index: "
        );


        int index =
                getChoice();



        if(index < 0 ||
                index >= requests.size()){


            System.out.println(
                    "Invalid index"
            );


            return;

        }



        requestService.approveRequest(
                requests.get(index)
        );



        System.out.println(
                "Approved"
        );


    }








    private void rejectRequest(){


        List<Request> requests =
                requestService.getPendingRequests();



        if(requests.isEmpty()){


            System.out.println(
                    "No requests"
            );


            return;

        }



        System.out.print(
                "Request index: "
        );



        int index =
                getChoice();



        if(index < 0 ||
                index >= requests.size()){


            System.out.println(
                    "Invalid index"
            );


            return;

        }



        requestService.rejectRequest(
                requests.get(index)
        );



        System.out.println(
                "Rejected"
        );


    }








    private void showComments(){


        List<Comment> comments =
                reviewService.getPendingComments();



        System.out.println(
                "\n------ PENDING COMMENTS ------"
        );



        for(int i=0;i<comments.size();i++){


            System.out.println(
                    i +
                            " | "
                            +
                            comments.get(i).getText()
            );


        }


    }








    private void approveComment(){


        List<Comment> comments =
                reviewService.getPendingComments();



        if(comments.isEmpty()){

            System.out.println(
                    "No comments"
            );

            return;

        }



        System.out.print(
                "Comment index: "
        );



        int index =
                getChoice();



        if(index < 0 ||
                index >= comments.size()){


            System.out.println(
                    "Invalid index"
            );


            return;

        }



        reviewService.approveComment(
                admin,
                comments.get(index)
        );



        System.out.println(
                "Approved"
        );


    }








    private void rejectComment(){


        List<Comment> comments =
                reviewService.getPendingComments();



        if(comments.isEmpty()){


            System.out.println(
                    "No comments"
            );


            return;

        }



        System.out.print(
                "Comment index: "
        );


        int index =
                getChoice();



        if(index < 0 ||
                index >= comments.size()){


            System.out.println(
                    "Invalid index"
            );


            return;

        }



        reviewService.rejectComment(
                admin,
                comments.get(index)
        );



        System.out.println(
                "Rejected"
        );


    }

    private double getDouble(){

        while(true){

            try{

                return Double.parseDouble(
                        scanner.nextLine()
                );


            }catch(Exception e){

                System.out.print(
                        "Enter a valid price: "
                );

            }

        }

    }


}