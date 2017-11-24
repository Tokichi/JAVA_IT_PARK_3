package com.company;

public class TextViewer {
    private Runnable tasks[] = new Runnable[3];
    private int count = 0;
    private String text;

    public void setText(String text) {
        this.text = text;
    }

    public void addTask(Runnable task) {
        if (task instanceof TextSetters) {
            ((TextSetters) task).setText(text);
            tasks[count] = task;
            count++;
        }
    }

    public void process() {
        for (int i = 0; i < tasks.length; i++) {
            Thread runnableThread = new Thread(tasks[i]);
            runnableThread.start();
        }
    }
}
