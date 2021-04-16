package com.streamliners.models;

import java.util.Properties;

/**
 * represents Cart Item with...
 * <p>
 * name - name of the item
 * unitPrice - price per unit of the cart item
 * qty - quantity of the item
 */
public class CartItem {

    public String name;
    public Product product;
    float qty, unitPrice;

    /**
     * Constructor to create cart item with...
     *
     * @param product   all detail of product is store
     * @param name      name of the product
     * @param qty       quantity of the product
     * @param unitPrice price of the product of unit quantity

     */

    public CartItem(Product product,String name, float qty, float unitPrice) {
        this.product = product;
        this.name = name;
        this.qty = qty;
        this.unitPrice = unitPrice;

    }

    float cost() {
        return qty * unitPrice;
    }

    @Override
    public String toString() {
        return name + "  (" + String.format("%.2f X %.2f = %.2f", unitPrice, qty, cost()) +
                ")\n";
    }
}
