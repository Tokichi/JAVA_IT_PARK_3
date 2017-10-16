package com.company;

public class AgeHumanComparator implements HumanComparator {
    public int compare(Human a, Human b) {
        return a.getAge() - b.getAge();
    }
}
