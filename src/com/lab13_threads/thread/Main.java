package com.lab13_threads.thread;

/**
 * Create 3 threads and print a message when they're done.
 */
public class Main {
    public static void main(String[] args) {
        Thread first = new Thread("Firs") {
            @Override
            public void run() {
                try {
                    sleep(100);
                } catch (InterruptedException e) {
                }
                System.out.println(getName() + ": done.");
            }
        };
        Thread second = new Thread("Second") {
            @Override
            public void run() {
                try {
                    sleep(200);
                } catch (InterruptedException e) {
                }
                System.out.println(getName() + ": done.");
            }
        };
        Thread third = new Thread("Third") {
            @Override
            public void run() {
                try {
                    sleep(300);
                } catch (InterruptedException e) {
                }
                System.out.println(getName() + ": done.");
            }
        };

        third.start();
        second.start();
        first.start();
    }
}
