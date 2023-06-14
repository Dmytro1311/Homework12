package net.dmytro.homework29.order;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Product {

    private int id;
    private String name;
    private double cost;

    public Product() {
    }
}
