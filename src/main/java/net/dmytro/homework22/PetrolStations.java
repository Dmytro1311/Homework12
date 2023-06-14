package net.dmytro.homework22;

import java.util.HashMap;
import java.util.UUID;
import java.util.concurrent.Semaphore;
import java.util.Map;

import static java.lang.Math.random;
import static java.lang.Thread.sleep;

public class PetrolStations {
    private double amount;
    private final Semaphore semaphore;
    private final Map <UUID,Double> operationsWithFuel;


    public PetrolStations(double amount,int queue){
        this.amount = amount;
        this.semaphore = new Semaphore(queue);
        this.operationsWithFuel = new HashMap<>();
    }

    public void doRefuel(double amount){
        UUID id = UUID.randomUUID();
        if(!reserveFuel(id,amount)){
            System.out.println("haven't enough fuel on the station." + getAmount());
            return;
        }

        try {
            semaphore.acquire();
            System.out.println("Refuel was starting");
            sleep((long)(random() * 6000));
            fuel(id);
            System.out.println("Refueling is done" +  "\n" + "remainder " + getAmount());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            semaphore.release();
        }

    }

    private synchronized boolean reserveFuel(UUID id, double amount){
        if (getAmount() - amount >= 0){
            operationsWithFuel.put(id,amount);
            return true;

        }else {
            return false;
        }
    }

    private synchronized double getAmount(){
        return amount - operationsWithFuel.values().stream().reduce(0.0,Double::sum);
    }
    private synchronized void fuel(UUID id){
        amount =- operationsWithFuel.get(id);
        operationsWithFuel.remove(id);
    }


}
