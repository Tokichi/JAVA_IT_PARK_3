package ru.itpark;

import java.util.Scanner;

public class Task5 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите число элементов массива");
        int massize = scanner.nextInt();
        int mas[] = new int[massize];
        System.out.println("Введите элементы массива");
        for (int i = 0; i < mas.length; i++){
            mas[i] = scanner.nextInt();
        }
        int locmax = 0;
        for (int i = 1; i < mas.length -1; i++){
            if (mas[i] > mas[i - 1] && mas[i] > mas[i + 1]){
                locmax = locmax + 1;
            }
        }
        System.out.println("Количество локальных максимумов: " + locmax);
    }
}
