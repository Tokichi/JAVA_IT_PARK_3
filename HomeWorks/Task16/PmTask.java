package com.company;

public class PmTask implements Runnable {
    String text;

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

    public void setText(String text) {
        this.text = text;
    }
}
