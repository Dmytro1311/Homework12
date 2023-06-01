package net.dmytro.homework27;

import java.util.ArrayList;
import java.util.List;


public class OrderRepository {

    List<Order> basket = new ArrayList<>();

    public void add(Order order){
        basket.add(order);
    }

    public Order getOrderById(int id){
        return basket.get(id);
    }

    public List<Order> getAll(){
        return basket;
    }

}
