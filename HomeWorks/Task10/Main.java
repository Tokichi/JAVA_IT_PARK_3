package com.company;

public class Main {

    public static void main(String[] args) {
        Car car = Car.builder()
                .color("red")
                .engineCapacity(2)
                .maxSpeed(200)
                .fuelConsumption(10)
                .height(2)
                .build();

    }
}
