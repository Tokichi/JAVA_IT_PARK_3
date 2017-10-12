package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("У вас в руках пульт от телевизора");
        System.out.println("Выберите канал");
        Scanner scanner = new Scanner(System.in);
        int button = scanner.nextInt();
        Televizor televizor = Televizor.getInstance();
        if (button > 0 && button < 4) {
            televizor.swhitchChannel(button);
        } else {
            System.out.println("Такого канала не существует");
        }
    }
}
