package net.dmytro.homework12;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;


public class ListTest {

    @Test
    public void countOccurrenceTest(){
        List<String> list = Arrays.asList("One","Two","Three","Four","Five","One","Six","One");
        String str = "One";
        int actualResult = ListMethods.countOccurance(list,str);

        Assertions.assertEquals(3,actualResult);
    }
    @Test
    public void toListTest(){
        List<Integer> expected = Arrays.asList(1,2,3,4);
        List<Integer> actual = Arrays.asList(1,2,3,4);
        Assertions.assertEquals(expected,actual);
    }
    @Test
    public void findUnique(){
        List<Integer>list = Arrays.asList(1,2,3,4,5,6,7,8,2,3,4,5,1,2,3,4,5,9,10);
        List<Integer> expectedList = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        List<Integer> actualList = ListMethods.findUnique(list);
        Assertions.assertEquals(expectedList,actualList);
    }
    @Test
    public void calcOccuranceTest(){
        List<String>list =Arrays.asList("Toyota","Reno","Kia","BMW","Mersedes","Lanos","Reno","Lanos");
        Map<String, Integer> expected = new HashMap<>();
        expected.put("Lanos", 2);
        expected.put("Reno",2);
        expected.put("Toyota",1);
        expected.put("Kia",1);
        expected.put("BMW",1);
        expected.put("Mersedes",1);
        Map<String,Integer>actual = ListMethods.calcOccurance(list);
        Assertions.assertEquals(expected,actual);

    }
    @Test
    public void findOccuranceTest(){
        List<String>list =Arrays.asList("Toyota","Reno","Kia","BMW","Mersedes","Lanos","Reno","Lanos");
        List<ListMethods.FindOccuran> expected = Arrays.asList(
                new ListMethods.FindOccuran("Lanos",2),
                new ListMethods.FindOccuran("Reno",2),
                new ListMethods.FindOccuran("Toyota",1),
                new ListMethods.FindOccuran("Kia",1),
                new ListMethods.FindOccuran("BMW",1),
                new ListMethods.FindOccuran("Mersedes",1));
        Comparator<ListMethods.FindOccuran> comparator = Comparator.comparing(ListMethods.FindOccuran::getWords);
        Collections.sort(expected,comparator);
        List<ListMethods.FindOccuran> actual = ListMethods.findOccurans(list);
        Collections.sort(actual,comparator);
        Assertions.assertEquals(expected,actual);



    }

}
