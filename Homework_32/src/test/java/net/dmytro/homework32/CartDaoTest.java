package net.dmytro.homework32;

import net.dmytro.homework32.config.AppConfig;
import net.dmytro.homework32.dao.CartDao;
import net.dmytro.homework32.dao.ProductDao;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CartDaoTest {
    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
    CartDao cartDao = context.getBean(CartDao.class);
    ProductDao productDao = context.getBean(ProductDao.class);


    @Test
    void addToCart(){
        cartDao.addToCart(1,2);

    }
    @Test
    void getCartById(){

        cartDao.getCartById(1);
    }
    @Test
    void removeFromCart(){
        cartDao.removeFromCart(1,2);
    }

    @Test
    void addCartTest(){
        cartDao.addCart();
    }
    @Test
    void deleteCartTest() {
        cartDao.deleteCart(3);
    }



}
