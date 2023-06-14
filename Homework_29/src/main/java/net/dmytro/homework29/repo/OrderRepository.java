package net.dmytro.homework29.repo;

import net.dmytro.homework29.order.Order;

import java.util.ArrayList;
import java.util.List;

public class OrderRepository {

    List<Order> basket;

    public OrderRepository() {
        this.basket = new ArrayList<>();
    }

    public Order add(Order order){
        basket.add(order);
        return order;
    }

    public Order getOrderById(int id){
        return basket.get(id);
    }

    public List<Order> getAll(){
        return basket;
    }
}
