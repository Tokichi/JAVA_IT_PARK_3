package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int arraySize = scanner.nextInt();
        int array[] = new int[arraySize];


        int min = array[0];
        int minid = 0;
        for (int i = 1; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
                minid = i;
            }
        }

        int max = array[0];
        int maxid = 0;
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
                maxid = i;

            }
        }

        int x = array[minid];
        array[maxid] = array[minid];
        array[minid] = x;

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }
}
