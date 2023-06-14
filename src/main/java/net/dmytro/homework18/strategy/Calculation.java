package net.dmytro.homework18.strategy;

import lombok.Value;

@Value
public class Calculation {
    AreaFigure areaFigure;

    public double calculation(){
       return areaFigure.areaCalculation();
    }
}
