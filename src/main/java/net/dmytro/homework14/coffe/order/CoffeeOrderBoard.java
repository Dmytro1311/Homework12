package net.dmytro.homework14.coffe.order;





import lombok.Data;

import java.util.LinkedList;
import java.util.Queue;
@Data
public class CoffeeOrderBoard {

    Queue<Order> orders = new LinkedList<>();
    int orderNumber = 1;

    public void add(String clientName) {
        orders.add(new Order(orderNumber, clientName));
        orderNumber++;

    }

    public void deliver() {
        if (!orders.isEmpty()) {
            Order order = orders.poll();
            System.out.println("Order #" + order.getOrderNumber() + " for " + order.getClientName());

        } else {
            System.out.println("Order list is empty");
        }
    }

    public void deliver(int orderNumber) {
        Order order = null;

        for (Order count : orders) {
            if (count.getOrderNumber() == orderNumber) {
                order = count;
                orders.remove(count);
                break;
            }

        }
        if (order != null) {
            System.out.println("Order # " + order.getOrderNumber() + " for " + order.getClientName());
        } else {
            System.out.println("Order #" + orderNumber + "not found");
        }
        }


    public void draw(){
        for (Order order : orders) {
            System.out.println(order.getOrderNumber() + " | " +  order.getClientName());
        }
    }
}
