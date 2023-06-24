package net.dmytro.homework32.dao;

import lombok.Data;
import net.dmytro.homework32.entity.Cart;
import net.dmytro.homework32.mapper.CartMapper;
import net.dmytro.homework32.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Data
@Repository
public class CartDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void addCart(){
        String sql = "INSERT INTO carts VALUES()";
        jdbcTemplate.update(sql);
    }
    public void deleteCart(int id){
        String sql = "DELETE FROM carts WHERE ID = ?";
        jdbcTemplate.update(sql,id);
    }
    public Cart getCartById(int id){

        String sql = "SELECT * FROM product_cart c JOIN product p ON c.product_id = p.id WHERE c.cart_id = ?";
        return jdbcTemplate.queryForObject(sql,new CartMapper(new ProductMapper()), id);
    }
    public void addToCart(int cartId, int productId){
        String sql = "INSERT INTO product_cart (cart_id, product_id) VALUES (?, ?)";
        jdbcTemplate.update(sql, cartId,productId);
    }
    public void removeFromCart(int cartId, int productId){
        String sql = "DELETE FROM product_cart WHERE cart_id =(?) AND product_id =(?)";
        jdbcTemplate.update(sql,cartId,productId);
    }

}
