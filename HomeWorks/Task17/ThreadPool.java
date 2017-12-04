package com.company;

import java.util.Deque;
import java.util.LinkedList;

public class ThreadPool {

    private PoolWorker threads[];

    private Deque<Runnable> tasks;

    public ThreadPool(int threadCount) {
        threads = new PoolWorker[threadCount];
        for (int i = 0; i < threadCount; i++) {
            threads[i] = new PoolWorker();
            threads[i].start();
        }

        tasks = new LinkedList<>();
    }

    public void submitTask(Runnable task) {
        synchronized (tasks) {
            tasks.add(task);
            tasks.notify();
        }
    }

    private class PoolWorker extends Thread {
        public void run() {
            Runnable task = null;
            while (true) {
                try {
                    synchronized (tasks) {
                        while (tasks.isEmpty()) {
                            try {
                                tasks.wait();
                            } catch (InterruptedException e) {
                                throw new IllegalStateException(e);
                            }
                        }
                        task = tasks.removeFirst();
                    }
                } catch (NullPointerException e) {
                }
                try {
                    task.run();
                } catch (NullPointerException e) {
                }
            }
        }
    }
}