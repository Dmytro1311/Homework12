package net.dmytro.homework18.strategy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CalculationTest {
    @Test
    void calculationAreaRectangleTest(){
        Calculation rectangle = new Calculation(new Rectangle(2,5));
        Assertions.assertEquals(10,rectangle.calculation());

    }
    @Test
    void calculationAreaTriangleTest(){
        Calculation triangle = new Calculation(new Triangle(2,5));
        Assertions.assertEquals(5, triangle.calculation());
    }
}
