package net.dmytro.homework31.product;

import lombok.Value;
import java.util.ArrayList;
import java.util.List;
@Value
public class Cart {

    List<Product> productList;

    public Cart(){
        productList = new ArrayList<>();
    }

    public void addToProductList(Product product){
        productList.add(product);
    }
    public void removeFromProductListById(int id){
        productList.removeIf(p -> p.getId() == id);
    }


}
