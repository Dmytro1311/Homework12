package net.dmytro.homework17.fruit_box;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;



public class BoxTest {

    @Test
    void addTest() {
        Box<Apple> appleBox = new Box<>();
        Apple apple1 = new Apple();
        Apple apple2 = new Apple();
        Apple apple3 = new Apple();
        List<Apple> expectedApples = Arrays.asList(apple1, apple2, apple3);
        appleBox.add(expectedApples);

        Assertions.assertEquals(expectedApples, appleBox.getFruits());

    }

    @Test
    void getAppleWeightTest() {
        Box<Apple> box1 = new Box<>();
        box1.add(new Apple());
        box1.add(new Apple());
        Assertions.assertEquals(2.0f, box1.getWeight());

    }
    @Test
    void getOrangeWeightTest(){
        Box<Orange> box2 = new Box<>();
        box2.add(new Orange());
        box2.add(new Orange());
        Assertions.assertEquals(3.0f, box2.getWeight());
    }
    @Test
    void getFruitFromEmptyBox(){
        Box<Apple> box = new Box<>();
        Assertions.assertEquals(0.0,box.getWeight());
    }

    @Test
    void compareTest() {
        Box<Apple> appleBox1 = new Box<>();
        appleBox1.add(new Apple());
        appleBox1.add(new Apple());

        Box<Apple> appleBox2 = new Box<>();
        appleBox2.add(new Apple());
        appleBox2.add(new Apple());

        Assertions.assertTrue(appleBox1.compare(appleBox2));

    }
    @Test
    void mergeTest(){
        Box <Apple> box1 = new Box<>();
        box1.add(new Apple());
        box1.add(new Apple());

        Box<Apple> box2 = new Box<>();
        box2.add(new Apple());

        box1.mergeTo(box2);
        Assertions.assertEquals(3,box1.getFruits().size());
    }
}
