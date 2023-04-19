package net.dmytro.homework18.strategy;

import lombok.Value;

@Value
public class Triangle implements AreaFigure{
    double width;
    double height;

    @Override
    public double areaCalculation() {
       return width * height * 0.5;
    }
}
