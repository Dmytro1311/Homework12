package net.dmytro.homework17;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class ListsTest {
  @Test
    void toListTest(){

    String[] str = {"A","B","C","D"};
    List<String> expected = new ArrayList<>();
    for (String i : str){
      expected.add(i);
    }
    Assertions.assertEquals(expected,Lists.toList(str));

  }

}
