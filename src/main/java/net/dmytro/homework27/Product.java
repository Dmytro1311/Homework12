package net.dmytro.homework27;

import lombok.Getter;
import lombok.ToString;

import java.util.UUID;
@Getter
@ToString

public class Product {
    private int id;
    private String name;
    private double cost;

    public Product() {
    }
}
