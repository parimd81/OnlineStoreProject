package com.online.store.view;


import com.online.store.controller.AdminController;
import com.online.store.model.products.Product;


import java.util.List;
import java.util.Scanner;



public class AdminView {


    private Scanner scanner;


    private AdminController adminController;



    public AdminView(AdminController adminController) {


        scanner = new Scanner(System.in);


        this.adminController = adminController;

    }





    public void showMenu() {


        while(true) {


            System.out.println("\n===== Admin Panel =====");


            System.out.println("1. Show Products");


            System.out.println("2. Remove Product");


            System.out.println("3. Logout");


            System.out.print("Choice: ");



            int choice =
                    scanner.nextInt();


            scanner.nextLine();




            switch(choice) {



                case 1:

                    showProducts();

                    break;




                case 2:

                    removeProduct();

                    break;




                case 3:

                    return;




                default:

                    System.out.println(
                            "Wrong choice"
                    );

            }

        }

    }





    private void showProducts() {


        List<Product> products =
                adminController.getProducts();



        if(products.isEmpty()) {


            System.out.println(
                    "No products"
            );


            return;

        }





        for(Product product : products) {


            System.out.println(product);

        }

    }





    private void removeProduct() {


        showProducts();



        System.out.print(
                "Enter product ID: "
        );


        String id =
                scanner.nextLine();




        Product product =
                adminController
                        .getProducts()
                        .stream()
                        .filter(p -> p.getId().equals(id))
                        .findFirst()
                        .orElse(null);




        if(product == null) {


            System.out.println(
                    "Product not found"
            );


            return;

        }





        adminController.removeProduct(product);



        System.out.println(
                "Product removed"
        );

    }


}