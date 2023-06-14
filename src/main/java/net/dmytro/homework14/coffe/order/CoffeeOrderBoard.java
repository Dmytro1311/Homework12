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
            logger.info("Order #" + order.getOrderNumber() + " for " + order.getClientName());


        } else {
            logger.info("order is empty");
        }

    }

    public void deliver(int orderNumber) {
        Order order;

        for (Order count : orders) {
            if (count.getOrderNumber() == orderNumber) {
                order = count;
                orders.remove(count);
                logger.info("order #" + orderNumber + "was deliver for " + order.getClientName() );
                break;
            } else {
                logger.info("Order #" + orderNumber + "not found");
            }
        }

    }
    public void draw(){
        for (Order order : orders) {
            logger.info(order.getOrderNumber() + " | " +  order.getClientName());
        }
        logger.info(" draw is finish");
    }
}
