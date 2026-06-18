package com.online.store.controller;


import com.online.store.model.products.Product;
import com.online.store.model.products.digital.FlashMemory;
import com.online.store.model.products.digital.SSD;


import java.util.ArrayList;
import java.util.List;



public class ProductController {


    private List<Product> products;



    public ProductController() {


        products = new ArrayList<>();


        loadSampleProducts();

    }





    // اضافه کردن محصول جدید

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





    // پیدا کردن محصول با ID

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


        List<Product> result =
                new ArrayList<>();


        for(Product product : products) {


            if(product.getName()
                    .toLowerCase()
                    .contains(keyword.toLowerCase())) {


                result.add(product);

            }

        }


        return result;

    }





    // فیلتر قیمت

    public List<Product> filterByPrice(double min,
                                       double max) {


        List<Product> result =
                new ArrayList<>();


        for(Product product : products) {


            if(product.getPrice() >= min
                    &&
                    product.getPrice() <= max) {


                result.add(product);

            }

        }


        return result;

    }





    // نمایش کالاهای موجود

    public List<Product> filterAvailableProducts() {


        List<Product> result =
                new ArrayList<>();


        for(Product product : products) {


            if(product.getStock() > 0) {


                result.add(product);

            }

        }


        return result;

    }





    // اضافه کردن محصولات اولیه برای تست

    private void loadSampleProducts() {



        Product ssd =
                new SSD(
                        "1",
                        "Samsung SSD",
                        5000,
                        10,
                        "Samsung",
                        512
                );



        Product flash =
                new FlashMemory(
                        "2",
                        "Kingston Flash Memory",
                        1000,
                        20,
                        "Kingston",
                        3
                );



        products.add(ssd);

        products.add(flash);

    }


}