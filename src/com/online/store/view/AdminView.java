package com.online.store.view;


import com.online.store.controller.AdminController;

import com.online.store.model.products.Product;
import com.online.store.model.products.digital.FlashMemory;
import com.online.store.model.products.digital.SSD;
import com.online.store.model.products.food.FoodProduct;
import com.online.store.model.products.stationery.Pencil;
import com.online.store.model.products.vehicle.Bicycle;
import com.online.store.model.products.vehicle.Car;


import java.time.LocalDate;
import java.util.Scanner;



public class AdminView {


    private Scanner scanner;

    private AdminController adminController;



    public AdminView(AdminController adminController) {

        scanner = new Scanner(System.in);

        this.adminController = adminController;

    }





    public void showMenu() {


        while (true) {


            System.out.println("\n===== Admin Panel =====");

            System.out.println("1. Show Products");

            System.out.println("2. Add Product");

            System.out.println("3. Remove Product");

            System.out.println("0. Back");


            System.out.print("Choice: ");


            int choice;

            try {

                choice = Integer.parseInt(scanner.nextLine());

            }
            catch(Exception e){

                System.out.println("Invalid input");
                continue;

            }




            switch(choice){


                case 1:

                    showProducts();

                    break;



                case 2:

                    addProduct();

                    break;



                case 3:

                    removeProduct();

                    break;



                case 0:

                    return;



                default:

                    System.out.println("Wrong choice");

            }

        }

    }







    private void showProducts(){


        System.out.println("\n===== Products =====");


        for(Product product :
                adminController.getAllProducts()){


            System.out.println(product);


        }


    }







    private void addProduct(){


        System.out.println("\n===== Add Product =====");


        System.out.println("0. Back");

        System.out.println("1. SSD");

        System.out.println("2. Flash Memory");

        System.out.println("3. Car");

        System.out.println("4. Bicycle");

        System.out.println("5. Pencil");

        System.out.println("6. Food Product");



        System.out.print("Type: ");



        int type;


        try {

            type =
                    Integer.parseInt(scanner.nextLine());

        }
        catch(Exception e){

            System.out.println("Invalid type");
            return;

        }




        if(type == 0){

            return;

        }




        System.out.print("ID: ");

        String id =
                scanner.nextLine();




        System.out.print("Name: ");

        String name =
                scanner.nextLine();




        System.out.print("Price: ");

        double price =
                Double.parseDouble(scanner.nextLine());




        System.out.print("Stock: ");

        int stock =
                Integer.parseInt(scanner.nextLine());




        Product product = null;
        switch(type){


            case 1:


                System.out.print("Brand: ");

                String ssdBrand =
                        scanner.nextLine();



                System.out.print("Capacity GB: ");

                int capacity =
                        Integer.parseInt(scanner.nextLine());



                product =
                        new SSD(
                                id,
                                name,
                                price,
                                stock,
                                ssdBrand,
                                capacity
                        );


                break;




            case 2:


                System.out.print("Brand: ");

                String flashBrand =
                        scanner.nextLine();



                System.out.print("USB Version: ");

                int usb =
                        Integer.parseInt(scanner.nextLine());



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




            case 3:


                System.out.print("Manufacturer: ");

                String manufacturer =
                        scanner.nextLine();



                System.out.print("Engine Capacity: ");

                int engine =
                        Integer.parseInt(scanner.nextLine());



                System.out.print("Automatic (true/false): ");

                boolean automatic =
                        Boolean.parseBoolean(scanner.nextLine());



                product =
                        new Car(
                                id,
                                name,
                                price,
                                stock,
                                manufacturer,
                                engine,
                                automatic
                        );


                break;




            case 4:


                System.out.print("Manufacturer: ");

                String bikeManufacturer =
                        scanner.nextLine();



                System.out.print("Bicycle Type: ");

                String bikeType =
                        scanner.nextLine();



                product =
                        new Bicycle(
                                id,
                                name,
                                price,
                                stock,
                                bikeManufacturer,
                                bikeType
                        );


                break;




            case 5:


                System.out.print("Brand: ");

                String pencilBrand =
                        scanner.nextLine();



                System.out.print("Hardness: ");

                String hardness =
                        scanner.nextLine();



                product =
                        new Pencil(
                                id,
                                name,
                                price,
                                stock,
                                pencilBrand,
                                hardness
                        );


                break;




            case 6:


                System.out.print("Production date (YYYY-MM-DD): ");

                LocalDate production =
                        LocalDate.parse(
                                scanner.nextLine()
                        );



                System.out.print("Expiration date (YYYY-MM-DD): ");

                LocalDate expiration =
                        LocalDate.parse(
                                scanner.nextLine()
                        );



                product =
                        new FoodProduct(
                                id,
                                name,
                                price,
                                stock,
                                production,
                                expiration
                        );


                break;




            default:

                System.out.println("Invalid product type");

                return;

        }




        adminController.addProduct(product);


        System.out.println(
                "Product added successfully"
        );


    }







    private void removeProduct(){


        System.out.print("Enter product ID: ");


        String id =
                scanner.nextLine();




        Product product =
                adminController.findProductById(id);




        if(product == null){


            System.out.println(
                    "Product not found"
            );


            return;

        }





        boolean removed =
                adminController.removeProduct(product);




        if(removed){


            System.out.println(
                    "Product removed"
            );


        }
        else{


            System.out.println(
                    "Remove failed"
            );


        }


    }


}