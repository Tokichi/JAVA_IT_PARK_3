package com.company;

class Channel3 {
    long timeNow() {
        long timeNow = System.currentTimeMillis();
        //86400000 - количество миллисекунд в сутках, 10800000 - сдвиг на 3 часа для нашего часового пояса
        long timeDay = (int) (timeNow % 86400000 + 10800000) % timeNow;
        return timeDay;
    }

    public String channel3Program() {
        Programs[] channel3 = new Programs[10];
        channel3[0] = new Programs("Русалочка 00:00 - 01:55", 0, 0, 1, 55);
        channel3[1] = new Programs("Алладин 01:55 - 04:20", 1, 55, 4, 20);
        channel3[2] = new Programs("Новые приключения Винни-Пуха 04:20 - 07:00", 4, 20, 7, 0);
        channel3[3] = new Programs("Чёрный Плащ 07:00 - 09:30", 7, 0, 9, 30);
        channel3[4] = new Programs("Утиные истории 09:30 - 12:10", 9, 30, 12, 10);
        channel3[5] = new Programs("Гравити Фолз 12:10 - 14:30", 12, 10, 14, 30);
        channel3[6] = new Programs("Тимон и Пумба 14:30 - 16:45", 14, 30, 16, 45);
        channel3[7] = new Programs("Чип и Дейл спешат на помощь 16:45 - 19:15", 16, 45, 19, 15);
        channel3[8] = new Programs("Чудеса на виражах 19:15 - 21:40", 19, 15, 21, 40);
        channel3[9] = new Programs("Геркулес 21:40 - 00:00", 21, 40, 24, 0);

        int numProgram = 0;
        for (int i = 0; i < channel3.length; i++) {
            int timeBegin = Programs.timeBeginCalc(channel3[i].timeBeginHour, channel3[i].timeBeginMin);
            int timeEnd = Programs.timeEndCalc(channel3[i].timeEndHour, channel3[i].timeEndMin);
            long timeNow = timeNow();
            if (timeNow > timeBegin && timeNow < timeEnd) {
                numProgram = i;
            }
        }
        return channel3[numProgram].nameProgram;
    }
}
