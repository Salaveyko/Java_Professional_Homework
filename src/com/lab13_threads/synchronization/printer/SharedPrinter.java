package com.lab13_threads.synchronization.printer;

import com.lab13_threads.synchronization.entity.Animal;
import com.lab13_threads.synchronization.entity.Car;

public class SharedPrinter {
    private int turn = 1;

    synchronized public void printAnimal(Animal animal) {
        while (turn != 1) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println(animal);
        turn = 2;
        notifyAll();
    }

    synchronized public void printCar(Car car) {
        while (turn != 2) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println(car);
        turn = 1;
        notifyAll();
    }
}
