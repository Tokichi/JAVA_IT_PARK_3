package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long timeNow = System.currentTimeMillis();
        long timeDay = timeNow % 86400000;

        System.out.println(timeDay);
        System.out.println("Выберите номер канала");
        int numChannel = scanner.nextInt();

        TVPrograms[] channel1 = new TVPrograms[10];
        channel1[0] = new TVPrograms("Передача про слонов", 0, 0, 1, 55);
        channel1[1] = new TVPrograms("Передача про китов", 1, 55, 4, 20);
        channel1[2] = new TVPrograms("Передача про собак", 4, 20, 7, 0);
        channel1[3] = new TVPrograms("Передача про обезьян", 7, 0, 9, 30);
        channel1[4] = new TVPrograms("Передача про лосей",9, 30, 12, 10);
        channel1[5] = new TVPrograms("Передача про боров", 12, 10, 14, 30);
        channel1[6] = new TVPrograms("Передача про муравьев", 14, 30, 16, 45);
        channel1[7] = new TVPrograms("Передача про бурундуков", 16, 45, 19, 15);
        channel1[8] = new TVPrograms("Передача про бегемотов", 19, 15, 21, 40);
        channel1[9] = new TVPrograms("Передача про черепах", 21, 40, 24, 0);

        TVPrograms.timeBeginMillSec(channel1);
        //for (int i = 0; i < channel1.length; i++) {

        //   if () {

    }
}
//   }
//}
