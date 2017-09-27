package ru.itpark;

import java.util.Scanner;

public class Task4 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите число элементов массива");
        int massize = scanner.nextInt();
        int mas[] = new int[massize];
        System.out.println("Введите элементы массива");
        for (int i = 0; i < mas.length; i++){
            mas[i] = scanner.nextInt();
        }
        int sumnechetpoz = 0;
        for (int i = 0; i <mas.length; i++){
            if (i % 2 != 0){
                sumnechetpoz = sumnechetpoz + mas[i];
            }
        }
        System.out.println("Сумма элементов массива на нечетных позициях равна: " + sumnechetpoz);
    }
}
