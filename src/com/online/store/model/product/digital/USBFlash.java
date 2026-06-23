package com.online.store.model.product.digital;


public class USBFlash extends StorageDevice {


    private String usbVersion;




    public USBFlash(int id,
                    String name,
                    double price,
                    int quantity,
                    double weight,
                    String dimension,
                    int capacity,
                    String usbVersion) {


        super(id,
                name,
                price,
                quantity,
                weight,
                dimension,
                capacity);



        this.usbVersion = usbVersion;


    }





    public String getUsbVersion(){

        return usbVersion;

    }



    public void setUsbVersion(String usbVersion){

        this.usbVersion = usbVersion;

    }


}