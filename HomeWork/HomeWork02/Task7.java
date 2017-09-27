package ru.itpark;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите число элементов массива");
        int massize = scanner.nextInt();
        int mas[] = new int[massize];
        System.out.println("Введите элементы массива");
        for (int i = 0; i < mas.length; i++){
            mas[i] = scanner.nextInt();
        }
        for (int i = 0; i < mas.length - 1; i++){
            if (mas[i] == 0){
                mas[i] = mas[i+1] * -1;
            }
        }
        for (int i = 0; i < mas.length; i++){
            System.out.print(mas[i] + " ");
        }
    }
}
