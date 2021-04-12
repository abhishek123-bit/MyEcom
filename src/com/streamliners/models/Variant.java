package com.streamliners.models;

public class Variant {
    String quantity;
    float price;

    public Variant(String quantity, float price) {
        this.quantity = quantity;
        this.price = price;
    }

    @Override
    public String toString() {
        return String.format("%s @ Rs. %.2f",quantity,price);
    }
}
