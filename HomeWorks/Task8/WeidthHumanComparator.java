package com.company;

public class WeidthHumanComparator implements HumanComparator {
    public int compare(Human a, Human b) {
        return a.getWeight() - b.getWeight();
    }
}
