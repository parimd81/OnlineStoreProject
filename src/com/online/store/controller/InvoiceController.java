package com.online.store.controller;


import com.online.store.model.cart.CartItem;
import com.online.store.model.invoices.Invoice;
import com.online.store.model.users.Buyer;


import java.util.ArrayList;
import java.util.List;



public class InvoiceController {


    private List<Invoice> invoices;



    public InvoiceController() {

        invoices = new ArrayList<>();

    }






    public Invoice checkout(Buyer buyer) {



        if(buyer.getCart()
                .getItems()
                .isEmpty()) {


            throw new RuntimeException(
                    "Cart is empty"
            );

        }





        double total =
                buyer.getCart()
                        .getTotalPrice();





        if(buyer.getWalletBalance() < total) {


            throw new RuntimeException(
                    "Insufficient balance"
            );

        }






        // بررسی نهایی موجودی قبل از خرید

        for(CartItem item :
                buyer.getCart().getItems()) {



            if(item.getProduct().getStock()
                    <
                    item.getQuantity()) {


                throw new RuntimeException(
                        "Not enough stock for "
                                +
                                item.getProduct().getName()
                );

            }

        }






        // کم کردن موجودی محصولات

        for(CartItem item :
                buyer.getCart().getItems()) {



            item.getProduct()
                    .setStock(

                            item.getProduct()
                                    .getStock()
                                    -
                                    item.getQuantity()

                    );

        }








        // کم کردن پول

        buyer.setWalletBalance(

                buyer.getWalletBalance()
                        -
                        total

        );








        // ساخت کپی از آیتم های خرید

        List<CartItem> invoiceItems =
                new ArrayList<>();


        for(CartItem item :
                buyer.getCart().getItems()) {


            invoiceItems.add(

                    new CartItem(
                            item.getProduct(),
                            item.getQuantity()
                    )

            );

        }








        Invoice invoice =
                new Invoice(

                        invoices.size()+1,

                        buyer,

                        invoiceItems

                );








        invoices.add(invoice);








        // خالی کردن سبد

        buyer.getCart()
                .clear();







        return invoice;

    }









    public List<Invoice> getAllInvoices() {


        return invoices;

    }



}