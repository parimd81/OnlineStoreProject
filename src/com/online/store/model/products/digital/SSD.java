package com.online.store.model.products.digital;

public class SSD extends DigitalProduct {

    private int capacityGB;

    public SSD(String id, String name, double price, int stock,
               String brand, int capacityGB) {
        super(id, name, price, stock, brand);
        this.capacityGB = capacityGB;
    }

    public int getCapacityGB() { return capacityGB; }
}