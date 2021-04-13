package com.streamliners.models;


import java.util.HashMap;

/**
 * represents cart with...
 *
 * total - total amount of the purchase
 * noOfItems - number of total items in the cart
 * cartItems - Map of the cart items with name as key and quantity as value
 */
public class Cart {
    HashMap<String, CartItem> cartItems = new HashMap<>();
    float total, noOfItems;

    /**
     * To add/edit weight based product in the cart
     *
     * @param product product to be added
     * @param qty     quantity of the product
     */
    public void addWBProduct(Product product, float qty) {
        //Item is already exist in cart
        if (cartItems.containsKey(product.name)) {
            total -= cartItems.get(product.name).cost();
            cartItems.get(product.name).qty = qty;
        }
        //Item is not present in cart
        else {
            CartItem item = new CartItem(product.name, qty, product.pricePerKg);
            cartItems.put(product.name, item);
            noOfItems++;
        }
        total += cartItems.get(product.name).cost();
    }

    /**
     * To add/edit variant based product in the cart
     *
     * @param product product to be added
     * @param variant which variant of the product to be added in the cart
     */
    public void addVBProduct(Product product, Variant variant) {
        String key = product.name + " " + variant.name;
        //Item is already exist in cart
        if (cartItems.containsKey(key)) {
            cartItems.get(key).qty++;
        }
        //Item is not present in cart
        else {
            CartItem item = new CartItem(product.name, 1, variant.price);
            cartItems.put(key, item);
        }
        noOfItems++;
        total += variant.price;
    }

    /**
     * To remove the weightBased product or variantBased product completely
     *
     * @param product product to be removed
     */
    public void removeAll(Product product) {
        //remove weightBased product
        if(product.type==ProductType.TYPE_WB) {
            removeWBProduct(product);
        }
        //remove all variantBased Product
        else{
            removeAllVariantsOfVariantBasedProduct(product);
        }
    }

    /**
     * To remove the weight based product completely
     *
     * @param product weight based product to be removed
     */
    private void removeWBProduct(Product product) {
        total-= cartItems.get(product.name).cost();
        noOfItems--;
        cartItems.remove(product.name);
    }

    /**
     * To decrease the quantity of the variant based product
     *
     * @param product product of which the quantity is to be decreased
     * @param variant variant of the product to be decreased
     */
    public void decrement(Product product, Variant variant) {
        String key = product.name + " " + variant.name;
        //update cartItem quantity
        cartItems.get(key).qty--;

        //update cart
        total -= variant.price;
        noOfItems--;

        //CartItem quantity is 0
        if (cartItems.get(key).qty == 0) {
            cartItems.remove(key);
        }

    }

    /**
     * To remove the variant based product completely
     *
     * @param product variant based product to be removed
     */
    private void removeAllVariantsOfVariantBasedProduct(Product product) {
        //Remove all variants
        for (Variant variant : product.variants) {
            String key = product.name + " " + variant.name;
            //Variant exist in cart
            if (cartItems.containsKey(key)) {
                total -= cartItems.get(key).cost();
                noOfItems -= cartItems.get(key).qty;
                cartItems.remove(key);
            }
        }
    }


    @Override
    public String toString() {
        return "MyCart{ " +
                cartItems.values() +
                String.format("\ntotal %.2f items (Rs. %.2f)", noOfItems, total)
                +"}";
    }
}
