package net.dmytro.homework18.factory;

public class Bed implements Furniture{
    @Override
    public void createFurniture() {
        System.out.println("create bed ");
    }
}
