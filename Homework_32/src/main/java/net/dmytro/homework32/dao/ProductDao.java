package net.dmytro.homework32.dao;

import lombok.Data;
import net.dmytro.homework32.entity.Product;
import net.dmytro.homework32.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Data
@Repository
public class ProductDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Product> getALl (){
        String sql = "Select * FROM product";
        return jdbcTemplate.query(sql,new ProductMapper());
    }

    public Product getProductById(int id){
        String sql = "SELECT * FROM product WHERE ID =?";
        return jdbcTemplate.queryForObject(sql,new ProductMapper(), id);
    }
    public void addToProduct(Product product){
        String sql = "INSERT INTO product (name,price) VALUES (? , ?)";
        jdbcTemplate.update(sql, product.getName(), product.getPrice());
    }
    public void deleteFromProduct(int id){
        String sql =" DELETE FROM product WHERE ID=?";
        jdbcTemplate.update(sql,id);
    }
}
