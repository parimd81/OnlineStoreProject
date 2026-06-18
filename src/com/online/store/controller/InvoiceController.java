package com.online.store.controller;


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


        // بررسی خالی نبودن سبد

        if (buyer.getCart()
                .getItems()
                .isEmpty()) {


            throw new RuntimeException(
                    "Cart is empty"
            );
        }



        double total =
                buyer.getCart()
                        .getTotalPrice();



        // بررسی موجودی کیف پول

        if (buyer.getWalletBalance() < total) {


            throw new RuntimeException(
                    "Insufficient balance"
            );
        }



        // کم کردن پول از کیف پول

        buyer.setWalletBalance(
                buyer.getWalletBalance() - total
        );



        // ساخت فاکتور

        Invoice invoice =
                new Invoice(
                        invoices.size() + 1,
                        buyer,
                        buyer.getCart().getItems()
                );



        invoices.add(invoice);



        // خالی کردن سبد خرید

        buyer.getCart().clear();



        return invoice;
    }





    public List<Invoice> getAllInvoices() {

        return invoices;

    }

}