package com.company;

public class BubbleHumanSorter implements HumanSorter {
    public void sort(HumanComparator comparator, Human humans[]) {
        Human human;
        for (int i = humans.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (comparator.compare(humans[i], humans[j]) < 0) {
                    Human tmp = humans[j];
                    humans[j] = humans[j + 1];
                    humans[j + 1] = tmp;
                }
            }
        }
        for (int i = 0; i < humans.length; i++) {
            System.out.println(humans[i].getName() + ", возраст: " + humans[i].getAge() + ", вес: " + humans[i].getWeight() + ", рост: " + humans[i].getHeight());
        }
    }
}