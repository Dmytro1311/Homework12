package net.dmytro.homework18.factory;

public class Chair implements Furniture{
    @Override
    public void createFurniture() {
        System.out.println("create chair");
    }
}
