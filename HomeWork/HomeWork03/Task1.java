package ru.itpark;

public class Main {
    public static int parse(char digits[]) {
        int itog = 0;
        for ( int i = 0; i < digits.length; i++){
            int a = digits.length - 1 - i;
            int b = (int)Math.pow(10, a);
            itog = itog + (digits[i] - 48) * b;
        }
        return itog;
    }

    public static void main(String[] args) {
        char number[] = {'1', '2', '6', '7'};
        int numberAsInt = parse(number);
        System.out.println(numberAsInt);

    }
}
