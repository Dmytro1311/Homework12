package net.dmytro.homework20;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
public class Product {

    private ProductType type;
    private double price;
    private int id;
    private boolean isDiscount;

    public double priceWithDiscount(double discountSize){
        return price * discountSize;
    }

    @Override
    public String toString() {
        return "Product{" +
                "type=" + type +
                ", price=" + price +
                ", id=" + id +
                ", isDiscount=" + isDiscount +
                '}';
    }



}
