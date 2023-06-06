package net.dmytro.homework27;


import jakarta.jws.WebMethod;
import jakarta.jws.WebService;

import java.util.List;

@WebService
public class Service {
private OrderRepository orderRepository = new OrderRepository();
    @WebMethod
    public void add (Order order){
        orderRepository.add(order);

    }
    @WebMethod
    public Order getById(int id){
        return orderRepository.getOrderById(id);
    }
    @WebMethod
    public List<Order> getAll(){
        return orderRepository.getAll();
    }

}
