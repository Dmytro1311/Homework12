package net.dmytro.homework17.fruit_box;

import java.util.ArrayList;

public class Box<T> {

    float maxWeight = 100;


    void addToBox(T fruit){
        if (currentWeight < maxWeight){
            arrayList.add(fruit);
            currentWeight++;

        }

    }
     public  float getWeight(Fruit f){
        return arrayList.size() * f.weight;

    }

    public boolean compare(Fruit f1, Fruit f2){
        if(f1.weight == f2.weight){
            return true;
        }else {
            return false;
        }

    }
    public boolean mergeTo(Box box){
        if (currentWeight == box.currentWeight){
            return true;
        }else {
            return false;
        }

    }

}
