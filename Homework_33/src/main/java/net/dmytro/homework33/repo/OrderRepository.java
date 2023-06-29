package net.dmytro.homework33.repo;

import lombok.Data;
import net.dmytro.homework33.entity.Order;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
@Data
public class OrderRepository {
    private Map<UUID, Order> orders;

    public OrderRepository(Map<UUID, Order> orders) {
        this.orders = new HashMap<>();
    }

    public void addToOrder(Order order){
        orders.put(order.getId(),order);
    }
    public Order getOrderById(UUID id){
        return orders.get(id);
    }
    public List<Order> getAllOrders(){
        return new ArrayList<>(orders.values());
    }

}
