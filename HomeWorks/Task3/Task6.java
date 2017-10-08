package ru.itpark;

import java.util.Scanner;

public class Task6 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите число элементов массива");
        int massize = scanner.nextInt();
        int mas[] = new int[massize];
        System.out.println("Введите элементы массива");
        for (int i = 0; i < mas.length; i++){
            mas[i] = scanner.nextInt();
        }
        int poslsize = 1;
        int maxposlsize = 0;
        for (int i = 1; i <mas.length; i++){
            if (mas[i] > mas [i-1]){
                poslsize = poslsize + 1;
                if (poslsize > maxposlsize){
                    maxposlsize = poslsize;
                }
            }
            else {
                poslsize = 1;
            }
        }
        System.out.println ("Число элементов самой длинной последовательности: " + maxposlsize);

    }
}
