package ru.itpark;

public class gg {
    public static int parse(char digits[]) {
        int itog = 0;
        for ( int i = 0; i < digits.length; i++){
            int x = digits.length - 1 - i;
            int b = stepen(x);
            itog = itog + (digits[i] - 48) * b;
        }
        return itog;
    }

    public static int stepen(int x) {
        int a = 1;
        for (int i = 0; i < x; i++) {
            a = a * 10;
        }
        return a;
    }

    public static void main(String[] args) {
        char number[] = {'1', '2', '6', '7',};
        int numberAsInt = parse(number);
        System.out.println(numberAsInt);

    }
}