package com.online.store.model.product.digital;

public class Computer extends DigitalProduct {

    private String cpuModel;
    private int ramCapacity;

    public Computer(
            int id,
            String name,
            double price,
            boolean stock,
            double weight,
            String dimensions,
            String cpuModel,
            int ramCapacity
    ) {
        super(
                id,
                name,
                price,
                stock,
                weight,
                dimensions
        );
        this.cpuModel = cpuModel;
        this.ramCapacity = ramCapacity;
    }

    public String getCpuModel() {
        return cpuModel;
    }

    public int getRamCapacity() {
        return ramCapacity;
    }
}