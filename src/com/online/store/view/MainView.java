package com.online.store.view;


import com.online.store.controller.AuthController;


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

                    System.out.println("Wrong choice");

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




        boolean result =
                authController.login(
                        username,
                        password
                );



        if(result)

            System.out.println("Login successful");


        else

            System.out.println("Login failed");

    }

}