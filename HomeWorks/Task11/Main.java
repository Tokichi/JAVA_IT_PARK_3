package com.company;

import java.io.IOException;


public class Main {
    public static void printList(List list) {
        Iterator iterator = list.iterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    public static void main(String[] args) throws IOException {
        StringLinkedList stringLinkedList[] = new StringLinkedList[100];
        DataReader reader = new DataReader("NamesAges.txt");
        String word = reader.readString();
        DataReader numbersReader = new DataReader("NamesAges.txt");
        int number = numbersReader.readInteger();
        while (number != 0) {
            stringLinkedList[number].addToBegin(word);
        }

        for (int i = 0; i < stringLinkedList.length; i++) {
            printList(stringLinkedList[i]);
        }
    }
}
