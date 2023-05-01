package net.dmytro.homework20;

import lombok.SneakyThrows;
import java.time.LocalDate;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
        return products.stream()
                .sorted(Comparator.comparing(product -> LocalDate.now()))
                .limit(3)
                .toList();

    }

    public static double getSumWithTypeAndFresh(List<Product> products, ProductType type, int year){
        return products.stream()
                .filter(product -> product.getType().equals(type) && product.getPrice() < 75
                        && LocalDate.now().getYear() == year)
                .mapToDouble(Product::getPrice)
                .sum();
    }

    public static Map<ProductType, List<Product>> getProductWithType(List<Product> products){
        return products.stream()
                .collect(Collectors.groupingBy(Product::getType));
    }

}
