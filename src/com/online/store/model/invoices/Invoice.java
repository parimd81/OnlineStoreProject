package com.online.store.model.invoices;


import com.online.store.model.cart.CartItem;
import com.online.store.model.users.Buyer;

import java.time.LocalDate;
import java.util.List;


public class Invoice {


    private int invoiceId;

    private Buyer buyer;

    private List<CartItem> items;

    private double totalAmount;

    private LocalDate date;



    public Invoice(int invoiceId,
                   Buyer buyer,
                   List<CartItem> items) {


        this.invoiceId = invoiceId;

        this.buyer = buyer;

        this.items = items;

        this.date = LocalDate.now();


        calculateTotal();
    }



    private void calculateTotal() {


        totalAmount = 0;


        for (CartItem item : items) {

            totalAmount += item.getTotalPrice();

        }
    }



    public int getInvoiceId() {

        return invoiceId;
    }



    public void setInvoiceId(int invoiceId) {

        this.invoiceId = invoiceId;
    }



    public Buyer getBuyer() {

        return buyer;
    }



    public void setBuyer(Buyer buyer) {

        this.buyer = buyer;
    }



    public List<CartItem> getItems() {

        return items;
    }



    public void setItems(List<CartItem> items) {

        this.items = items;

        calculateTotal();
    }



    public double getTotalAmount() {

        return totalAmount;
    }



    public LocalDate getDate() {

        return date;
    }



    @Override
    public String toString() {

        return "Invoice{" +
                "invoiceId=" + invoiceId +
                ", buyer=" + buyer.getUsername() +
                ", totalAmount=" + totalAmount +
                ", date=" + date +
                '}';
    }
}