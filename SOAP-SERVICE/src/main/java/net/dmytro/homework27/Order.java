package net.dmytro.homework27;

import lombok.Getter;

import lombok.ToString;


import java.util.List;

@Getter
@ToString
public class    Order {

    private int id;
    private String date;
    private double cost;
    private List<Product> products;

    public Order() {
    }


}
