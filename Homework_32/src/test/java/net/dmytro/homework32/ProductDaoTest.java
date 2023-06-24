package net.dmytro.homework32;

import net.dmytro.homework32.config.AppConfig;
import net.dmytro.homework32.dao.ProductDao;
import net.dmytro.homework32.entity.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class ProductDaoTest {
    private AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
    private ProductDao productDao = context.getBean(ProductDao.class);
    @Test
    void addProductTest() {


        Product product1 = Product.builder()
                .name("Product1")
                .price(10.00)
                .build();
        Product product2 = Product.builder()
                .name("Product1")
                .price(10.00)
                .build();
        Product product3 = Product.builder()
                .name("Product1")
                .price(10.00)
                .build();

        productDao.addToProduct(product1);
        productDao.addToProduct(product2);
        productDao.addToProduct(product3);

    }
    @Test
    void deleteFromProduct(){
        productDao.deleteFromProduct(1);
    }
    @Test
    void getAllFromProduct(){
        System.out.println(productDao.getALl());
    }
    @Test
    void getProductById(){
        Assertions.assertEquals(3,productDao.getProductById(3).getId());
    }
}


