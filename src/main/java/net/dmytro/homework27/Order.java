package net.dmytro.homework27;

import lombok.Getter;


import java.util.List;

@Getter
public class Order {

    private int id;
    private String date;
    private double cost;
    private List<Product> products;

}
