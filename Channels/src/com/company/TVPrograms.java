package com.company;

public class TVPrograms {
    String nameChannel;
    String nameProgram;
    int timeBeginHour, timeBeginMin, timeEndHour, timeEndMin;
    long timeBeginMSec;

    public TVPrograms(String nameProgram, int timeBeginHour, int timeBeginMin, int timeEndHour, int timeEndMin) {
        this.nameProgram = nameProgram;
        this.timeBeginHour = timeBeginHour;
        this.timeBeginMin = timeBeginMin;
        this.timeEndHour = timeEndHour;
        this.timeEndMin = timeEndMin;
    }

    public timeBeginMillSec(TVPrograms[] channel1) {
        for (int i = 0; i < channel1.length; i++){
            channel1[i].timeBeginMSec = ((timeBeginHour * 3600) + (timeBeginMin * 60)) * 1000;

        }
    }

    public timeEndMillSec(TVPrograms[] channel1) {

        long timeEndMSec = ((timeEndHour * 3600) + (timeEndMin * 60)) * 1000;
        return timeEndMSec;
    }
}