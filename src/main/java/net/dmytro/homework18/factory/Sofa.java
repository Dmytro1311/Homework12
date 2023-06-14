package net.dmytro.homework18.factory;

public class Sofa implements Furniture{
    @Override
    public void createFurniture() {
        System.out.println("create sofa");
    }
}
