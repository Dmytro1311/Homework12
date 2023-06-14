package net.dmytro.homework21;

import java.lang.reflect.Array;
import java.util.Arrays;

public class ValueCalculator {
    private int[] array;
    private int halfSize;

    public ValueCalculator(int size){
        if(size > 1000000){
            this.array = new int[size];
        }else {
            this.array = new int[1000000];
        }

        this.halfSize = size / 2;
    }

    public void calculate(){
        long start = System.currentTimeMillis();
        Arrays.fill(array, 1);

        int[] firstArray = Arrays.copyOfRange(array,0,halfSize);
        int[] secondArray = Arrays.copyOfRange(array,halfSize,array.length);

        Thread thread = new Thread(() ->{
            for (int i = 0; i < firstArray.length; i++){
                firstArray[i] = (int) (firstArray[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
        });

        Thread thread1 = new Thread(()->{
            for (int i = 0; i < secondArray.length; i++){
                secondArray[i] = (int) (secondArray[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
        });

        thread1.start();
        thread.start();

        try {
            thread.join();
            thread1.join();

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.arraycopy(firstArray,0,array,0,halfSize);
        System.arraycopy(secondArray,0,array,halfSize,halfSize);

        long end = System.currentTimeMillis();
        System.out.println("Takes time = " + (end - start) + " ms");

    }

}
