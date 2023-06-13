package net.dmytro.homework24.entity;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Data
@Builder
public class Lesson {
    long id;
    String name;
    Homework homework;
}
