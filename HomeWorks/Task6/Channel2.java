package com.company;

class Channel2 {
    long timeNow() {
        long timeNow = System.currentTimeMillis();
        //86400000 - количество миллисекунд в сутках, 10800000 - сдвиг на 3 часа для нашего часового пояса
        long timeDay = (int) (timeNow % 86400000 + 10800000) % timeNow;
        return timeDay;
    }

    public String channel2Program() {
        Programs[] channel2 = new Programs[10];
        channel2[0] = new Programs("Футбол 00:00 - 01:55", 0, 0, 1, 55);
        channel2[1] = new Programs("Хоккей 01:55 - 04:20", 1, 55, 4, 20);
        channel2[2] = new Programs("Волейбол 04:20 - 07:00", 4, 20, 7, 0);
        channel2[3] = new Programs("Теннис 07:00 - 09:30", 7, 0, 9, 30);
        channel2[4] = new Programs("Бокс 09:30 - 12:10", 9, 30, 12, 10);
        channel2[5] = new Programs("Борьба 12:10 - 14:30", 12, 10, 14, 30);
        channel2[6] = new Programs("Фигурное катание 14:30 - 16:45", 14, 30, 16, 45);
        channel2[7] = new Programs("Биатлон 16:45 - 19:15", 16, 45, 19, 15);
        channel2[8] = new Programs("Марафон 19:15 - 21:40", 19, 15, 21, 40);
        channel2[9] = new Programs("Фехтование 21:40 - 00:00", 21, 40, 24, 0);

        int numProgram = 0;
        for (int i = 0; i < channel2.length; i++) {
            int timeBegin = Programs.timeBeginCalc(channel2[i].timeBeginHour, channel2[i].timeBeginMin);
            int timeEnd = Programs.timeEndCalc(channel2[i].timeEndHour, channel2[i].timeEndMin);
            long timeNow = timeNow();
            if (timeNow > timeBegin && timeNow < timeEnd) {
                numProgram = i;
            }
        }
        return channel2[numProgram].nameProgram;
    }
}
