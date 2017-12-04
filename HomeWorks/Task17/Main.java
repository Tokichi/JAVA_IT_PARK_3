package com.company;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception{
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите количество строк матрицы");
        int rowNum = scanner.nextInt();
        System.out.println("Введите количество столбцов матрицы");
        int columnNum = scanner.nextInt();
        int[][] matrix = new int[rowNum][columnNum];
        Random random = new Random();
        for (int i = 0; i < rowNum; i++) {
            for (int j = 0; j < columnNum; j++) {
                matrix[i][j] = random.nextInt(100);
            }
        }
        System.out.println("Матрица сгенерирована:");
        for (int i = 0; i < rowNum; i++) {
            System.out.print("|");
            for (int j = 0; j < columnNum; j++) {
                if (matrix[i][j] > 9) {
                    System.out.print(matrix[i][j] + "|");
                } else {
                    System.out.print("0" + matrix[i][j] + "|");
                }
            }
            System.out.println();
        }
        System.out.println("Введите значение, которое хотите найти");
        int value = scanner.nextInt();

        ThreadPool threadPool = new ThreadPool(5);
        MatrixValueFinder matrixValueFinder = new MatrixValueFinder();
        for (int i = 0; i < rowNum; i++){
            int y = i;
            threadPool.submitTask(() ->matrixValueFinder.findValue(y,matrix[y],value));
        }
    }
}

