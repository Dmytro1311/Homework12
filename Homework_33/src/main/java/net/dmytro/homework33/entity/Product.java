package net.dmytro.homework33.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;
@Getter
@Setter
@ToString
public class Product {
    UUID id = UUID.randomUUID();
    String name;
    double cost;
}
