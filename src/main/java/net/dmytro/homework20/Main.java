package net.dmytro.homework20;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Product> testProduct = List.of(
                new Product(ProductType.BOOK,323.5,1, true),
                new Product(ProductType.TOY,453,2, true),
                new Product(ProductType.BOOK,150,3, true),
                new Product(ProductType.TOY,200,4, true),
                new Product(ProductType.BOOK,255,5, true),
                new Product(ProductType.TOY,100,6, true),
                new Product(ProductType.BOOK,999,7, false)
        );


      //  System.out.println(ProductMain.getProductList(testProduct, ProductType.BOOK));
//        System.out.println(ProductMain.getProductListWithDiscount(testProduct, ProductType.BOOK));
        System.out.println(ProductMain.getCheapestProductFromPrice(testProduct,ProductType.BOOK));


    }

}
