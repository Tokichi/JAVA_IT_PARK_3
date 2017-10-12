package com.company;

public class Televizor {
    private static Televizor televizor = new Televizor();

    public static Televizor getInstance() {
        return televizor;
    }

    private Televizor() {

    }

    public void swhitchChannel(int i) {
        switch (i) {
            case 1: {
                Channel1 channel1 = new Channel1();
                String nameProgram = channel1.channel1Program();
                System.out.println("Вы включили канал 'В мире животных', в данный момент вы смотрите:");
                System.out.println(nameProgram);
            }
            break;
            case 2: {
                Channel2 channel2 = new Channel2();
                String nameProgram = channel2.channel2Program();
                System.out.println("Вы включили канал 'Спорт', в данный момент вы смотрите:");
                System.out.println(nameProgram);
            }
            break;
            case 3: {
                Channel3 channel3 = new Channel3();
                String nameProgram = channel3.channel3Program();
                System.out.println("Вы включили канал 'Дисней', в данный момент вы смотрите:");
                System.out.println(nameProgram);
            }
        }
    }
}
