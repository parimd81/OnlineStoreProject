package com.online.store.service;


import com.online.store.model.product.Product;
import com.online.store.model.product.category.Category;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;



public class ProductService {


    private static ProductService instance;


    private List<Product> products;



    private ProductService(){

        products = new ArrayList<>();

    }



    public static ProductService getInstance(){

        if(instance == null){

            instance = new ProductService();

        }

        return instance;

    }



    public boolean addProduct(Product product){


        if(product == null){

            return false;

        }


        if(findById(product.getId()) != null){

            return false;

        }


        products.add(product);

        return true;

    }





    public void removeProduct(Product product){

        products.remove(product);

    }





    public Product findById(int id){


        return products.stream()

                .filter(p -> p.getId() == id)

                .findFirst()

                .orElse(null);

    }






    public List<Product> searchByName(String keyword){


        return products.stream()

                .filter(p ->
                        p.getName()
                                .toLowerCase()
                                .contains(
                                        keyword.toLowerCase()
                                )
                )

                .collect(Collectors.toList());

    }







    public List<Product> filterByCategory(Category category){


        return products.stream()

                .filter(p ->
                        p.getCategory() == category
                )

                .collect(Collectors.toList());

    }






    public List<Product> filterByPriceRange(
            double min,
            double max
    ){


        return products.stream()

                .filter(p ->
                        p.getPrice() >= min
                                &&
                                p.getPrice() <= max
                )

                .collect(Collectors.toList());

    }







    public List<Product> getAllProducts(){

        return new ArrayList<>(products);

    }



}