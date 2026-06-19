package com.online.store.model.order;


import com.online.store.model.product.Product;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;




public class Invoice {



    private int id;


    private LocalDate date;


    private double total;



    private List<Product> products =
            new ArrayList<>();







    public Invoice(int id){


        this.id=id;


        this.date =
                LocalDate.now();


    }







    public void add(Product product){


        products.add(product);


        total += product.getPrice();


    }








    public boolean containsProduct(int productId){


        return products.stream()
                .anyMatch(product ->
                        product.getId()==productId
                );


    }








    public int getId(){

        return id;

    }





    public LocalDate getDate(){

        return date;

    }





    public double getTotal(){

        return total;

    }





    public List<Product> getProducts(){

        return new ArrayList<>(products);

    }


    public boolean contains(int productId) {
        return false;
    }
}