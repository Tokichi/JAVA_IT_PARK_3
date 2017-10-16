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
        int a = ageHumanComparator.compare(humans[1], humans[0]);
        int b = heightHumanComparator.compare(humans[1], humans[0]);
        int c = weightHumanComparator.compare(humans[1], humans[0]);
        System.out.println("Разница в возрасте двух сравниваемых людей равна: " + a);
        System.out.println("Разница в росте двух сравниваемых людей равна:" + b);
        System.out.println("Разница в весе двух сравниваемых людей равна:" + c);

        HumanSorter humanSorter = new BubbleHumanSorter();
        System.out.println("Сортировка по возрасту:");
        humanSorter.sort(ageHumanComparator, humans);
        System.out.println("Сортировка по росту:");
        humanSorter.sort(heightHumanComparator, humans);
        System.out.println("Сортировка по весу:");
        humanSorter.sort(weightHumanComparator, humans);


    }
}
