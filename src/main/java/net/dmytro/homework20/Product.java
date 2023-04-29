package net.dmytro.homework20;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@ToString
public class Product {

    private ProductType type;
    private double price;
    private int id;
    private boolean isDiscount;


    public Product() {
    }
}
