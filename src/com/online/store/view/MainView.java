package com.online.store.view;


import com.online.store.controller.AdminController;
import com.online.store.controller.AuthController;
import com.online.store.controller.CartController;
import com.online.store.controller.ProductController;


import com.online.store.model.users.Admin;
import com.online.store.model.users.Buyer;
import com.online.store.model.users.User;


import java.util.Scanner;



public class MainView {


    private Scanner scanner;


    private AuthController authController;


    // کنترلر مشترک محصولات برای کل برنامه
    private ProductController productController;





    public MainView() {


        scanner = new Scanner(System.in);



        authController =
                new AuthController();



        // فقط یک نمونه از ProductController
        productController =
                new ProductController();

    }







    public void showMenu() {


        while(true) {


            System.out.println("\n===== Online Store =====");


            System.out.println("1. Register");


            System.out.println("2. Login");


            System.out.println("3. Exit");


            System.out.print("Choice: ");




            int choice =
                    scanner.nextInt();



            scanner.nextLine();





            switch(choice) {



                case 1:

                    register();

                    break;





                case 2:

                    login();

                    break;





                case 3:

                    System.out.println(
                            "Goodbye"
                    );

                    return;





                default:

                    System.out.println(
                            "Wrong choice"
                    );

            }

        }

    }








    private void register() {


        System.out.print(
                "Username: "
        );


        String username =
                scanner.nextLine();




        System.out.print(
                "Email: "
        );


        String email =
                scanner.nextLine();




        System.out.print(
                "Phone: "
        );


        String phone =
                scanner.nextLine();




        System.out.print(
                "Password: "
        );


        String password =
                scanner.nextLine();





        authController.register(
                username,
                email,
                phone,
                password
        );




        System.out.println(
                "Register successful"
        );

    }









    private void login() {


        System.out.print(
                "Username: "
        );


        String username =
                scanner.nextLine();





        System.out.print(
                "Password: "
        );


        String password =
                scanner.nextLine();






        boolean result =
                authController.login(
                        username,
                        password
                );






        if(result) {



            System.out.println(
                    "Login successful"
            );




            User user =
                    authController.getCurrentUser();








            if(user instanceof Buyer) {



                BuyerView buyerView =
                        new BuyerView(
                                (Buyer) user,

                                productController,

                                new CartController()
                        );



                buyerView.showMenu();

            }









            else if(user instanceof Admin) {




                AdminView adminView =
                        new AdminView(

                                new AdminController(
                                        productController
                                )

                        );



                adminView.showMenu();

            }



        }

        else {



            System.out.println(
                    "Login failed"
            );

        }


    }



}