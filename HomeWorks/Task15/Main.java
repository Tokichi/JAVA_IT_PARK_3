package com.company;

import java.util.Iterator;

public class Main {
    public static void printList(HashSet set) {
        Iterator iterator = set.iterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
    public static void main(String[] args) {
        HashSet<String> set = new HashSet<>();
        set.put("Василий");
        set.put("Марсель");
        set.put("Инокентий");
        set.put("Марсель");
        set.put("Александр");
        set.put("Марсель");
        set.put("Марсель");
        set.put("Александр");
        set.put("Марсель");
        set.put("Сергей");
        set.put("Артем");
        set.put("Артем");
        set.put("Сергей");

        printList(set);
    }

}
