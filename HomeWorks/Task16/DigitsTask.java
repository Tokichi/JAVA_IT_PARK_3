package com.company;

public class DigitsTask implements Runnable{
    static String text;

    @Override
    public void run() {
        char letter[] = text.toCharArray();
        for (int i = 0; i < letter.length; i++) {
            if (letter[i] > '0' && letter[i] < '9') {
                System.out.println(letter[i]);
            }
        }
    }
}
