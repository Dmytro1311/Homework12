package net.dmytro.homework20;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
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
    private final LocalDate dateOfCreate = LocalDate.now();


    public Product() {
    }
}
