package net.dmytro.homework24.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Homework {
     long id;
     String name;
     String description;
}
