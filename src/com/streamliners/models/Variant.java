package com.streamliners.models;
/**
 * represents a variant with...
 *
 * name - name of the variant
 * price - price of the variant
 */
public class Variant {

    String name;
    float price;

    /**
     * Constructor to initialize product with all parameters
     *
     * @param name  name of the variant
     * @param price price of the variant
     */
    public Variant(String name, float price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return String.format("%s @ Rs. %.2f",name,price);
    }
}
