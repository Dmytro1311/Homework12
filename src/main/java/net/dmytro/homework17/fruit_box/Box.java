package net.dmytro.homework17.fruit_box;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
@Data
public class Box<T extends Fruit> {


    private final List<T> fruits;

    public Box() {

        this.fruits = new ArrayList<>();
    }

    public boolean add(T fruit) {
        return fruits.add(fruit);
    }


    public boolean add(List<T> fruit) {
        return fruits.addAll(fruit);
    }

    public float getWeight() {
        if (!fruits.isEmpty()){
            float toReturn = fruits.get(0).getWeight();
            return toReturn * fruits.size();

        }else {
           return 0;
        }

    }

    public boolean compare(Box<T> box) {
        return this.getWeight() == box.getWeight();
    }

    public void mergeTo(Box<T> box) {
        if (fruits.size() == 0 || box.fruits.size() == 0) {
            return;
        }
        fruits.addAll(box.fruits);
        box.fruits.clear();
    }

}

