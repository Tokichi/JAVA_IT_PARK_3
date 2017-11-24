package com.company;

public class TextViewer {
    private Runnable tasks[];
    private int count;
    private String text;

    public void setText(String text) {
        this.text = text;
    }

    public void addTask(Runnable task) {
            tasks[count] = task;
            count++;
    }

    public void process() {
        for (int i = 0; i < tasks.length; i++) {
            Thread runnableThread = new Thread(tasks[i]);
            runnableThread.start();
        }
    }
}
