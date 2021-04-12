package com.streamliners.models;

import java.util.List;

public class VariantsBasedProduct extends Product {
    List<Variant> variants;

    public VariantsBasedProduct(String name, String image, List<Variant> variants) {
        super(name, image);
        this.variants = variants;
    }

    @Override
    public String toString() {
        return "VariantsBasedProduct{" +
                "name='" + name + '\'' +
                ", image='" + image + '\'' +
                ", variants=" + variants +
                '}';
    }
}
