package com.streamliners;

import com.streamliners.models.Product;
import com.streamliners.models.Variant;
import com.streamliners.models.VariantsBasedProduct;
import com.streamliners.models.WeightBasedProduct;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Product product1=new Product("Apple","aa");
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





    }
}
