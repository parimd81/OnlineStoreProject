package com.online.store.service;


import com.online.store.model.product.Product;

import java.util.ArrayList;
import java.util.List;



public class ProductService {


    private List<Product> products =
            new ArrayList<>();






    public void addProduct(Product product){

        products.add(product);

    }






    public void removeProduct(int id){


        products.removeIf(
                p -> p.getId()==id
        );


    }







    public Product findById(int id){


        return products.stream()
                .filter(p -> p.getId()==id)
                .findFirst()
                .orElse(null);


    }







    public List<Product> getAllProducts(){

        return products;

    }


}