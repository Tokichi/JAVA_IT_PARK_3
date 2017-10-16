package com.company;

public class Main {

    public static void main(String[] args) {
        Human humans[] = new Human[4];
        humans[0] = new Human("Vasya", 180, 24, 85);
        humans[1] = new Human("Petya", 170, 26, 75);
        humans[2] = new Human("Sasha", 175, 30, 70);
        humans[3] = new Human("Misha", 185, 28, 80);
        HumanComparator ageHumanComparator = new AgeHumanComparator();
        HumanComparator heightHumanComparator = new HeightHumanComparator();
        HumanComparator weightHumanComparator = new WeidthHumanComparator();

        HumanSorter humanSorter = new BubbleHumanSorter();
        System.out.println("Сортировка по возрасту:");
        humanSorter.sort(ageHumanComparator, humans);
        System.out.println("Сортировка по росту:");
        humanSorter.sort(heightHumanComparator, humans);
        System.out.println("Сортировка по весу:");
        humanSorter.sort(weightHumanComparator, humans);


    }
}
