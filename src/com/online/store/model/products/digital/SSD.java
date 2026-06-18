package com.online.store.model.products.digital;


public class SSD extends DigitalProduct {

    private int capacityGB;


    public SSD(String id,
               String name,
               double price,
               int stock,
               String brand,
               int capacityGB) {

        super(id, name, price, stock, brand);

        this.capacityGB = capacityGB;
    }


    public int getCapacityGB() {
        return capacityGB;
    }


    public void setCapacityGB(int capacityGB) {
        this.capacityGB = capacityGB;
    }


    @Override
    public String toString() {

        return "SSD{" +
                "id='" + getId() + '\'' +
                ", name='" + getName() + '\'' +
                ", price=" + getPrice() +
                ", stock=" + getStock() +
                ", brand='" + getBrand() + '\'' +
                ", capacityGB=" + capacityGB +
                '}';
    }
}