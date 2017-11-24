package com.company;

public class TextViewer {
    private Runnable tasks[] = new Runnable[3];
    private int count = 0;
    private String text;

    public void setText(String text) {
        this.text = text;
    }

    public void addTask(Runnable task) {
            tasks[count] = task;
            count++;
    }

    public void process() {
        getText(text);
        for (int i = 0; i < tasks.length; i++) {
            Thread runnableThread = new Thread(tasks[i]);
            runnableThread.start();
        }
    }

    static private void getText(String text) {
        LettersTask.text = text;
        DigitsTask.text = text;
        PmTask.text = text;
    }
}
