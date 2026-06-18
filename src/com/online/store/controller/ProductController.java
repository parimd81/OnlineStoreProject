package com.online.store.controller;


import com.online.store.model.products.Product;
import com.online.store.model.products.digital.FlashMemory;
import com.online.store.model.products.digital.SSD;
import com.online.store.storage.FileManager;


import java.util.ArrayList;
import java.util.List;



public class ProductController {



    private static ProductController instance;


    private List<Product> products;



    private final String FILE_PATH =
            "data/products.txt";







    private ProductController() {


        products = new ArrayList<>();


        loadProducts();


    }







    public static ProductController getInstance() {


        if(instance == null) {


            instance =
                    new ProductController();

        }


        return instance;

    }









    public void addProduct(Product product) {


        products.add(product);


        saveProducts();

    }









    public boolean removeProduct(Product product) {


        boolean result =
                products.remove(product);



        if(result){

            saveProducts();

        }


        return result;

    }









    public List<Product> getAllProducts() {


        return products;

    }









    public Product findById(String id) {



        for(Product product : products) {



            if(product.getId()
                    .equals(id)) {


                return product;

            }

        }


        return null;

    }









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









    private void saveProducts(){


        List<String> data =
                new ArrayList<>();



        for(Product product : products){



            if(product instanceof SSD){


                SSD ssd =
                        (SSD) product;



                data.add(
                        "SSD,"
                                + ssd.getId()
                                + ","
                                + ssd.getName()
                                + ","
                                + ssd.getPrice()
                                + ","
                                + ssd.getStock()
                                + ","
                                + ssd.getBrand()
                                + ","
                                + ssd.getCapacityGB()
                );


            }




            else if(product instanceof FlashMemory){


                FlashMemory flash =
                        (FlashMemory) product;



                data.add(
                        "FlashMemory,"
                                + flash.getId()
                                + ","
                                + flash.getName()
                                + ","
                                + flash.getPrice()
                                + ","
                                + flash.getStock()
                                + ","
                                + flash.getBrand()
                                + ","
                                + flash.getUsbVersion()
                );

            }


        }



        FileManager.writeFile(
                FILE_PATH,
                data
        );


    }









    private void loadProducts(){



        List<String> data =
                FileManager.readFile(
                        FILE_PATH
                );




        if(data.isEmpty()){


            loadSampleProducts();


            saveProducts();


            return;

        }







        for(String line : data){



            String[] parts =
                    line.split(",");




            if(parts[0].equals("SSD")){


                products.add(

                        new SSD(

                                parts[1],
                                parts[2],
                                Double.parseDouble(parts[3]),
                                Integer.parseInt(parts[4]),
                                parts[5],
                                Integer.parseInt(parts[6])

                        )

                );

            }






            else if(parts[0].equals("FlashMemory")){


                products.add(

                        new FlashMemory(

                                parts[1],
                                parts[2],
                                Double.parseDouble(parts[3]),
                                Integer.parseInt(parts[4]),
                                parts[5],
                                Integer.parseInt(parts[6])

                        )

                );


            }


        }


    }









    private void loadSampleProducts() {



        products.add(

                new SSD(
                        "1",
                        "Samsung SSD",
                        5000,
                        10,
                        "Samsung",
                        512
                )

        );





        products.add(

                new FlashMemory(
                        "2",
                        "Kingston Flash Memory",
                        1000,
                        20,
                        "Kingston",
                        3
                )

        );


    }



}