package com.online.store.view;


import com.online.store.controller.CartController;
import com.online.store.controller.ProductController;
import com.online.store.model.products.Product;
import com.online.store.model.users.Buyer;


import java.util.List;
import java.util.Scanner;



public class BuyerView {


    private Scanner scanner;

    private Buyer buyer;

    private ProductController productController;

    private CartController cartController;




    public BuyerView(Buyer buyer,
                     ProductController productController,
                     CartController cartController) {


        scanner = new Scanner(System.in);


        this.buyer = buyer;

        this.productController = productController;

        this.cartController = cartController;

    }





    public void showMenu() {


        while(true) {


            System.out.println("\n===== Buyer Panel =====");


            System.out.println("1. Show Products");

            System.out.println("2. Search Product");

            System.out.println("3. Add Product To Cart");

            System.out.println("4. Show Cart");

            System.out.println("5. Logout");


            System.out.print("Choice: ");



            int choice =
                    scanner.nextInt();


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

                    return;



                default:

                    System.out.println("Wrong choice");

            }

        }

    }





    // نمایش محصولات

    private void showProducts() {


        List<Product> products =
                productController.getAllProducts();



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





    // جستجوی محصول

    private void searchProduct() {


        System.out.print(
                "Enter product name: "
        );


        String name =
                scanner.nextLine();



        List<Product> result =
                productController.searchByName(name);




        if(result.isEmpty()) {


            System.out.println(
                    "Product not found"
            );


            return;

        }




        for(Product product : result) {


            System.out.println(product);

        }

    }





    // اضافه کردن محصول به سبد

    private void addToCart() {



        showProducts();



        System.out.print(
                "Enter product ID: "
        );


        String id =
                scanner.nextLine();




        Product product =
                productController.findById(id);




        if(product == null) {


            System.out.println(
                    "Product not found"
            );


            return;

        }





        System.out.print(
                "Enter quantity: "
        );


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





    // نمایش سبد خرید

    private void showCart() {


        System.out.println(
                "===== Your Cart ====="
        );



        System.out.println(
                cartController.viewCart(buyer)
        );



        System.out.println(
                "Total Price: "
                        +
                        cartController.calculateTotal(buyer)
        );

    }


}