package com.company;

public class MatrixValueFinder {
    private static boolean flag = false;

    public void findValue(int rowNum, int matrixColumn[], int value) {
        for (int i = 0; i < matrixColumn.length; i++) {
            if (value == matrixColumn[i] && flag == false) {
                flag = true;
                System.out.println("Элемент с таким значением находится в строке №: " + (rowNum + 1) + ", в столбце №:" + (i + 1));
            }
        }
    }
}
