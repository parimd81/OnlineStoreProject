package com.online.store.model.product.digital;


public class FlashMemory extends StorageDevice {



    private String usbVersion;





    public FlashMemory(
            int id,
            String name,
            double price,
            boolean stock,
            double weight,
            String dimensions,
            int capacity,
            String usbVersion
    ){


        super(
                id,
                name,
                price,
                stock,
                weight,
                dimensions,
                capacity
        );


        this.usbVersion=usbVersion;


    }






    public String getUsbVersion(){

        return usbVersion;

    }


}