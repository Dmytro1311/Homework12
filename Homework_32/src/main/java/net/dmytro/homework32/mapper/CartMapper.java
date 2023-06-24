package net.dmytro.homework32.mapper;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import net.dmytro.homework32.entity.Cart;
import net.dmytro.homework32.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
@NoArgsConstructor
@AllArgsConstructor
public class CartMapper implements RowMapper<Cart> {
     ProductMapper productMapper;




    @Override
    public Cart mapRow(ResultSet rs, int rowNum) throws SQLException {
        Cart cart = new Cart();
        cart.setId(rs.getInt("id"));

        List<Product> products = new ArrayList<>();

        do {
            Product product = productMapper.mapRow(rs, rowNum);
            products.add(product);
        }while (rs.next() && cart.getId() == rs.getInt("id"));

        cart.setProductList(products);

        return cart;
    }
}
