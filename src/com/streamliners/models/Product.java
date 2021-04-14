package com.streamliners.models;

import java.util.List;
import java.util.Objects;

/**
 * represents a product with...
 * <p>
 * name - name of the product
 * image - image of the product
 * type - whether it is weight based or variant based product
 */
public class Product {

    String name, image;

    /**
     * field for the Variant Based Product
     */
    public List<Variant> variants;

    /**
     * fields for the Weight Based Product
     * minQty - minimum quantity have to purchase at least
     * pricePerKg - price of the product of 1 kg
     */
    float minQty, pricePerKg;

    int type;

    /**
     * Constructor for the weight based product
     *
     * @param name       name of the product
     * @param image      image for the product
     * @param minQty     minimum quantity must be purchased of the product
     * @param pricePerKg price of the product of 1 kg
     */
    public Product(String name, String image, float minQty, float pricePerKg) {
        type = ProductType.TYPE_WB;
        this.name = name;
        this.image = image;
        this.minQty = minQty;
        this.pricePerKg = pricePerKg;
    }

    /**
     * Constructor for the variant based product
     *
     * @param name      name of the product
     * @param image     image for the product
     * @param variants  list of the variants of the product
     */
    public Product(String name, String image, List<Variant> variants) {
        type = ProductType.TYPE_VB;
        this.name = name;
        this.image = image;
        this.variants = variants;
    }


    @Override
    public String toString() {
        if (type == ProductType.TYPE_WB) {
            return "WeightBasedProduct{" +
                    "name='" + name + '\'' +
                    ", image='" + image + '\'' +
                    ", minQty=" + minQty +
                    ", pricePerKg=" + pricePerKg +
                    '}';
        } else {
            return "VariantsBasedProduct{" +
                    "name='" + name + '\'' +
                    ", image='" + image + '\'' +
                    ", variants=" + variants +
                    '}';
        }
    }
}
