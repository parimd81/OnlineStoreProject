package com.online.store.view;


import com.online.store.controller.CartController;
import com.online.store.controller.InvoiceController;
import com.online.store.controller.ProductController;

import com.online.store.model.invoices.Invoice;
import com.online.store.model.products.Product;
import com.online.store.model.users.Buyer;


import java.util.List;
import java.util.Scanner;



public class BuyerView {


    private Scanner scanner;

    private Buyer buyer;

    private ProductController productController;

    private CartController cartController;

    private InvoiceController invoiceController;



    public BuyerView(Buyer buyer,
                     ProductController productController,
                     CartController cartController) {


        scanner = new Scanner(System.in);


        this.buyer = buyer;

        this.productController = productController;

        this.cartController = cartController;


        invoiceController = new InvoiceController();

    }






    public void showMenu() {


        while(true) {


            System.out.println("\n===== Buyer Panel =====");


            System.out.println("1. Show Products");

            System.out.println("2. Search Product");

            System.out.println("3. Add Product To Cart");

            System.out.println("4. Show Cart");

            System.out.println("5. Checkout");

            System.out.println("0. Back");



            System.out.print("Choice: ");


            int choice = scanner.nextInt();

            scanner.nextLine();




            switch(choice) {


                case 1:
                    showProducts();
                    break;


                case 2:
                    searchProduct();
                    break;


                case 3:
                    addToCart();
                    break;


                case 4:
                    showCart();
                    break;


                case 5:
                    checkout();
                    break;


                case 0:
                    return;


                default:
                    System.out.println("Wrong choice");

            }

        }

    }






    private void showProducts() {


        List<Product> products =
                productController.getAllProducts();



        System.out.println("\n===== Products =====");



        for(Product product : products) {


            System.out.println(product);

        }

    }







    private void searchProduct() {


        System.out.print("Enter product name: ");

        String name =
                scanner.nextLine();



        List<Product> result =
                productController.searchByName(name);



        if(result.isEmpty()) {


            System.out.println("Product not found");

            return;

        }



        for(Product product : result) {


            System.out.println(product);

        }

    }








    private void addToCart() {


        showProducts();



        System.out.println("0. Back");

        System.out.print("Enter product ID: ");


        String id =
                scanner.nextLine();



        if(id.equals("0")) {

            return;

        }




        Product product =
                productController.findById(id);



        if(product == null) {


            System.out.println("Product not found");

            return;

        }





        System.out.print("Enter quantity: ");


        int quantity =
                scanner.nextInt();


        scanner.nextLine();




        cartController.addToCart(
                buyer,
                product,
                quantity
        );



        System.out.println(
                "Product added to cart"
        );


    }








    private void showCart() {


        System.out.println("\n===== Your Cart =====");


        System.out.println(
                cartController.viewCart(buyer)
        );



        System.out.println(
                "Total Price: "
                        +
                        cartController.calculateTotal(buyer)
        );


    }








    private void checkout() {


        try {


            Invoice invoice =
                    invoiceController.checkout(buyer);



            System.out.println(
                    "Purchase completed successfully"
            );



            System.out.println(invoice);



        }
        catch(RuntimeException e) {


            System.out.println(
                    e.getMessage()
            );

        }


    }


}