package com.company;

public class PoolWorker extends Thread {
    private Runnable task;

    public PoolWorker(Runnable task) {
        this.task = task;
    }

    public void run() {
        task.run();
    }
}

