package net.dmytro.homework18.factory;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FurnitureFactoryTest {
    @Test
    void furnitureFactoryTest(){
        FurnitureFactory factory = new FurnitureFactory();
        Assertions.assertEquals(Bed.class, factory.getFurniture(FurnitureTypes.BED).getClass());
        Assertions.assertEquals(Chair.class, factory.getFurniture(FurnitureTypes.CHAIR).getClass());
        Assertions.assertEquals(Sofa.class, factory.getFurniture(FurnitureTypes.SOFA).getClass());
    }


}
