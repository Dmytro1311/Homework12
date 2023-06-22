package net.dmytro.homework31.config;
import net.dmytro.homework31.product.Cart;
import net.dmytro.homework31.repository.ProductRepository;
import net.dmytro.homework31.service.ConsoleShopping;
import net.dmytro.homework31.service.ShoppingCartApp;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public ProductRepository productRepository(){
        return new ProductRepository();
    }

    @Bean
    public Cart cart(){
        return new Cart();
    }
    @Bean
    public ShoppingCartApp shoppingCartApp (ProductRepository productRepository, Cart cart){
        return new ShoppingCartApp(productRepository, cart);
    }
    @Bean
    public ConsoleShopping consoleShopping (ShoppingCartApp shoppingCartApp){
        return new ConsoleShopping(shoppingCartApp);
    }
}
