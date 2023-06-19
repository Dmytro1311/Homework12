package net.dmytro.homework29.service;

import net.dmytro.homework29.order.Order;
import net.dmytro.homework29.repo.OrderRepository;

import java.util.List;

public class Service {

    private OrderRepository orderRepository = new OrderRepository();

    public Order add (Order order){
       return orderRepository.add(order);
    }

    public Order getById(int id){
        return orderRepository.getOrderById(id);
    }

    public List<Order> getAll(){
        return orderRepository.getAll();
    }

}
