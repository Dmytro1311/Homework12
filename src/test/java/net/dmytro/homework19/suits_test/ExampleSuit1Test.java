package net.dmytro.homework19.suits_test;

import net.dmytro.homework19.annotation.AfterSuit;
import net.dmytro.homework19.annotation.BeforeSuit;
import net.dmytro.homework19.annotation.Test;

public class ExampleSuit1Test {


    @BeforeSuit
    public void setUp(){
        System.out.println("Before suite test");
    }
    @BeforeSuit
    public void setUp2(){
        System.out.println("Before suite test");
    }

    @Test(priority = 1)
    public void test1(){
        System.out.println("Test 1");
    }
    @Test(priority = 2)
    public void test2(){
        System.out.println("test 2");
    }
    @Test(priority = 3)
    public void test3(){
        System.out.println("test 3");
    }

    @AfterSuit
    public void clean(){
        System.out.println("After suite test");
    }
}
