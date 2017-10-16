package com.company;

public class HeightHumanComparator implements HumanComparator {
    @Override
    public int compare(Human a, Human b) {
        int c = a.height - b.height;
        return c;

    }
}
