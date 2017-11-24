package com.company;

public class PmTask implements Runnable {
    static String text;

    @Override
    public void run() {
        char letter[] = text.toCharArray();
        for (int i = 0; i < letter.length; i++) {
            if (letter[i] > '!' && letter[i] < '/' ||
                    letter[i] > ':' && letter[i] < '@' ||
                    letter[i] > '[' && letter[i] < '_') {
                System.out.println(letter[i]);
            }
        }
    }
}
