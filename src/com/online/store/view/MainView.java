package com.online.store.view;


import com.online.store.model.users.Customer;
import com.online.store.model.users.Role;
import com.online.store.model.users.User;
import com.online.store.service.UserService;

import com.online.store.service.AuthService;


import java.util.Scanner;



public class MainView {



    private Scanner scanner =
            new Scanner(System.in);



    private AuthService authService =
            AuthService.getInstance();






    public void start(){


        while(true){



            System.out.println("\n========== ONLINE STORE ==========");

            System.out.println("1. Login");
            System.out.println("2. Register");
            System.out.println("0. Exit");


            System.out.print("Choice: ");


            int choice =
                    scanner.nextInt();




            switch(choice){


                case 1:

                    login();

                    break;



                case 2:

                    register();

                    break;



                case 0:

                    System.out.println(
                            "Goodbye"
                    );

                    return;



                default:

                    System.out.println(
                            "Invalid option"
                    );


            }


        }


    }









    private void login(){



        scanner.nextLine();



        System.out.print("Username: ");

        String username =
                scanner.nextLine();



        System.out.print("Password: ");

        String password =
                scanner.nextLine();





        User user =
                authService.login(
                        username,
                        password
                );




        if(user == null){


            System.out.println(
                    "Wrong username or password"
            );


            return;


        }




        System.out.println(
                "Login successful"
        );



        openPanel(user);



    }









    private void register(){



        scanner.nextLine();



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






        try {



            Customer customer =
                    new Customer(
                            username,
                            email,
                            phone,
                            password
                    );




            boolean registered =
                    authService.register(customer);


            if(registered){


                UserService.getInstance()
                        .addUser(customer);


                System.out.println(
                        "Register completed"
                );


            }
            else{


                System.out.println(
                        "Username already exists"
                );


            }





        }
        catch(IllegalArgumentException e){


            System.out.println(
                    e.getMessage()
            );


        }



    }









    private void openPanel(User user){



        if(user.getRole()
                == Role.ADMIN){



            AdminView adminView =
                    new AdminView();



            adminView.showMenu();



        }



        else if(user.getRole()
                == Role.CUSTOMER){



            BuyerView buyerView =
                    new BuyerView(
                            (Customer) user
                    );



            buyerView.showMenu();



        }



    }




}