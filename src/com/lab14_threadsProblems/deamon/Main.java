package com.lab14_threadsProblems.deamon;

/**
 * Create a daemon thread and print all possible info about it.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Starting Main");

        Thread daemon = new Thread(() -> {
            System.out.println("Starting Daemon");
            try {
                while (true) {
                    System.out.println("Daemon is running...");
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Daemon is done.");
        });

        daemon.setDaemon(true);
        daemon.start();

        System.out.println("Main is running...");

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Main is done.");
    }
}
