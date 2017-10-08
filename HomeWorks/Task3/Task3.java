package ru.itpark;

import java.util.Scanner;

public class Task3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите число элементов массива");
        int massize = scanner.nextInt();
        int mas[] = new int[massize];
        System.out.println("Введите элементы массива");
        for (int i = 0; i < mas.length; i++){
            mas[i] = scanner.nextInt();
        }
        int sumchetpoz = 0;
        for (int i = 0; i <mas.length; i++){
            if (i % 2 == 0){
                sumchetpoz = sumchetpoz + mas[i];
            }
        }
        System.out.println("Сумма элементов массива на четных позициях равна: " + sumchetpoz);
    }
}
