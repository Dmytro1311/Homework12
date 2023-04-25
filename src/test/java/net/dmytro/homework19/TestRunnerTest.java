package net.dmytro.homework19;
import net.dmytro.homework19.suits_test.ExampleSuit1Test;
import net.dmytro.homework19.suits_test.ExampleSuitTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import lombok.SneakyThrows;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;


public class TestRunnerTest {
    @SneakyThrows
    @Test
    void startTest() {

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        TestRunner.start(ExampleSuitTest.class);


        Assertions.assertTrue(outputStream.toString().contains("Before suite test"));
        Assertions.assertTrue(outputStream.toString().contains("Test 1"));
        Assertions.assertTrue(outputStream.toString().contains("Test 2"));
        Assertions.assertTrue(outputStream.toString().contains("Test 3"));
        Assertions.assertTrue(outputStream.toString().contains("After suite test"));
    }
    @Test
    void startTestWithDoubleAnnotationBeforeSuit(){
        Assertions.assertThrows(RuntimeException.class,() -> TestRunner.start(ExampleSuit1Test.class));
    }



}

