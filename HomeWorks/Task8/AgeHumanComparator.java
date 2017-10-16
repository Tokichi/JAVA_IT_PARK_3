package com.company;

public class AgeHumanComparator implements HumanComparator {
    public int compare(Human a, Human b) {
        int c = a.age - b.age;
        return c;
    }
}
