package com.online.store.view;


import com.online.store.controller.AdminController;


import com.online.store.model.products.Product;

import com.online.store.model.products.digital.FlashMemory;
import com.online.store.model.products.digital.SSD;

import com.online.store.model.products.vehicle.Car;
import com.online.store.model.products.vehicle.Bicycle;

import com.online.store.model.products.stationery.Pencil;

import com.online.store.model.products.food.FoodProduct;


import java.time.LocalDate;
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


        System.out.println("3. Car");


        System.out.println("4. Bicycle");


        System.out.println("5. Pencil");


        System.out.println("6. Food Product");


        System.out.print("Choice: ");




        int type =
                scanner.nextInt();


        scanner.nextLine();






        System.out.print("ID: ");

        String id =
                scanner.nextLine();





        System.out.print("Name: ");

        String name =
                scanner.nextLine();





        System.out.print("Price: ");

        double price =
                scanner.nextDouble();





        System.out.print("Stock: ");

        int stock =
                scanner.nextInt();


        scanner.nextLine();





        Product product = null;






        switch(type) {



            case 1:


                System.out.print("Brand: ");

                String brand =
                        scanner.nextLine();




                System.out.print("Capacity GB: ");

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


                System.out.print("Brand: ");

                String flashBrand =
                        scanner.nextLine();




                System.out.print("USB Version: ");

                int usbVersion =
                        scanner.nextInt();


                scanner.nextLine();




                product =
                        new FlashMemory(
                                id,
                                name,
                                price,
                                stock,
                                flashBrand,
                                usbVersion
                        );


                break;








            case 3:


                System.out.print("Manufacturer: ");

                String manufacturer =
                        scanner.nextLine();




                System.out.print("Engine Capacity: ");

                int engineCapacity =
                        scanner.nextInt();




                System.out.print("Automatic (true/false): ");

                boolean automatic =
                        scanner.nextBoolean();


                scanner.nextLine();




                product =
                        new Car(
                                id,
                                name,
                                price,
                                stock,
                                manufacturer,
                                engineCapacity,
                                automatic
                        );


                break;








            case 4:


                System.out.print("Manufacturer: ");

                String bikeManufacturer =
                        scanner.nextLine();




                System.out.print("Bicycle Type: ");

                String bicycleType =
                        scanner.nextLine();




                product =
                        new Bicycle(
                                id,
                                name,
                                price,
                                stock,
                                bikeManufacturer,
                                bicycleType
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


                System.out.println("Production Date");


                System.out.print("Year: ");

                int py =
                        scanner.nextInt();


                System.out.print("Month: ");

                int pm =
                        scanner.nextInt();


                System.out.print("Day: ");

                int pd =
                        scanner.nextInt();



                LocalDate productionDate =
                        LocalDate.of(
                                py,
                                pm,
                                pd
                        );






                System.out.println("Expiration Date");



                System.out.print("Year: ");

                int ey =
                        scanner.nextInt();


                System.out.print("Month: ");

                int em =
                        scanner.nextInt();


                System.out.print("Day: ");

                int ed =
                        scanner.nextInt();


                scanner.nextLine();




                LocalDate expirationDate =
                        LocalDate.of(
                                ey,
                                em,
                                ed
                        );





                product =
                        new FoodProduct(
                                id,
                                name,
                                price,
                                stock,
                                productionDate,
                                expirationDate
                        );


                break;








            default:


                System.out.println(
                        "Invalid product type"
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