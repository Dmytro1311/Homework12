package net.dmytro.homework17.fruit_box;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class BoxTest {
    Box box = new Box();
    @Test
    void addToBoxWhenWeightMoreThenMaxWeight(){
        ArrayList<Object> orange = new ArrayList<>();
        for (int i = 0; i < 100; i++){
            orange.add(i);
        }

        Assertions.assertEquals(orange, box.addToBox(orange));


    }
}
