package com.online.store.view;


import java.util.Scanner;


public class MainView {


    private Scanner scanner;



    public MainView() {

        scanner = new Scanner(System.in);

    }




    public void showMenu() {


        while(true) {


            System.out.println("====================");

            System.out.println(" Online Store ");

            System.out.println("====================");


            System.out.println("1. Register");

            System.out.println("2. Login");

            System.out.println("3. Exit");


            System.out.print("Choose: ");



            int choice =
                    scanner.nextInt();



            switch(choice) {


                case 1:

                    System.out.println("Register selected");

                    break;



                case 2:

                    System.out.println("Login selected");

                    break;



                case 3:

                    System.out.println("Goodbye");

                    return;



                default:

                    System.out.println("Invalid choice");

            }

        }

    }

}