package com.online.store.service;


import com.online.store.model.order.CartItem;
import com.online.store.model.order.Invoice;
import com.online.store.model.product.Product;
import com.online.store.model.users.Customer;



public class OrderService {


    private static OrderService instance;


    private static int nextInvoiceId = 1;





    private OrderService(){

    }





    public static OrderService getInstance(){


        if(instance == null){

            instance = new OrderService();

        }


        return instance;

    }









    public void addToCart(
            Customer customer,
            Product product,
            int quantity
    ){


        if(customer == null || product == null){

            throw new IllegalArgumentException(
                    "Customer or Product cannot be null"
            );

        }





        if(quantity <= 0){

            throw new IllegalArgumentException(
                    "Quantity must be positive"
            );

        }





        if(product.getQuantity() < quantity){


            throw new IllegalStateException(
                    "Not enough product stock"
            );


        }





        CartItem item =
                new CartItem(
                        product,
                        quantity
                );




        customer.addToCart(item);



    }









    public double calculateCartTotal(
            Customer customer
    ){


        if(customer == null){

            throw new IllegalArgumentException(
                    "Customer cannot be null"
            );

        }



        return customer.getCart()
                .getTotalPrice();


    }









    public void checkout(
            Customer customer
    ){



        if(customer == null){

            throw new IllegalArgumentException(
                    "Customer cannot be null"
            );

        }






        if(customer.getCart()
                .getItems()
                .isEmpty()){



            throw new IllegalStateException(
                    "Cart is empty"
            );

        }








        double total =
                calculateCartTotal(customer);







        if(customer.getBalance() < total){


            throw new IllegalStateException(
                    "Insufficient balance"
            );


        }









        customer.getAccount()
                .deductBalance(total);









        Invoice invoice =
                new Invoice(
                        nextInvoiceId++
                );










        for(CartItem item :
                customer.getCart().getItems()){



            Product product =
                    item.getProduct();




            product.decreaseQuantity(
                    item.getQuantity()
            );





            invoice.addItem(item);



        }









        customer.addInvoice(invoice);









        customer.getCart()
                .clear();



    }






}