package com.lab13_threads.synchronization;

import com.lab13_threads.synchronization.entity.Animal;
import com.lab13_threads.synchronization.entity.Car;
import com.lab13_threads.synchronization.printer.SharedPrinter;

public class Main {
    public static void main(String[] args) {
        SharedPrinter printer = new SharedPrinter();

        Car car = new Car(1100, 350) {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    printer.printCar(this);
                }
            }
        };
        Animal animal = new Animal("Cow", "Black") {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    printer.printAnimal(this);
                }
            }
        };

        car.start();
        animal.start();
    }
}
