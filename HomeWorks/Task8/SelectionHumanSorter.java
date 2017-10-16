package com.company;

public class SelectionHumanSorter implements HumanSorter {
    public void sort(HumanComparator comparator, Human humans[]) {
        Human human;
        for (int i = 0; i < humans.length; i++) {
            Human min = humans[i];
            int min_i = i;
            for (int j = i + 1; j < humans.length; j++) {
                if (comparator.compare(humans[i], humans[j]) > 0) {
                    min = humans[j];
                    min_i = j;
                }
            }
            if (i != min_i) {
                Human tmp = humans[i];
                humans[i] = humans[min_i];
                humans[min_i] = tmp;
            }
        }
        for (int i = 0; i < humans.length; i++) {
            System.out.println(humans[i].getName() + ", возраст :" + humans[i].getAge() + ",вес :" + humans[i].getWeight() + ", рост:" + humans[i].getHeight());
        }
    }
}