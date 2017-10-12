package com.company;

class Channel1 {
    long timeNow() {
        long timeNow = System.currentTimeMillis();
        //86400000 - количество миллисекунд в сутках, 10800000 - сдвиг на 3 часа для нашего часового пояса
        long timeDaylong = (timeNow + 10800000) % 86400000;
        int timeDay = (int) timeDaylong;
        return timeDay;
    }

    public String channel1Program() {
        Programs[] channel1 = new Programs[10];
        channel1[0] = new Programs("Передача про слонов 00:00 - 01:55", 0, 0, 1, 55);
        channel1[1] = new Programs("Передача про китов 01:55 - 04:20", 1, 55, 4, 20);
        channel1[2] = new Programs("Передача про собак 04:20 - 07:00", 4, 20, 7, 0);
        channel1[3] = new Programs("Передача про обезьян 07:00 - 09:30", 7, 0, 9, 30);
        channel1[4] = new Programs("Передача про лосей 09:30 - 12:10", 9, 30, 12, 10);
        channel1[5] = new Programs("Передача про боров 12:10 - 14:30", 12, 10, 14, 30);
        channel1[6] = new Programs("Передача про муравьев 14:30 - 16:45", 14, 30, 16, 45);
        channel1[7] = new Programs("Передача про бурундуков 16:45 - 19:15", 16, 45, 19, 15);
        channel1[8] = new Programs("Передача про бегемотов 19:15 - 21:40", 19, 15, 21, 40);
        channel1[9] = new Programs("Передача про черепах 21:40 - 00:00", 21, 40, 24, 0);

        int numProgram = 0;
        for (int i = 0; i < channel1.length; i++) {
            int timeBegin = Programs.timeBeginCalc(channel1[i].timeBeginHour, channel1[i].timeBeginMin);
            int timeEnd = Programs.timeEndCalc(channel1[i].timeEndHour, channel1[i].timeEndMin);
            long timeNow = timeNow();
            if (timeNow > timeBegin && timeNow < timeEnd) {
                numProgram = i;
            }
        }
        return channel1[numProgram].nameProgram;
    }
}

