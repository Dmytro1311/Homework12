package net.dmytro.homework22;

import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {

        // ThreadSafeList
        ThreadSafeList<String> list = new ThreadSafeList<>();
        String str = "some words";
        new Thread(() -> {
            list.add(str);
            System.out.println(" use method add = " + Arrays.toString(list.getList().toArray()));
        }).start();

        new Thread(()->{
            System.out.println(list.get(0));
        });
        new Thread(() ->{
            System.out.println("list before use remove " + Arrays.toString(list.getList().toArray()));
            list.remove(str);
            System.out.println("list after use remove " + Arrays.toString(list.getList().toArray()));
        }).start();

        // Petrol Station
        PetrolStations petrolStations = new PetrolStations(100, 4);
        ExecutorService executor = Executors.newFixedThreadPool(5);
        executor.execute(() -> petrolStations.doRefuel(7));
        executor.execute(() -> petrolStations.doRefuel(3));
        executor.execute(() -> petrolStations.doRefuel(2));
        executor.execute(() -> petrolStations.doRefuel(4));
        executor.execute(() -> petrolStations.doRefuel(3));
        executor.execute(() -> petrolStations.doRefuel(4));

        executor.shutdown();


    }
}