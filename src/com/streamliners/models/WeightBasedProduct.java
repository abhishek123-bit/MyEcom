package com.streamliners.models;

public class WeightBasedProduct extends Product {
    float minQty;
    float pricePerKg;

    public WeightBasedProduct(String name, String image, float minQty, float pricePerKg) {
        super(name, image);
        this.minQty = minQty;
        this.pricePerKg = pricePerKg;
    }

    @Override
    public String toString() {
        return "WeightBasedProduct{" +
                "name='" + name + '\'' +
                ", image='" + image + '\'' +
                ", minQty=" + minQty +
                ", pricePerKg=" + pricePerKg +
                '}';
    }
}
