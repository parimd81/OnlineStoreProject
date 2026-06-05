package com.online.store.model.products.digital;

public class SSD extends DigitalProduct {
    private int capacityGB;
    private int readSpeed;

    public SSD(String id, String name, double price, int stock, String brand, double weight, int capacityGB, int readSpeed) {
        super(id, name, price, stock, brand, weight);
        this.capacityGB = capacityGB;
        this.readSpeed = readSpeed;
    }
}