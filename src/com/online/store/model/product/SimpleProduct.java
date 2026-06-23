package com.online.store.model.product;


import com.online.store.model.product.category.Category;


public class SimpleProduct extends Product {


    public SimpleProduct(
            int id,
            String name,
            double price,
            int quantity,
            Category category
    ) {

        super(
                id,
                name,
                price,
                quantity,
                category
        );

    }


}