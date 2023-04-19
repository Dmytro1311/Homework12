package net.dmytro.homework18.builder;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CarTest {
    @Test
    void catBuilderTest(){
        Car car = new Car.Builder()
                .withName("BMV")
                .withCarBrand("X5")
                .withTypeTransmission("avto")
                .build();


        Assertions.assertEquals("BMV",car.getName());
        Assertions.assertEquals("X5",car.getCarBrand());
        Assertions.assertEquals("avto",car.getTypeTransmission());

    }
}
