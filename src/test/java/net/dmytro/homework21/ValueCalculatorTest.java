package net.dmytro.homework21;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class ValueCalculatorTest {
    @Test
    void valueCalculatorTest(){
        ValueCalculator valueCalculator = new ValueCalculator(10000000);
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        valueCalculator.calculate();

        Assertions.assertTrue(outContent.toString().contains("Takes time = "));
    }

}

