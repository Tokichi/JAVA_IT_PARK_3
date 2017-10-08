package ru.itpark;

import java.util.Scanner;

public class Task1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите число элементов массива");
        int massize = scanner.nextInt();
        int mas[] = new int[massize];
        System.out.println("Введите элементы массива");
        for (int i = 0; i < mas.length; i++){
            mas[i] = scanner.nextInt();
        }
        int sumchet = 0;
        for (int i = 0; i <mas.length; i++){
            if (mas[i] % 2 == 0){
                sumchet = sumchet + mas[i];
            }
        }
        System.out.println("Сумма четных элементов массива равна: " + sumchet);
    }
}
