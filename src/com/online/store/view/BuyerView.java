package com.online.store.view;


import com.online.store.model.order.Invoice;
import com.online.store.model.product.Product;
import com.online.store.model.users.Customer;
import com.online.store.service.OrderService;
import com.online.store.service.ProductService;
import com.online.store.service.ReviewService;
import com.online.store.model.order.CartItem;

import java.util.List;
import java.util.Scanner;


public class BuyerView {


    private Customer customer;

    private Scanner scanner = new Scanner(System.in);


    private ProductService productService =
            ProductService.getInstance();


    private OrderService orderService =
            OrderService.getInstance();


    private ReviewService reviewService =
            ReviewService.getInstance();



    public BuyerView(Customer customer){

        this.customer = customer;

    }



    public void showMenu(){


        while(true){


            System.out.println("\n========== BUYER MENU ==========");
            System.out.println("1. Show Products");
            System.out.println("2. Search Product");
            System.out.println("3. Filter Product By Price");
            System.out.println("4. Add Product To Cart");
            System.out.println("5. Show Cart");
            System.out.println("6. Recharge Account");
            System.out.println("7. Checkout");
            System.out.println("8. Purchase History");
            System.out.println("9. Add Comment");
            System.out.println("10. Add Rating");
            System.out.println("0. Logout");
            System.out.println("11. Show Account Information");


            System.out.print("Choice: ");

            int choice =
                    scanner.nextInt();



            switch(choice){


                case 1:
                    showProducts();
                    break;


                case 2:
                    searchProduct();
                    break;


                case 3:
                    filterProduct();
                    break;


                case 4:
                    addToCart();
                    break;


                case 5:
                    showCart();
                    break;


                case 6:
                    recharge();
                    break;


                case 7:
                    checkout();
                    break;


                case 8:
                    showInvoices();
                    break;


                case 9:
                    addComment();
                    break;


                case 10:
                    addRating();
                    break;

                case 11:
                    showAccountInfo();
                    break;


                case 0:
                    return;


                default:
                    System.out.println("Invalid option");

            }

        }

    }




    private void showProducts(){


        List<Product> products =
                productService.getAllProducts();



        System.out.println("\n------ PRODUCTS ------");


        for(Product p : products){

            System.out.println(
                    "ID: " + p.getId()
                            +
                            " | Name: " + p.getName()
                            +
                            " | Price: " + p.getPrice()
                            +
                            " | Category: " + p.getCategory()
                            +
                            " | Quantity: " + p.getQuantity()
                            +
                            " | In Stock: " + p.isInStock()
                            +
                            " | Rating: " + p.getAverageRating()
            );

        }

    }





    private void searchProduct(){


        scanner.nextLine();


        System.out.print("Enter name: ");

        String name =
                scanner.nextLine();



        List<Product> result =
                productService.searchByName(name);



        for(Product p : result){

            System.out.println(
                    p.getId()
                            +
                            " - "
                            +
                            p.getName()
            );

        }


    }





    private void filterProduct(){


        System.out.print("Minimum price: ");

        double min =
                scanner.nextDouble();



        System.out.print("Maximum price: ");

        double max =
                scanner.nextDouble();



        List<Product> result =
                productService.filterByPriceRange(min,max);



        for(Product p : result){


            System.out.println(
                    p.getName()
                            +
                            " : "
                            +
                            p.getPrice()
            );

        }

    }




    private void addToCart(){


        try{


            System.out.print("Product ID: ");

            int id =
                    scanner.nextInt();



            Product product =
                    productService.findById(id);



            if(product == null){

                System.out.println(
                        "Product not found"
                );

                return;

            }



            System.out.print("Quantity: ");

            int quantity =
                    scanner.nextInt();



            orderService.addToCart(
                    customer,
                    product,
                    quantity
            );



            System.out.println(
                    "Added to cart successfully"
            );


        }
        catch(Exception e){


            System.out.println(
                    e.getMessage()
            );


        }


    }







    private void showCart(){



        System.out.println("\n------ CART ------");



        List<CartItem> items =
                customer.getCart().getItems();



        if(items.isEmpty()){

            System.out.println("Cart is empty");

            return;

        }



        for(CartItem item : items){


            System.out.println(
                    item.getProduct().getName()
                            +
                            " | Quantity: "
                            +
                            item.getQuantity()
                            +
                            " | Total: "
                            +
                            item.getTotalPrice()
            );

        }



        System.out.println(
                "Total : "
                        +
                        orderService.calculateCartTotal(customer)
        );


    }







    private void recharge(){


        try{


            System.out.print("Amount: ");


            double amount =
                    scanner.nextDouble();



            customer.getAccount().recharge(amount);



            System.out.printf(
                    "%.0f%n",
                    customer.getBalance()
            );


        }
        catch(Exception e){


            System.out.println(
                    e.getMessage()
            );


        }


    }







    private void checkout(){



        try{


            orderService.checkout(customer);


            System.out.println(
                    "Purchase completed successfully"
            );


        }
        catch(Exception e){


            System.out.println(
                    e.getMessage()
            );

        }

    }







    private void showInvoices(){



        List<Invoice> invoices =
                customer.getInvoices();



        System.out.println(
                "------ PURCHASE HISTORY ------"
        );



        for(Invoice invoice : invoices){


            System.out.println(
                    "Invoice ID : "
                            +
                            invoice.getId()
                            +
                            " | Total : "
                            +
                            invoice.getTotal()
            );

        }

    }







    private void addComment(){

        try{

            System.out.print("Product ID: ");

            int id = scanner.nextInt();

            scanner.nextLine();

            Product product =
                    productService.findById(id);

            if(product == null){

                System.out.println("Product not found");
                return;

            }

            System.out.print("Comment: ");

            String text =
                    scanner.nextLine();

            reviewService.addComment(
                    customer,
                    product,
                    text
            );

            System.out.println(
                    "Comment submitted"
            );

        }
        catch(Exception e){

            System.out.println(
                    e.getMessage()
            );

        }

    }







    private void addRating(){

        try{

            System.out.print("Product ID: ");

            int id =
                    scanner.nextInt();

            Product product =
                    productService.findById(id);

            if(product == null){

                System.out.println("Product not found");
                return;

            }

            System.out.print("Score (1-5): ");

            int score =
                    scanner.nextInt();

            reviewService.addRating(
                    customer,
                    product,
                    score
            );

            System.out.println(
                    "Rating added successfully"
            );

        }
        catch(Exception e){

            System.out.println(
                    e.getMessage()
            );

        }

    }

    private void showAccountInfo(){


        System.out.println("\n------ ACCOUNT INFORMATION ------");


        System.out.println(
                "Username: "
                        +
                        customer.getUsername()
        );


        System.out.println(
                "Email: "
                        +
                        customer.getEmail()
        );


        System.out.println(
                "Phone: "
                        +
                        customer.getPhone()
        );


        System.out.println(
                "Balance: "
                        +
                        customer.getBalance()
        );


        System.out.println(
                "Invoices Count: "
                        +
                        customer.getInvoices().size()
        );


        System.out.println(
                "Cart Items: "
                        +
                        customer.getCart()
                                .getItems()
                                .size()
        );


    }


}