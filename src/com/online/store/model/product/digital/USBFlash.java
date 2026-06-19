package com.online.store.model.product.digital;
public class USBFlash extends DigitalProduct {

    private String usbVersion;
    private int capacity;

    public USBFlash(int id, String n, double p, boolean s,
                    double w, String d, String v, int c) {
        super(id, n, p, s, w, d);
        this.usbVersion = v;
        this.capacity = c;
    }
}