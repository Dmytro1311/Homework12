package net.dmytro.homework31.repository;

import lombok.Value;
import net.dmytro.homework31.product.Product;

import java.util.ArrayList;
import java.util.List;
@Value
public class ProductRepository {
    List<Product> productList;

    public ProductRepository() {
        productList = new ArrayList<>();
        productList.add(new Product(1, "Product 1", 10.0));
        productList.add(new Product(2, "Product 2", 20.0));
        productList.add(new Product(3, "Product 3", 30.0));

    }

    public List<Product> getAllProduct(){
        return productList;
    }

    public Product getProductById(int id){
        for (Product product : productList){
            if (product.getId() == id){
                return product;
            }
        }
        return null;
    }
}
