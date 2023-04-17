package net.dmytro.homework17.fruit_box;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
@Data
public class Box<T extends Fruit> {
    private float weight;
    private final List<T> fruits;

    public  Box() {
        this.weight = 0;
        this.fruits = new ArrayList<>();
    }

    public void add(T fruit){
        if (fruits.isEmpty() || fruits.get(0).getClass().equals(fruit.getClass())){
            fruits.add(fruit);
        }else {
            System.out.println("Cannot add fruit of different type to the box");
        }
    }


    public void add(List <T> fruit) {
            for (T fruity : fruit) {
                this.fruits.add(fruity);
            }
        }

        public float getWeight() {
            for (T fruits : fruits) {
                weight += fruits.getWEIGHT();

            }
            return weight;

        }

        public boolean compare (Box<T> box){
            return this.getWeight() == box.getWeight();

        }
        public void mergeTo (Box<T> box) {
            if (fruits.size() == 0 || box.fruits.size() == 0) {
                return;
            }
            if (fruits.get(0).getClass() == box.fruits.get(0).getClass()) {
                fruits.addAll(box.fruits);
                box.fruits.clear();
            }

        }

    }

