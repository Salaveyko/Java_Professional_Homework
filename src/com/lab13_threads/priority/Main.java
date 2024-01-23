package com.lab13_threads.priority;

/**
 * Create 3 threads with priorities min, max and normal.
 * Using a loop, print to the console integers from 1 to 50 and the name of the thread.
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        Runnable task = () -> {
            for (int i = 1; i <= 50; i++) {
                System.out.println(Thread.currentThread().getName() + ": " + i);
            }
        };

        Thread min = new Thread(task, "MinP");
        Thread max = new Thread(task, "MaxP");
        Thread norm = new Thread(task, "NormP");

        min.setPriority(Thread.MIN_PRIORITY);
        max.setPriority(Thread.MAX_PRIORITY);

        System.out.println("Starting...");

        norm.start();
        max.start();
        min.start();
    }
}
