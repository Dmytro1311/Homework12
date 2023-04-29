package net.dmytro.homework20;

import lombok.SneakyThrows;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ProductMain {

    public ProductMain() {

    }

    public static List<Product> getProductList(List<Product> products, ProductType type){
        return products.stream()
                .filter(product -> product.getType().equals(type) && product.getPrice() > 250)
                .toList();


    }
    public static List<Product> getProductListWithDiscount(List<Product> products,ProductType type){
        return products.stream()
                .filter(product -> product.getType().equals(type) && product.isDiscount())
                .map(product -> {
                    double priceWithDiscount = product.getPrice() * 0.9;
                    return new Product(product.getType(), priceWithDiscount, product.getId(), true);
                })
                .toList();
    }
    @SneakyThrows
    public static List<Product> getCheapestProductFromPrice(List<Product> products, ProductType type)  {
        return Collections.singletonList(products.stream()
                .filter(product -> product.getType().equals(ProductType.BOOK))
                .min(Comparator.comparing(Product::getPrice))
                .orElseThrow(() -> new Exception("Product [category:" + type.toString() + "] not found")));

    }

    public static List<Product> getFreshProduct (List<Product> products){

    }

}
