package net.dmytro.homework18.builder;

import lombok.Data;


@Data
public class Car {
    private String name;
    private String carBrand;
    private String motor;
    private String typeCorps;
    private String  typeTransmission;

    public static class Builder{
        private Car newCar;

        public Builder(){
            newCar = new Car();
        }
        public Builder withName(String name){
            newCar.name = name;
            return this;
        }
        public Builder withCarBrand(String carBrand){
            newCar.carBrand = carBrand;
        return this;
        }

        public Builder withMotor(String motor){
            newCar.motor =motor;
            return this;
        }
        public Builder withTypeCorp(String typeCorp){
            newCar.typeCorps = typeCorp;
            return this;
        }
        public Builder withTypeTransmission(String typeTransmission){
            newCar.typeTransmission = typeTransmission;
            return this;
        }
        public Car build(){
            return newCar;
        }

    }
}
