package net.dmytro.homework20;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.*;

public class ProductMainTest {

    private static  List<Product> testProduct = List.of(
            new Product(ProductType.BOOK,323,1, true),
            new Product(ProductType.TOY,453,2, true),
            new Product(ProductType.BOOK,150,3, true),
            new Product(ProductType.TOY,200,4, true),
            new Product(ProductType.BOOK,255,5, true),
            new Product(ProductType.TOY,100,6, true),
            new Product(ProductType.BOOK,999,7, false),
            new Product(ProductType.BOOK,50,8, true),
            new Product(ProductType.BOOK,60,9, true),
            new Product(ProductType.TOY,40,10, true)
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
    @Test
    void getFresherProduct() throws InterruptedException {
        List<Product> testProduct2 = new ArrayList<>();
        Product product1 = new Product(ProductType.BOOK, 323, 1, true);
        Product product2 = new Product(ProductType.TOY, 453, 2, true);
        Product product3 = new Product(ProductType.BOOK, 150, 3, true);
        Product product4 = new Product(ProductType.TOY, 200, 4, true);
        Product product5 = new Product(ProductType.BOOK, 255, 5, true);

        testProduct2.add(product1);
        Thread.sleep(100);
        testProduct2.add(product5);
        Thread.sleep(100);
        testProduct2.add(product4);
        Thread.sleep(100);
        testProduct2.add(product3);
        Thread.sleep(100);
        testProduct2.add(product2);

        List <Product> expected = new ArrayList<>();
        expected.add(product1);
        expected.add(product5);
        expected.add(product4);
        expected.sort(Comparator.comparing(product -> LocalDate.now()));

        Assertions.assertEquals(expected, ProductMain.getFreshProduct(testProduct2));

    }
    @Test
    void getPriceAmountWithFreshDate(){
        Assertions.assertEquals(110, ProductMain.getSumWithTypeAndFresh(testProduct,ProductType.BOOK,2023));
    }
    @Test
    void getGroupProduct(){




        Assertions.assertEquals(, ProductMain.getProductWithType(testProduct));
    }
}
