package com.company;

public class Human {
    String name;
    int height;
    int age;
    int weight;

    public Human(String name, int height, int age, int weight) {
        this.name = name;
        if (height >= 0) {
            this.height = height;
        } else {
            System.out.println("Рост не может быть отрицательным");
        }
        if (age >= 0) {
            this.age = age;
        } else {
            System.out.println("Возраст не может быть отрицательным");
        }
        if (weight >= 0) {
            this.weight = weight;
        } else {
            System.out.println("Вес не может быть отрицательным");
        }
    }
}
