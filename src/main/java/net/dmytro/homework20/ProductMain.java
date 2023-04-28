package net.dmytro.homework20;

import java.util.List;

public class ProductMain {

    public ProductMain() {

    }

    public static List<Product> getProductList(List<Product> products, ProductType type){
        return products.stream()
                .filter(product -> product.getType().equals(type) && product.getPrice() > 250)
                .toList();


    }
    public static List<Product> getProductListWithDiscount(List<Product> products,ProductType type, double discountSize){
        return products.stream()
                .filter(product -> product.getType().equals(type) && product.isDiscount())
                .peek(product -> product.priceWithDiscount(discountSize))
                .toList();
    }

}
