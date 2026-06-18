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





    public MainView() {


        scanner = new Scanner(System.in);


        authController =
                new AuthController();

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

                    return;



                default:

                    System.out.println(
                            "Wrong choice"
                    );

            }

        }

    }









    private void register() {



        System.out.print("Username: ");

        String username =
                scanner.nextLine();




        System.out.print("Email: ");

        String email =
                scanner.nextLine();




        System.out.print("Phone: ");

        String phone =
                scanner.nextLine();




        System.out.print("Password: ");

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



        System.out.print("Username: ");

        String username =
                scanner.nextLine();





        System.out.print("Password: ");

        String password =
                scanner.nextLine();







        User user =
                authController.getUser(
                        username,
                        password
                );






        if(user == null) {



            System.out.println(
                    "Login failed"
            );


            return;

        }







        System.out.println(
                "Login successful"
        );







        if(user instanceof Admin) {



            System.out.println(
                    "Welcome Admin"
            );



            AdminView adminView =
                    new AdminView(
                            new AdminController()
                    );



            adminView.showMenu();

        }








        else if(user instanceof Buyer) {



            System.out.println(
                    "Welcome Buyer"
            );




            BuyerView buyerView =
                    new BuyerView(
                            (Buyer) user,
                            new ProductController(),
                            new CartController()
                    );



            buyerView.showMenu();

        }


    }


}