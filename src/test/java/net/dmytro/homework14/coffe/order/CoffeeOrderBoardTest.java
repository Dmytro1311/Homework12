package net.dmytro.homework14.coffe.order;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class CoffeeOrderBoardTest {
    @Test
    void addTest() {
        CoffeeOrderBoard coffeeOrderBoard = new CoffeeOrderBoard();
        Order order = new Order(1, "Miki");
        coffeeOrderBoard.add("Miki");
        coffeeOrderBoard.add("Jack");
        Assertions.assertEquals(2, coffeeOrderBoard.getOrders().size());
        Assertions.assertTrue(coffeeOrderBoard.getOrders().contains(order));


    }
    @Test
    void deliverIsEmptyTest(){
        CoffeeOrderBoard coffeeOrderBoard = new CoffeeOrderBoard();
        Assertions.assertTrue(coffeeOrderBoard.orders.isEmpty());
    }
    @Test
    void deliverTest(){

        CoffeeOrderBoard coffeeOrderBoard = new CoffeeOrderBoard();
        coffeeOrderBoard.add("Kate");
        coffeeOrderBoard.add("Miki");
        coffeeOrderBoard.add("Olga");

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        coffeeOrderBoard.deliver();


        Assertions.assertTrue(outputStream.toString().contains("Order #1 for Kate"));


    }
    @Test
    void drawTest(){
        CoffeeOrderBoard coffeeOrderBoard = new CoffeeOrderBoard();
        coffeeOrderBoard.add("Kate");
        coffeeOrderBoard.add("Miki");
        coffeeOrderBoard.add("Olga");
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        coffeeOrderBoard.deliver(3);

        outContent.reset();
        System.setOut(new PrintStream(outContent));
        coffeeOrderBoard.draw();

        Assertions.assertTrue(outContent.toString().contains("1 | Kate"));
        Assertions.assertTrue(outContent.toString().contains("2 | Miki"));
        Assertions.assertFalse(outContent.toString().contains("3 | Olga"));



    }

}

