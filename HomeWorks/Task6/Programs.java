package com.company;

class Programs {
    String nameProgram;
    int timeBeginHour;
    int timeBeginMin;
    int timeEndHour;
    int timeEndMin;

    //Перевожу часы и минуты в миллисекунды
    static int timeBeginCalc(int timeBeginHour, int timeBeginMin) {
        int timeBegin = (timeBeginHour * 3600 + timeBeginMin * 60) * 1000;
        return timeBegin;
    }

    static int timeEndCalc(int timeEndHour, int timeEndMin) {
        int timeEnd = (timeEndHour * 3600 + timeEndMin * 60) * 1000;
        return timeEnd;
    }


    Programs(String nameProgram, int timeBeginHour, int timeBeginMin, int timeEndHour, int timeEndMin) {
        this.nameProgram = nameProgram;
        this.timeBeginHour = timeBeginHour;
        this.timeBeginMin = timeBeginMin;
        this.timeEndHour = timeEndHour;
        this.timeEndMin = timeEndMin;
    }
}