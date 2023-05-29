package net.dmytro.homework14.coffe.order;

import lombok.Data;



import java.util.LinkedList;
import java.util.Queue;


import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;



@Data

public class CoffeeOrderBoard {
   private static final Logger logger = LogManager.getLogger(CoffeeOrderBoard.class);

    Queue<Order> orders = new LinkedList<>();
    int orderNumber = 1;

    public void add(String clientName) {
        orders.add(new Order(orderNumber, clientName));
        orderNumber++;
        logger.info("order for " + clientName + " added");


    }

    public void deliver() {
        if (!orders.isEmpty()) {
            Order order = orders.poll();
            System.out.println("Order #" + order.getOrderNumber() + " for " + order.getClientName());
            logger.info(orderNumber + "was deliver");


        } else {
            System.out.println("Order list is empty");
            logger.info("order is empty");
        }

    }

    public void deliver(int orderNumber) {
        Order order;

        for (Order count : orders) {
            if (count.getOrderNumber() == orderNumber) {
                order = count;
                orders.remove(count);
                System.out.println("Order # " + order.getOrderNumber() + " for " + order.getClientName());
                logger.info("order #" + orderNumber + "was deliver for " + order.getClientName() );
                break;
            } else {
                System.out.println("Order #" + orderNumber + "not found");
            }
        }

    }
    public void draw(){
        for (Order order : orders) {
            System.out.println(order.getOrderNumber() + " | " +  order.getClientName());
        }
        logger.info(" draw is finish");
    }
}
