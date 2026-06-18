package com.online.store.model.products.digital;


public class FlashMemory extends DigitalProduct {

    private int usbVersion;


    public FlashMemory(String id,
                       String name,
                       double price,
                       int stock,
                       String brand,
                       int usbVersion) {

        super(id, name, price, stock, brand);

        this.usbVersion = usbVersion;
    }


    public int getUsbVersion() {
        return usbVersion;
    }


    public void setUsbVersion(int usbVersion) {
        this.usbVersion = usbVersion;
    }


    @Override
    public String toString() {
        return "FlashMemory{" +
                "usbVersion=" + usbVersion +
                '}';
    }
}