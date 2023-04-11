package net.dmytro.homework13;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;



public class AlgorithmsTest {
    @Test
    void quickSortTest(){

        int[] arr = {2,4,6,8,1,3,5,7,9};
        int[] expectedArr = {1,2,3,4,5,6,7,8,9};
        Assertions.assertArrayEquals(expectedArr,Algorithms.quickSort(arr));
    }

    @Test
    void shakeSortTest(){
        int[] arr = {2,4,6,8,1,3,5,7,9};
        int[] expectedArr = {1,2,3,4,5,6,7,8,9};
        Assertions.assertArrayEquals(expectedArr,Algorithms.shakeSort(arr));
    }

}
