package net.dmytro.homework20;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class ProductMainTest {

    private static  List<Product> testProduct = List.of(
            new Product(ProductType.BOOK,323.5,1, true),
            new Product(ProductType.TOY,453,2, true),
            new Product(ProductType.BOOK,150,3, true),
            new Product(ProductType.TOY,200,4, true),
            new Product(ProductType.BOOK,255,5, true),
            new Product(ProductType.TOY,100,6, true),
            new Product(ProductType.BOOK,999,7, false)
    );


    @Test
    void getProductList(){
        List<Product> expected = List.of(
                new Product(ProductType.BOOK,323.5,1,true),
                new Product(ProductType.BOOK,255,5,true),
                new Product(ProductType.BOOK,999,7,false)

        );

        List<Product> actual = ProductMain.getProductList(testProduct, ProductType.BOOK);



        Assertions.assertEquals(expected,actual);



    }
}
