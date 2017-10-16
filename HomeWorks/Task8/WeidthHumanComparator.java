package com.company;

public class WeidthHumanComparator implements HumanComparator{
    public int compare(Human a, Human b) {
        int c = a.weight - b.weight;
        return c;
    }
}
