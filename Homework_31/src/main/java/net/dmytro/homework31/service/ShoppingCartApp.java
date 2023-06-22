package net.dmytro.homework31.service;
import net.dmytro.homework31.product.Cart;
import net.dmytro.homework31.product.Product;
import net.dmytro.homework31.repository.ProductRepository;
import java.util.List;

public class ShoppingCartApp {
    private ProductRepository productRepository;
    private Cart cart;
    private Product product;

    public ShoppingCartApp(ProductRepository productRepository, Cart cart) {
        this.productRepository = productRepository;
        this.cart = cart;
    }

    public void addToCart(int id){
        product = productRepository.getProductById(id);
        if (product != null){
            cart.addToProductList(product);
        }
    }
    public void removeFromCart(int id){
        product = productRepository.getProductById(id);
        if (product != null){
            cart.removeFromProductListById(id);
        }
    }
    public void displayList(){
        List<Product> products = cart.getProductList();
        if (!products.isEmpty()){
            for (Product product1 : products){
                System.out.println(product1.getName() + " - cost " + product1.getPrice());
            }
        }
    }
}
