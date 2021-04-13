package com.streamliners;

import com.streamliners.models.Cart;
import com.streamliners.models.Product;
import com.streamliners.models.Variant;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {

        //creating WeightBased Product
        Product apple=new Product("apple","",0.7f,80)
                ,orange=new Product("orange","",0.4f,100)

        //creating VariantBased Product
                ,Kiwi=new Product("kiwi","",new ArrayList<>(
                Arrays.asList(
                        new Variant("500g",96)
                        ,new Variant("1Kg",200)
                )))
                ,surfExcel=new Product("surfExcel","",new ArrayList<>(
                Collections.singletonList(new Variant("2kg", 200))
        ));

        Cart cart=new Cart();
        //Adding apple in cart
        cart.addWBProduct(apple,2f);
        System.out.println(cart);

        //Adding Kiwi in cart
        cart.addVBProduct(Kiwi,Kiwi.variants.get(1));
        cart.addVBProduct(Kiwi,Kiwi.variants.get(1));
        cart.addVBProduct(Kiwi,Kiwi.variants.get(1));

        //Adding surfExcel in cart
        cart.addVBProduct(surfExcel,surfExcel.variants.get(0));
        cart.addVBProduct(surfExcel,surfExcel.variants.get(0));


        System.out.println();
        System.out.println(cart);

        //remove  weightBased product apple
        cart.removeAll(apple);
        //remove completely variantBased product Kiwi
        cart.removeAll(Kiwi);

        //remove single item of variantBased product
        cart.decrement(surfExcel,surfExcel.variants.get(0));

        System.out.println();
        System.out.println(cart);


       /* Product product1=new Product("Apple","aa");
        Product product2=new Product("Apple","aa");

        System.out.println(product2);

        //check hashcode and equals of product
        System.out.println(product1.hashCode());
        System.out.println(product2.hashCode());
        System.out.println(product2.equals(product1));

        System.out.println(product2==product1);

        List<Variant> variantList=new ArrayList<>(
                Arrays.asList(
                        new Variant("3kg",90),
                        new Variant("2kg",40)
                )
        );

        System.out.println(variantList);

        // creating variantBasedProduct
        Product variantsBasedProduct=new VariantsBasedProduct("Kiwi","aa",variantList);
        System.out.println(variantsBasedProduct);

        // creating weightBasedProduct
        Product weightBasedProduct=new WeightBasedProduct("Apple","qq",3,40);
        System.out.println(weightBasedProduct);

        */
    }
}
