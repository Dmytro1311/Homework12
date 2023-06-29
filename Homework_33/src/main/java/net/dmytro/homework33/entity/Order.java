package net.dmytro.homework33.entity;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
import java.util.List;
import java.util.UUID;
@Getter
@Setter
@ToString
public class Order {
     UUID id = UUID.randomUUID();
     Date data = new Date();
     double cost;
     List<Product> products;
}
