package net.dmytro.homework20;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class ProductMainTest {

    private static  List<Product> testProduct = List.of(
            new Product(ProductType.BOOK,323,1, true),
            new Product(ProductType.TOY,453,2, true),
            new Product(ProductType.BOOK,150,3, true),
            new Product(ProductType.TOY,200,4, true),
            new Product(ProductType.BOOK,255,5, true),
            new Product(ProductType.TOY,100,6, true),
            new Product(ProductType.BOOK,999,7, false)
    );



    @Test
    void getProductList(){
        var expected = testProduct.stream()
                .filter(product -> product.getType().equals(ProductType.BOOK) && product.getPrice() > 250 )
                .toList();


        List<Product> actual = ProductMain.getProductList(testProduct, ProductType.BOOK);



        Assertions.assertEquals(expected,actual);
        Assertions.assertEquals(3, ProductMain.getProductList(testProduct,ProductType.BOOK).size());

    }

    @Test
    void getProductListWithDiscount(){
        var resultList = ProductMain.getProductListWithDiscount(testProduct,ProductType.BOOK);
        var actual = resultList.stream().map(Product::getPrice).toList();
        var expected = List.of(290.7,135.0,229.5);

        Assertions.assertEquals(expected,actual);
    }
    @Test
    void getCheapestProductFromPriceWithTypeBook(){
        var resultList = ProductMain.getCheapestProductFromPrice(testProduct,ProductType.BOOK);
        var actual = resultList.stream().map(Product::getPrice).toList();
        var expected = List.of(150.0);

        Assertions.assertEquals(expected,actual);
    }
}
