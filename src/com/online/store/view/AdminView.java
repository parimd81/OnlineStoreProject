package com.online.store.view;


import com.online.store.controller.AdminController;

import com.online.store.model.products.Product;
import com.online.store.model.products.digital.FlashMemory;
import com.online.store.model.products.digital.SSD;


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


            System.out.println("2. Add Product");


            System.out.println("3. Remove Product");


            System.out.println("4. Logout");


            System.out.print("Choice: ");




            int choice =
                    scanner.nextInt();


            scanner.nextLine();





            switch(choice) {



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
                    "No products available"
            );


            return;

        }





        for(Product product : products) {


            System.out.println(product);

        }

    }









    private void addProduct() {


        System.out.println("\n===== Add Product =====");


        System.out.println("1. SSD");


        System.out.println("2. Flash Memory");


        System.out.print("Choice: ");



        int type =
                scanner.nextInt();


        scanner.nextLine();






        System.out.print(
                "ID: "
        );


        String id =
                scanner.nextLine();





        System.out.print(
                "Name: "
        );


        String name =
                scanner.nextLine();





        System.out.print(
                "Price: "
        );


        double price =
                scanner.nextDouble();





        System.out.print(
                "Stock: "
        );


        int stock =
                scanner.nextInt();


        scanner.nextLine();





        Product product = null;






        switch(type) {



            case 1:



                System.out.print(
                        "Brand: "
                );


                String brand =
                        scanner.nextLine();




                System.out.print(
                        "Capacity GB: "
                );


                int capacity =
                        scanner.nextInt();


                scanner.nextLine();





                product =
                        new SSD(
                                id,
                                name,
                                price,
                                stock,
                                brand,
                                capacity
                        );


                break;







            case 2:



                System.out.print(
                        "Brand: "
                );


                String flashBrand =
                        scanner.nextLine();




                System.out.print(
                        "USB Version: "
                );


                int usb =
                        scanner.nextInt();


                scanner.nextLine();





                product =
                        new FlashMemory(
                                id,
                                name,
                                price,
                                stock,
                                flashBrand,
                                usb
                        );


                break;







            default:

                System.out.println(
                        "Wrong type"
                );

                return;

        }







        adminController.addProduct(product);



        System.out.println(
                "Product added successfully"
        );

    }









    private void removeProduct() {


        showProducts();



        System.out.print(
                "Enter product ID: "
        );


        String id =
                scanner.nextLine();




        Product product =
                adminController.findProductById(id);




        if(product == null) {


            System.out.println(
                    "Product not found"
            );


            return;

        }





        adminController.removeProduct(product);



        System.out.println(
                "Product removed successfully"
        );

    }


}