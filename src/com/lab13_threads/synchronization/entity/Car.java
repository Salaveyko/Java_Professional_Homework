package com.lab13_threads.synchronization.entity;

public class Car extends Thread {
    private int weight;
    private int speed;

    public Car() {
    }

    public Car(int weight, int speed) {
        this.weight = weight;
        this.speed = speed;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    @Override
    public String toString() {
        return "Car{" +
                "weight=" + weight +
                ", speed=" + speed +
                '}';
    }
}
