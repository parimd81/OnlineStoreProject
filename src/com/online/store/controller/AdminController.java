package com.online.store.controller;


import com.online.store.model.products.Product;


import java.util.List;



public class AdminController {



    private ProductController productController;





    public AdminController(ProductController productController) {


        this.productController =
                productController;

    }







    // اضافه کردن محصول

    public void addProduct(Product product) {


        productController.addProduct(product);

    }







    // حذف محصول

    public boolean removeProduct(Product product) {


        return productController.removeProduct(product);

    }







    // گرفتن همه محصولات

    public List<Product> getAllProducts() {


        return productController.getAllProducts();

    }







    // پیدا کردن محصول

    public Product findProductById(String id) {


        return productController.findById(id);

    }



}