package com.online.store.controller;


import com.online.store.model.products.Product;

import java.util.ArrayList;
import java.util.List;


public class ProductController {


    private List<Product> products;



    public ProductController() {

        products = new ArrayList<>();

    }



    // اضافه کردن محصول

    public void addProduct(Product product) {

        products.add(product);

    }



    // حذف محصول

    public boolean removeProduct(Product product) {

        return products.remove(product);

    }



    // گرفتن همه محصولات

    public List<Product> getAllProducts() {

        return products;

    }



    // پیدا کردن محصول با id

    public Product findById(String id) {


        for(Product product : products) {


            if(product.getId().equals(id)) {

                return product;

            }

        }


        return null;
    }



    // جستجو بر اساس نام

    public List<Product> searchByName(String keyword) {


        List<Product> result = new ArrayList<>();


        for(Product product : products) {


            if(product.getName()
                    .toLowerCase()
                    .contains(keyword.toLowerCase())) {


                result.add(product);

            }

        }


        return result;

    }

}