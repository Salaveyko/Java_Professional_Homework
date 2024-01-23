package com.lab14_threadsProblems.deadlock;

import com.lab14_threadsProblems.entity.ClassA;
import com.lab14_threadsProblems.entity.ClassB;

/**
 * Create 2 classes and implement a deadlock for them.
 */
public class Main {
    public static void main(String[] args) {
        ClassA a = new ClassA(5);
        ClassB b = new ClassB(3);

        Runnable task1 = () -> {
            synchronized (a) {
                String thName = Thread.currentThread().getName();
                System.out.println(thName + ": lock A..\n" +
                        "Value of A - " + a.getA());
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                synchronized (b) {
                    System.out.println(thName + ": lock B..\n" +
                            "Value of B - " + b.getB());
                }
            }
        };
        Runnable task2 = () -> {
            synchronized (b) {
                String thName = Thread.currentThread().getName();
                System.out.println(thName + ": lock B..\n" +
                        "Value of B - " + b.getB());
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                synchronized (a) {
                    System.out.println(thName + ": lock A..\n" +
                            "Value of A - " + a.getA());
                }
            }
        };

        Thread th1 = new Thread(task1, "Thread_1");
        Thread th2 = new Thread(task2, "Thread_2");

        th1.start();
        th2.start();
    }
}
