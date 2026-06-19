package com.online.store.service;



import com.online.store.model.order.Invoice;
import com.online.store.model.product.Product;
import com.online.store.model.users.Customer;


public class OrderService {



    private int invoiceCounter=1;







    public Invoice buyProduct(
            Customer customer,
            Product product
    ){



        Invoice invoice =
                new Invoice(invoiceCounter++);




        invoice.add(product);



        customer.getInvoices()
                .add(invoice);



        return invoice;


    }



}